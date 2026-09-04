const express = require('express');
const slugify = require('slugify');
const db = require('../db');
const { requireAuth, optionalAuth } = require('../middleware/auth');

const router = express.Router();

// Helper – attach tags array to a post object
function withTags(post) {
  if (!post) return null;
  const tags = db.prepare(`
    SELECT t.name FROM tags t
    JOIN post_tags pt ON pt.tag_id = t.id
    WHERE pt.post_id = ?
  `).all(post.id).map(r => r.name);
  return { ...post, tags };
}

// Helper – upsert tags and link them to a post
function syncTags(postId, tagNames) {
  db.prepare('DELETE FROM post_tags WHERE post_id = ?').run(postId);
  for (const name of tagNames) {
    const trimmed = name.trim().toLowerCase();
    if (!trimmed) continue;
    db.prepare('INSERT OR IGNORE INTO tags (name) VALUES (?)').run(trimmed);
    const tag = db.prepare('SELECT id FROM tags WHERE name = ?').get(trimmed);
    db.prepare('INSERT OR IGNORE INTO post_tags (post_id, tag_id) VALUES (?, ?)').run(postId, tag.id);
  }
}

// ── GET /api/posts ───────────────────────────────────────────────────────────
router.get('/', optionalAuth, (req, res) => {
  const { tag, author, search, page = 1, limit = 10 } = req.query;
  const offset = (Number(page) - 1) * Number(limit);

  let where = ['p.published = 1'];
  const params = [];

  if (tag) {
    where.push('EXISTS (SELECT 1 FROM post_tags pt JOIN tags t ON t.id = pt.tag_id WHERE pt.post_id = p.id AND t.name = ?)');
    params.push(tag.toLowerCase());
  }
  if (author) {
    where.push('u.username = ?');
    params.push(author);
  }
  if (search) {
    where.push('(p.title LIKE ? OR p.excerpt LIKE ?)');
    params.push(`%${search}%`, `%${search}%`);
  }

  const whereClause = where.length ? 'WHERE ' + where.join(' AND ') : '';

  const posts = db.prepare(`
    SELECT p.id, p.title, p.slug, p.excerpt, p.cover_url, p.created_at, p.updated_at,
           u.id AS author_id, u.username AS author_username, u.avatar_url AS author_avatar,
           (SELECT COUNT(*) FROM likes   WHERE post_id = p.id) AS like_count,
           (SELECT COUNT(*) FROM comments WHERE post_id = p.id) AS comment_count
    FROM posts p JOIN users u ON u.id = p.author_id
    ${whereClause}
    ORDER BY p.created_at DESC
    LIMIT ? OFFSET ?
  `).all(...params, Number(limit), offset);

  const { total } = db.prepare(`
    SELECT COUNT(*) AS total FROM posts p JOIN users u ON u.id = p.author_id ${whereClause}
  `).get(...params);

  res.json({
    posts: posts.map(withTags),
    pagination: { page: Number(page), limit: Number(limit), total, pages: Math.ceil(total / Number(limit)) },
  });
});

// ── GET /api/posts/:slug ─────────────────────────────────────────────────────
router.get('/:slug', optionalAuth, (req, res) => {
  const post = db.prepare(`
    SELECT p.*, u.id AS author_id, u.username AS author_username,
           u.bio AS author_bio, u.avatar_url AS author_avatar,
           (SELECT COUNT(*) FROM likes WHERE post_id = p.id) AS like_count,
           (SELECT COUNT(*) FROM comments WHERE post_id = p.id) AS comment_count
    FROM posts p JOIN users u ON u.id = p.author_id
    WHERE p.slug = ? AND (p.published = 1 OR p.author_id = ?)
  `).get(req.params.slug, req.user?.id ?? -1);

  if (!post) return res.status(404).json({ error: 'Post not found' });

  const liked = req.user
    ? !!db.prepare('SELECT 1 FROM likes WHERE post_id = ? AND user_id = ?').get(post.id, req.user.id)
    : false;

  res.json({ ...withTags(post), liked });
});

// ── POST /api/posts ──────────────────────────────────────────────────────────
router.post('/', requireAuth, (req, res) => {
  const { title, content, excerpt = '', cover_url = '', published = false, tags = [] } = req.body;

  if (!title || !content) {
    return res.status(400).json({ error: 'title and content are required' });
  }

  const baseSlug = slugify(title, { lower: true, strict: true });
  let slug = baseSlug;
  let attempt = 1;
  while (db.prepare('SELECT id FROM posts WHERE slug = ?').get(slug)) {
    slug = `${baseSlug}-${attempt++}`;
  }

  const { lastInsertRowid } = db.prepare(`
    INSERT INTO posts (title, slug, excerpt, content, cover_url, published, author_id)
    VALUES (?, ?, ?, ?, ?, ?, ?)
  `).run(title, slug, excerpt, content, cover_url, published ? 1 : 0, req.user.id);

  syncTags(lastInsertRowid, tags);

  const post = db.prepare('SELECT * FROM posts WHERE id = ?').get(lastInsertRowid);
  res.status(201).json(withTags(post));
});

// ── PATCH /api/posts/:slug ───────────────────────────────────────────────────
router.patch('/:slug', requireAuth, (req, res) => {
  const post = db.prepare('SELECT * FROM posts WHERE slug = ?').get(req.params.slug);
  if (!post) return res.status(404).json({ error: 'Post not found' });
  if (post.author_id !== req.user.id) return res.status(403).json({ error: 'Forbidden' });

  const { title, content, excerpt, cover_url, published, tags } = req.body;

  let newSlug = post.slug;
  if (title && title !== post.title) {
    const baseSlug = slugify(title, { lower: true, strict: true });
    newSlug = baseSlug;
    let attempt = 1;
    while (db.prepare('SELECT id FROM posts WHERE slug = ? AND id != ?').get(newSlug, post.id)) {
      newSlug = `${baseSlug}-${attempt++}`;
    }
  }

  db.prepare(`
    UPDATE posts SET
      title     = COALESCE(?, title),
      slug      = ?,
      excerpt   = COALESCE(?, excerpt),
      content   = COALESCE(?, content),
      cover_url = COALESCE(?, cover_url),
      published = COALESCE(?, published),
      updated_at = datetime('now')
    WHERE id = ?
  `).run(title ?? null, newSlug, excerpt ?? null, content ?? null, cover_url ?? null,
         published !== undefined ? (published ? 1 : 0) : null, post.id);

  if (Array.isArray(tags)) syncTags(post.id, tags);

  const updated = db.prepare('SELECT * FROM posts WHERE id = ?').get(post.id);
  res.json(withTags(updated));
});

// ── DELETE /api/posts/:slug ──────────────────────────────────────────────────
router.delete('/:slug', requireAuth, (req, res) => {
  const post = db.prepare('SELECT * FROM posts WHERE slug = ?').get(req.params.slug);
  if (!post) return res.status(404).json({ error: 'Post not found' });
  if (post.author_id !== req.user.id) return res.status(403).json({ error: 'Forbidden' });

  db.prepare('DELETE FROM posts WHERE id = ?').run(post.id);
  res.json({ message: 'Post deleted' });
});

// ── POST /api/posts/:slug/like ───────────────────────────────────────────────
router.post('/:slug/like', requireAuth, (req, res) => {
  const post = db.prepare('SELECT id FROM posts WHERE slug = ? AND published = 1').get(req.params.slug);
  if (!post) return res.status(404).json({ error: 'Post not found' });

  const existing = db.prepare('SELECT 1 FROM likes WHERE post_id = ? AND user_id = ?').get(post.id, req.user.id);
  if (existing) {
    db.prepare('DELETE FROM likes WHERE post_id = ? AND user_id = ?').run(post.id, req.user.id);
    const { count } = db.prepare('SELECT COUNT(*) AS count FROM likes WHERE post_id = ?').get(post.id);
    return res.json({ liked: false, like_count: count });
  }

  db.prepare('INSERT INTO likes (post_id, user_id) VALUES (?, ?)').run(post.id, req.user.id);
  const { count } = db.prepare('SELECT COUNT(*) AS count FROM likes WHERE post_id = ?').get(post.id);
  res.json({ liked: true, like_count: count });
});

module.exports = router;
