import React from 'react';

const PRODUCTS = [
  { id: 1, name: 'Pen', price: 10 },
  { id: 2, name: 'Book', price: 20 },
  { id: 3, name: 'Bag', price: 30 }
];

export default function ProductList() {
  return (
    <div>
      <ul>
        {PRODUCTS.map(p => (
          <li key={p.id}>{p.name} - ${p.price}</li>
        ))}
      </ul>
    </div>
  );
}
