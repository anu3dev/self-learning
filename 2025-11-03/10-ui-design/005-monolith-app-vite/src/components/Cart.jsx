import React from 'react';

export default function Cart({ items, onRemove }) {
  return (
    <div>
      <h2>Cart</h2>
      {items.length === 0 ? (
        <p>Your cart is empty.</p>
      ) : (
        <ul className="list">
          {items.map((it, idx) => (
            <li key={idx} className="card">
              <div>
                <strong>{it.name}</strong>
                <div>${it.price}</div>
              </div>
              <button onClick={() => onRemove(idx)}>Remove</button>
            </li>
          ))}
        </ul>
      )}
      <div className="total">
        Total: ${items.reduce((s, i) => s + i.price, 0)}
      </div>
    </div>
  );
}
