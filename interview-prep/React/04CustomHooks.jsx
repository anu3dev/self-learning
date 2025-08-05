import { useState, useEffect } from 'react';

/**
 * Have you built your own custom hooks? Share an example.
 * Custom hooks in React allow you to extract component logic into reusable functions.
 * They can encapsulate stateful logic and side effects, making it easier to share
 * functionality across components.
 */

// Example: useWindowWidth - a custom hook to get the current window width
function useWindowWidth() {
    const [width, setWidth] = useState(window.innerWidth);

    useEffect(() => {
        function handleResize() {
            setWidth(window.innerWidth);
        }
        window.addEventListener('resize', handleResize);
        return () => window.removeEventListener('resize', handleResize);
    }, []);

    return width;
}