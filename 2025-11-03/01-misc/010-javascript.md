### javascript

####
<details>
<summary> 🟩 get scrolling related values </summary>

```javascript
const {scrollTop, scrollHeight, clientHeight} = document.documentElement
```

</details>

####
<details>
<summary> 🟩 Explain event loop and how asynchronous tasks are executed in JavaScript. </summary>

- JavaScript is single-threaded, so it uses an event loop to handle asynchronous tasks without blocking the main thread.

- How it works:
    - Call Stack executes synchronous code.
    - Asynchronous operations (setTimeout, fetch, promises) are handled by Web APIs/Node APIs.
    - When they finish, callbacks are placed into:
    - Microtask queue (promises, async/await)
    - Macrotask queue (setTimeout, setInterval, events)

- The event loop runs:
    - If the call stack is empty → run all microtasks first
    - Then run one macrotask
    - Repeat

- Key point: Microtasks (promises) have higher priority than macrotasks (setTimeout).

</details>