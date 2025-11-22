import React, { useState } from 'react';
import Header from './components/Header';
import ProductList from './components/ProductList';
import Cart from './components/Cart';

const PRODUCTS = [
  { id: 1, name: 'Pen', price: 10 },
  { id: 2, name: 'Notebook', price: 20 },
  { id: 3, name: 'Backpack', price: 30 }
];

export default function App() {
  const [cartItems, setCartItems] = useState([]);
  const [view, setView] = useState('products');

  const addToCart = (product) => {
    setCartItems(prev => [...prev, product]);
  };

  const removeFromCart = (id) => {
    setCartItems(prev => prev.filter((p, idx) => idx !== id));
  };

  return (
    <div className="app">
      <Header cartCount={cartItems.length} onNavigate={setView} />
      <main className="container">
        {view === 'products' && (
          <ProductList products={PRODUCTS} onAdd={addToCart} />
        )}
        {view === 'cart' && (
          <Cart items={cartItems} onRemove={removeFromCart} />
        )}
        {view === 'about' && (
          <div>
            <h2>About</h2>
            <p>This is a simple monolithic frontend learning project.</p>
          </div>
        )}
      </main>
    </div>
  );
}
