import { useEffect, useState } from 'react';
import { motion } from 'framer-motion';
import ReactConfetti from 'react-confetti';
import StarField from './StarField';
import Petals from './Petals';

const PROMISES = [
  { icon: '🤞', text: 'Jaldi milenge — yeh mera waada hai' },
  { icon: '💌', text: 'Har doori ke baad ek milna hoga' },
  { icon: '😘', text: 'Woh naak — ek baar zaroor chumma lunga' },
  { icon: '❤️', text: 'Pyaar aur zyada hoga, har saal' },
  { icon: '🌟', text: 'Tere saath har naya safar karunga' },
];

export default function SlideFinal({ onRestart }) {
  const [wSize, setWSize] = useState({ width: window.innerWidth, height: window.innerHeight });
  const [confetti, setConfetti] = useState(true);

  useEffect(() => {
    const h = () => setWSize({ width: window.innerWidth, height: window.innerHeight });
    window.addEventListener('resize', h);
    const t = setTimeout(() => setConfetti(false), 8000);
    return () => { window.removeEventListener('resize', h); clearTimeout(t); };
  }, []);

  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 50% 50%, #3d0030 0%, #1a0025 50%, #0d0010 100%)',
      display: 'flex', flexDirection: 'column',
      alignItems: 'center', justifyContent: 'center',
      minHeight: '100vh', padding: '40px 20px', textAlign: 'center',
    }}>
      {confetti && (
        <ReactConfetti
          width={wSize.width} height={wSize.height}
          colors={['#e8547a','#f0c060','#8b4fa8','#f9c6d8','#fff']}
          numberOfPieces={320}
          recycle={false}
          gravity={0.2}
          style={{ position: 'fixed', inset: 0, zIndex: 50, pointerEvents: 'none' }}
        />
      )}

      <StarField count={90} />
      <Petals count={24} />

      <motion.div
        initial={{ opacity: 0 }} animate={{ opacity: 1 }}
        transition={{ duration: 1 }}
        style={{ position: 'relative', zIndex: 1, maxWidth: 620 }}
      >
        {/* Big heart pulse */}
        <motion.div
          animate={{ scale: [1, 1.12, 1], filter: ['drop-shadow(0 0 20px #e8547a88)', 'drop-shadow(0 0 40px #e8547acc)', 'drop-shadow(0 0 20px #e8547a88)'] }}
          transition={{ duration: 1.8, repeat: Infinity, ease: 'easeInOut' }}
          style={{ fontSize: 'clamp(4rem,12vw,7rem)', lineHeight: 1, marginBottom: 20 }}
        >
          ❤️
        </motion.div>

        <motion.h1
          initial={{ opacity: 0, y: 30 }} animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 0.3, duration: 0.8 }}
          style={{
            fontFamily: 'var(--font-script)',
            fontSize: 'clamp(2.2rem,7vw,4rem)',
            background: 'linear-gradient(135deg,#f9a8c9,#e8547a,#f0c060)',
            WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent',
            filter: 'drop-shadow(0 0 20px #e8547a55)',
            marginBottom: 8,
          }}
        >
          Soon, baby.
        </motion.h1>
        <motion.h2
          initial={{ opacity: 0, y: 20 }} animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 0.5, duration: 0.8 }}
          style={{
            fontFamily: 'var(--font-script)',
            fontSize: 'clamp(1.4rem,4vw,2rem)',
            color: '#f9c6d8', marginBottom: 36,
          }}
        >
          We'll meet soon. I promise. 🤞
        </motion.h2>

        {/* Promises list */}
        <div style={{ display: 'flex', flexDirection: 'column', gap: 14, marginBottom: 40 }}>
          {PROMISES.map((p, i) => (
            <motion.div
              key={i}
              initial={{ opacity: 0, x: -30 }}
              animate={{ opacity: 1, x: 0 }}
              transition={{ delay: 0.7 + i * 0.15, duration: 0.5 }}
              className="glass"
              style={{
                display: 'flex', alignItems: 'center', gap: 16,
                padding: '14px 22px', textAlign: 'left',
              }}
            >
              <span style={{ fontSize: '1.6rem', flexShrink: 0 }}>{p.icon}</span>
              <p style={{
                fontFamily: 'var(--font-serif)', fontStyle: 'italic',
                color: '#f9d4e3', fontSize: '0.95rem', lineHeight: 1.5,
              }}>
                {p.text}
              </p>
            </motion.div>
          ))}
        </div>

        {/* Closing note */}
        <motion.div
          initial={{ opacity: 0, y: 20 }} animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 1.7, duration: 0.8 }}
          className="glass"
          style={{ padding: '32px 28px', marginBottom: 36 }}
        >
          <p style={{
            fontFamily: 'var(--font-script)', fontSize: 'clamp(1.3rem,3.5vw,1.7rem)',
            color: '#f0c060', marginBottom: 16,
          }}>
            Meri Jaan,
          </p>
          <p style={{
            fontFamily: 'var(--font-serif)', fontStyle: 'italic',
            color: '#f4d4e8', lineHeight: 2, fontSize: 'clamp(0.9rem,2.5vw,1rem)',
          }}>
            Distance is just a test of how far love can travel.<br />
            Aur humara pyaar? Woh toh seedha dil se dil tak pahunchta hai. 💌<br /><br />
            Happy 30th, my most beautiful girl.<br />
            Here's to the woman you are,<br />
            the woman you're becoming,<br />
            and every moment we still have waiting for us. 🌟<br /><br />
            <span style={{ color: '#e8547a' }}>
              Love you from heart to toe…<br />
              and yes, especially that nose. ❤️😂
            </span>
          </p>
          <p style={{
            fontFamily: 'var(--font-script)', fontSize: '1.5rem',
            color: '#e8547a', marginTop: 20, textAlign: 'right',
          }}>
            — Tumhara, hamesha ❤️
          </p>
        </motion.div>

        {/* Date stamp */}
        <motion.p
          initial={{ opacity: 0 }} animate={{ opacity: 1 }}
          transition={{ delay: 2, duration: 0.8 }}
          style={{
            color: '#f0c06077', fontSize: '0.8rem',
            letterSpacing: 3, marginBottom: 32,
          }}
        >
          09 · 09 · 2026 · India 🇮🇳
        </motion.p>

        {/* Restart */}
        <motion.button
          initial={{ opacity: 0 }} animate={{ opacity: 1 }}
          transition={{ delay: 2.2, duration: 0.6 }}
          className="btn btn-ghost"
          onClick={onRestart}
          whileHover={{ scale: 1.04 }}
          whileTap={{ scale: 0.96 }}
        >
          🔁 Start Over
        </motion.button>
      </motion.div>
    </div>
  );
}
