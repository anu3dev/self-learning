import React from 'react';

export default function Header({ cartCount, onNavigate }) {
  return (
    <header className="header">
      <div className="brand" onClick={() => onNavigate('products')}>MyStore (Monolith)</div>
      <nav>
        <button onClick={() => onNavigate('products')}>Products</button>
        <button onClick={() => onNavigate('cart')}>Cart ({cartCount})</button>
        <button onClick={() => onNavigate('about')}>About</button>
      </nav>
    </header>
  );
}
