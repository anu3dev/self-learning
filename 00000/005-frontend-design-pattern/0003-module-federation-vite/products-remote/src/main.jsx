import React from 'react';
import { createRoot } from 'react-dom/client';
import ProductList from './ProductList';

function App(){
  return (
    <div style={{padding:20}}>
      <h2>Products (Remote)</h2>
      <ProductList />
    </div>
  );
}

createRoot(document.getElementById('root')).render(<App />);
