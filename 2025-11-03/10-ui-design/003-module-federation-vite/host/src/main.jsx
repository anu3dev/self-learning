import React, { Suspense, lazy } from "react";
import { createRoot } from "react-dom/client";

// Remote modules loaded via federation
const ProductList = lazy(() => import("productsApp/ProductList"));
const CartWidget = lazy(() => import("cartApp/CartWidget"));

function App() {
  return (
    <div style={{ padding: 20 }}>
      <h1>Shell (Vite + Module Federation)</h1>

      <Suspense fallback={<div>Loading remote...</div>}>
        <div style={{ border: "1px solid #ddd", padding: 10, marginBottom: 10 }}>
          <h3>Products (remote)</h3>
          <ProductList />
        </div>

        <div style={{ border: "1px solid #ddd", padding: 10 }}>
          <h3>Cart (remote)</h3>
          <CartWidget />
        </div>
      </Suspense>
    </div>
  );
}

createRoot(document.getElementById("root")).render(<App />);
