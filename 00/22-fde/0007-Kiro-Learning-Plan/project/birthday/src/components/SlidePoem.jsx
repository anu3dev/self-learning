import { useState } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import Petals from './Petals';
import StarField from './StarField';

const STANZAS = [
  {
    emoji: '🌹',
    lines: [
      'Happy Birthday, meri jaan ❤️',
      '',
      '9/9/97 se lekar aaj tak,',
      'tumne sirf saal nahi badle…',
      'tumne khud ko har saal',
      'aur khoobsurat banaya hai. ✨',
    ],
  },
  {
    emoji: '🦋',
    lines: [
      'Ab 30 ki taraf ek naya kadam hai,',
      'new dreams, new challenges,',
      'new beginnings…',
      '',
      'Aur mujhe pata hai,',
      'you\'re ready for all of it.',
      '',
      'Because the woman you\'re becoming',
      'is even more beautiful',
      'than the girl I first fell for. ❤️',
    ],
  },
  {
    emoji: '🥹',
    lines: [
      'Tumhari khoobsurti ka kya kehna…',
      '',
      'I love you from your heart',
      'to every little part of you,',
      '',
      'but honestly…',
      'that cute little nose of yours',
      'still has my heart. 🥹❤️',
    ],
  },
  {
    emoji: '👑',
    lines: [
      '30 isn\'t getting older, meri jaan…',
      '',
      'it\'s stepping into a new kind of beautiful —',
      'more confident,',
      'more fearless,',
      'more you.',
      '',
      'Bas ek cheez same rehni chahiye…',
      'mera tumse pyaar.',
      '',
      'Aur woh har saal aur zyada hoga. ❤️',
    ],
  },
  {
    emoji: '🌙',
    lines: [
      'I may not be there beside you tonight,',
      'but promise me this birthday:',
      '',
      'jaldi milenge. 🤞',
      '',
      'No matter how busy life gets,',
      'no matter what new challenges come,',
      'I\'ll be waiting for the day',
      'I can finally hold you,',
      'look at that beautiful face,',
      'and kiss that nose I love so much. 😘',
    ],
  },
  {
    emoji: '💍',
    lines: [
      'Happy 30th, my beautiful girl.',
      '',
      'Here\'s to the woman you are,',
      'the woman you\'re becoming,',
      'and all the moments',
      'we still have waiting for us. 🌟',
      '',
      'Love you from heart to toe…',
      'and yes, especially that nose. ❤️😂',
      '',
      'Soon, baby. We\'ll meet soon.',
      'I promise. ❤️',
    ],
  },
];

export default function SlidePoem({ onNext }) {
  const [current, setCurrent] = useState(0);
  const isLast = current === STANZAS.length - 1;

  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 70% 30%, #2a0040 0%, #180025 55%, #0d0010 100%)',
      display: 'flex', flexDirection: 'column',
      alignItems: 'center', justifyContent: 'center',
      minHeight: '100vh', padding: '40px 20px',
    }}>
      <StarField count={60} />
      <Petals count={14} />

      <div style={{ position: 'relative', zIndex: 1, maxWidth: 560, width: '100%' }}>
        {/* Header */}
        <motion.div
          initial={{ opacity: 0, y: -20 }} animate={{ opacity: 1, y: 0 }}
          style={{ textAlign: 'center', marginBottom: 32 }}
        >
          <span style={{
            fontFamily: 'var(--font-script)', fontSize: 'clamp(1.8rem,5vw,2.6rem)',
            background: 'linear-gradient(135deg,#f9a8c9,#e8547a,#f0c060)',
            WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent',
            filter: 'drop-shadow(0 0 16px #e8547a66)',
          }}>
            A Poem For You 🌹
          </span>
          {/* Progress dots */}
          <div style={{ display: 'flex', justifyContent: 'center', gap: 8, marginTop: 16 }}>
            {STANZAS.map((_, i) => (
              <div key={i} style={{
                width: i === current ? 24 : 8, height: 8, borderRadius: 4,
                background: i === current ? '#e8547a' : 'rgba(255,255,255,0.2)',
                transition: 'all 0.4s',
              }} />
            ))}
          </div>
        </motion.div>

        {/* Stanza card */}
        <AnimatePresence mode="wait">
          <motion.div
            key={current}
            initial={{ opacity: 0, x: 60, scale: 0.95 }}
            animate={{ opacity: 1, x: 0, scale: 1 }}
            exit={{ opacity: 0, x: -60, scale: 0.95 }}
            transition={{ duration: 0.5, ease: 'easeInOut' }}
            className="glass"
            style={{ padding: '40px 36px', textAlign: 'center' }}
          >
            <div style={{ fontSize: '3rem', marginBottom: 20 }}>
              {STANZAS[current].emoji}
            </div>
            {STANZAS[current].lines.map((line, i) => (
              <motion.p
                key={i}
                initial={{ opacity: 0, y: 10 }}
                animate={{ opacity: 1, y: 0 }}
                transition={{ delay: i * 0.07, duration: 0.4 }}
                style={{
                  fontFamily: line === '' ? undefined : 'var(--font-serif)',
                  fontStyle: 'italic',
                  color: line.includes('❤️') || line.includes('I promise') ? '#f9a8c9' : '#f0e8f4',
                  fontSize: 'clamp(0.95rem,2.4vw,1.1rem)',
                  lineHeight: 1.9,
                  marginBottom: line === '' ? 8 : 0,
                  fontWeight: i === 0 && current === 0 ? 600 : 400,
                }}
              >
                {line || '\u00A0'}
              </motion.p>
            ))}
          </motion.div>
        </AnimatePresence>

        {/* Navigation */}
        <div style={{ display: 'flex', justifyContent: 'space-between', marginTop: 28, gap: 16 }}>
          <motion.button
            className="btn btn-ghost"
            onClick={() => setCurrent(c => Math.max(0, c - 1))}
            disabled={current === 0}
            whileHover={{ scale: 1.04 }}
            style={{ opacity: current === 0 ? 0.3 : 1 }}
          >
            ← Prev
          </motion.button>
          {isLast ? (
            <motion.button
              className="btn btn-gold"
              onClick={onNext}
              whileHover={{ scale: 1.05 }}
              whileTap={{ scale: 0.96 }}
            >
              See Shayaris 🌸
            </motion.button>
          ) : (
            <motion.button
              className="btn btn-rose"
              onClick={() => setCurrent(c => c + 1)}
              whileHover={{ scale: 1.05 }}
              whileTap={{ scale: 0.96 }}
            >
              Next →
            </motion.button>
          )}
        </div>
      </div>
    </div>
  );
}
