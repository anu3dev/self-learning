import React from 'react';

export default function ProductList({ products, onAdd }) {
  return (
    <div>
      <h2>Products</h2>
      <ul className="list">
        {products.map(p => (
          <li key={p.id} className="card">
            <div>
              <strong>{p.name}</strong>
              <div>${p.price}</div>
            </div>
            <button onClick={() => onAdd(p)}>Add</button>
          </li>
        ))}
      </ul>
    </div>
  );
}
