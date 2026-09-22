import { useState } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import StarField from './StarField';
import Petals from './Petals';

const SHAYARIS = [
  {
    emoji: '🌹',
    hindi: true,
    text: `Teri aankhon mein jo gehraai hai,
teri muskaan mein jo roshni hai —
30 saal mein bani hai yeh duniya teri,
aur main khush-nasib hoon ki yeh duniya meri bhi hai. ❤️`,
    tag: 'Pyaar',
  },
  {
    emoji: '✨',
    hindi: false,
    text: `They say 30 is just a number —
but for you, it's a crown.
Every scar you've healed,
every storm you've survived,
every dream you've chased…
it all leads to this:
the most beautiful version of you. 👑`,
    tag: 'Strength',
  },
  {
    emoji: '🥹',
    hindi: true,
    text: `Teri naak pe mujhe pyaar aata hai sabse zyada,
woh choti si cute naak — meri sabse favourite ada. 😂
Baaqi sab toh khoobsurti hai tumhari,
par yeh naak… yaar, dil le gayi humari. 🥹❤️`,
    tag: 'Cute 😂',
  },
  {
    emoji: '🌙',
    hindi: true,
    text: `30 saal ki umar mein aayi ho jab,
toh samjho naya sawera shuru ho gaya.
Jo darr tha woh peeche chhoot gaya,
jo sapna tha woh ab seedha ho gaya. 🌟

Nayi duniya, naye raaste,
naye challenges, naye fasaane —
aur tum ready ho har cheez ke liye,
yahi toh hai tumhara afsaane. ✨`,
    tag: 'Naya Safar',
  },
  {
    emoji: '💌',
    hindi: false,
    text: `Miles apart, hearts together —
that's our story, written in patience.

I count the days not with a calendar
but with the beats of my heart
that echo your name.

Jaldi milenge, meri jaan.
That promise lives in every breath I take. 🤞❤️`,
    tag: 'Promise',
  },
  {
    emoji: '💃',
    hindi: true,
    text: `Teen ka ank — nabbe saal ke baad,
aaya hai yeh khaas paigam.
9 / 9 / 97 ka yeh sangam —
tera janam, teri roshni, mera sukoon. ✨

Aaj chand bhi sharmaya hoga,
sitaare bhi jhuke honge.
Kyunki jis raat tum aayi thi is duniya mein,
us raat se hi duniya khoobsurat hui thi. 🌹`,
    tag: 'Janam din',
  },
  {
    emoji: '🔥',
    hindi: false,
    text: `You're not stepping into 30.
You're stepping into your power.

The girl who used to wonder 'Am I enough?' —
she became a woman who knows
she's more than enough.

And I've had the privilege of watching
every single chapter of that becoming. ❤️`,
    tag: 'Empowered',
  },
  {
    emoji: '😘',
    hindi: true,
    text: `Duur hain hum, yeh sach hai —
par dil ke darmiyaan koi faasla nahi.
Teri yaadon mein jeeta hoon main,
aur teri baahon ka intezaar hai mujhe. 🤗

Ek din zaroor milenge,
teri aankhon mein aankhein daalenge.
Aur us din main woh naak —
haan, wahi — zaroor chumma lunga. 😘❤️`,
    tag: 'Waada',
  },
];

export default function SlideShayari({ onNext }) {
  const [current, setCurrent] = useState(0);

  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 20% 80%, #300020 0%, #1a0030 60%, #0d0010 100%)',
      display: 'flex', flexDirection: 'column',
      alignItems: 'center', justifyContent: 'center',
      minHeight: '100vh', padding: '40px 20px',
    }}>
      <StarField count={55} />
      <Petals count={12} />

      <div style={{ position: 'relative', zIndex: 1, maxWidth: 580, width: '100%' }}>
        {/* Header */}
        <motion.div
          initial={{ opacity: 0, y: -20 }} animate={{ opacity: 1, y: 0 }}
          style={{ textAlign: 'center', marginBottom: 28 }}
        >
          <span style={{
            fontFamily: 'var(--font-script)', fontSize: 'clamp(1.8rem,5vw,2.6rem)',
            color: '#f0c060', textShadow: '0 0 20px #f0c06066',
          }}>
            Shayari Tumhare Liye 💛
          </span>
          <p style={{ color: '#f9c6d899', fontSize: '0.85rem', marginTop: 6 }}>
            {current + 1} / {SHAYARIS.length}
          </p>
        </motion.div>

        {/* Card */}
        <AnimatePresence mode="wait">
          <motion.div
            key={current}
            initial={{ opacity: 0, rotateY: 25, scale: 0.92 }}
            animate={{ opacity: 1, rotateY: 0, scale: 1 }}
            exit={{ opacity: 0, rotateY: -25, scale: 0.92 }}
            transition={{ duration: 0.55, ease: 'easeInOut' }}
            className="glass"
            style={{
              padding: '44px 36px', textAlign: 'center',
              borderColor: 'rgba(240,192,96,0.2)',
              background: 'rgba(255,200,100,0.05)',
            }}
          >
            {/* Tag */}
            <span style={{
              display: 'inline-block',
              background: 'rgba(240,192,96,0.15)',
              border: '1px solid rgba(240,192,96,0.3)',
              color: '#f0c060', fontSize: '0.75rem',
              padding: '4px 14px', borderRadius: 50,
              letterSpacing: 2, marginBottom: 16,
            }}>
              {SHAYARIS[current].tag.toUpperCase()}
            </span>

            <div style={{ fontSize: '2.8rem', marginBottom: 20 }}>
              {SHAYARIS[current].emoji}
            </div>

            <p style={{
              fontFamily: SHAYARIS[current].hindi ? 'var(--font-serif)' : 'var(--font-serif)',
              fontStyle: 'italic',
              color: '#f4e0f0',
              fontSize: 'clamp(0.95rem,2.5vw,1.12rem)',
              lineHeight: 2,
              whiteSpace: 'pre-line',
            }}>
              {SHAYARIS[current].text}
            </p>
          </motion.div>
        </AnimatePresence>

        {/* Dot nav */}
        <div style={{ display: 'flex', justifyContent: 'center', gap: 8, margin: '20px 0' }}>
          {SHAYARIS.map((_, i) => (
            <button
              key={i}
              onClick={() => setCurrent(i)}
              style={{
                width: i === current ? 28 : 8, height: 8, borderRadius: 4,
                background: i === current ? '#f0c060' : 'rgba(255,255,255,0.2)',
                border: 'none', cursor: 'pointer', transition: 'all 0.3s',
              }}
            />
          ))}
        </div>

        {/* Nav buttons */}
        <div style={{ display: 'flex', justifyContent: 'space-between', gap: 16 }}>
          <motion.button
            className="btn btn-ghost"
            onClick={() => setCurrent(c => Math.max(0, c - 1))}
            disabled={current === 0}
            style={{ opacity: current === 0 ? 0.3 : 1 }}
            whileHover={{ scale: 1.04 }}
          >
            ← Pehle
          </motion.button>

          {current === SHAYARIS.length - 1 ? (
            <motion.button
              className="btn btn-rose"
              onClick={onNext}
              whileHover={{ scale: 1.05 }}
              whileTap={{ scale: 0.96 }}
            >
              Tumhari Tasveerein 📸
            </motion.button>
          ) : (
            <motion.button
              className="btn btn-gold"
              onClick={() => setCurrent(c => c + 1)}
              whileHover={{ scale: 1.05 }}
              whileTap={{ scale: 0.96 }}
            >
              Agle →
            </motion.button>
          )}
        </div>
      </div>
    </div>
  );
}
