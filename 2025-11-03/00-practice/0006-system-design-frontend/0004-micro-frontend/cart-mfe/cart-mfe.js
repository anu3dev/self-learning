// cart-mfe/cart-mfe.js
class CartWidget extends HTMLElement {
  connectedCallback() {
    this.innerHTML = `
      <div style="padding:10px;border:1px dashed #ccc;">
        <strong>Cart</strong>
        <ul><li>Pen</li><li>Book</li></ul>
      </div>
    `;
  }
}
customElements.define('cart-widget', CartWidget);
