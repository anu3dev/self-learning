/**
 * Question: Explain React's concurrent mode and its benefits.
 * Answer: React's concurrent mode is a set of new features that help React apps stay
 * responsive by allowing multiple tasks to be processed simultaneously. It enables
 * React to work on rendering updates in the background, without blocking the main thread.
 * This means that user interactions can be prioritized, and the UI remains responsive even
 * during heavy rendering tasks. Benefits include improved user experience, smoother
 * animations, and better resource utilization.
 */



/**
 * Example: Using React's Concurrent Mode with `startTransition`
 * 
 * React's concurrent features are available in modern React (18+) using APIs like `startTransition`.
 * This allows you to mark certain updates as "non-urgent", so React can interrupt them if more urgent updates (like user input) occur.
 */



import React, { useState, startTransition } from 'react';
function SearchComponent() {
    const [query, setQuery] = useState('');
    const [results, setResults] = useState([]);

    function handleChange(e) {
        const value = e.target.value;
        setQuery(value);

        // Mark the search update as non-urgent
        startTransition(() => {
            // Simulate a heavy computation or filtering
            const filtered = fakeSearch(value);
            setResults(filtered);
        });
    }

    return (
        <div>
            <input value={query} onChange={handleChange} placeholder="Search..." />
            <ul>
                {results.map((item, idx) => <li key={idx}>{item}</li>)}
            </ul>
        </div>
    );
}

// Simulated search function
function fakeSearch(query) {
    const data = ['apple', 'banana', 'orange', 'grape', 'pear'];
    return data.filter(item => item.includes(query));
}

/**
 * In this example, typing in the input triggers two updates:
 * 1. The input value (urgent, updated immediately)
 * 2. The search results (non-urgent, can be interrupted)
 * 
 * This keeps the UI responsive even if the search is slow.
 */



/**
 * startTransition is a React API that allows you to mark updates as non-urgent.
 * It introduced in version 18, helps React to prioritize user interactions
 * over less critical updates, ensuring a smoother user experience.
 */