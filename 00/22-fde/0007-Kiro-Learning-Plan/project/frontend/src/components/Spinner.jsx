export default function Spinner({ size = 'md' }) {
  const cls = size === 'sm' ? 'w-4 h-4' : size === 'lg' ? 'w-10 h-10' : 'w-7 h-7';
  return (
    <div className={`${cls} border-2 border-indigo-200 border-t-indigo-600 rounded-full animate-spin`} role="status" aria-label="Loading" />
  );
}
