import { useState } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { SHAYARIS } from '../config';
import StarField from './StarField';
import Petals from './Petals';

export default function SlideShayari({ onNext, onPrev }) {
  const [current, setCurrent] = useState(0);
  const isLast = current === SHAYARIS.length - 1;

  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 20% 80%, #300020 0%, #1a0030 60%, #0d0010 100%)',
      display: 'flex', flexDirection: 'column',
      alignItems: 'center',
      minHeight: '100vh', padding: '0 20px 40px',
    }}>
      <StarField count={55} />
      <Petals count={12} />
      <div className="nav-spacer" />
      <div style={{ position: 'relative', zIndex: 1, maxWidth: 580, width: '100%', paddingTop: 0 }}>
        {/* header */}
        <motion.div
          initial={{ opacity: 0, y: -20 }} animate={{ opacity: 1, y: 0 }}
          style={{ textAlign: 'center', marginBottom: 28 }}
        >
          <span style={{
            fontFamily: 'var(--font-script)', fontSize: 'clamp(1.8rem,5vw,2.6rem)',
            color: '#f0c060', textShadow: '0 0 22px #f0c06066',
          }}>
            Shayari Tumhare Naam 💛
          </span>
          <p style={{ color: '#f9c6d877', fontSize: '0.8rem', marginTop: 6 }}>
            {current + 1} / {SHAYARIS.length}
          </p>
        </motion.div>

        {/* card */}
        <AnimatePresence mode="wait">
          <motion.div
            key={current}
            initial={{ opacity: 0, rotateY: 18, scale: 0.93 }}
            animate={{ opacity: 1, rotateY: 0, scale: 1 }}
            exit={{ opacity: 0, rotateY: -18, scale: 0.93 }}
            transition={{ duration: 0.5, ease: 'easeInOut' }}
            className="glass"
            style={{
              padding: '40px 32px', textAlign: 'center', minHeight: 290,
              borderColor: 'rgba(240,192,96,0.2)',
              background: 'rgba(240,192,96,0.04)',
            }}
          >
            <span style={{
              display: 'inline-block',
              background: 'rgba(240,192,96,0.12)',
              border: '1px solid rgba(240,192,96,0.28)',
              color: '#f0c060', fontSize: '0.72rem',
              padding: '3px 14px', borderRadius: 50,
              letterSpacing: 2, marginBottom: 18,
            }}>
              {SHAYARIS[current].tag.toUpperCase()}
            </span>

            <div style={{ fontSize: '2.6rem', marginBottom: 20 }}>
              {SHAYARIS[current].emoji}
            </div>

            <p style={{
              fontFamily: 'var(--font-serif)', fontStyle: 'italic',
              color: '#f4e0f0',
              fontSize: 'clamp(0.92rem,2.5vw,1.1rem)',
              lineHeight: 2.05,
              whiteSpace: 'pre-line',
            }}>
              {SHAYARIS[current].text}
            </p>
          </motion.div>
        </AnimatePresence>

        {/* dot nav */}
        <div style={{ display: 'flex', justifyContent: 'center', gap: 8, margin: '18px 0' }}>
          {SHAYARIS.map((_, i) => (
            <button key={i} onClick={() => setCurrent(i)} style={{
              width: i === current ? 26 : 8, height: 8, borderRadius: 4,
              background: i === current ? '#f0c060' : 'rgba(255,255,255,0.18)',
              border: 'none', cursor: 'pointer', padding: 0, transition: 'all 0.3s',
            }} />
          ))}
        </div>

        {/* nav buttons */}
        <div style={{ display: 'flex', justifyContent: 'space-between', gap: 12 }}>
          <motion.button
            className="btn btn-ghost"
            onClick={current === 0 ? onPrev : () => setCurrent(c => c - 1)}
            whileHover={{ scale: 1.04 }}
            style={{ padding: '10px 22px' }}
          >
            {current === 0 ? '← Nazm' : '← Pehle'}
          </motion.button>
          <motion.button
            className={`btn ${isLast ? 'btn-rose' : 'btn-gold'}`}
            onClick={isLast ? onNext : () => setCurrent(c => c + 1)}
            whileHover={{ scale: 1.05 }}
            whileTap={{ scale: 0.96 }}
            style={{ padding: '10px 26px' }}
          >
            {isLast ? 'Photos 📸' : 'Agle →'}
          </motion.button>
        </div>
      </div>
    </div>
  );
}
