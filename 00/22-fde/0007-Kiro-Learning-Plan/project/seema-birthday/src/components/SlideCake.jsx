import { useState, useEffect } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import ReactConfetti from 'react-confetti';
import StarField from './StarField';
import Petals from './Petals';

// ── Single candle ─────────────────────────────────────────────────────────────
function Candle({ lit, onBlow, index }) {
  return (
    <motion.div
      onClick={lit ? onBlow : undefined}
      whileHover={lit ? { scale: 1.18 } : {}}
      style={{
        cursor: lit ? 'pointer' : 'default',
        display: 'flex', flexDirection: 'column', alignItems: 'center',
        padding: '8px 10px', userSelect: 'none',
      }}
      title={lit ? 'Tap to blow! 💨' : ''}
    >
      {/* flame slot – fixed height so cake never jumps */}
      <div style={{ width: 28, height: 52, display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'flex-end' }}>
        <AnimatePresence mode="wait">
          {lit && (
            <motion.div
              key={`flame-${index}`}
              initial={{ scaleY: 0, opacity: 0 }}
              animate={{ scaleY: 1, opacity: 1 }}
              exit={{ scaleY: 0, opacity: 0, transition: { duration: 0.16, ease: 'easeIn' } }}
              transition={{ duration: 0.22 }}
              style={{ transformOrigin: 'bottom center', width: '100%', display: 'flex', flexDirection: 'column', alignItems: 'center' }}
            >
              <motion.div
                animate={{ scaleX: [1,1.25,0.85,1.15,1], scaleY: [1,0.9,1.2,0.95,1], opacity: [1,0.85,1,0.9,1] }}
                transition={{ duration: 0.65, repeat: Infinity, ease: 'easeInOut' }}
                style={{
                  width: 22, height: 34, borderRadius: '55% 55% 30% 30%',
                  background: 'radial-gradient(ellipse at 50% 75%,#fff9c4 0%,#ffcc00 35%,#ff8c00 65%,#ff3b00 100%)',
                  boxShadow: '0 0 18px 6px #ff8c0088, 0 0 36px 10px #ff8c0033',
                  transformOrigin: 'bottom center', marginBottom: 2,
                }}
              />
            </motion.div>
          )}
        </AnimatePresence>
      </div>
      {/* wick */}
      <div style={{ width: 3, height: 8, background: lit ? '#8B4513' : '#444', borderRadius: 2, marginBottom: 1, transition: 'background 0.3s' }} />
      {/* body */}
      <motion.div
        animate={lit ? { boxShadow: ['0 0 8px #e8547a44','0 0 18px #e8547a88','0 0 8px #e8547a44'] } : { boxShadow: 'none' }}
        transition={{ duration: 1.2, repeat: Infinity }}
        style={{
          width: 20, height: 52, borderRadius: '5px 5px 3px 3px',
          background: lit
            ? 'linear-gradient(180deg,#ffd6e8 0%,#f9a8c9 40%,#e8547a 100%)'
            : 'linear-gradient(180deg,#aaa 0%,#666 100%)',
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
      <div style={{ display: 'flex', gap: 6, alignItems: 'flex-end', marginBottom: 0 }}>
        {candles.map((lit, i) => (
          <Candle key={i} index={i} lit={lit} onBlow={() => onBlow(i)} />
        ))}
      </div>

      {/* top tier */}
      <div style={{
        width: 200, height: 62,
        background: 'linear-gradient(135deg,#f9c6d8,#e8547a,#c03060)',
        borderRadius: '12px 12px 0 0',
        display: 'flex', alignItems: 'center', justifyContent: 'center',
        boxShadow: '0 4px 20px #e8547a55',
        border: '2px solid rgba(255,255,255,0.28)',
        position: 'relative', overflow: 'hidden',
      }}>
        {[14,38,62,86,110,134,158].map(x => (
          <div key={x} style={{ position:'absolute', top:-7, left:x, width:13, height:20, background:'rgba(255,255,255,0.72)', borderRadius:'0 0 8px 8px' }} />
        ))}
        <span style={{ fontSize:'1.4rem', zIndex:1 }}>🌹 🌸 🌹</span>
      </div>

      {/* middle tier */}
      <div style={{
        width: 260, height: 72,
        background: 'linear-gradient(135deg,#f0c060,#d4903a,#b07020)',
        display: 'flex', alignItems: 'center', justifyContent: 'center',
        boxShadow: '0 4px 20px #f0c06055',
        border: '2px solid rgba(255,255,255,0.2)', borderTop:'none',
        position: 'relative', overflow: 'hidden',
      }}>
        {[10,42,74,106,138,170,202,234].map(x => (
          <div key={x} style={{ position:'absolute', top:-7, left:x, width:13, height:20, background:'rgba(255,255,255,0.5)', borderRadius:'0 0 8px 8px' }} />
        ))}
        <span style={{ fontFamily:'var(--font-script)', color:'#fff', fontSize:'1.15rem', fontWeight:700, textShadow:'0 1px 4px rgba(0,0,0,0.5)', zIndex:1 }}>
          Happy Birthday Seema ❤️
        </span>
      </div>

      {/* bottom tier */}
      <div style={{
        width: 320, height: 86,
        background: 'linear-gradient(135deg,#8b4fa8,#5c2a7a,#3d1655)',
        borderRadius: '0 0 12px 12px',
        display: 'flex', alignItems: 'center', justifyContent: 'center',
        boxShadow: '0 8px 32px #8b4fa855',
        border: '2px solid rgba(255,255,255,0.15)', borderTop:'none',
        position: 'relative', overflow: 'hidden',
      }}>
        {[10,46,82,118,154,190,226,262,294].map(x => (
          <div key={x} style={{ position:'absolute', top:-7, left:x, width:14, height:22, background:'rgba(255,255,255,0.25)', borderRadius:'0 0 8px 8px' }} />
        ))}
        <span style={{ fontFamily:'var(--font-script)', color:'#f9c6d8', fontSize:'1.1rem', zIndex:1 }}>
          14 · 09 · 1992 &nbsp;💖&nbsp; 34 Saal
        </span>
      </div>

      {/* plate */}
      <div style={{
        width: 360, height: 18,
        background: 'linear-gradient(180deg,#d8d8d8,#a0a0a0)',
        borderRadius: '0 0 50px 50px',
        boxShadow: '0 6px 24px rgba(0,0,0,0.5)',
      }} />
    </div>
  );
}

// ── Slide ─────────────────────────────────────────────────────────────────────
// 34 candles would be too many to tap one-by-one.
// Design: two groups — "3" (left: 3 candles) and "4" (right: 4 candles)
// representing the digits of 34. Each group has a "blow group" button below it.
// There is also a "Blow all at once" shortcut.
export default function SlideCake({ onNext, onPrev }) {
  // 7 individual candles: indices 0-2 = digit "3", indices 3-6 = digit "4"
  const [candles, setCandles]         = useState(Array(7).fill(true));
  const [allBlown, setAllBlown]       = useState(false);
  const [showMessage, setShowMessage] = useState(false);
  const [wSize, setWSize]             = useState({ width: window.innerWidth, height: window.innerHeight });

  useEffect(() => {
    const h = () => setWSize({ width: window.innerWidth, height: window.innerHeight });
    window.addEventListener('resize', h);
    return () => window.removeEventListener('resize', h);
  }, []);

  const checkAllBlown = (next) => {
    if (next.every(c => !c)) {
      setTimeout(() => setAllBlown(true), 350);
      setTimeout(() => setShowMessage(true), 1100);
    }
  };

  const blowCandle = (i) => {
    const next = candles.map((c, idx) => idx === i ? false : c);
    setCandles(next);
    checkAllBlown(next);
  };

  const blowGroup = (indices) => {
    const next = candles.map((c, idx) => indices.includes(idx) ? false : c);
    setCandles(next);
    checkAllBlown(next);
  };

  const blowAll = () => {
    const next = Array(7).fill(false);
    setCandles(next);
    checkAllBlown(next);
  };

  const relightAll = () => {
    setCandles(Array(7).fill(true));
    setAllBlown(false);
    setShowMessage(false);
  };

  const litCount = candles.filter(Boolean).length;
  const group3   = [0,1,2];
  const group4   = [3,4,5,6];
  const group3Lit = group3.some(i => candles[i]);
  const group4Lit = group4.some(i => candles[i]);

  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 50% 50%,#2a0018 0%,#180030 50%,#0d0010 100%)',
      display: 'flex', flexDirection: 'column',
      alignItems: 'center',
      minHeight: '100vh', padding: '0 20px 40px', textAlign: 'center',
    }}>
      {allBlown && (
        <ReactConfetti
          width={wSize.width} height={wSize.height}
          colors={['#e8547a','#f0c060','#8b4fa8','#f9c6d8','#fff','#ff8c00']}
          numberOfPieces={320} recycle={false} gravity={0.22}
          style={{ position:'fixed', inset:0, zIndex:50, pointerEvents:'none' }}
        />
      )}
      <StarField count={60} />
      <Petals count={16} />
      <div className="nav-spacer" />
      <div style={{ position:'relative', zIndex:1, paddingTop: 0 }}>
        {/* headline */}
        <motion.div initial={{ opacity:0, y:-20 }} animate={{ opacity:1, y:0 }} style={{ marginBottom:20 }}>
          <p style={{
            fontFamily:'var(--font-script)',
            fontSize:'clamp(1.8rem,5vw,2.6rem)',
            color:'#f9c6d8', textShadow:'0 0 20px #e8547a66',
          }}>
            {allBlown ? 'Wish Granted! 🌟' : 'Blow the Candles, Seema! 🕯️'}
          </p>
          {!allBlown && (
            <motion.div
              animate={{ opacity:[0.7,1,0.7] }}
              transition={{ duration:2, repeat:Infinity }}
              style={{ marginTop:8 }}
            >
              <p style={{ color:'#f9c6d8', fontSize:'clamp(1rem,3vw,1.2rem)', fontFamily:'var(--font-sans)' }}>
                Tap a candle or blow a whole group 💨
              </p>
              <p style={{ color:'#f0c060', fontSize:'clamp(1.1rem,3.2vw,1.35rem)', fontFamily:'var(--font-script)', marginTop:4 }}>
                {litCount} candle{litCount !== 1 ? 's' : ''} left · 34 saal 🕯️
              </p>
            </motion.div>
          )}
        </motion.div>

        {/* digit candle groups above cake */}
        {!allBlown && (
          <div style={{ display:'flex', alignItems:'flex-end', justifyContent:'center', gap:24, marginBottom:0 }}>
            {/* Digit "3" group */}
            <div style={{ display:'flex', flexDirection:'column', alignItems:'center', gap:8 }}>
              <div style={{ display:'flex', gap:4, alignItems:'flex-end' }}>
                {group3.map(i => <Candle key={i} index={i} lit={candles[i]} onBlow={() => blowCandle(i)} />)}
              </div>
              <div style={{
                fontFamily:'var(--font-serif)', fontSize:'3.5rem', fontWeight:700, lineHeight:1,
                background:'linear-gradient(135deg,#f0c060,#e8547a)',
                WebkitBackgroundClip:'text', WebkitTextFillColor:'transparent',
                filter:'drop-shadow(0 0 10px #f0c06066)',
              }}>3</div>
              {group3Lit && (
                <motion.button
                  className="btn btn-ghost"
                  onClick={() => blowGroup(group3)}
                  whileHover={{ scale:1.06 }}
                  style={{ padding:'6px 16px', fontSize:'0.78rem', marginTop:2 }}
                >
                  💨 Blow "3"
                </motion.button>
              )}
            </div>

            {/* separator */}
            <div style={{ paddingBottom:64, color:'rgba(255,255,255,0.2)', fontSize:'2rem' }}>·</div>

            {/* Digit "4" group */}
            <div style={{ display:'flex', flexDirection:'column', alignItems:'center', gap:8 }}>
              <div style={{ display:'flex', gap:4, alignItems:'flex-end' }}>
                {group4.map(i => <Candle key={i} index={i} lit={candles[i]} onBlow={() => blowCandle(i)} />)}
              </div>
              <div style={{
                fontFamily:'var(--font-serif)', fontSize:'3.5rem', fontWeight:700, lineHeight:1,
                background:'linear-gradient(135deg,#f0c060,#e8547a)',
                WebkitBackgroundClip:'text', WebkitTextFillColor:'transparent',
                filter:'drop-shadow(0 0 10px #f0c06066)',
              }}>4</div>
              {group4Lit && (
                <motion.button
                  className="btn btn-ghost"
                  onClick={() => blowGroup(group4)}
                  whileHover={{ scale:1.06 }}
                  style={{ padding:'6px 16px', fontSize:'0.78rem', marginTop:2 }}
                >
                  💨 Blow "4"
                </motion.button>
              )}
            </div>
          </div>
        )}

        {/* cake — no candles on the cake itself when using digit groups */}
        <motion.div
          initial={{ scale:0.8, opacity:0 }}
          animate={{ scale:1, opacity:1 }}
          transition={{ delay:0.3, duration:0.6, type:'spring' }}
        >
          <Cake candles={[]} onBlow={() => {}} />
        </motion.div>

        {/* blow all shortcut */}
        {!allBlown && litCount > 0 && (
          <motion.button
            initial={{ opacity:0 }} animate={{ opacity:1 }} transition={{ delay:1.2 }}
            className="btn btn-rose"
            onClick={blowAll}
            whileHover={{ scale:1.05 }}
            style={{ marginTop:16, padding:'10px 28px', fontSize:'0.9rem' }}
          >
            💨 Blow All 34!
          </motion.button>
        )}

        {/* message */}
        <AnimatePresence>
          {showMessage && (
            <motion.div
              initial={{ opacity:0, y:40, scale:0.9 }}
              animate={{ opacity:1, y:0, scale:1 }}
              transition={{ duration:0.7, type:'spring' }}
              className="glass"
              style={{ maxWidth:540, margin:'32px auto 0', padding:'36px 28px' }}
            >
              <p style={{ fontSize:'2.8rem', marginBottom:12 }}>🎂✨🎉</p>
              <p style={{
                fontFamily:'var(--font-script)',
                fontSize:'clamp(1.6rem,4vw,2rem)',
                color:'#f0c060', marginBottom:16,
                textShadow:'0 0 20px #f0c06066',
              }}>
                Happy 34th Birthday, Seema!
              </p>
              <p style={{
                fontFamily:'var(--font-serif)', fontStyle:'italic',
                color:'#f4d4e8', lineHeight:1.9,
                fontSize:'clamp(0.92rem,2.5vw,1.02rem)',
              }}>
                Tumhari wish meri dua bhi hai —<br />
                ki har sapna poora ho, har khushi mil jaaye.<br />
                Aur jo bhi maango is saal,<br />
                woh milne ki shuruaat ho jaye. 🌟<br /><br />
                34 saal mein tumne jo diya woh<br />
                koi hisaab nahi kar sakta. ❤️
              </p>
              <div style={{ display:'flex', gap:12, justifyContent:'center', marginTop:24 }}>
                <button className="btn btn-ghost" onClick={relightAll} style={{ fontSize:'0.88rem', padding:'10px 20px' }}>
                  🕯️ Relight
                </button>
                <motion.button
                  className="btn btn-rose" onClick={onNext}
                  whileHover={{ scale:1.05 }} whileTap={{ scale:0.96 }}
                >
                  Last Surprise 💌
                </motion.button>
              </div>
            </motion.div>
          )}
        </AnimatePresence>

        {/* back nav */}
        {!showMessage && (
          <motion.button
            initial={{ opacity:0 }} animate={{ opacity:1 }} transition={{ delay:1 }}
            className="btn btn-ghost" onClick={onPrev}
            style={{ marginTop:28, padding:'8px 20px', fontSize:'0.85rem' }}
          >
            ← Photos
          </motion.button>
        )}
      </div>
    </div>
  );
}
