import { useState, useEffect } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import ReactConfetti from 'react-confetti';
import StarField from './StarField';
import Petals from './Petals';

// ── Candle ────────────────────────────────────────────────────────────────────
// The flame flicker lives in a *nested* element separate from the
// AnimatePresence wrapper so the exit transition fires cleanly and immediately.
function Candle({ lit, onBlow, index }) {
  return (
    <motion.div
      onClick={lit ? onBlow : undefined}
      whileHover={lit ? { scale: 1.18 } : {}}
      style={{
        cursor: lit ? 'pointer' : 'default',
        display: 'flex', flexDirection: 'column', alignItems: 'center',
        // big tap target
        padding: '8px 10px',
        userSelect: 'none',
      }}
      title={lit ? 'Tap to blow! 💨' : ''}
    >
      {/* ── flame slot (fixed height so cake doesn't jump) ── */}
      <div style={{ width: 28, height: 52, display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'flex-end' }}>
        <AnimatePresence mode="wait">
          {lit && (
            <motion.div
              key={`flame-${index}`}
              // enter: grow up from nothing
              initial={{ scaleY: 0, opacity: 0 }}
              animate={{ scaleY: 1, opacity: 1 }}
              // exit: shrink to nothing immediately — no repeat on exit
              exit={{ scaleY: 0, opacity: 0, transition: { duration: 0.18, ease: 'easeIn' } }}
              transition={{ duration: 0.25 }}
              style={{ transformOrigin: 'bottom center', width: '100%', display: 'flex', flexDirection: 'column', alignItems: 'center' }}
            >
              {/* outer glow */}
              <motion.div
                animate={{ scaleX: [1, 1.25, 0.85, 1.15, 1], scaleY: [1, 0.9, 1.2, 0.95, 1], opacity: [1, 0.85, 1, 0.9, 1] }}
                transition={{ duration: 0.65, repeat: Infinity, ease: 'easeInOut' }}
                style={{
                  width: 22, height: 34,
                  borderRadius: '55% 55% 30% 30%',
                  background: 'radial-gradient(ellipse at 50% 75%, #fff9c4 0%, #ffcc00 35%, #ff8c00 65%, #ff3b00 100%)',
                  boxShadow: '0 0 18px 6px #ff8c0088, 0 0 36px 10px #ff8c0033',
                  transformOrigin: 'bottom center',
                  marginBottom: 2,
                }}
              />
              {/* inner white core */}
              <div style={{
                position: 'absolute',
                bottom: 14,
                width: 8, height: 14,
                borderRadius: '50% 50% 30% 30%',
                background: 'radial-gradient(ellipse at 50% 80%, #fff 40%, rgba(255,255,200,0))',
                pointerEvents: 'none',
              }} />
            </motion.div>
          )}
        </AnimatePresence>
      </div>

      {/* wick */}
      <div style={{
        width: 3, height: 8,
        background: lit ? '#8B4513' : '#444',
        borderRadius: 2,
        marginBottom: 1,
        transition: 'background 0.3s',
      }} />

      {/* candle body */}
      <motion.div
        animate={lit ? {
          boxShadow: ['0 0 8px #e8547a44', '0 0 18px #e8547a88', '0 0 8px #e8547a44'],
        } : { boxShadow: 'none' }}
        transition={{ duration: 1.2, repeat: Infinity }}
        style={{
          width: 20, height: 52,
          background: lit
            ? 'linear-gradient(180deg, #ffd6e8 0%, #f9a8c9 40%, #e8547a 100%)'
            : 'linear-gradient(180deg, #aaa 0%, #666 100%)',
          borderRadius: '5px 5px 3px 3px',
          transition: 'background 0.5s',
        }}
      />
    </motion.div>
  );
}

// ── Cake ──────────────────────────────────────────────────────────────────────
function Cake({ candles, onBlow }) {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
      {/* candles */}
      <div style={{ display: 'flex', gap: 8, alignItems: 'flex-end', marginBottom: 0 }}>
        {candles.map((lit, i) => (
          <Candle key={i} index={i} lit={lit} onBlow={() => onBlow(i)} />
        ))}
      </div>

      {/* top tier */}
      <div style={{
        width: 180, height: 60,
        background: 'linear-gradient(135deg,#f9c6d8,#e8547a,#c03060)',
        borderRadius: '12px 12px 0 0',
        display: 'flex', alignItems: 'center', justifyContent: 'center',
        boxShadow: '0 4px 20px #e8547a55',
        border: '2px solid rgba(255,255,255,0.3)',
        position: 'relative', overflow: 'hidden',
      }}>
        {[16,42,68,94,120,146].map(x => (
          <div key={x} style={{ position:'absolute', top:-7, left:x, width:13, height:20, background:'rgba(255,255,255,0.75)', borderRadius:'0 0 8px 8px' }} />
        ))}
        <span style={{ fontSize:'1.5rem', zIndex:1 }}>🌹 🌸 🌹</span>
      </div>

      {/* middle tier */}
      <div style={{
        width: 240, height: 72,
        background: 'linear-gradient(135deg,#f0c060,#d4903a,#b07020)',
        display: 'flex', alignItems: 'center', justifyContent: 'center',
        boxShadow: '0 4px 20px #f0c06055',
        border: '2px solid rgba(255,255,255,0.2)', borderTop:'none',
        position: 'relative', overflow: 'hidden',
      }}>
        {[10,40,72,104,136,168,200].map(x => (
          <div key={x} style={{ position:'absolute', top:-7, left:x, width:13, height:20, background:'rgba(255,255,255,0.55)', borderRadius:'0 0 8px 8px' }} />
        ))}
        <span style={{ fontFamily:'var(--font-script)', color:'#fff', fontSize:'1.2rem', fontWeight:700, textShadow:'0 1px 4px rgba(0,0,0,0.5)', zIndex:1 }}>
          Happy 30th ❤️
        </span>
      </div>

      {/* bottom tier */}
      <div style={{
        width: 300, height: 84,
        background: 'linear-gradient(135deg,#8b4fa8,#5c2a7a,#3d1655)',
        borderRadius: '0 0 12px 12px',
        display: 'flex', alignItems: 'center', justifyContent: 'center',
        boxShadow: '0 8px 32px #8b4fa855',
        border: '2px solid rgba(255,255,255,0.15)', borderTop:'none',
        position: 'relative', overflow: 'hidden',
      }}>
        {[10,46,82,118,154,190,226,262].map(x => (
          <div key={x} style={{ position:'absolute', top:-7, left:x, width:14, height:22, background:'rgba(255,255,255,0.28)', borderRadius:'0 0 8px 8px' }} />
        ))}
        <span style={{ fontFamily:'var(--font-script)', color:'#f9c6d8', fontSize:'1.1rem', zIndex:1 }}>9 · 9 · 1997 💖</span>
      </div>

      {/* plate */}
      <div style={{
        width: 340, height: 18,
        background: 'linear-gradient(180deg,#d8d8d8,#a0a0a0)',
        borderRadius: '0 0 50px 50px',
        boxShadow: '0 6px 24px rgba(0,0,0,0.5)',
      }} />
    </div>
  );
}

// ── Main slide ────────────────────────────────────────────────────────────────
export default function SlideCake({ onNext }) {
  const [candles, setCandles]       = useState(Array(5).fill(true));
  const [allBlown, setAllBlown]     = useState(false);
  const [showMessage, setShowMessage] = useState(false);
  const [windowSize, setWindowSize] = useState({ width: window.innerWidth, height: window.innerHeight });

  useEffect(() => {
    const h = () => setWindowSize({ width: window.innerWidth, height: window.innerHeight });
    window.addEventListener('resize', h);
    return () => window.removeEventListener('resize', h);
  }, []);

  const blowCandle = (i) => {
    const next = candles.map((c, idx) => idx === i ? false : c);
    setCandles(next);
    if (next.every(c => !c)) {
      setTimeout(() => setAllBlown(true),  350);
      setTimeout(() => setShowMessage(true), 1100);
    }
  };

  const relightAll = () => {
    setCandles(Array(5).fill(true));
    setAllBlown(false);
    setShowMessage(false);
  };

  const litCount = candles.filter(Boolean).length;

  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 50% 50%,#2a0018 0%,#180030 50%,#0d0010 100%)',
      display: 'flex', flexDirection: 'column',
      alignItems: 'center', justifyContent: 'center',
      minHeight: '100vh', padding: '40px 20px', textAlign: 'center',
    }}>
      {allBlown && (
        <ReactConfetti
          width={windowSize.width} height={windowSize.height}
          colors={['#e8547a','#f0c060','#8b4fa8','#f9c6d8','#fff','#ff8c00']}
          numberOfPieces={300} recycle={false} gravity={0.22}
          style={{ position:'fixed', inset:0, zIndex:50, pointerEvents:'none' }}
        />
      )}

      <StarField count={60} />
      <Petals count={16} />

      <div style={{ position:'relative', zIndex:1 }}>

        {/* ── headline ── */}
        <motion.div initial={{ opacity:0, y:-20 }} animate={{ opacity:1, y:0 }} style={{ marginBottom:28 }}>
          <p style={{
            fontFamily: 'var(--font-script)',
            fontSize: 'clamp(1.8rem,5vw,2.6rem)',
            color: '#f9c6d8', textShadow: '0 0 20px #e8547a66',
          }}>
            {allBlown ? 'Wish granted! 🌟' : 'Blow the candles, meri jaan! 🕯️'}
          </p>

          {/* ── hint & counter — big and visible ── */}
          {!allBlown && (
            <motion.div
              animate={{ opacity:[0.7,1,0.7] }}
              transition={{ duration:2, repeat:Infinity }}
              style={{ marginTop:12 }}
            >
              <p style={{
                color: '#f9c6d8',
                fontSize: 'clamp(1rem,3vw,1.25rem)',   /* was 0.82rem — now much larger */
                fontFamily: 'var(--font-sans)',
                fontWeight: 400,
              }}>
                Tap each flame to blow it out 💨
              </p>
              <p style={{
                color: '#f0c060',
                fontSize: 'clamp(1.1rem,3.5vw,1.4rem)', /* was 0.8rem — now larger */
                fontFamily: 'var(--font-script)',
                marginTop: 6,
              }}>
                {litCount} candle{litCount !== 1 ? 's' : ''} left 🕯️
              </p>
            </motion.div>
          )}
        </motion.div>

        {/* ── cake ── */}
        <motion.div
          initial={{ scale:0.8, opacity:0 }}
          animate={{ scale:1, opacity:1 }}
          transition={{ delay:0.3, duration:0.6, type:'spring' }}
        >
          <Cake candles={candles} onBlow={blowCandle} />
        </motion.div>

        {/* ── blown message ── */}
        <AnimatePresence>
          {showMessage && (
            <motion.div
              initial={{ opacity:0, y:40, scale:0.9 }}
              animate={{ opacity:1, y:0, scale:1 }}
              transition={{ duration:0.7, type:'spring' }}
              className="glass"
              style={{ maxWidth:520, margin:'36px auto 0', padding:'36px 28px' }}
            >
              <p style={{ fontSize:'2.8rem', marginBottom:12 }}>🎂✨🎉</p>
              <p style={{
                fontFamily:'var(--font-script)',
                fontSize:'clamp(1.6rem,4vw,2rem)',
                color:'#f0c060', marginBottom:16,
                textShadow:'0 0 20px #f0c06066',
              }}>
                Happy 30th Birthday!
              </p>
              <p style={{
                fontFamily:'var(--font-serif)', fontStyle:'italic',
                color:'#f4d4e8', lineHeight:1.9,
                fontSize:'clamp(0.95rem,2.5vw,1.05rem)',
              }}>
                Tumne ek wish ki…<br />
                Maine bhi — ki tumhari har dua poori ho.<br />
                Har sapna sach ho. Har khushi tumhari ho. 🌟<br /><br />
                30 ho ya 3000 — tum meri sab se khoobsurat dua ho. ❤️
              </p>
              <div style={{ display:'flex', gap:12, justifyContent:'center', marginTop:24 }}>
                <button className="btn btn-ghost" onClick={relightAll} style={{ fontSize:'0.9rem', padding:'10px 22px' }}>
                  🕯️ Relight
                </button>
                <motion.button
                  className="btn btn-rose"
                  onClick={onNext}
                  whileHover={{ scale:1.05 }}
                  whileTap={{ scale:0.96 }}
                >
                  Final Promise 💌
                </motion.button>
              </div>
            </motion.div>
          )}
        </AnimatePresence>
      </div>
    </div>
  );
}
