# BlogSpace — Full Stack Blogging App

A full-featured blogging platform built with **React + Vite** (frontend) and **Node.js + Express + SQLite** (backend).

---

## Features

- **Auth** — Register, login, JWT-based sessions, profile editing
- **Posts** — Create, edit, delete, publish/draft, slug-based URLs, cover images
- **Tags** — Tag posts, filter by tag, popular tags sidebar
- **Likes** — Toggle likes per post (authenticated users)
- **Comments** — Add and delete comments on published posts
- **Dashboard** — Manage all your posts in one place
- **Author pages** — Public profile page per author
- **Search** — Full-text search across titles and excerpts
- **Pagination** — Server-side pagination on the post list

---

## Project Structure

```
project/
├── backend/          # Express API
│   ├── src/
│   │   ├── index.js          # Entry point
│   │   ├── db.js             # SQLite schema + connection
│   │   ├── config.js         # JWT secret, port
│   │   ├── middleware/
│   │   │   └── auth.js       # JWT middleware
│   │   └── routes/
│   │       ├── auth.js       # /api/auth/*
│   │       ├── posts.js      # /api/posts/*
│   │       ├── comments.js   # /api/posts/:slug/comments
│   │       └── tags.js       # /api/tags
│   └── package.json
│
└── frontend/         # React + Vite + Tailwind
    └── src/
        ├── api/              # Axios wrappers
        ├── context/          # AuthContext
        ├── components/       # Navbar, PostCard, PostEditor, etc.
        └── pages/            # HomePage, PostPage, Dashboard, etc.
```

---

## Getting Started

### Prerequisites

- Node.js 18+

### 1. Backend

```bash
cd backend
npm install
npm run dev        # runs on http://localhost:4000
```

The SQLite database (`blog.db`) is created automatically on first run.

### 2. Frontend

```bash
cd frontend
npm install
npm run dev        # runs on http://localhost:5173
```

Open **http://localhost:5173** in your browser.

---

## API Overview

| Method | Path | Auth | Description |
|--------|------|------|-------------|
| POST | `/api/auth/register` | — | Register |
| POST | `/api/auth/login` | — | Login |
| GET | `/api/auth/me` | ✓ | Get current user |
| PATCH | `/api/auth/me` | ✓ | Update profile |
| GET | `/api/posts` | — | List published posts (search, tag, author, page) |
| GET | `/api/posts/:slug` | — | Get single post |
| POST | `/api/posts` | ✓ | Create post |
| PATCH | `/api/posts/:slug` | ✓ | Update post |
| DELETE | `/api/posts/:slug` | ✓ | Delete post |
| POST | `/api/posts/:slug/like` | ✓ | Toggle like |
| GET | `/api/posts/:slug/comments` | — | List comments |
| POST | `/api/posts/:slug/comments` | ✓ | Add comment |
| DELETE | `/api/posts/:slug/comments/:id` | ✓ | Delete comment |
| GET | `/api/tags` | — | List popular tags |

---

## Environment Variables

Backend uses defaults that work out of the box. For production, set:

```
JWT_SECRET=your_strong_secret_here
PORT=4000
```
