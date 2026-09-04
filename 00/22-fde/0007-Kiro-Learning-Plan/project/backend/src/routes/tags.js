const express = require('express');
const db = require('../db');

const router = express.Router();

// ── GET /api/tags ─────────────────────────────────────────────────────────────
router.get('/', (_req, res) => {
  const tags = db.prepare(`
    SELECT t.name, COUNT(pt.post_id) AS post_count
    FROM tags t
    JOIN post_tags pt ON pt.tag_id = t.id
    JOIN posts p ON p.id = pt.post_id AND p.published = 1
    GROUP BY t.id
    ORDER BY post_count DESC
  `).all();
  res.json(tags);
});

module.exports = router;
