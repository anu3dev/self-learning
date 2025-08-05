import React, { useState, useRef } from "react";

// Debounce function - delays the execution of a function until after a specified delay
function debounce(fn, delay) {
    let timer;
    return (...args) => {
        clearTimeout(timer);
        timer = setTimeout(() => fn(...args), delay);
    };
}

// Throttle function - ensures a function is called at most once in a specified time interval
function throttle(fn, limit) {
    let inThrottle;
    return (...args) => {
        if (!inThrottle) {
            fn(...args);
            inThrottle = true;
            setTimeout(() => (inThrottle = false), limit);
        }
    };
}

const SearchForm = () => {
    const [search, setSearch] = useState("");
    const [debouncedResult, setDebouncedResult] = useState("");
    const [throttledResult, setThrottledResult] = useState("");

    /**
     * Refs to store debounced/throttled handlers
     *
     * 
     * useRef is a React hook that lets you create a "reference" to a value that stays 
     * the same between renders. Think of it like a box where you can store something, 
     * and React won’t reset or change it when your component updates.
     * 
     * 
     * Main uses of useRef:
     * 
     * 
     * Accessing DOM elements: You can use it to directly interact with HTML elements 
     * (like focusing an input).
     * 
     * Storing mutable values: You can keep data that you don’t want to trigger a 
     * re-render when it changes (like timers, previous values, or third-party libraries).
     * 
     * Persisting functions/handlers: Useful for things like debounced or throttled 
     * functions, so they don’t get recreated every render.
     */
    const debouncedHandler = useRef(
        debounce((value) => setDebouncedResult(value), 500)
    );
    const throttledHandler = useRef(
        throttle((value) => setThrottledResult(value), 1000)
    );

    const handleChange = (e) => {
        const value = e.target.value;
        setSearch(value);
        debouncedHandler.current(value);
        throttledHandler.current(value);
    };

    return (
        <div>
            <h2>Search Form with Debounce & Throttle</h2>
            <form>
                <input
                    type="text"
                    value={search}
                    onChange={handleChange}
                    placeholder="Type to search..."
                />
            </form>
            <div>
                <div>
                    <strong>Debounced Value:</strong> {debouncedResult}
                </div>
                <div>
                    <strong>Throttled Value:</strong> {throttledResult}
                </div>
            </div>
        </div>
    );
};

export default SearchForm;