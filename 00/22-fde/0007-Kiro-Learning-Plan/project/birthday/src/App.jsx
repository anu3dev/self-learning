import { useState } from 'react';
import { AnimatePresence, motion } from 'framer-motion';

import SlideIntro    from './components/SlideIntro';
import SlideEnvelope from './components/SlideEnvelope';
import SlidePoem     from './components/SlidePoem';
import SlideShayari  from './components/SlideShayari';
import SlideGallery  from './components/SlideGallery';
import SlideCake     from './components/SlideCake';
import SlideFinal    from './components/SlideFinal';

const SLIDES = [
  SlideIntro,
  SlideEnvelope,
  SlidePoem,
  SlideShayari,
  SlideGallery,
  SlideCake,
  SlideFinal,
];

// Navigation dots at the top
function NavDots({ current, total, onChange }) {
  return (
    <div style={{
      position: 'fixed', top: 16, left: '50%', transform: 'translateX(-50%)',
      display: 'flex', gap: 8, zIndex: 200,
      background: 'rgba(0,0,0,0.35)', backdropFilter: 'blur(8px)',
      padding: '6px 14px', borderRadius: 50,
      border: '1px solid rgba(255,255,255,0.1)',
    }}>
      {Array.from({ length: total }).map((_, i) => (
        <button
          key={i}
          onClick={() => onChange(i)}
          title={['Intro','Letter','Poem','Shayari','Gallery','Cake','Promise'][i]}
          style={{
            width: i === current ? 24 : 8,
            height: 8, borderRadius: 4,
            background: i === current
              ? 'linear-gradient(90deg,#e8547a,#f0c060)'
              : i < current ? '#e8547a66' : 'rgba(255,255,255,0.2)',
            border: 'none', cursor: 'pointer',
            transition: 'all 0.35s',
            padding: 0,
          }}
        />
      ))}
    </div>
  );
}

export default function App() {
  const [step, setStep] = useState(0);
  const [dir,  setDir]  = useState(1); // 1 = forward, -1 = back

  const goTo = (next) => {
    setDir(next > step ? 1 : -1);
    setStep(next);
  };

  const goNext    = () => goTo(Math.min(step + 1, SLIDES.length - 1));
  const goRestart = () => { setDir(-1); setStep(0); };

  const CurrentSlide = SLIDES[step];

  const slideVariants = {
    enter:  (d) => ({ opacity: 0, x: d > 0 ? '8%' : '-8%' }),
    center: { opacity: 1, x: 0 },
    exit:   (d) => ({ opacity: 0, x: d > 0 ? '-8%' : '8%' }),
  };

  return (
    <>
      <NavDots current={step} total={SLIDES.length} onChange={goTo} />

      <AnimatePresence mode="wait" custom={dir}>
        <motion.div
          key={step}
          custom={dir}
          variants={slideVariants}
          initial="enter"
          animate="center"
          exit="exit"
          transition={{ duration: 0.45, ease: 'easeInOut' }}
          style={{ position: 'fixed', inset: 0 }}
        >
          <CurrentSlide
            onNext={goNext}
            onRestart={goRestart}
          />
        </motion.div>
      </AnimatePresence>
    </>
  );
}
