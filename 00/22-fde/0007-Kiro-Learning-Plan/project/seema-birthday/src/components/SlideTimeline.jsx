import { useState, useRef, useEffect } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { TIMELINE } from '../config';
import StarField from './StarField';

// Vite static asset helper – returns the URL or null if file is absent
const imgUrl = (filename) => {
  if (!filename) return null;
  try {
    return new URL(`../assets/seema/${filename}`, import.meta.url).href;
  } catch {
    return null;
  }
};

export default function SlideTimeline({ onNext, onPrev }) {
  const [active, setActive] = useState(0);
  const dotRefs  = useRef([]);
  const trackRef = useRef(null);

  // keep active dot scrolled into view inside the track
  useEffect(() => {
    const dot = dotRefs.current[active];
    if (dot && trackRef.current) {
      dot.scrollIntoView({ behavior: 'smooth', block: 'nearest', inline: 'center' });
    }
  }, [active]);

  const item = TIMELINE[active];
  const isFirst = active === 0;
  const isLast  = active === TIMELINE.length - 1;

  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 30% 60%, #1a0030 0%, #0d001a 60%, #0a000f 100%)',
      display: 'flex', flexDirection: 'column',
      minHeight: '100vh', overflow: 'auto',
    }}>
      <StarField count={70} />
      <div className="nav-spacer" />

      {/* ── header ── */}
      <div style={{ position: 'relative', zIndex: 1, textAlign: 'center', padding: '0 20px' }}>
        <motion.p
          initial={{ opacity: 0, y: -16 }} animate={{ opacity: 1, y: 0 }}
          style={{
            fontFamily: 'var(--font-script)', fontSize: 'clamp(1.6rem,4vw,2.2rem)',
            background: 'linear-gradient(135deg,#f9a8c9,#e8547a,#f0c060)',
            WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent',
          }}
        >
          Our Story 💫
        </motion.p>
        <p style={{ color: '#f9c6d866', fontSize: '0.8rem', marginTop: 4 }}>
          Tap a moment to relive it
        </p>
      </div>

      {/* ── dot track ── */}
      <div style={{ position: 'relative', zIndex: 1, padding: '24px 0 0' }}>
        {/* connecting line */}
        <div style={{
          position: 'absolute', top: 44, left: 0, right: 0, height: 2,
          background: 'linear-gradient(90deg,transparent,rgba(240,192,96,0.25),transparent)',
        }} />

        <div
          ref={trackRef}
          style={{
            display: 'flex', gap: 0,
            overflowX: 'auto', overflowY: 'visible',
            padding: '0 24px 8px',
            scrollbarWidth: 'none',
            msOverflowStyle: 'none',
          }}
        >
          {TIMELINE.map((t, i) => (
            <button
              key={i}
              ref={el => (dotRefs.current[i] = el)}
              onClick={() => setActive(i)}
              style={{
                flexShrink: 0,
                display: 'flex', flexDirection: 'column', alignItems: 'center',
                gap: 6, padding: '4px 10px',
                background: 'none', border: 'none', cursor: 'pointer',
                minWidth: 72,
              }}
            >
              {/* dot */}
              <motion.div
                animate={i === active ? { scale: 1.3, boxShadow: `0 0 16px ${t.color}99` } : { scale: 1 }}
                style={{
                  width: 14, height: 14, borderRadius: '50%',
                  background: i <= active ? t.color : 'rgba(255,255,255,0.15)',
                  border: `2px solid ${i === active ? t.color : 'rgba(255,255,255,0.2)'}`,
                  transition: 'background 0.4s',
                }}
              />
              {/* year label */}
              <span style={{
                fontSize: '0.6rem', color: i === active ? '#f0c060' : '#ffffff44',
                whiteSpace: 'nowrap', fontFamily: 'var(--font-sans)',
                transition: 'color 0.3s', fontWeight: i === active ? 700 : 400,
              }}>
                {t.year.length > 10 ? t.year.slice(0, 9) + '…' : t.year}
              </span>
            </button>
          ))}
        </div>
      </div>

      {/* ── main card ── */}
      <div style={{
        flex: 1, display: 'flex', alignItems: 'center', justifyContent: 'center',
        padding: '16px 20px 20px', position: 'relative', zIndex: 1,
        overflow: 'hidden',
      }}>
        <AnimatePresence mode="wait">
          <motion.div
            key={active}
            initial={{ opacity: 0, y: 30, scale: 0.96 }}
            animate={{ opacity: 1, y: 0, scale: 1 }}
            exit={{ opacity: 0, y: -24, scale: 0.96 }}
            transition={{ duration: 0.42, ease: 'easeInOut' }}
            style={{
              maxWidth: 680, width: '100%',
              display: 'flex', flexDirection: 'column', gap: 0,
            }}
          >
            {/* card */}
            <div className="glass" style={{
              overflow: 'hidden',
              borderColor: `${item.color}44`,
              boxShadow: `0 0 40px ${item.color}22`,
            }}>
              {/* image strip */}
              {item.img && (
                <div style={{ position: 'relative', height: 220, overflow: 'hidden' }}>
                  {/* blurred bg */}
                  <img
                    src={imgUrl(item.img)}
                    aria-hidden
                    style={{
                      position: 'absolute', inset: 0,
                      width: '100%', height: '100%',
                      objectFit: 'cover',
                      filter: 'blur(20px) brightness(0.4) saturate(1.4)',
                      transform: 'scale(1.12)',
                    }}
                  />
                  {/* main image */}
                  <img
                    src={imgUrl(item.img)}
                    alt={item.title}
                    style={{
                      position: 'relative',
                      display: 'block',
                      width: '100%', height: '100%',
                      objectFit: 'contain',
                      objectPosition: 'center',
                    }}
                  />
                  {/* colour tint overlay */}
                  <div style={{
                    position: 'absolute', inset: 0,
                    background: `linear-gradient(to bottom, transparent 50%, rgba(10,0,15,0.85) 100%)`,
                  }} />
                  {/* year badge */}
                  <div style={{
                    position: 'absolute', top: 14, left: 14,
                    background: `${item.color}cc`,
                    backdropFilter: 'blur(8px)',
                    padding: '4px 14px', borderRadius: 50,
                    fontSize: '0.72rem', fontWeight: 700, color: '#fff', letterSpacing: 1,
                  }}>
                    {item.year}
                  </div>
                </div>
              )}

              {/* text body */}
              <div style={{ padding: '24px 28px 28px' }}>
                {!item.img && (
                  <p style={{
                    fontSize: '0.75rem', color: item.color,
                    letterSpacing: 2, fontWeight: 700,
                    marginBottom: 8, fontFamily: 'var(--font-sans)',
                  }}>
                    {item.year}
                  </p>
                )}

                <div style={{ display: 'flex', alignItems: 'flex-start', gap: 12, marginBottom: 12 }}>
                  <span style={{ fontSize: '2rem', flexShrink: 0 }}>{item.emoji}</span>
                  <h3 style={{
                    fontFamily: 'var(--font-script)',
                    fontSize: 'clamp(1.4rem,4vw,2rem)',
                    color: item.color,
                    textShadow: `0 0 20px ${item.color}66`,
                    lineHeight: 1.2,
                  }}>
                    {item.title}
                  </h3>
                </div>

                <p style={{
                  fontFamily: 'var(--font-serif)', fontStyle: 'italic',
                  color: '#f0e8f4', lineHeight: 1.85,
                  fontSize: 'clamp(0.9rem,2.4vw,1.05rem)',
                }}>
                  {item.body}
                </p>

                {/* progress indicator */}
                <p style={{
                  marginTop: 16, fontSize: '0.72rem',
                  color: 'rgba(255,255,255,0.3)',
                  fontFamily: 'var(--font-sans)',
                }}>
                  {active + 1} / {TIMELINE.length}
                </p>
              </div>
            </div>

            {/* nav buttons */}
            <div style={{ display: 'flex', justifyContent: 'space-between', marginTop: 16, gap: 12 }}>
              <motion.button
                className="btn btn-ghost"
                onClick={isFirst ? onPrev : () => setActive(a => a - 1)}
                whileHover={{ scale: 1.04 }}
                style={{ padding: '10px 24px', opacity: 1 }}
              >
                {isFirst ? '← Intro' : '← Back'}
              </motion.button>

              <motion.button
                className={`btn ${isLast ? 'btn-rose' : 'btn-gold'}`}
                onClick={isLast ? onNext : () => setActive(a => a + 1)}
                whileHover={{ scale: 1.05 }}
                whileTap={{ scale: 0.96 }}
                style={{ padding: '10px 28px' }}
              >
                {isLast ? 'See the Poem 🌹' : 'Next →'}
              </motion.button>
            </div>
          </motion.div>
        </AnimatePresence>
      </div>
    </div>
  );
}
