import React from 'react';
import { createRoot } from 'react-dom/client';
import CartWidget from './CartWidget';

const App = () => (
  <div style={{padding:20}}>
    <h2>Cart (Remote)</h2>
    <CartWidget />
  </div>
);

createRoot(document.getElementById('root')).render(<App />);
