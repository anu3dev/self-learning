const express = require('express');
const db = require('../db');
const { requireAuth } = require('../middleware/auth');

const router = express.Router({ mergeParams: true }); // needs mergeParams for :slug

// ── GET /api/posts/:slug/comments ────────────────────────────────────────────
router.get('/', (req, res) => {
  const post = db.prepare('SELECT id FROM posts WHERE slug = ?').get(req.params.slug);
  if (!post) return res.status(404).json({ error: 'Post not found' });

  const comments = db.prepare(`
    SELECT c.id, c.body, c.created_at,
           u.id AS author_id, u.username AS author_username, u.avatar_url AS author_avatar
    FROM comments c JOIN users u ON u.id = c.author_id
    WHERE c.post_id = ?
    ORDER BY c.created_at ASC
  `).all(post.id);

  res.json(comments);
});

// ── POST /api/posts/:slug/comments ───────────────────────────────────────────
router.post('/', requireAuth, (req, res) => {
  const { body } = req.body;
  if (!body || !body.trim()) return res.status(400).json({ error: 'Comment body is required' });

  const post = db.prepare('SELECT id FROM posts WHERE slug = ? AND published = 1').get(req.params.slug);
  if (!post) return res.status(404).json({ error: 'Post not found' });

  const { lastInsertRowid } = db.prepare(
    'INSERT INTO comments (body, post_id, author_id) VALUES (?, ?, ?)'
  ).run(body.trim(), post.id, req.user.id);

  const comment = db.prepare(`
    SELECT c.id, c.body, c.created_at,
           u.id AS author_id, u.username AS author_username, u.avatar_url AS author_avatar
    FROM comments c JOIN users u ON u.id = c.author_id
    WHERE c.id = ?
  `).get(lastInsertRowid);

  res.status(201).json(comment);
});

// ── DELETE /api/posts/:slug/comments/:id ─────────────────────────────────────
router.delete('/:id', requireAuth, (req, res) => {
  const comment = db.prepare('SELECT * FROM comments WHERE id = ?').get(req.params.id);
  if (!comment) return res.status(404).json({ error: 'Comment not found' });
  if (comment.author_id !== req.user.id) return res.status(403).json({ error: 'Forbidden' });

  db.prepare('DELETE FROM comments WHERE id = ?').run(comment.id);
  res.json({ message: 'Comment deleted' });
});

module.exports = router;
