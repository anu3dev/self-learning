import { useEffect, useState } from 'react';
import { motion } from 'framer-motion';
import ReactConfetti from 'react-confetti';
import { PROMISES, BIRTHDAY } from '../config';
import StarField from './StarField';
import Petals from './Petals';

export default function SlideFinal({ onRestart }) {
  const [wSize, setWSize]     = useState({ width: window.innerWidth, height: window.innerHeight });
  const [confetti, setConfetti] = useState(true);

  useEffect(() => {
    const h = () => setWSize({ width: window.innerWidth, height: window.innerHeight });
    window.addEventListener('resize', h);
    const t = setTimeout(() => setConfetti(false), 8000);
    return () => { window.removeEventListener('resize', h); clearTimeout(t); };
  }, []);

  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 50% 50%,#3d0030 0%,#1a0025 50%,#0d0010 100%)',
      display: 'flex', flexDirection: 'column',
      alignItems: 'center',
      minHeight: '100vh', padding: '0 20px 40px', textAlign: 'center',
    }}>
      {confetti && (
        <ReactConfetti
          width={wSize.width} height={wSize.height}
          colors={['#e8547a','#f0c060','#8b4fa8','#f9c6d8','#fff']}
          numberOfPieces={300} recycle={false} gravity={0.2}
          style={{ position:'fixed', inset:0, zIndex:50, pointerEvents:'none' }}
        />
      )}
      <StarField count={90} />
      <Petals count={24} />
      <div className="nav-spacer" />
      <motion.div
        initial={{ opacity:0 }} animate={{ opacity:1 }} transition={{ duration:1 }}
        style={{ position:'relative', zIndex:1, maxWidth:640, width:'100%', paddingTop: 0 }}
      >
        {/* pulsing heart */}
        <motion.div
          animate={{ scale:[1,1.12,1], filter:['drop-shadow(0 0 20px #e8547a88)','drop-shadow(0 0 44px #e8547acc)','drop-shadow(0 0 20px #e8547a88)'] }}
          transition={{ duration:1.8, repeat:Infinity }}
          style={{ fontSize:'clamp(3.5rem,10vw,6rem)', lineHeight:1, marginBottom:16 }}
        >
          ❤️
        </motion.div>

        <motion.h1
          initial={{ opacity:0, y:30 }} animate={{ opacity:1, y:0 }}
          transition={{ delay:0.3, duration:0.8 }}
          style={{
            fontFamily:'var(--font-script)',
            fontSize:'clamp(2rem,7vw,3.8rem)',
            background:'linear-gradient(135deg,#f9a8c9,#e8547a,#f0c060)',
            WebkitBackgroundClip:'text', WebkitTextFillColor:'transparent',
            filter:'drop-shadow(0 0 20px #e8547a55)',
            marginBottom:6,
          }}
        >
          Happy Birthday, Seema
        </motion.h1>

        <motion.h2
          initial={{ opacity:0, y:20 }} animate={{ opacity:1, y:0 }}
          transition={{ delay:0.5, duration:0.8 }}
          style={{
            fontFamily:'var(--font-script)',
            fontSize:'clamp(1.3rem,3.5vw,1.8rem)',
            color:'#f9c6d8', marginBottom:32,
          }}
        >
          Meri Taaqat, Mera Yakeen, Meri Zindagi 🌹
        </motion.h2>

        {/* promises */}
        <div style={{ display:'flex', flexDirection:'column', gap:12, marginBottom:32 }}>
          {PROMISES.map((p, i) => (
            <motion.div
              key={i}
              initial={{ opacity:0, x:-30 }}
              animate={{ opacity:1, x:0 }}
              transition={{ delay:0.7 + i*0.14, duration:0.5 }}
              className="glass"
              style={{ display:'flex', alignItems:'center', gap:14, padding:'14px 22px', textAlign:'left',
                background: 'rgba(255,255,255,0.1)',
                border: '1px solid rgba(255,255,255,0.2)',
              }}
            >
              <span style={{ fontSize:'1.6rem', flexShrink:0 }}>{p.icon}</span>
              <p style={{
                fontFamily:'var(--font-serif)', fontStyle:'italic',
                color:'#fff', fontSize:'0.98rem', lineHeight:1.5,
              }}>{p.text}</p>
            </motion.div>
          ))}
        </div>

        {/* closing letter */}
        <motion.div
          initial={{ opacity:0, y:20 }} animate={{ opacity:1, y:0 }}
          transition={{ delay:1.6, duration:0.8 }}
          className="glass"
          style={{ padding:'32px 28px', marginBottom:32 }}
        >
          <p style={{
            fontFamily:'var(--font-script)',
            fontSize:'clamp(1.3rem,3.5vw,1.7rem)',
            color:'#f0c060', marginBottom:14,
          }}>
            Seema,
          </p>
          <p style={{
            fontFamily:'var(--font-serif)', fontStyle:'italic',
            color:'#f4d4e8', lineHeight:2,
            fontSize:'clamp(0.88rem,2.4vw,1rem)',
          }}>
            Main jaanta hoon meri jagah abhi tumhare paas honi chahiye thi,<br />
            aur yeh doori ka dard main bhi roz feel karta hoon.<br /><br />
            Par tumne jo kiya — akele pregnancy, do bachiyan,<br />
            ghar, mere parents, sab kuch — woh sirf Seema kar sakti hai.<br /><br />
            Tum meri wife ho, mere twins ki maa ho,<br />
            mere parents ki bahu ho —<br />
            par sabse pehle tum <em>meri yakin</em> ho.<br /><br />
            Jab bhi main thaka, tumne kaha:{' '}
            <span style={{ color:'#e8547a', fontWeight:600 }}>"Are yaar, ap kr loge."</span><br />
            Aur main kar leta tha.<br /><br />
            Ek saal aur, Seema. Phir main ghar aaunga.<br />
            Tab tak — apni khushi ka khayal rakho,<br />
            thoda apni life bhi jiyo,<br />
            aur jaano ki tum jahan bhi ho, main tumhare saath hoon. ❤️
          </p>
          <p style={{
            fontFamily:'var(--font-script)', fontSize:'1.5rem',
            color:'#e8547a', marginTop:20, textAlign:'right',
          }}>
            — Anurag ❤️
          </p>
        </motion.div>

        {/* date stamp */}
        <motion.p
          initial={{ opacity:0 }} animate={{ opacity:1 }}
          transition={{ delay:2, duration:0.8 }}
          style={{ color:'#f0c06066', fontSize:'0.78rem', letterSpacing:3, marginBottom:28 }}
        >
          14 · 09 · 2026 &nbsp;·&nbsp; Made with love, from the heart ❤️
        </motion.p>

        <motion.button
          initial={{ opacity:0 }} animate={{ opacity:1 }}
          transition={{ delay:2.2, duration:0.6 }}
          className="btn btn-ghost" onClick={onRestart}
          whileHover={{ scale:1.04 }} whileTap={{ scale:0.96 }}
        >
          🔁 From the Beginning
        </motion.button>
      </motion.div>
    </div>
  );
}
