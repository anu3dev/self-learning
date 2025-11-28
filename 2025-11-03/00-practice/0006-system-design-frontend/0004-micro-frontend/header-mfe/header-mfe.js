// header-mfe/header-mfe.js
class AppHeader extends HTMLElement {
  connectedCallback() {
    this.innerHTML = `
      <header style="background:#222;color:#fff;padding:12px;">
        <h2 style="margin:0">My Micro Frontend Header</h2>
      </header>
    `;
  }
}
customElements.define('app-header', AppHeader);
