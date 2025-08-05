/**
 * What are the best practices you follow while structuring a scalable React app?
 * Best practices for structuring a scalable React app include:
 * 1. Organize components into a clear directory structure (e.g., components, hooks, contexts).
 * 2. Use functional components and hooks for state management and side effects.
 * 3. Implement code splitting and lazy loading for performance optimization.
 * 4. Use PropTypes or TypeScript for type checking.
 * 5. Keep components small and focused on a single responsibility.
 * 6. Use context or state management libraries (like Redux, Zustand) for global state management.
 * 7. Write reusable custom hooks to encapsulate logic.
 * 8. Use memoization techniques (React.memo, useMemo, useCallback) to optimize performance.
 * 9. Follow a consistent naming convention and coding style.
 * 10. Write unit tests for components and hooks to ensure reliability.
 * 11. Use a linter and formatter (like ESLint and Prettier) to maintain code quality.
 * 12. Document components and hooks for better maintainability.
 * 13. Use environment variables for configuration.
 * 14. Implement error boundaries to handle errors gracefully.
 * 15. Optimize images and assets for faster loading.
 * 16. Use a state management solution that fits the app's complexity (e.g., Context API, Redux, Zustand).
 * 17. Keep dependencies up to date to benefit from performance improvements and security patches.
 * 18. Use React DevTools for debugging and performance profiling.
 * 19. Implement server-side rendering (SSR) or static site generation (SSG) for better performance and SEO.
 * 20. Monitor performance and optimize rendering with tools like Lighthouse.
 * These practices help ensure that your React app remains maintainable, performant, and scalable as it grows.
 * Example of a scalable React app structure:
 * ```
 * src/
 * ├── components/
 * │   ├── Button/
 * │   │   ├── Button.js
 * │   │   └── Button.test.js
 * │   └── Modal/
 * │       ├── Modal.js
 * │       └── Modal.test.js
 * ├── hooks/
 * │   ├── useFetch.js
 * │   └── useLocalStorage.js
 * ├── contexts/
 * │   └── AuthContext.js
 * ├── utils/
 * │   └── api.js
 * ├── App.js
 * └── index.js
 * ```
 */