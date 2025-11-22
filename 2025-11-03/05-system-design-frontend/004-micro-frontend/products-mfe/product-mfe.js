// products-mfe/product-mfe.js
class ProductList extends HTMLElement {
  connectedCallback() {
    const items = [
      { id: 1, name: 'Pen', price: 10 },
      { id: 2, name: 'Book', price: 20 },
      { id: 3, name: 'Bag', price: 30 }
    ];
    this.innerHTML = `<div style="padding:10px"><h3>Products</h3><ul>${items.map(p => `<li>${p.name} - $${p.price}</li>`).join('')}</ul></div>`;
  }
}
customElements.define('product-list', ProductList);
