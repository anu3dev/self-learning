### ui-design

- 1. SPA (Single Page Application)
    - Benefits
        - Fast, smooth UX (no full page reload).
        - Reusable components → faster development.
        - Clear separation of frontend & backend (API-driven).
        - Efficient rendering using Virtual DOM.
        - Good caching → fewer server calls.

    - Disadvantages
        - Poor SEO by default.
        - Large initial bundle → slow first load.
        - More complex client-side routing.
        - More responsibility on browser/JS.
        - Harder security (XSS, token exposure).

    - Use Vite for almost all new SPAs — unless you have a specific need for Webpack (notably Module Federation or heavy legacy/tooling that depends on Webpack).
        - Vite — lightning-fast dev server, excellent HMR, minimal config, modern ESM workflow. Best for new projects.
        - Webpack — extremely flexible and mature, huge plugin/ecosystem, supports advanced bundler features (Module Federation). Best for complex enterprise needs or when MF is required.

- 2. Module Federation
    - Benefits
        - Runtime sharing of components/modules.
        - Independent builds & deployments (true microfrontend support).
        - No need to publish shared libraries via NPM — load remotely.
        - Avoid code duplication with shared dependencies (React).
        - Great for large-scale micro frontend architectures.

    - Disadvantages
        - Requires Webpack — limits framework/build tool choice.
        - Complex configuration (especially shared deps).
        - Harder version management — must align React versions.
        - Debugging remote loading issues is tricky.
        - Caching problems if remoteEntry URLs are not versioned.

    - you can create a “Module Federated” architecture with both Webpack and Vite
        - Webpack Module Federation
            - Official feature built into Webpack 5
            - Uses the real Module Federation runtime
            - Production-proven, stable, fully supported
            - Best for large, enterprise microfrontend systems
        - Vite Module Federation (via plugin)
            - Achieved using vite-plugin-federation, NOT using Webpack
            - A re-implementation (community plugin) that imitates Module Federation
            - Works, but not as mature or feature-complete
            - Good for prototypes or simple MF setups
            
- 3. Micro Frontends
    - Benefits
        - Independent deployments per team.
        - Faster development — teams work in parallel.
        - Technology freedom (React + Vue + Angular).
        - Smaller, maintainable codebases.
        - Fault isolation — one team’s issue doesn’t break entire app.

    - Disadvantages
        - Increased architectural complexity.
        - Harder shared state management.
        - Duplicate dependencies → larger bundle sizes.
        - More complex routing/layout composition.
        - Requires strict coordination between teams.

- 4. Monolithic Frontend Application
    - Benefits
        - Simple architecture (easy to build & deploy).
        - Shared state and routing are straightforward.
        - No dependency duplication — smaller bundle.
        - Easier onboarding for new developers.
        - Better performance without cross-app overhead.

    - Disadvantages
        - Hard to scale with large teams.
        - A small change requires redeploying entire app.
        - Build times get slow as app grows.
        - Tight coupling — code becomes messy over time.
        - Hard to adopt new technologies incrementally.