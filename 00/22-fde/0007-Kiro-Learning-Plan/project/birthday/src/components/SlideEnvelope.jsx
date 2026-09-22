import { useState } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import StarField from './StarField';

export default function SlideEnvelope({ onNext }) {
  const [opened, setOpened] = useState(false);

  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 30% 70%, #200030 0%, #150018 60%, #0d0010 100%)',
      display: 'flex', flexDirection: 'column',
      alignItems: 'center', justifyContent: 'center',
      minHeight: '100vh', padding: '40px 20px', textAlign: 'center',
    }}>
      <StarField count={70} />

      <motion.p
        initial={{ opacity: 0, y: -20 }} animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.8 }}
        style={{
          fontFamily: 'var(--font-script)', fontSize: 'clamp(1.2rem,4vw,1.8rem)',
          color: '#f0c060', marginBottom: 40, position: 'relative', zIndex: 1,
        }}
      >
        A letter sealed with love… 💌
      </motion.p>

      <div style={{ position: 'relative', zIndex: 1, width: 320, maxWidth: '90vw' }}>
        {/* Envelope */}
        <motion.div
          onClick={() => !opened && setOpened(true)}
          style={{ cursor: opened ? 'default' : 'pointer', position: 'relative' }}
          whileHover={!opened ? { scale: 1.04 } : {}}
        >
          {/* Envelope body */}
          <div style={{
            width: '100%', paddingBottom: '65%',
            background: 'linear-gradient(160deg, #6b1a3a 0%, #3d0028 100%)',
            borderRadius: 16,
            border: '1.5px solid rgba(240,192,96,0.4)',
            position: 'relative',
            boxShadow: '0 12px 48px #e8547a44',
          }}>
            {/* Envelope flap */}
            <motion.div
              animate={opened ? { rotateX: -180, y: -20 } : { rotateX: 0 }}
              transition={{ duration: 0.8, ease: 'easeInOut' }}
              style={{
                position: 'absolute', top: 0, left: 0, right: 0,
                height: '50%',
                background: 'linear-gradient(160deg, #9b2a5a 0%, #6b1a3a 100%)',
                borderRadius: '16px 16px 0 0',
                clipPath: 'polygon(0 0, 50% 60%, 100% 0)',
                transformOrigin: 'top center',
                transformStyle: 'preserve-3d',
              }}
            />
            {/* Wax seal */}
            <AnimatePresence>
              {!opened && (
                <motion.div
                  exit={{ scale: 0, opacity: 0 }}
                  style={{
                    position: 'absolute', top: '50%', left: '50%',
                    transform: 'translate(-50%, -50%)',
                    width: 60, height: 60, borderRadius: '50%',
                    background: 'radial-gradient(circle at 40% 35%, #f0c060, #c07820)',
                    border: '2px solid rgba(255,255,255,0.3)',
                    display: 'flex', alignItems: 'center', justifyContent: 'center',
                    fontSize: '1.6rem',
                    boxShadow: '0 4px 16px #f0c06044',
                    zIndex: 2,
                  }}
                >❤️</motion.div>
              )}
            </AnimatePresence>
          </div>
        </motion.div>

        {/* Hint text */}
        <AnimatePresence>
          {!opened && (
            <motion.p
              exit={{ opacity: 0 }}
              style={{ color: '#f9c6d8', fontSize: '0.85rem', marginTop: 16 }}
              animate={{ opacity: [0.5,1,0.5] }}
              transition={{ duration: 2, repeat: Infinity }}
            >
              Tap the envelope to open 💝
            </motion.p>
          )}
        </AnimatePresence>

        {/* Letter that slides out */}
        <AnimatePresence>
          {opened && (
            <motion.div
              initial={{ y: 0, opacity: 0, scale: 0.8 }}
              animate={{ y: -20, opacity: 1, scale: 1 }}
              transition={{ delay: 0.5, duration: 0.7, ease: 'easeOut' }}
              className="glass"
              style={{
                marginTop: 24, padding: '32px 28px',
                textAlign: 'left', position: 'relative',
              }}
            >
              <p style={{
                fontFamily: 'var(--font-script)', fontSize: '1.8rem',
                color: '#f0c060', marginBottom: 16,
              }}>
                Meri Pyaari Jaan,
              </p>
              <p style={{
                fontFamily: 'var(--font-serif)', fontStyle: 'italic',
                color: '#f9d4e3', lineHeight: 1.9, fontSize: '1rem',
              }}>
                Aaj ka din sirf ek birthday nahi hai…<br />
                yeh ek celebration hai — teri strength ka,<br />
                teri khoobsurti ka, teri rooh ka.<br /><br />
                9 September 1997 ko duniya mein kuch<br />
                bahut khaas aaya tha. <em>Tum.</em><br /><br />
                Aur aaj, 30 saal baad, tum aur bhi<br />
                roshan ho — jaise sone ko aag se<br />
                aur chamak milti hai. ✨<br /><br />
                Har page is letter mein tumhare liye hai.<br />
                Keep going…
              </p>
              <p style={{
                fontFamily: 'var(--font-script)', fontSize: '1.3rem',
                color: '#e8547a', marginTop: 20, textAlign: 'right',
              }}>
                — Tumhara ❤️
              </p>
              <div style={{ textAlign: 'center', marginTop: 28 }}>
                <motion.button
                  className="btn btn-rose"
                  onClick={onNext}
                  whileHover={{ scale: 1.05 }}
                  whileTap={{ scale: 0.96 }}
                >
                  Continue 💖
                </motion.button>
              </div>
            </motion.div>
          )}
        </AnimatePresence>
      </div>
    </div>
  );
}
