const express = require('express');
const cors = require('cors');
const { PORT } = require('./config');

// Import routes
const authRoutes     = require('./routes/auth');
const postsRoutes    = require('./routes/posts');
const commentsRoutes = require('./routes/comments');
const tagsRoutes     = require('./routes/tags');

const app = express();

// ── Middleware ────────────────────────────────────────────────────────────────
app.use(cors({ origin: 'http://localhost:5173', credentials: true }));
app.use(express.json());

// ── Routes ────────────────────────────────────────────────────────────────────
app.use('/api/auth',                          authRoutes);
app.use('/api/posts',                         postsRoutes);
app.use('/api/posts/:slug/comments',          commentsRoutes);
app.use('/api/tags',                          tagsRoutes);

// ── Health check ──────────────────────────────────────────────────────────────
app.get('/api/health', (_req, res) => res.json({ status: 'ok' }));

// ── 404 handler ───────────────────────────────────────────────────────────────
app.use((_req, res) => res.status(404).json({ error: 'Not found' }));

// ── Error handler ─────────────────────────────────────────────────────────────
app.use((err, _req, res, _next) => {
  console.error(err);
  res.status(500).json({ error: 'Internal server error' });
});

app.listen(PORT, () => {
  console.log(`Blog API listening on http://localhost:${PORT}`);
});
