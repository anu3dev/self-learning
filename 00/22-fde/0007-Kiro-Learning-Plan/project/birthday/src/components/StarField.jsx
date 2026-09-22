import { useMemo } from 'react';

export default function StarField({ count = 80 }) {
  const stars = useMemo(() => Array.from({ length: count }, (_, i) => ({
    id: i,
    left:  Math.random() * 100,
    top:   Math.random() * 100,
    delay: Math.random() * 4,
    dur:   1.5 + Math.random() * 3,
    size:  1 + Math.random() * 2.5,
  })), [count]);

  return (
    <>
      {stars.map(s => (
        <div
          key={s.id}
          className="star"
          style={{
            left:             `${s.left}%`,
            top:              `${s.top}%`,
            width:            `${s.size}px`,
            height:           `${s.size}px`,
            animationDuration:`${s.dur}s`,
            animationDelay:   `${s.delay}s`,
          }}
        />
      ))}
    </>
  );
}
