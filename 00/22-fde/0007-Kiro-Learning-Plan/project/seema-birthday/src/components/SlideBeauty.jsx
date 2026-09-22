import { useState } from 'react';
import { motion } from 'framer-motion';
import { BEAUTY_LINES, GALLERY } from '../config';
import StarField from './StarField';
import Petals from './Petals';

// pick 3 most flattering photos from gallery for background rotation
const BEAUTY_PICS = [
  'after-baby-delivery.jpg',
  'our-last-pic-together-in-rect-times.jpeg',
  'happily-ever-after.jpg',
  'before-marriage-date-2.jpg',
];

const imgUrl = (f) => {
  try { return new URL(`../assets/seema/${f}`, import.meta.url).href; }
  catch { return null; }
};

const WINE_YEARS = [
  { year: '2012', label: 'First sip of love', color: '#f0c060' },
  { year: '2015', label: 'Aged in distance',   color: '#e8547a' },
  { year: '2019', label: 'Married & richer',   color: '#8b4fa8' },
  { year: '2025', label: 'Motherhood — finest vintage', color: '#2dd4bf' },
  { year: '2026', label: 'Peak. Still rising.', color: '#f9a8c9' },
];

export default function SlideBeauty({ onNext, onPrev }) {
  const [picIdx, setPicIdx] = useState(0);

  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 40% 60%, #2a0020 0%, #150028 55%, #0d0010 100%)',
      minHeight: '100vh', padding: '0 20px 60px',
      display: 'flex', flexDirection: 'column', alignItems: 'center',
    }}>
      <StarField count={80} />
      <Petals count={20} />
      <div className="nav-spacer" />
      <div style={{ position: 'relative', zIndex: 1, maxWidth: 700, width: '100%' }}>

        {/* heading */}
        <motion.div
          initial={{ opacity: 0, y: -20 }} animate={{ opacity: 1, y: 0 }}
          style={{ textAlign: 'center', marginBottom: 32 }}
        >
          <p style={{
            fontFamily: 'var(--font-script)', fontSize: 'clamp(1.8rem,5vw,2.6rem)',
            background: 'linear-gradient(135deg,#f9a8c9,#e8547a,#f0c060)',
            WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent',
            filter: 'drop-shadow(0 0 18px #e8547a55)',
          }}>
            Jaise Purani Sharaab… 🍷
          </p>
          <p style={{ color: '#f9c6d877', fontSize: '0.85rem', marginTop: 8, fontFamily: 'var(--font-serif)', fontStyle: 'italic' }}>
            Waqt ke saath aur khaas, aur roshan, aur khoobsurat
          </p>
        </motion.div>

        {/* wine bottle + photo side by side */}
        <div style={{ display: 'flex', gap: 20, alignItems: 'flex-start', marginBottom: 32, flexWrap: 'wrap', justifyContent: 'center' }}>

          {/* photo with click-to-change */}
          <motion.div
            initial={{ opacity: 0, scale: 0.9 }} animate={{ opacity: 1, scale: 1 }}
            transition={{ delay: 0.2, duration: 0.6 }}
            onClick={() => setPicIdx(i => (i + 1) % BEAUTY_PICS.length)}
            style={{
              cursor: 'pointer', borderRadius: 20, overflow: 'hidden',
              width: 'clamp(180px,40vw,260px)', flexShrink: 0,
              border: '1px solid rgba(240,192,96,0.3)',
              boxShadow: '0 0 40px rgba(232,84,122,0.25)',
              position: 'relative', background: '#0d0010',
            }}
            whileHover={{ scale: 1.03 }}
            key={picIdx}
          >
            {/* blurred bg */}
            <img src={imgUrl(BEAUTY_PICS[picIdx])} aria-hidden style={{
              position: 'absolute', inset: 0, width: '100%', height: '100%',
              objectFit: 'cover', filter: 'blur(18px) brightness(0.4) saturate(1.5)',
              transform: 'scale(1.1)', pointerEvents: 'none',
            }} />
            <img
              src={imgUrl(BEAUTY_PICS[picIdx])}
              alt="Seema"
              style={{
                position: 'relative', display: 'block',
                width: '100%', maxHeight: 340,
                objectFit: 'contain', objectPosition: 'center top',
              }}
            />
            {/* tap hint */}
            <div style={{
              position: 'absolute', bottom: 10, right: 12,
              background: 'rgba(0,0,0,0.6)', backdropFilter: 'blur(6px)',
              borderRadius: 50, padding: '3px 10px',
              fontSize: '0.68rem', color: '#f0c060',
            }}>
              tap to change ✨
            </div>
          </motion.div>

          {/* wine timeline */}
          <div style={{ flex: 1, minWidth: 220, display: 'flex', flexDirection: 'column', gap: 12 }}>
            <p style={{
              fontFamily: 'var(--font-script)', fontSize: '1.2rem',
              color: '#f0c060', marginBottom: 4,
            }}>
              Seema Vintage Collection 🍷
            </p>
            {WINE_YEARS.map((w, i) => (
              <motion.div
                key={w.year}
                initial={{ opacity: 0, x: 30 }}
                animate={{ opacity: 1, x: 0 }}
                transition={{ delay: 0.3 + i * 0.12, duration: 0.5 }}
                style={{
                  display: 'flex', alignItems: 'center', gap: 12,
                  background: 'rgba(255,255,255,0.05)',
                  border: `1px solid ${w.color}33`,
                  borderRadius: 12, padding: '10px 16px',
                }}
              >
                <div style={{
                  width: 36, height: 36, borderRadius: '50%', flexShrink: 0,
                  background: `radial-gradient(circle at 40% 35%, ${w.color}, ${w.color}66)`,
                  display: 'flex', alignItems: 'center', justifyContent: 'center',
                  fontSize: '0.72rem', fontWeight: 700, color: '#fff',
                  boxShadow: `0 0 10px ${w.color}55`,
                }}>
                  {w.year.slice(2)}
                </div>
                <div>
                  <p style={{ fontFamily: 'var(--font-sans)', fontSize: '0.72rem', color: w.color, letterSpacing: 1 }}>
                    {w.year}
                  </p>
                  <p style={{ fontFamily: 'var(--font-serif)', fontStyle: 'italic', color: '#f0e8f4', fontSize: '0.88rem' }}>
                    {w.label}
                  </p>
                </div>
              </motion.div>
            ))}
          </div>
        </div>

        {/* beauty lines */}
        <div style={{ display: 'flex', flexDirection: 'column', gap: 10, marginBottom: 32 }}>
          {BEAUTY_LINES.map((l, i) => (
            <motion.div
              key={i}
              initial={{ opacity: 0, y: 16 }}
              animate={{ opacity: 1, y: 0 }}
              transition={{ delay: 0.6 + i * 0.1, duration: 0.5 }}
              className="glass"
              style={{ display: 'flex', alignItems: 'center', gap: 14, padding: '12px 20px', textAlign: 'left' }}
            >
              <span style={{ fontSize: '1.5rem', flexShrink: 0 }}>{l.icon}</span>
              <p style={{ fontFamily: 'var(--font-serif)', fontStyle: 'italic', color: '#f4d4e8', fontSize: '0.92rem', lineHeight: 1.5 }}>
                {l.text}
              </p>
            </motion.div>
          ))}
        </div>

        {/* main beauty shayari */}
        <motion.div
          initial={{ opacity: 0, scale: 0.95 }} animate={{ opacity: 1, scale: 1 }}
          transition={{ delay: 1.2, duration: 0.6 }}
          className="glass"
          style={{
            padding: '28px 28px', textAlign: 'center', marginBottom: 28,
            borderColor: 'rgba(240,192,96,0.25)',
            background: 'rgba(240,192,96,0.04)',
          }}
        >
          <p style={{ fontSize: '2rem', marginBottom: 12 }}>🍷✨</p>
          <p style={{
            fontFamily: 'var(--font-serif)', fontStyle: 'italic',
            color: '#f4e0f0', lineHeight: 2,
            fontSize: 'clamp(0.92rem,2.5vw,1.08rem)',
            whiteSpace: 'pre-line',
          }}>{`Log kehte hain umar ke saath
khoobsurti dhalni chahiye —
Seema ke saath toh ulta hota hai.

Har saal thodi aur roshan,
har saal thoda aur gehri.

Jaise purani sharaab —
waqt ke saath aur bhi khaas,
aur bhi behtareen.

34 pe tum 24 se zyada khoobsurat ho —
yeh science nahi, yeh sirf tum ho. 💖`}</p>
        </motion.div>

        {/* nav */}
        <div style={{ display: 'flex', justifyContent: 'space-between', gap: 12 }}>
          <motion.button className="btn btn-ghost" onClick={onPrev} whileHover={{ scale: 1.04 }} style={{ padding: '10px 22px' }}>
            ← Shayari
          </motion.button>
          <motion.button className="btn btn-rose" onClick={onNext} whileHover={{ scale: 1.05 }} whileTap={{ scale: 0.96 }} style={{ padding: '10px 26px' }}>
            Hamare Twins 👶 →
          </motion.button>
        </div>
      </div>
    </div>
  );
}
