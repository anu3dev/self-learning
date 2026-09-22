import { useState } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { GALLERY } from '../config';
import StarField from './StarField';
import Petals from './Petals';

const imgUrl = (filename) => {
  try {
    return new URL(`../assets/seema/${filename}`, import.meta.url).href;
  } catch {
    return null;
  }
};

const FRAMES = GALLERY.map(g => ({ ...g, src: imgUrl(g.file) }));

// ── Photo card ────────────────────────────────────────────────────────────────
function PhotoCard({ frame, index, onClick }) {
  const [err, setErr] = useState(false);
  return (
    <motion.div
      initial={{ opacity: 0, y: 36 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ delay: index * 0.06, duration: 0.5 }}
      whileHover={{ scale: 1.04, zIndex: 10 }}
      onClick={() => onClick(index)}
      style={{
        cursor: 'pointer', borderRadius: 16, overflow: 'hidden',
        border: '1px solid rgba(240,192,96,0.22)',
        boxShadow: '0 8px 28px rgba(0,0,0,0.5)',
        background: '#0d0010', position: 'relative',
        breakInside: 'avoid', marginBottom: 14,
      }}
    >
      {!err && frame.src ? (
        <>
          {/* blurred fill */}
          <img src={frame.src} aria-hidden style={{
            position: 'absolute', inset: 0, width: '100%', height: '100%',
            objectFit: 'cover', filter: 'blur(16px) brightness(0.4) saturate(1.4)',
            transform: 'scale(1.1)', pointerEvents: 'none',
          }} />
          {/* main image — contain, no stretch */}
          <img src={frame.src} alt={frame.caption}
            onError={() => setErr(true)}
            style={{
              position: 'relative', display: 'block',
              width: '100%', maxHeight: 300,
              objectFit: 'contain', objectPosition: 'center top',
            }}
          />
        </>
      ) : (
        <div style={{
          height: 220,
          background: `linear-gradient(135deg,hsl(${index*32},55%,14%),hsl(${index*32+40},45%,9%))`,
          display: 'flex', flexDirection: 'column',
          alignItems: 'center', justifyContent: 'center', gap: 8,
        }}>
          <span style={{ fontSize: '2.4rem', opacity: 0.5 }}>🌹</span>
          <p style={{ fontFamily: 'var(--font-script)', color: 'rgba(255,255,255,0.35)', fontSize: '0.78rem' }}>
            {frame.label}
          </p>
        </div>
      )}

      {/* year badge */}
      <div style={{
        position: 'absolute', top: 10, left: 10, zIndex: 3,
        background: 'rgba(232,84,122,0.88)', backdropFilter: 'blur(6px)',
        padding: '2px 10px', borderRadius: 50,
        fontSize: '0.68rem', fontWeight: 700, color: '#fff', letterSpacing: 0.5,
      }}>{frame.label}</div>

      {/* caption overlay */}
      <div style={{
        position: 'absolute', bottom: 0, left: 0, right: 0,
        background: 'linear-gradient(transparent,rgba(0,0,0,0.82))',
        padding: '24px 10px 10px', pointerEvents: 'none',
      }}>
        <p style={{
          fontFamily: 'var(--font-script)', color: '#f9d4e3',
          fontSize: '0.78rem', lineHeight: 1.4,
        }}>{frame.caption}</p>
        <p style={{ fontSize: '0.62rem', color: '#f0c06077', marginTop: 2 }}>{frame.year}</p>
      </div>
    </motion.div>
  );
}

// ── Lightbox ──────────────────────────────────────────────────────────────────
function Lightbox({ frame, onClose, onPrev, onNext, hasPrev, hasNext }) {
  const [err, setErr] = useState(false);
  return (
    <motion.div
      initial={{ opacity: 0 }} animate={{ opacity: 1 }} exit={{ opacity: 0 }}
      onClick={onClose}
      style={{
        position: 'fixed', inset: 0, zIndex: 100,
        background: 'rgba(0,0,0,0.95)', backdropFilter: 'blur(18px)',
        display: 'flex', alignItems: 'center', justifyContent: 'center', padding: 20,
      }}
    >
      <motion.div
        initial={{ scale: 0.88, opacity: 0 }}
        animate={{ scale: 1, opacity: 1 }}
        exit={{ scale: 0.88, opacity: 0 }}
        transition={{ duration: 0.32 }}
        onClick={e => e.stopPropagation()}
        style={{
          maxWidth: 560, width: '100%',
          background: 'rgba(18,4,16,0.98)',
          border: '1px solid rgba(240,192,96,0.3)',
          borderRadius: 24, overflow: 'hidden',
          boxShadow: '0 24px 80px rgba(232,84,122,0.3)',
        }}
      >
        {/* image */}
        <div style={{ position: 'relative', background: '#0d0010', minHeight: 180 }}>
          {!err && frame.src ? (
            <>
              <img src={frame.src} aria-hidden style={{
                position: 'absolute', inset: 0, width: '100%', height: '100%',
                objectFit: 'cover', filter: 'blur(22px) brightness(0.3) saturate(1.3)',
                transform: 'scale(1.1)', pointerEvents: 'none',
              }} />
              <img src={frame.src} alt={frame.caption}
                onError={() => setErr(true)}
                style={{
                  position: 'relative', display: 'block',
                  maxWidth: '100%', maxHeight: '60vh',
                  objectFit: 'contain', margin: '0 auto',
                  filter: 'drop-shadow(0 4px 20px rgba(0,0,0,0.7))',
                }}
              />
            </>
          ) : (
            <div style={{ height: 260, display: 'flex', alignItems: 'center', justifyContent: 'center', fontSize: '4rem' }}>
              🌹
            </div>
          )}
        </div>
        {/* caption */}
        <div style={{ padding: '20px 24px' }}>
          <p style={{ fontFamily: 'var(--font-script)', color: '#f0c060', fontSize: '0.78rem', marginBottom: 6 }}>
            {frame.year}
          </p>
          <p style={{
            fontFamily: 'var(--font-serif)', fontStyle: 'italic',
            color: '#f9d4e3', fontSize: '1rem', lineHeight: 1.7, textAlign: 'center', marginBottom: 18,
          }}>
            {frame.caption}
          </p>
          <div style={{ display: 'flex', justifyContent: 'center', gap: 10 }}>
            <button className="btn btn-ghost" onClick={onPrev} disabled={!hasPrev}
              style={{ opacity: hasPrev ? 1 : 0.3, padding: '8px 18px' }}>←</button>
            <button className="btn btn-ghost" onClick={onClose} style={{ padding: '8px 18px' }}>✕</button>
            <button className="btn btn-ghost" onClick={onNext} disabled={!hasNext}
              style={{ opacity: hasNext ? 1 : 0.3, padding: '8px 18px' }}>→</button>
          </div>
        </div>
      </motion.div>
    </motion.div>
  );
}

// ── Main slide ────────────────────────────────────────────────────────────────
export default function SlideGallery({ onNext, onPrev }) {
  const [lightbox, setLightbox] = useState(null);

  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 50% 0%, #2a0038 0%, #160020 50%, #0d0010 100%)',
      minHeight: '100vh', padding: '0 20px 80px',
    }}>
      <StarField count={50} />
      <Petals count={10} />
      <div className="nav-spacer" />
      <div style={{ position: 'relative', zIndex: 1, maxWidth: 960, margin: '0 auto', paddingTop: 0 }}>
        <motion.div
          initial={{ opacity: 0, y: -20 }} animate={{ opacity: 1, y: 0 }}
          style={{ textAlign: 'center', marginBottom: 32 }}
        >
          <span style={{
            fontFamily: 'var(--font-script)', fontSize: 'clamp(1.8rem,5vw,2.6rem)',
            background: 'linear-gradient(135deg,#f9a8c9,#e8547a,#f0c060)',
            WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent',
            filter: 'drop-shadow(0 0 16px #e8547a44)',
          }}>
            Hamare Khoobsurat Lamhe 📸
          </span>
          <p style={{ color: '#f9c6d877', fontSize: '0.82rem', marginTop: 6 }}>
            Tap any photo to open · {FRAMES.length} moments
          </p>
        </motion.div>

        {/* masonry grid */}
        <div style={{ columns: 'auto 190px', columnGap: 14 }}>
          {FRAMES.map((frame, i) => (
            <PhotoCard key={i} frame={frame} index={i} onClick={setLightbox} />
          ))}
        </div>

        <div style={{ textAlign: 'center', marginTop: 40 }}>
          <motion.button
            className="btn btn-rose" onClick={onNext}
            whileHover={{ scale: 1.05 }} whileTap={{ scale: 0.96 }}
            style={{ fontSize: '1.05rem', padding: '16px 44px' }}
          >
            Make a Wish 🎂
          </motion.button>
        </div>
      </div>

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
