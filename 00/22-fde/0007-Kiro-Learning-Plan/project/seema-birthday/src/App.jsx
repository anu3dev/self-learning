import { useState } from 'react';
import { AnimatePresence, motion } from 'framer-motion';

import SlideIntro      from './components/SlideIntro';
import SlideTimeline   from './components/SlideTimeline';
import SlidePoem       from './components/SlidePoem';
import SlideShayari    from './components/SlideShayari';
import SlideBeauty     from './components/SlideBeauty';
import SlideTwinsWish  from './components/SlideTwinsWish';
import SlideGallery    from './components/SlideGallery';
import SlideCake       from './components/SlideCake';
import SlideFinal      from './components/SlideFinal';

// ── Slide registry ────────────────────────────────────────────────────────────
// Order: Intro → Timeline → Poem → Shayari → Beauty → TwinsWish → Gallery → Cake → Final
const SLIDE_META = [
  { label: 'Welcome',  icon: '🌹' },
  { label: 'Journey',  icon: '💫' },
  { label: 'Poem',     icon: '📜' },
  { label: 'Shayari',  icon: '💛' },
  { label: 'Beauty',   icon: '🍷' },
  { label: 'Twins',    icon: '👶' },
  { label: 'Photos',   icon: '📸' },
  { label: 'Cake',     icon: '🎂' },
  { label: 'Forever',  icon: '❤️' },
];

// ── Nav dots ──────────────────────────────────────────────────────────────────
function NavDots({ current, total, onChange }) {
  return (
    <div style={{
      position: 'fixed', top: 0, left: 0, right: 0,
      height: 44,                     /* matches --nav-h */
      display: 'flex', alignItems: 'center', justifyContent: 'center',
      gap: 5, zIndex: 200,
      background: 'rgba(0,0,0,0.55)', backdropFilter: 'blur(12px)',
      WebkitBackdropFilter: 'blur(12px)',
      borderBottom: '1px solid rgba(255,255,255,0.07)',
      padding: '0 12px',
    }}>
      {SLIDE_META.map((m, i) => (
        <button
          key={i}
          onClick={() => onChange(i)}
          title={`${m.icon} ${m.label}`}
          aria-label={m.label}
          style={{
            background: 'none', border: 'none',
            cursor: 'pointer', padding: '8px 3px',  /* larger tap target */
            display: 'flex', alignItems: 'center',
          }}
        >
          <div style={{
            width: i === current ? 22 : 7, height: 7, borderRadius: 4,
            background: i === current
              ? 'linear-gradient(90deg,#e8547a,#f0c060)'
              : i < current ? '#e8547a55' : 'rgba(255,255,255,0.18)',
            transition: 'all 0.35s',
          }} />
        </button>
      ))}
    </div>
  );
}

// ── App ───────────────────────────────────────────────────────────────────────
const TOTAL = SLIDE_META.length; // 9

export default function App() {
  const [step, setStep] = useState(0);
  const [dir,  setDir]  = useState(1);

  const goTo      = (n) => { setDir(n > step ? 1 : -1); setStep(Math.max(0, Math.min(n, TOTAL - 1))); };
  const goNext    = ()  => goTo(step + 1);
  const goPrev    = ()  => goTo(step - 1);
  const goRestart = ()  => goTo(0);

  const p = { onNext: goNext, onPrev: goPrev, onRestart: goRestart };

  const SLIDES = [
    <SlideIntro     {...p} />,   // 0
    <SlideTimeline  {...p} />,   // 1
    <SlidePoem      {...p} />,   // 2
    <SlideShayari   {...p} />,   // 3
    <SlideBeauty    {...p} />,   // 4
    <SlideTwinsWish {...p} />,   // 5
    <SlideGallery   {...p} />,   // 6
    <SlideCake      {...p} />,   // 7
    <SlideFinal     {...p} />,   // 8
  ];

  const variants = {
    enter:  (d) => ({ opacity: 0, x: d > 0 ? '6%' : '-6%' }),
    center: { opacity: 1, x: 0 },
    exit:   (d) => ({ opacity: 0, x: d > 0 ? '-6%' : '6%' }),
  };

  return (
    <>
      <NavDots current={step} total={TOTAL} onChange={goTo} />
      <AnimatePresence mode="wait" custom={dir}>
        <motion.div
          key={step} custom={dir}
          variants={variants}
          initial="enter" animate="center" exit="exit"
          transition={{ duration: 0.42, ease: 'easeInOut' }}
          style={{ position: 'fixed', inset: 0 }}
        >
          {SLIDES[step]}
        </motion.div>
      </AnimatePresence>
    </>
  );
}
