import { useState } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import StarField from './StarField';
import Petals from './Petals';

// ── PNG imports via Vite's static asset URL ───────────────────────────────────
// Images live at src/assets/images/1.png … 8.png
// new URL() is resolved at build time by Vite — no dynamic import needed.
const img = (n) => new URL(`../assets/images/${n}.png`, import.meta.url).href;

const FRAMES = [
  { src: img(1), caption: 'The smile that started everything 🥹',         label: 'My favourite ❤️' },
  { src: img(2), caption: 'Those eyes… I could get lost forever 🌊',       label: 'Beautiful 💖'    },
  { src: img(3), caption: 'That nose 👃😂❤️ — always my favourite',        label: 'The Nose 😘'     },
  { src: img(4), caption: 'Radiant. Always radiant. ✨',                   label: 'Glowing 🌟'      },
  { src: img(5), caption: 'Pure joy — this is you at your best 🎉',        label: 'Happy 🎈'        },
  { src: img(6), caption: 'You carry grace effortlessly 🌷',               label: 'Grace 🌸'        },
  { src: img(7), caption: '30 years of becoming this wonderful 💫',        label: 'Timeless 👑'     },
  { src: img(8), caption: "Soon we'll make memories like this together 🤞",label: 'Us 🌹'           },
];

const FALLBACK_ICONS = ['🌸','📷','💖','🌹','✨','🌺','👑','🥹'];

// ── PhotoCard ─────────────────────────────────────────────────────────────────
// The card keeps a fixed aspect-ratio frame. The image uses object-fit:contain
// so NO stretching or cropping — the full photo is always visible, centered,
// with a soft blurred version of itself as the background fill.
function PhotoCard({ frame, index, onClick }) {
  const [err, setErr] = useState(false);

  return (
    <motion.div
      initial={{ opacity: 0, y: 40, rotate: index % 2 === 0 ? -2 : 2 }}
      animate={{ opacity: 1, y: 0, rotate: 0 }}
      transition={{ delay: index * 0.07, duration: 0.5 }}
      whileHover={{ scale: 1.05, rotate: 0, zIndex: 10 }}
      onClick={() => onClick(index)}
      style={{
        cursor: 'pointer',
        position: 'relative',
        borderRadius: 18,
        overflow: 'hidden',
        border: '1px solid rgba(240,192,96,0.28)',
        boxShadow: '0 8px 32px rgba(0,0,0,0.5)',
        // let height be determined by content — no forced aspect ratio that
        // would distort portrait vs landscape photos
        minHeight: 220,
        background: '#0d0010',
      }}
    >
      {!err ? (
        <>
          {/* Blurred background fill — gives colour even for transparent PNGs */}
          <img
            src={frame.src}
            aria-hidden
            style={{
              position: 'absolute', inset: 0,
              width: '100%', height: '100%',
              objectFit: 'cover',
              filter: 'blur(18px) brightness(0.45) saturate(1.4)',
              transform: 'scale(1.1)',
              pointerEvents: 'none',
            }}
          />
          {/* Actual image — contain so it's never cropped or stretched */}
          <img
            src={frame.src}
            alt={frame.caption}
            onError={() => setErr(true)}
            style={{
              position: 'relative',
              display: 'block',
              width: '100%',
              maxHeight: 320,
              objectFit: 'contain',
              objectPosition: 'center top',
            }}
          />
        </>
      ) : (
        /* Placeholder if image fails to load */
        <div style={{
          height: 240,
          background: `linear-gradient(135deg,
            hsl(${index * 45},55%,15%),
            hsl(${index * 45 + 40},45%,10%))`,
          display: 'flex', flexDirection: 'column',
          alignItems: 'center', justifyContent: 'center', gap: 10,
        }}>
          <span style={{ fontSize: '2.8rem', opacity: 0.55 }}>
            {FALLBACK_ICONS[index]}
          </span>
          <p style={{
            fontFamily: 'var(--font-script)', color: 'rgba(255,255,255,0.4)',
            fontSize: '0.8rem', textAlign: 'center', padding: '0 12px',
          }}>
            Photo {index + 1}
          </p>
        </div>
      )}

      {/* Label ribbon */}
      <div style={{
        position: 'absolute', top: 10, left: 10, zIndex: 3,
        background: 'rgba(232,84,122,0.88)',
        backdropFilter: 'blur(6px)',
        padding: '3px 11px', borderRadius: 50,
        fontSize: '0.7rem', fontWeight: 700, color: '#fff', letterSpacing: 0.5,
      }}>
        {frame.label}
      </div>

      {/* Caption gradient overlay */}
      <div style={{
        position: 'absolute', bottom: 0, left: 0, right: 0,
        background: 'linear-gradient(transparent, rgba(0,0,0,0.82))',
        padding: '28px 12px 12px',
        pointerEvents: 'none',
      }}>
        <p style={{
          fontFamily: 'var(--font-script)', color: '#f9d4e3',
          fontSize: '0.82rem', lineHeight: 1.4,
        }}>
          {frame.caption}
        </p>
      </div>
    </motion.div>
  );
}

// ── Lightbox ──────────────────────────────────────────────────────────────────
// Shows the image at its natural size, constrained to the viewport.
// object-fit: contain guarantees no distortion at any aspect ratio.
function Lightbox({ frame, onClose, onPrev, onNext, hasPrev, hasNext }) {
  const [err, setErr] = useState(false);

  return (
    <motion.div
      initial={{ opacity: 0 }} animate={{ opacity: 1 }} exit={{ opacity: 0 }}
      onClick={onClose}
      style={{
        position: 'fixed', inset: 0, zIndex: 100,
        background: 'rgba(0,0,0,0.94)',
        backdropFilter: 'blur(16px)',
        display: 'flex', flexDirection: 'column',
        alignItems: 'center', justifyContent: 'center',
        padding: '20px 16px',
      }}
    >
      <motion.div
        initial={{ scale: 0.88, opacity: 0 }}
        animate={{ scale: 1, opacity: 1 }}
        exit={{ scale: 0.88, opacity: 0 }}
        transition={{ duration: 0.35, ease: 'easeOut' }}
        onClick={e => e.stopPropagation()}
        style={{
          display: 'flex', flexDirection: 'column',
          alignItems: 'center',
          width: '100%', maxWidth: 560,
          background: 'rgba(20,4,18,0.97)',
          border: '1px solid rgba(240,192,96,0.35)',
          borderRadius: 26,
          overflow: 'hidden',
          boxShadow: '0 24px 80px rgba(232,84,122,0.35)',
        }}
      >
        {/* Image area with blurred bg */}
        <div style={{
          position: 'relative', width: '100%',
          background: '#0d0010',
          display: 'flex', alignItems: 'center', justifyContent: 'center',
          minHeight: 200,
        }}>
          {!err ? (
            <>
              {/* blurred bg fill */}
              <img
                src={frame.src}
                aria-hidden
                style={{
                  position: 'absolute', inset: 0,
                  width: '100%', height: '100%',
                  objectFit: 'cover',
                  filter: 'blur(24px) brightness(0.35) saturate(1.3)',
                  transform: 'scale(1.12)',
                  pointerEvents: 'none',
                }}
              />
              {/* main image — contain, max 70vh so it never overflows screen */}
              <img
                src={frame.src}
                alt={frame.caption}
                onError={() => setErr(true)}
                style={{
                  position: 'relative',
                  display: 'block',
                  maxWidth: '100%',
                  maxHeight: '62vh',
                  objectFit: 'contain',
                  margin: '0 auto',
                  // subtle drop shadow on the photo itself
                  filter: 'drop-shadow(0 4px 24px rgba(0,0,0,0.7))',
                }}
              />
            </>
          ) : (
            <div style={{
              height: 260, width: '100%',
              background: 'linear-gradient(135deg,#3d0030,#1a0020)',
              display: 'flex', alignItems: 'center', justifyContent: 'center',
              fontSize: '5rem',
            }}>💖</div>
          )}
        </div>

        {/* Caption + controls */}
        <div style={{ padding: '20px 24px', width: '100%' }}>
          <p style={{
            fontFamily: 'var(--font-serif)', fontStyle: 'italic',
            color: '#f9d4e3', fontSize: '1rem', lineHeight: 1.7,
            textAlign: 'center', marginBottom: 18,
          }}>
            {frame.caption}
          </p>
          <div style={{ display: 'flex', justifyContent: 'center', gap: 10 }}>
            <button
              className="btn btn-ghost"
              onClick={onPrev}
              disabled={!hasPrev}
              style={{ opacity: hasPrev ? 1 : 0.3, padding: '10px 20px' }}
            >←</button>
            <button
              className="btn btn-ghost"
              onClick={onClose}
              style={{ padding: '10px 20px' }}
            >✕</button>
            <button
              className="btn btn-ghost"
              onClick={onNext}
              disabled={!hasNext}
              style={{ opacity: hasNext ? 1 : 0.3, padding: '10px 20px' }}
            >→</button>
          </div>
        </div>
      </motion.div>
    </motion.div>
  );
}

// ── Main slide ────────────────────────────────────────────────────────────────
export default function SlideGallery({ onNext }) {
  const [lightbox, setLightbox] = useState(null);

  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 50% 0%, #2a0038 0%, #160020 50%, #0d0010 100%)',
      minHeight: '100vh', padding: '56px 20px 80px',
    }}>
      <StarField count={50} />
      <Petals count={10} />

      <div style={{ position: 'relative', zIndex: 1, maxWidth: 960, margin: '0 auto' }}>
        {/* Heading */}
        <motion.div
          initial={{ opacity: 0, y: -20 }} animate={{ opacity: 1, y: 0 }}
          style={{ textAlign: 'center', marginBottom: 36 }}
        >
          <span style={{
            fontFamily: 'var(--font-script)', fontSize: 'clamp(1.8rem,5vw,2.6rem)',
            background: 'linear-gradient(135deg,#f9a8c9,#e8547a,#f0c060)',
            WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent',
            filter: 'drop-shadow(0 0 16px #e8547a55)',
          }}>
            Tumhari Khubsurat Duniya 📸
          </span>
          <p style={{ color: '#f9c6d888', fontSize: '0.85rem', marginTop: 8 }}>
            Click any photo to open ✨
          </p>
        </motion.div>

        {/* Masonry-style grid — 2 cols on mobile, 3 on tablet, 4 on desktop */}
        <div style={{
          columns: 'auto 200px',
          columnGap: 16,
        }}>
          {FRAMES.map((frame, i) => (
            <div key={i} style={{ breakInside: 'avoid', marginBottom: 16 }}>
              <PhotoCard frame={frame} index={i} onClick={setLightbox} />
            </div>
          ))}
        </div>

        <div style={{ textAlign: 'center', marginTop: 48 }}>
          <motion.button
            className="btn btn-rose"
            onClick={onNext}
            whileHover={{ scale: 1.05 }}
            whileTap={{ scale: 0.96 }}
            style={{ fontSize: '1.05rem', padding: '16px 44px' }}
          >
            One Last Surprise 🎂
          </motion.button>
        </div>
      </div>

      {/* Lightbox */}
      <AnimatePresence>
        {lightbox !== null && (
          <Lightbox
            frame={FRAMES[lightbox]}
            onClose={() => setLightbox(null)}
            onPrev={() => setLightbox(l => Math.max(0, l - 1))}
            onNext={() => setLightbox(l => Math.min(FRAMES.length - 1, l + 1))}
            hasPrev={lightbox > 0}
            hasNext={lightbox < FRAMES.length - 1}
          />
        )}
      </AnimatePresence>
    </div>
  );
}
