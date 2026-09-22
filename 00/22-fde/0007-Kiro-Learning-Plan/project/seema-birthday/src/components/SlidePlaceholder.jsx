// ─────────────────────────────────────────────────────────────────────────────
//  PLACEHOLDER SLIDE — replace with real content once details are shared
// ─────────────────────────────────────────────────────────────────────────────
import { motion } from 'framer-motion';
import StarField from './StarField';

export default function SlidePlaceholder({ title, emoji, note, onNext, onPrev }) {
  return (
    <div className="slide" style={{
      background: 'radial-gradient(ellipse at 50% 50%, #2a0030 0%, #180025 60%, #0d0010 100%)',
      display: 'flex', flexDirection: 'column',
      alignItems: 'center', justifyContent: 'center',
      minHeight: '100vh', padding: '40px 20px', textAlign: 'center',
    }}>
      <StarField count={60} />

      <motion.div
        initial={{ opacity: 0, y: 30 }} animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.6 }}
        style={{ position: 'relative', zIndex: 1, maxWidth: 520 }}
      >
        <div style={{ fontSize: '4rem', marginBottom: 20 }}>{emoji}</div>

        <h2 style={{
          fontFamily: 'var(--font-script)',
          fontSize: 'clamp(1.8rem,5vw,2.6rem)',
          background: 'linear-gradient(135deg,#f9a8c9,#e8547a,#f0c060)',
          WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent',
          marginBottom: 20,
        }}>
          {title}
        </h2>

        <div className="glass" style={{ padding: '32px 28px', marginBottom: 32 }}>
          <p style={{
            fontFamily: 'var(--font-serif)', fontStyle: 'italic',
            color: '#f9c6d8bb', lineHeight: 1.8,
            fontSize: '1rem',
          }}>
            {note || '✏️ Content coming soon — share details and this slide will be fully written.'}
          </p>
        </div>

        <div style={{ display: 'flex', gap: 12, justifyContent: 'center' }}>
          {onPrev && (
            <button className="btn btn-ghost" onClick={onPrev}>← Back</button>
          )}
          {onNext && (
            <button className="btn btn-rose" onClick={onNext}>Next →</button>
          )}
        </div>
      </motion.div>
    </div>
  );
}
