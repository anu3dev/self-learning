const express = require('express');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const db = require('../db');
const { JWT_SECRET, JWT_EXPIRES_IN } = require('../config');
const { requireAuth } = require('../middleware/auth');

const router = express.Router();

// ── POST /api/auth/register ──────────────────────────────────────────────────
router.post('/register', (req, res) => {
  const { username, email, password } = req.body;

  if (!username || !email || !password) {
    return res.status(400).json({ error: 'username, email and password are required' });
  }
  if (password.length < 6) {
    return res.status(400).json({ error: 'Password must be at least 6 characters' });
  }

  const existing = db.prepare('SELECT id FROM users WHERE email = ? OR username = ?').get(email, username);
  if (existing) {
    return res.status(409).json({ error: 'Email or username already taken' });
  }

  const hashed = bcrypt.hashSync(password, 10);
  const { lastInsertRowid } = db.prepare(
    'INSERT INTO users (username, email, password) VALUES (?, ?, ?)'
  ).run(username, email, hashed);

  const user = db.prepare('SELECT id, username, email, bio, avatar_url, created_at FROM users WHERE id = ?').get(lastInsertRowid);
  const token = jwt.sign({ id: user.id, username: user.username }, JWT_SECRET, { expiresIn: JWT_EXPIRES_IN });

  res.status(201).json({ token, user });
});

// ── POST /api/auth/login ─────────────────────────────────────────────────────
router.post('/login', (req, res) => {
  const { email, password } = req.body;

  if (!email || !password) {
    return res.status(400).json({ error: 'email and password are required' });
  }

  const user = db.prepare('SELECT * FROM users WHERE email = ?').get(email);
  if (!user || !bcrypt.compareSync(password, user.password)) {
    return res.status(401).json({ error: 'Invalid credentials' });
  }

  const token = jwt.sign({ id: user.id, username: user.username }, JWT_SECRET, { expiresIn: JWT_EXPIRES_IN });
  const { password: _pw, ...safeUser } = user;

  res.json({ token, user: safeUser });
});

// ── GET /api/auth/me ─────────────────────────────────────────────────────────
router.get('/me', requireAuth, (req, res) => {
  const user = db.prepare('SELECT id, username, email, bio, avatar_url, created_at FROM users WHERE id = ?').get(req.user.id);
  if (!user) return res.status(404).json({ error: 'User not found' });
  res.json(user);
});

// ── PATCH /api/auth/me ───────────────────────────────────────────────────────
router.patch('/me', requireAuth, (req, res) => {
  const { bio, avatar_url } = req.body;
  db.prepare('UPDATE users SET bio = COALESCE(?, bio), avatar_url = COALESCE(?, avatar_url) WHERE id = ?')
    .run(bio ?? null, avatar_url ?? null, req.user.id);
  const user = db.prepare('SELECT id, username, email, bio, avatar_url, created_at FROM users WHERE id = ?').get(req.user.id);
  res.json(user);
});

module.exports = router;
