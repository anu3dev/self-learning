const jwt = require('jsonwebtoken');
const { JWT_SECRET } = require('../config');

/**
 * Attach req.user if a valid Bearer token is present.
 * Does NOT block unauthenticated requests — use `requireAuth` for that.
 */
function optionalAuth(req, _res, next) {
  const header = req.headers.authorization || '';
  const token = header.startsWith('Bearer ') ? header.slice(7) : null;
  if (token) {
    try {
      req.user = jwt.verify(token, JWT_SECRET);
    } catch {
      // ignore invalid tokens for optional auth
    }
  }
  next();
}

/**
 * Block unauthenticated requests with 401.
 */
function requireAuth(req, res, next) {
  optionalAuth(req, res, () => {
    if (!req.user) {
      return res.status(401).json({ error: 'Authentication required' });
    }
    next();
  });
}

module.exports = { optionalAuth, requireAuth };
