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

####
<details>
<summary> 🟩 deep copy and shallow copy </summary>

```javascript
// Shallow Copy	-> Copies only the top-level (direct) properties -> Inner (nested) objects still share reference
const user = {
  name: "Anurag",
  address: { city: "Minneapolis", zip: 55408 }
};

const copy1 = { ...user };
copy1.name = "John";
copy1.address.city = "Tampa";

console.log(user.name); // "Anurag" - not changed
console.log(user.address.city); // "Tampa" - changed

console.log(copy1.name); // "John" - changed
console.log(copy1.address.city); // "Tampa" - changed
// address is a nested object, so both user and copy1 share the same address reference.



// Deep Copy -> Copies everything recursively -> New memory for all nested objects — fully independent copy
const deepCopy = structuredClone(user);
deepCopy.address.city = "Boston";

console.log(user.address.city); // "Minneapolis" - unchanged


// similar with array as well.
const arr = [1, 2, [3, 4]];

const shallowCopy = [...arr];
shallowCopy[2][0] = 99;

console.log(arr); // [1, 2, [99, 4]] - changed

const deepCopy = structuredClone(arr);
deepCopy[2][0] = 99;

console.log(arr); // ✅ [1, 2, [3, 4]] (not changed)

// Shallow Copy: Only top-level is copied; inner references are shared.
// Deep Copy: Everything is copied recursively; inner data is independent.

```

</details>