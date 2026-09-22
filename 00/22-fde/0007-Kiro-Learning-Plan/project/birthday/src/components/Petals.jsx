import { useMemo } from 'react';

const EMOJIS = ['🌸','🌹','💗','💖','✨','🌺','💕','🫧','🌷','💝'];

export default function Petals({ count = 18 }) {
  const petals = useMemo(() => Array.from({ length: count }, (_, i) => ({
    id:    i,
    emoji: EMOJIS[i % EMOJIS.length],
    left:  Math.random() * 100,
    delay: Math.random() * 8,
    dur:   6 + Math.random() * 8,
    size:  0.9 + Math.random() * 1.2,
  })), [count]);

  return (
    <>
      {petals.map(p => (
        <div
          key={p.id}
          className="petal"
          style={{
            left:              `${p.left}%`,
            fontSize:          `${p.size}rem`,
            animationDuration: `${p.dur}s`,
            animationDelay:    `${p.delay}s`,
          }}
        >
          {p.emoji}
        </div>
      ))}
    </>
  );
}
