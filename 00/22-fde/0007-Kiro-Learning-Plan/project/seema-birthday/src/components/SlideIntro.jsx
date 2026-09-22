import { motion } from 'framer-motion';
import { BIRTHDAY } from '../config';
import StarField from './StarField';
import Petals from './Petals';

const fade = { hidden: { opacity: 0, y: 40 }, show: { opacity: 1, y: 0 } };

export default function SlideIntro({ onNext }) {
  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 60% 40%, #3d0030 0%, #1a0020 50%, #0d0010 100%)',
      display: 'flex', flexDirection: 'column',
      alignItems: 'center', justifyContent: 'center',
      minHeight: '100vh', padding: '0 20px 40px', textAlign: 'center',
    }}>
      <StarField count={120} />
      <Petals count={22} />
      <div className="nav-spacer" />

      <motion.div
        initial="hidden" animate="show"
        transition={{ staggerChildren: 0.22 }}
        style={{ position: 'relative', zIndex: 1, maxWidth: 660 }}
      >
        {/* date badge */}
        <motion.div variants={fade} transition={{ duration: 0.7 }}>
          <span style={{
            fontFamily: 'var(--font-script)', fontSize: 'clamp(1rem,3vw,1.3rem)',
            color: '#f0c060', letterSpacing: 3,
            background: 'rgba(240,192,96,0.1)', padding: '6px 22px',
            borderRadius: 50, border: '1px solid rgba(240,192,96,0.3)',
          }}>
            14 · 09 · 2026 🌹
          </span>
        </motion.div>

        {/* headline */}
        <motion.h1 variants={fade} transition={{ duration: 0.8 }} style={{
          fontFamily: 'var(--font-script)',
          fontSize: 'clamp(2.6rem,9vw,6rem)',
          lineHeight: 1.1, marginTop: 20,
          background: 'linear-gradient(135deg,#f9a8c9,#e8547a,#f0c060)',
          WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent',
          filter: 'drop-shadow(0 0 28px #e8547a88)',
        }}>
          Happy Birthday
        </motion.h1>

        <motion.h2 variants={fade} transition={{ duration: 0.8 }} style={{
          fontFamily: 'var(--font-script)',
          fontSize: 'clamp(2.2rem,7vw,4.2rem)',
          color: '#f9c6d8', marginTop: 4,
          textShadow: '0 0 28px #e8547a99',
        }}>
          Seema 🌹
        </motion.h2>

        {/* 33 ring */}
        <motion.div variants={fade} transition={{ duration: 0.9 }}
          style={{ margin: '28px auto', position: 'relative', width: 170, height: 170 }}>
          {[...Array(12)].map((_, i) => (
            <div key={i} style={{
              position: 'absolute', inset: 0,
              border: `1.5px solid rgba(240,192,96,${0.06 + i * 0.02})`,
              borderRadius: '50%',
              transform: `scale(${0.28 + i * 0.07})`,
              animation: `twinkle ${1.6 + i * 0.18}s ease-in-out infinite`,
            }} />
          ))}
          <div style={{
            position: 'absolute', inset: 0,
            display: 'flex', flexDirection: 'column',
            alignItems: 'center', justifyContent: 'center',
          }}>
            <span style={{
              fontFamily: 'var(--font-serif)', fontSize: '4.2rem', fontWeight: 700,
              background: 'linear-gradient(135deg,#f0c060,#e8547a)',
              WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent',
              filter: 'drop-shadow(0 0 14px #f0c06099)',
            }}>{BIRTHDAY.turningAge}</span>
            <span style={{ fontSize: '0.6rem', color: '#f9c6d8', letterSpacing: 4, marginTop: -8 }}>
              BEAUTIFUL YEARS
            </span>
          </div>
        </motion.div>

        {/* tagline */}
        <motion.p variants={fade} transition={{ duration: 0.8 }} style={{
          fontFamily: 'var(--font-serif)', fontStyle: 'italic',
          fontSize: 'clamp(1rem,2.8vw,1.3rem)',
          color: '#f9d4e3', lineHeight: 1.8, marginBottom: 10,
        }}>
          "{BIRTHDAY.tagline}"
        </motion.p>

        <motion.p variants={fade} transition={{ duration: 0.7 }} style={{
          color: '#f0c06088', fontSize: '0.88rem', marginBottom: 38,
          fontFamily: 'var(--font-sans)',
        }}>
          A journey through 34 years — made just for you 🎁
        </motion.p>

        <motion.button
          variants={fade} transition={{ duration: 0.7 }}
          className="btn btn-rose"
          onClick={onNext}
          whileHover={{ scale: 1.06 }}
          whileTap={{ scale: 0.96 }}
          style={{ fontSize: '1.1rem', padding: '16px 52px' }}
        >
          Begin Our Story 🌹
        </motion.button>
      </motion.div>
    </div>
  );
}
