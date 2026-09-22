import { motion } from 'framer-motion';
import StarField from './StarField';
import Petals from './Petals';

const fade = { hidden: { opacity: 0, y: 40 }, show: { opacity: 1, y: 0 } };

export default function SlideIntro({ onNext }) {
  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 60% 40%, #3d0030 0%, #1a0020 50%, #0d0010 100%)',
      display: 'flex', flexDirection: 'column',
      alignItems: 'center', justifyContent: 'center',
      minHeight: '100vh', padding: '40px 20px', textAlign: 'center',
    }}>
      <StarField count={100} />
      <Petals count={20} />

      <motion.div
        initial="hidden" animate="show"
        transition={{ staggerChildren: 0.25 }}
        style={{ position: 'relative', zIndex: 1, maxWidth: 640 }}
      >
        {/* Date badge */}
        <motion.div variants={fade} transition={{ duration: 0.7 }}>
          <span style={{
            fontFamily: 'var(--font-script)',
            fontSize: 'clamp(1rem,3vw,1.3rem)',
            color: '#f0c060',
            letterSpacing: 3,
            background: 'rgba(240,192,96,0.12)',
            padding: '6px 20px', borderRadius: 50,
            border: '1px solid rgba(240,192,96,0.3)',
          }}>
            09 · 09 · 1997 &nbsp;→&nbsp; 09 · 09 · 2026
          </span>
        </motion.div>

        {/* Main headline */}
        <motion.h1 variants={fade} transition={{ duration: 0.8 }}
          style={{
            fontFamily: 'var(--font-script)',
            fontSize: 'clamp(2.8rem,9vw,6rem)',
            lineHeight: 1.1,
            marginTop: 24,
            background: 'linear-gradient(135deg, #f9a8c9, #e8547a, #f0c060)',
            WebkitBackgroundClip: 'text',
            WebkitTextFillColor: 'transparent',
            filter: 'drop-shadow(0 0 24px #e8547a88)',
          }}>
          Happy Birthday
        </motion.h1>

        <motion.h2 variants={fade} transition={{ duration: 0.8 }}
          style={{
            fontFamily: 'var(--font-script)',
            fontSize: 'clamp(1.8rem,5vw,3.2rem)',
            color: '#f9c6d8',
            marginTop: 8,
            textShadow: '0 0 20px #e8547a66',
          }}>
          Meri Jaan ❤️
        </motion.h2>

        {/* 30 ring */}
        <motion.div variants={fade} transition={{ duration: 0.9 }}
          style={{ margin: '32px auto', position: 'relative', width: 160, height: 160 }}>
          {[...Array(12)].map((_, i) => (
            <div key={i} style={{
              position: 'absolute', inset: 0,
              border: '2px solid rgba(240,192,96,0.15)',
              borderRadius: '50%',
              transform: `scale(${0.3 + i * 0.07})`,
              animation: `twinkle ${1.5 + i * 0.2}s ease-in-out infinite`,
            }} />
          ))}
          <div style={{
            position: 'absolute', inset: 0,
            display: 'flex', flexDirection: 'column',
            alignItems: 'center', justifyContent: 'center',
          }}>
            <span style={{
              fontFamily: 'var(--font-serif)',
              fontSize: '4rem', fontWeight: 700,
              background: 'linear-gradient(135deg,#f0c060,#e8547a)',
              WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent',
              filter: 'drop-shadow(0 0 12px #f0c06088)',
            }}>30</span>
            <span style={{ fontSize: '0.7rem', color: '#f9c6d8', letterSpacing: 3, marginTop: -6 }}>
              BEAUTIFUL YEARS
            </span>
          </div>
        </motion.div>

        <motion.p variants={fade} transition={{ duration: 0.8 }}
          style={{
            fontFamily: 'var(--font-serif)', fontStyle: 'italic',
            fontSize: 'clamp(1rem,2.5vw,1.25rem)',
            color: '#f9d4e3', lineHeight: 1.8, marginBottom: 12,
          }}>
          "Tum sirf 30 nahi ho rahi…<br />
          tum ek naye, aur bhi khoobsurat chapter mein<br />
          qadam rakh rahi ho." ✨
        </motion.p>

        <motion.p variants={fade} transition={{ duration: 0.7 }}
          style={{ color: '#f0c06099', fontSize: '0.85rem', marginBottom: 36 }}>
          A little something made just for you 🎁
        </motion.p>

        <motion.button
          variants={fade} transition={{ duration: 0.7 }}
          className="btn btn-rose"
          onClick={onNext}
          whileHover={{ scale: 1.06 }}
          whileTap={{ scale: 0.96 }}
          style={{ fontSize: '1.1rem', padding: '16px 48px' }}
        >
          Open Your Gift 🎀
        </motion.button>
      </motion.div>
    </div>
  );
}
