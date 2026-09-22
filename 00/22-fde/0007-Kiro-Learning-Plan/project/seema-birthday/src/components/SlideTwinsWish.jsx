import { useState, useEffect } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import StarField from './StarField';
import Petals from './Petals';

const imgUrl = (f) => {
  try { return new URL(`../assets/seema/${f}`, import.meta.url).href; }
  catch { return null; }
};

// Baby handwriting style messages from the twins
const BABY_MESSAGES = [
  { from: 'Beti #1 🌸', msg: 'Mamma… aap sabse pyaari ho! 🥰\nHappy Birthday!\n(Mujhe doodh aur aapki goodi chahiye 😄)', delay: 0 },
  { from: 'Beti #2 💕', msg: 'Mamma… main aapko bahut bahut pyaar karti hoon! ❤️\nAap meri hero ho!\n(Aaj mujhe jyada nap time chahiye! 😂)', delay: 0.4 },
];

export default function SlideTwinsWish({ onNext, onPrev }) {
  const [envelope, setEnvelope] = useState(false);
  const [revealed, setRevealed] = useState(false);
  const [sparkle, setSparkle]   = useState(false);

  const openEnvelope = () => {
    setEnvelope(true);
    setTimeout(() => setRevealed(true), 600);
    setTimeout(() => setSparkle(true), 1000);
  };

  // sparkling hearts burst
  const SPARKS = Array.from({ length: 14 }, (_, i) => ({
    angle: (i / 14) * 360,
    dist:  80 + Math.random() * 60,
    emoji: ['💕','✨','🌸','💖','⭐','🌟'][i % 6],
    delay: i * 0.06,
  }));

  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 50% 40%, #1a0030 0%, #0d001a 60%, #0a000f 100%)',
      minHeight: '100vh', padding: '0 20px 60px',
      display: 'flex', flexDirection: 'column', alignItems: 'center',
    }}>
      <StarField count={70} />
      <Petals count={18} />
      <div className="nav-spacer" />
      <div style={{ position: 'relative', zIndex: 1, maxWidth: 660, width: '100%', textAlign: 'center', paddingTop: 0 }}>

        {/* heading */}
        <motion.div initial={{ opacity: 0, y: -20 }} animate={{ opacity: 1, y: 0 }} style={{ marginBottom: 28 }}>
          <p style={{
            fontFamily: 'var(--font-script)', fontSize: 'clamp(1.8rem,5vw,2.6rem)',
            background: 'linear-gradient(135deg,#f9a8c9,#e8547a,#f0c060)',
            WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent',
          }}>
            Hamare Twins Ka Pyaar 👶👶
          </p>
          <p style={{ color: '#f9c6d877', fontSize: '0.85rem', marginTop: 6, fontFamily: 'var(--font-serif)', fontStyle: 'italic' }}>
            A birthday wish from your two biggest fans 💖
          </p>
        </motion.div>

        {/* big baby-wish image — creative frame */}
        <motion.div
          initial={{ opacity: 0, scale: 0.88 }}
          animate={{ opacity: 1, scale: 1 }}
          transition={{ delay: 0.3, duration: 0.7, type: 'spring' }}
          style={{ position: 'relative', display: 'inline-block', marginBottom: 28 }}
        >
          {/* sparkle burst on open */}
          <AnimatePresence>
            {sparkle && SPARKS.map((s, i) => (
              <motion.div
                key={i}
                initial={{ opacity: 1, x: 0, y: 0, scale: 0 }}
                animate={{
                  opacity: 0,
                  x: Math.cos(s.angle * Math.PI / 180) * s.dist,
                  y: Math.sin(s.angle * Math.PI / 180) * s.dist,
                  scale: 1.4,
                }}
                transition={{ delay: s.delay, duration: 0.9, ease: 'easeOut' }}
                style={{
                  position: 'absolute', top: '50%', left: '50%',
                  fontSize: '1.4rem', pointerEvents: 'none', zIndex: 10,
                  transform: 'translate(-50%,-50%)',
                }}
              >
                {s.emoji}
              </motion.div>
            ))}
          </AnimatePresence>

          {/* photo frame */}
          <div style={{
            borderRadius: 24, overflow: 'hidden',
            border: '3px solid rgba(240,192,96,0.5)',
            boxShadow: '0 0 60px rgba(232,84,122,0.35), 0 0 120px rgba(240,192,96,0.15)',
            background: '#0d0010', position: 'relative',
            maxWidth: 'clamp(260px, 70vw, 420px)',
            margin: '0 auto',
          }}>
            {/* blurred bg */}
            <img src={imgUrl('baby-wish.png')} aria-hidden style={{
              position: 'absolute', inset: 0, width: '100%', height: '100%',
              objectFit: 'cover', filter: 'blur(20px) brightness(0.35) saturate(1.6)',
              transform: 'scale(1.12)', pointerEvents: 'none',
            }} />
            {/* main image */}
            <img
              src={imgUrl('baby-wish.png')}
              alt="Birthday wish from twins"
              style={{
                position: 'relative', display: 'block',
                width: '100%', maxHeight: '55vh',
                objectFit: 'contain', objectPosition: 'center',
              }}
            />
            {/* golden glow border animation */}
            <motion.div
              animate={{ opacity: [0.4, 0.8, 0.4] }}
              transition={{ duration: 2.5, repeat: Infinity }}
              style={{
                position: 'absolute', inset: 0,
                border: '2px solid rgba(240,192,96,0.4)',
                borderRadius: 22, pointerEvents: 'none',
                boxShadow: 'inset 0 0 30px rgba(240,192,96,0.08)',
              }}
            />
            {/* corner roses */}
            {['top:8px;left:10px','top:8px;right:10px','bottom:8px;left:10px','bottom:8px;right:10px'].map((pos, i) => (
              <div key={i} style={{
                position: 'absolute', fontSize: '1.2rem',
                ...(Object.fromEntries(pos.split(';').map(p => p.split(':')))),
              }}>🌸</div>
            ))}
          </div>
        </motion.div>

        {/* envelope / card open interaction */}
        <AnimatePresence mode="wait">
          {!envelope ? (
            <motion.div key="cta" exit={{ opacity: 0, scale: 0.9 }} transition={{ duration: 0.25 }}>
              <motion.p
                animate={{ opacity: [0.6, 1, 0.6] }}
                transition={{ duration: 2, repeat: Infinity }}
                style={{ color: '#f9c6d8', fontSize: '1rem', marginBottom: 16, fontFamily: 'var(--font-serif)', fontStyle: 'italic' }}
              >
                Tumhare liye ek chitthi hai… 💌
              </motion.p>
              <motion.button
                className="btn btn-rose"
                onClick={openEnvelope}
                whileHover={{ scale: 1.06 }}
                whileTap={{ scale: 0.96 }}
                style={{ padding: '14px 36px', fontSize: '1rem' }}
              >
                Open Their Letter 💌
              </motion.button>
            </motion.div>
          ) : (
            <motion.div key="letters" initial={{ opacity: 0 }} animate={{ opacity: 1 }} transition={{ duration: 0.5 }}>
              <div style={{ display: 'flex', flexDirection: 'column', gap: 14, marginBottom: 24 }}>
                {BABY_MESSAGES.map((b, i) => (
                  <motion.div
                    key={i}
                    initial={{ opacity: 0, y: 24, rotate: i === 0 ? -2 : 2 }}
                    animate={{ opacity: 1, y: 0, rotate: 0 }}
                    transition={{ delay: b.delay + 0.3, duration: 0.6, type: 'spring' }}
                    style={{
                      background: i === 0
                        ? 'linear-gradient(135deg, rgba(255,182,193,0.12), rgba(255,192,203,0.06))'
                        : 'linear-gradient(135deg, rgba(255,218,185,0.12), rgba(255,160,122,0.06))',
                      border: `1px solid ${i === 0 ? 'rgba(232,84,122,0.3)' : 'rgba(240,192,96,0.3)'}`,
                      borderRadius: 18, padding: '20px 22px', textAlign: 'left',
                      backdropFilter: 'blur(12px)',
                    }}
                  >
                    <p style={{
                      fontFamily: 'var(--font-script)', fontSize: '1.1rem',
                      color: i === 0 ? '#f9a8c9' : '#f0c060', marginBottom: 8,
                    }}>
                      {b.from}
                    </p>
                    <p style={{
                      fontFamily: 'var(--font-serif)', fontStyle: 'italic',
                      color: '#f4d4e8', lineHeight: 1.85, fontSize: '0.95rem',
                      whiteSpace: 'pre-line',
                    }}>
                      {b.msg}
                    </p>
                  </motion.div>
                ))}
              </div>

              {/* from papa too */}
              <motion.div
                initial={{ opacity: 0, y: 16 }}
                animate={{ opacity: 1, y: 0 }}
                transition={{ delay: 1.2, duration: 0.6 }}
                className="glass"
                style={{ padding: '16px 22px', textAlign: 'center', marginBottom: 28 }}
              >
                <p style={{
                  fontFamily: 'var(--font-serif)', fontStyle: 'italic',
                  color: '#f0e8f4', lineHeight: 1.8, fontSize: '0.92rem',
                }}>
                  "Do choti si jaan jis din se aaye hain,<br />
                  ghar mein char chaand lag gaye hain.<br />
                  Tum teeno meri duniya ho —<br />
                  Happy Birthday, Mamma. ❤️"
                </p>
                <p style={{ fontFamily: 'var(--font-script)', color: '#e8547a', fontSize: '1rem', marginTop: 10 }}>
                  — Papa (aur unki do choti farishte 👶👶)
                </p>
              </motion.div>
            </motion.div>
          )}
        </AnimatePresence>

        {/* nav */}
        <div style={{ display: 'flex', justifyContent: 'space-between', gap: 12 }}>
          <motion.button className="btn btn-ghost" onClick={onPrev} whileHover={{ scale: 1.04 }} style={{ padding: '10px 22px' }}>
            ← Beauty
          </motion.button>
          <motion.button className="btn btn-rose" onClick={onNext} whileHover={{ scale: 1.05 }} whileTap={{ scale: 0.96 }} style={{ padding: '10px 26px' }}>
            Photos 📸
          </motion.button>
        </div>
      </div>
    </div>
  );
}
