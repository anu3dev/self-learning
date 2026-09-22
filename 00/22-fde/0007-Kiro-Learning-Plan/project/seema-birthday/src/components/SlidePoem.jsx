import { useState } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { POEM_STANZAS } from '../config';
import StarField from './StarField';
import Petals from './Petals';

export default function SlidePoem({ onNext, onPrev }) {
  const [current, setCurrent] = useState(0);
  const isLast = current === POEM_STANZAS.length - 1;

  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 70% 30%, #2a0040 0%, #180025 55%, #0d0010 100%)',
      display: 'flex', flexDirection: 'column',
      alignItems: 'center',
      minHeight: '100vh', padding: '0 20px 40px',
    }}>
      <StarField count={65} />
      <Petals count={14} />
      <div className="nav-spacer" />
      <div style={{ position: 'relative', zIndex: 1, maxWidth: 580, width: '100%', paddingTop: 0 }}>
        {/* header */}
        <motion.div
          initial={{ opacity: 0, y: -20 }} animate={{ opacity: 1, y: 0 }}
          style={{ textAlign: 'center', marginBottom: 28 }}
        >
          <span style={{
            fontFamily: 'var(--font-script)', fontSize: 'clamp(1.8rem,5vw,2.6rem)',
            background: 'linear-gradient(135deg,#f9a8c9,#e8547a,#f0c060)',
            WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent',
            filter: 'drop-shadow(0 0 16px #e8547a55)',
          }}>
            Tumhare Liye Ek Nazm 🌹
          </span>
          {/* progress dots */}
          <div style={{ display: 'flex', justifyContent: 'center', gap: 8, marginTop: 14 }}>
            {POEM_STANZAS.map((_, i) => (
              <button key={i} onClick={() => setCurrent(i)} style={{
                width: i === current ? 28 : 8, height: 8, borderRadius: 4,
                background: i === current ? '#e8547a' : 'rgba(255,255,255,0.18)',
                border: 'none', cursor: 'pointer', padding: 0, transition: 'all 0.35s',
              }} />
            ))}
          </div>
        </motion.div>

        {/* stanza card */}
        <AnimatePresence mode="wait">
          <motion.div
            key={current}
            initial={{ opacity: 0, x: 50, scale: 0.96 }}
            animate={{ opacity: 1, x: 0, scale: 1 }}
            exit={{ opacity: 0, x: -50, scale: 0.96 }}
            transition={{ duration: 0.45, ease: 'easeInOut' }}
            className="glass"
            style={{ padding: '36px 32px', textAlign: 'center', minHeight: 280 }}
          >
            {/* tag */}
            <span style={{
              display: 'inline-block',
              background: 'rgba(232,84,122,0.15)',
              border: '1px solid rgba(232,84,122,0.35)',
              color: '#e8547a', fontSize: '0.72rem',
              padding: '3px 14px', borderRadius: 50,
              letterSpacing: 2, marginBottom: 18,
            }}>
              {POEM_STANZAS[current].tag.toUpperCase()}
            </span>

            <div style={{ fontSize: '2.6rem', marginBottom: 18 }}>
              {POEM_STANZAS[current].emoji}
            </div>

            {POEM_STANZAS[current].lines.map((line, i) => (
              <motion.p
                key={i}
                initial={{ opacity: 0, y: 8 }}
                animate={{ opacity: 1, y: 0 }}
                transition={{ delay: i * 0.06, duration: 0.35 }}
                style={{
                  fontFamily: 'var(--font-serif)', fontStyle: 'italic',
                  color: line === '' ? 'transparent' : '#f0e8f4',
                  fontSize: 'clamp(0.92rem,2.5vw,1.08rem)',
                  lineHeight: 1.95,
                  fontWeight: line.startsWith('Happy') || line.startsWith('"') ? 600 : 400,
                  marginBottom: line === '' ? 6 : 0,
                  userSelect: 'text',
                }}
              >
                {line || '\u00A0'}
              </motion.p>
            ))}
          </motion.div>
        </AnimatePresence>

        {/* nav */}
        <div style={{ display: 'flex', justifyContent: 'space-between', marginTop: 22, gap: 12 }}>
          <motion.button
            className="btn btn-ghost"
            onClick={current === 0 ? onPrev : () => setCurrent(c => c - 1)}
            whileHover={{ scale: 1.04 }}
            style={{ padding: '10px 22px' }}
          >
            {current === 0 ? '← Story' : '← Pehle'}
          </motion.button>
          <motion.button
            className={`btn ${isLast ? 'btn-rose' : 'btn-gold'}`}
            onClick={isLast ? onNext : () => setCurrent(c => c + 1)}
            whileHover={{ scale: 1.05 }}
            whileTap={{ scale: 0.96 }}
            style={{ padding: '10px 26px' }}
          >
            {isLast ? 'Shayari 💛' : 'Next →'}
          </motion.button>
        </div>
      </div>
    </div>
  );
}
