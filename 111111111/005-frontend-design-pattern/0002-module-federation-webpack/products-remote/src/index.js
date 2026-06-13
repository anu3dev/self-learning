import React from 'react';
import { createRoot } from 'react-dom/client';
import ProductList from './ProductList';

const App = () => (
  <div style={{padding:20}}>
    <h2>Products (Remote)</h2>
    <ProductList />
  </div>
);

const root = createRoot(document.getElementById('root'));
root.render(<App />);
