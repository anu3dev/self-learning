/**
 * Question: How can you optimize performance in a React application?
 * Answer: There are several strategies to optimize performance in a React application:
 * 1. Use React.memo for functional components to prevent unnecessary re-renders.
 * 2. Implement shouldComponentUpdate or React.PureComponent for class components.
 * 3. Use the useCallback and useMemo hooks to memoize functions and values.
 * 4. Code-split your application using React.lazy and Suspense to load components only when needed.
 * 5. Optimize context usage to avoid re-renders of all consumers when context value changes.
 * 6. Use the Profiler API to identify performance bottlenecks.
 */



/**
 * React memo - A higher order component that memoizes a functional component to prevent 
 * unnecessary re-renders.
 */
import React from 'react';

// A simple functional component
function MyComponent({ value }) {
    console.log('MyComponent rendered');
    return <div>{value}</div>;
}

// Memoized version of the component
const MemoizedMyComponent = React.memo(MyComponent);

// Usage example
function App() {
    const [count, setCount] = React.useState(0);

    return (
        <div>
            <button onClick={() => setCount(c => c + 1)}>Increment</button>
            <MemoizedMyComponent value="Hello, world!" />
        </div>
    );
}

/**
 * what is memoization in javascript and react?
 * Memoization is an optimization technique used to speed up function calls by caching 
 * the results of expensive function calls and returning the cached result when the 
 * same inputs occur again. In JavaScript, this can be implemented using closures
 * or by using libraries like lodash. In React, memoization is often used to prevent 
 * unnecessary re-renders of components by memoizing their output based on props. 
 * React provides built-in support for memoization through the React.memo
 * higher-order component and the useMemo and useCallback hooks.
 */



/**
 * React useCallback - A hook that returns a memoized version of the callback function
 * that only changes if one of the dependencies has changed.
 */
import React, { useState, useCallback } from 'react';

function Counter() {
    const [count, setCount] = useState(0);

    // Memoized increment function
    const increment = useCallback(() => {
        setCount(c => c + 1);
    }, []); // No dependencies, so it won't change
    return (
        <div>
            <p>Count: {count}</p>
            <button onClick={increment}>Increment</button>
        </div>
    );
}



/**
 * useEffect and useCallback
 * The useCallback hook is used to memoize a callback function so that it only changes 
 * when its dependencies change. When you use a memoized callback inside a useEffect 
 * dependency array, the effect will only re-run when the callback changes.
 * This prevents unnecessary executions of the effect on every render, optimizing performance.
 * Example:
 * 
 * const memoizedCallback = useCallback(() => {
 *   // some logic
 * }, [dependency]);
 * 
 * useEffect(() => {
 *   // This effect will only run when memoizedCallback changes
 *   memoizedCallback();
 * }, [memoizedCallback]);
 */



/**
 * Explain lazy and suspense in React
 * Lazy and Suspense are features in React that allow you to load components lazily,
 * meaning that they are only loaded when they are needed. This can help improve the
 * performance of your application by reducing the initial bundle size and loading
 * components on demand.
 * 
 * React.lazy is a function that lets you define a component that is loaded
 * asynchronously. It takes a function that returns a dynamic import() call,
 * which returns a promise that resolves to the component.
 * 
 * Suspense is a component that wraps a lazy-loaded component and provides a
 * fallback UI to display while the component is being loaded. This allows you
 * to show a loading spinner or some other placeholder content while the
 * component is being fetched.
 */
import React, { Suspense, lazy } from 'react';

const LazyComponent = lazy(() => import('./LazyComponent'));

function App() {
    return (
        <div>
            <h1>My App</h1>
            <Suspense fallback={<div>Loading...</div>}>
                <LazyComponent />
            </Suspense>
        </div>
    );
}




/**
 * React Profiler API
 * The React Profiler API is a tool that allows you to measure the performance of your 
 * React application. It provides insights into how long each component takes to 
 * render and helps identify performance bottlenecks. You can use the Profiler component 
 * to wrap parts of your application and log render timings.
 */
import React, { Profiler } from 'react';

function App() {
    const onRender = (id, phase, actualDuration) => {
        console.log({ id, phase, actualDuration });
    };

    return (
        <Profiler id="App" onRender={onRender}>
            <div>
                <h1>My App</h1>
                <Suspense fallback={<div>Loading...</div>}>
                    <LazyComponent />
                </Suspense>
            </div>
        </Profiler>
    );
}




/**
 * React Context Optimization
 * When using React Context, it's important to optimize how context values are provided
 * to avoid unnecessary re-renders of all consumers when the context value changes.
 * One way to do this is by splitting context into smaller contexts or using memoization
 * techniques to ensure that only components that depend on specific parts of the context
 * re-render when those parts change.
 */
import React, { createContext, useState } from 'react';
const UserContext = createContext();
const UserProvider = ({ children }) => {
    const [user, setUser] = useState({ name: 'John Doe', age: 30 });

    return (
        <UserContext.Provider value={user}>
            {children}
        </UserContext.Provider>
    );
};



/**
 * What are alternatives to React Context?
 * 
 * Alternatives to React Context for state management include:
 * 1. Redux: A popular state management library that provides a global store and predictable state updates.
 * 2. Zustand: A minimal, fast state management solution using hooks.
 * 3. Recoil: A state management library for React that provides a more granular approach to state sharing.
 * 4. Jotai: A primitive and flexible state management library for React.
 * 5. MobX: A reactive state management library that uses observables.
 * 6. XState: For managing state machines and statecharts in React apps.
 * 
 * These libraries can help manage complex state and avoid some of the performance pitfalls of Context.
 */



/**
 * Example of use reducer in React
 * The useReducer hook is an alternative to useState for managing complex state logic in React components
 */
import React, { useReducer } from 'react';

const initialState = { count: 0 };

function reducer(state, action) {
    switch (action.type) {
        case 'increment':
            return { count: state.count + 1 };
        case 'decrement':
            return { count: state.count - 1 };
        default:
            return state;
    }
}


/**
 * useReducer and Redux are not the same, but they share similar concepts.
 * 
 * - useReducer is a React hook for managing local component state using a reducer function. 
 *  It is useful for handling complex state logic within a single component or a small 
 *  component tree.
 * 
 * - Redux is a standalone state management library that manages global application 
 *  state in a single store. Redux uses reducers, actions, and a centralized store to 
 * manage state across the entire app.
 * 
 * Key differences:
 * - Scope: useReducer is for local state, Redux is for global state.
 * - Middleware: Redux supports middleware (like redux-thunk, redux-saga) for side effects; 
 *      useReducer does not.
 * - DevTools: Redux has powerful developer tools for debugging; useReducer does not.
 * - Boilerplate: Redux typically requires more setup and boilerplate than useReducer.
 * 
 * In summary, useReducer is inspired by Redux's reducer pattern, but they serve 
 * different purposes and are used at different scales.
 */