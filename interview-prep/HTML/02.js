/**
 * Sass/SCSS over plain CSS:
 * 
 * - Variables: Use variables for colors, fonts, etc.
 * Example:
 * $primary-color: #3498db;
 * .button {
 *   background-color: $primary-color;
 * }
 * 
 * 
 * 
 * - Nesting: Write nested selectors in a cleaner way.
 * Example:
 * nav {
 *   ul {
 *     li {
 *       a {
 *         color: white;
 *       }
 *     }
 *   }
 * }
 * 
 * 
 * 
 * - Mixins: Reuse blocks of CSS with parameters — great for things like responsive breakpoints.
 * Example:
 * @mixin responsive($breakpoint) {
 *   @media (max-width: $breakpoint) {
 *     .container {
 *       width: 100%;
 *     }
 *   }
 * 
 * .container {
 *   @include flex-center;
 * }
 * 
 * 
 * 
 * - Functions & Calculations: Do math, manipulate colors, and return values dynamically.
 * Example:
 * $base-size: 16px;
 * body {
 *   font-size: $base-size * 1.2;
 * }
 * 
 * 
 *
 * - Partials & Imports: Split styles into modular files and import them, keeping code clean.
 * Example:
 * .button { padding: 10px; }
 * @import 'buttons';
 */