# Shikha Proposal Website

A romantic proposal website built with React + Vite, ready to deploy on Netlify.

## Run locally

```bash
npm install
npm run dev
```

## Add Shikha's photo

Place her image at:

`public/pp.jpeg`

The page automatically checks these names if present:

- `public/pp.jpeg`
- `public/pp.jpg`
- `public/pp.png`
- `public/pp.webp`
- `public/shikha.jpg`

## Build for production

```bash
npm run build
```

## Deploy to Netlify

This project already includes:

- `netlify.toml`
- `public/_redirects`

If you connect this repo on Netlify, use:

- Build command: `npm run build`
- Publish directory: `dist`
