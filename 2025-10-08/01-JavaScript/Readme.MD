### 💥 JavaScript Interview Preparation (By Anurag Kumar)

---

####
<details>
<summary> 🟩 How does the browser handle rendering and reflow/repaint? </summary>

The browser converts HTML, CSS, and JavaScript into pixels on screen through a well-defined sequence of steps.
Understanding this helps you write high-performance, jank-free web apps.

- JavaScript Execution
    - JS runs on the main thread, modifying the DOM or CSS.
    - While JS is running, the browser cannot render or paint (single-threaded).
    - Long-running scripts block UI updates.

- Style Calculation
    - The browser figures out which CSS rules apply to each element.
    - Builds a Render Tree combining DOM + computed CSS styles.
    - Triggered when you change CSS, classes, or inline styles.

- Layout (Reflow)
    - Calculates each element’s position and size in the viewport.
    - Triggered when layout-affecting properties change — e.g. width, height, margin, padding, font-size, etc.
    - Costly if done repeatedly (e.g. inside loops or animations).

- Paint
    - Browser fills pixels for visual details like colors, borders, text, images, shadows.
    - Happens when appearance changes but layout doesn’t — e.g. color, background, visibility, opacity.

- Composite
    - The browser combines painted layers into the final frame displayed on screen (often GPU-accelerated).
    - Happens ~60 times per second for smooth animations and scrolling.

</details>

####
<details>
<summary> 🟩 What is hoisting? How do var, let, and const behave differently? </summary>

Hoisting means JavaScript moves declarations (not initializations) to the top of their scope during the compilation phase, before code execution.

So variables and functions can be used before they’re declared — but behavior differs for var, let, and const.

```js
// hoisted and initilized with undefined value
console.log(a); // undefined
var a = 10;

// hoisted but not initilized
console.log(b); // ❌ ReferenceError
let b = 20;

// hoisted but not initilized
console.log(c); // ❌ ReferenceError
const c = 30;

// function declarations are fully hoisted (both name and body),
sayHi(); // ✅ Works
function sayHi() {
  console.log("Hello!");
}

// function expressions are not
sayHello(); // ❌ Error
var sayHello = () => console.log("Hi");
```

TDZ → Temporal Dead Zone (time between hoisting and actual declaration where variable is inaccessible).

When JavaScript runs, it creates an **execution context** for each scope and pushes it onto the **call stack**.  
    
Every context has two phases:

- **Creation Phase (Hoisting)**  
    - `var` → hoisted & initialized as `undefined`  
    - `let` / `const` → hoisted but not initialized (Temporal Dead Zone)  
    - **Function declarations** → hoisted with full definition  
    - **Function expressions / arrow functions** → treated as variables (undefined until assigned)

- **Execution Phase**  
    - Code executes line-by-line  
    - Variables get assigned values  
    - Functions execute → new execution context pushed to stack  

```js
sayHello();           // ✅ works (function hoisted)
console.log(name);    // ❌ undefined (var hoisted)
console.log(age);     // ❌ ReferenceError (TDZ)

var name = "Anurag";
let age = 30;

function sayHello() {
    console.log("Hello from function declaration");
}

var sayHi = function() {
console.log("Hi from function expression");
};

sayHi(); // ✅ works after initialization
// Hello from function declaration -> undefined -> ReferenceError -> Hi from function expression
```

- During creation, JS reserves memory for all variables & function declarations.
- Function declarations are hoisted with body → can be called before definition.
- Variables declared with var exist but are undefined until assigned.
- let & const stay in TDZ until their line executes.
- Function expressions i.e. arrow function act like variables → not callable before assignment.
- Each function call creates a new stack frame (own local variables, arguments).
- Once the function returns, its frame is popped from the call stack.
    
</details>

####
<details>
<summary> 🟩 Explain null vs undefined and == vs === behavior. </summary>

- undefined
    - A variable declared but not assigned any value.
    - Set by JavaScript engine

- null
    - An explicitly assigned “no value” (intentional absence).
    - set by Developer (manually)

    ```js
    let a;
    console.log(a); // undefined

    let b = null;
    console.log(b); // null
    ```

- Equality Operators - == (loose equality) vs === (strict equality)
    - == -> Checks for value equality
    - === -> Checks for value + type equality

</details>

####
<details>
<summary> 🟩 What are closures? Example where they are useful (memoization, private variables). </summary>

A closure is formed when an inner function remembers and accesses variables from its outer function’s scope, even after the outer function has finished executing.

An inner function **remembers and accesses variables** from its outer (lexical) scope **even after** that outer function has finished executing.

Every time a function is pushed on the **call stack**, a new **lexical environment** is created.  

When the outer function finishes and is popped from the stack, the inner function keeps a **reference (not copy)** of the outer variables through the closure.

```js
function outer() {
    let counter = 0;

    function inner() {
        counter++;
        console.log(counter);
    }

    return inner;
}

const increment = outer(); // outer() runs and returns inner()

increment(); // 1
increment(); // 2
increment(); // 3
```

Closures help encapsulate data
```js
function createAccount() {
  let balance = 0;
  return {
    deposit(amount) { balance += amount; },
    getBalance() { return balance; }
  };
}

const account = createAccount();
account.deposit(100);
console.log(account.getBalance()); // 100
// balance is private — cannot be accessed directly outside the closure.
```

Closures can cache results of expensive function calls
```js
function memoize(fn) {
  const cache = {};
  return function(n) {
    if (cache[n]) return cache[n];
    console.log("Computing...");
    cache[n] = fn(n);
    return cache[n];
  };
}

const factorial = memoize(function fact(n) {
  return n <= 1 ? 1 : n * fact(n - 1);
});

console.log(factorial(5)); // Computing... 120
console.log(factorial(5)); // Returns cached 120
// The inner function remembers cache from its outer scope — classic closure use.
```

</details>

####
<details>
<summary> 🟩 Difference between synchronous and asynchronous execution. </summary>

- Synchronous
    - Tasks run one after another, each must finish before next starts.
    - Blocks main thread until task completes.
- Asynchronous
    - Tasks can start and continue later without blocking others.
    - Non-blocking, main thread keeps running
    - Handled via event loop, queued and executed later.

</details>

####
<details>
<summary> 🟩 Explain event loop, call stack, microtask/macrotask queue</summary>

JavaScript is **single-threaded**. The **call stack** executes synchronous code line by line.

However, browsers (and Node.js) provide background APIs that handle asynchronous tasks like timers, network calls, and DOM events — managed via the Event Loop mechanism.

- Call Stack
    - Stack-based structure where JS tracks function execution (LIFO).
    - When a function is called → it’s pushed to the stack.
    - When it returns → it’s popped off the stack.
    - If stack is full, new tasks must wait.

```js
function greet() {
    console.log("Hello");
}

function sayBye() {
    console.log("Bye");
}

greet();
sayBye();
// main() → greet() → logs “Hello” → returns → sayBye() → logs “Bye”.
```

- Event Loop
    - Is the call stack empty?  
    - If yes → push next microtask(s).  
    - When microtasks finish → take one macrotask → repeat.

**Async tasks** (Promises, timers, I/O) are delegated to the Web APIs and queued back in:
    - **Microtask queue** → `Promise.then`, `MutationObserver`
    - **Macrotask queue** → `setTimeout`, `setInterval`, `setImmediate`

```js
console.log("start");

setTimeout(() => console.log("timeout"), 0);

Promise.resolve()
    .then(() => console.log("promise1"))
    .then(() => console.log("promise2"));

console.log("end");
// start -> end -> promise1 -> promise2 -> timeout
```

- aync/await
**async/await** is syntactic sugar for Promises. When you await something, JavaScript pauses that async function at that point, allowing other tasks (in the event loop) to run. When the awaited Promise resolves, the async function resumes in a new microtask.

```js
console.log("A");

setTimeout(() => console.log("B (timeout)"), 0);

(async function() {
    console.log("C (start async)");
    await Promise.resolve();
    console.log("D (after await)");
})();

console.log("E");
// A -> C (start async) -> E -> D (after await) -> B (timeout)
```

- When JS executes an async function it immediately returns a Promise object.
- If you return value, it’s treated as Promise.resolve(value).
- If an error is thrown, it’s treated as Promise.reject(error).
- The returned Promise’s state (fulfilled or rejected) reflects the async function’s completion.

</details>

####
<details>
<summary> 🟩 Explain prototype inheritance and how it differs from class-based inheritance. </summary>

In JavaScript, inheritance is prototype-based, not class-based.
Every object has an internal link to another object called its prototype, from which it can inherit properties and methods.

**objects inherit properties and methods** from other objects via the **prototype chain**.  

Every object has an internal reference called `[[Prototype]]` (accessible as `__proto__`), which points to another object.  

If a property or method isn’t found on the current object, JS looks it up the chain until it reaches `Object.prototype`.

- Prototype Chain
```js
const person = {
    greet() {
        console.log(`Hello, I'm ${this.name}`);
    }
};

const user = Object.create(person);
user.name = "Anurag";

user.greet(); // ✅ found in prototype chain -> Hello, I'm Anurag
console.log(user.__proto__ === person); // true
console.log(Object.getPrototypeOf(user) === person); // true
```

- ES6 example
```js
class Animal {
    speak() { console.log("Animal sound"); }
}

class Dog extends Animal {
    speak() { console.log("Bark"); }
}

const d = new Dog();
d.speak(); // Bark

// ES6 class syntax just makes it look like traditional class-based inheritance, but under the hood, it’s all prototypes.
```

</details>

####
<details>
<summary> 🟩 What is this context? How does it change in arrow vs normal functions? </summary>

The keyword `this` refers to the object that is currently executing the function.

```js
// this in Normal Functions, determines at call time (dynamic binding).
function show() {
    console.log(this.name);
}

const user = { name: "Anurag", show };

user.show();           // "Anurag"
show();                // undefined (or window.name)

show.call({ name: "X" }); // "X"
```

```js
// this in Arrow Functions, Lexically bound → inherits this from its surrounding scope. Does not have its own this, arguments, or new.target.

const user = {
    name: "Anurag",
    show: () => console.log(this.name)
};
user.show(); // ❌ undefined — `this` comes from outer (global) scope

const user2 = {
    name: "Anurag",
    show() {
        const arrow = () => console.log(this.name);
        arrow(); // ✅ "Anurag" — inherits from `show()`'s this
  }
};
user2.show();
```

- Normal functions: this depends on how they’re called.
- Arrow functions: this is inherited from where they’re defined.

</details>

####
<details>
<summary> 🟩 How does JavaScript handle garbage collection and memory leaks? </summary>

JavaScript manages memory automatically using a garbage collector (GC) —
it frees memory used by objects that are no longer reachable

JS automatically frees memory using mark-and-sweep garbage collection,
but memory leaks can still occur when you keep unintended references alive.
</details>

####
<details>
<summary> 🟩 Difference between shallow copy vs deep copy, and how to implement both. </summary>

Shallow copy - Copies only the first-level properties. Nested objects still share the same reference.
```js
const user = {
  name: "Anurag",
  address: { city: "Minneapolis" }
};

const shallow = { ...user }; // or Object.assign({}, user)
shallow.address.city = "Chicago";

console.log(user.address.city); // "Chicago" ❌ also changed
```

Deep copy - Copies everything recursively, creating new copies of all nested objects.
```js
const user = {
  name: "Anurag",
  address: { city: "Minneapolis" }
};

// Option 1: JSON (simple, but loses methods & undefined)
const deep = JSON.parse(JSON.stringify(user));
deep.address.city = "Chicago";

console.log(user.address.city); // "Minneapolis" ✅ unaffected
```

Structured cloning for deep copy:
```js
const clone = structuredClone(user);
```
</details>

####
<details>
<summary> 🟩 Explain event delegation — how and why it improves performance. </summary>

Event delegation is a technique where you attach a single event listener to a parent element instead of adding listeners to each child element individually.

It works because of event bubbling — when an event occurs, it bubbles up the DOM tree until it reaches the root.

```js
// Event Delegation
document.querySelector("#list").addEventListener("click", (e) => {
  if (e.target.tagName === "LI") {
    console.log("Clicked:", e.target.textContent);
  }
});
// Instead of adding onclick to every <li>, we attach one to the parent <ul>.
```

</details>

####
<details>
<summary> 🟩 What are higher-order functions? </summary>

A higher-order function is a function that does any of the following:
- Takes another function as an argument, or
- Returns a new function as its result.

- Passing Function as Argument
```js
function greet(name) {
  return `Hello, ${name}`;
}

function processUser(fn, user) {
  return fn(user);
}

console.log(processUser(greet, "Anurag")); // "Hello, Anurag"
```

- Returning a Function
```js
function multiplier(factor) {
    return function (num) {
        return num * factor;
    };
}

const double = multiplier(2);
console.log(double(5)); // 10
// multiplier returns another function that remembers factor — closure + HOF in action.
```

Higher-order functions treat functions as values — passing or returning them —
enabling functional, reusable, and expressive code.

</details>

####
<details>
<summary> 🟩 Difference between call(), apply(), and bind() </summary>

All three are Function methods used to explicitly set the this context of a function

```js
const person = { name: "Anurag" };

function greet(city, country) {
  console.log(`Hi, I’m ${this.name} from ${city}, ${country}`);
}

// call → invoke immediately with comma args
greet.call(person, "Minneapolis", "USA");

// apply → invoke immediately with array args
greet.apply(person, ["Minneapolis", "USA"]);

// bind → returns new function
const greetAnurag = greet.bind(person, "Minneapolis", "USA");
greetAnurag(); // invoke later
```

</details>

####
<details>
<summary> 🟩 What are generators and iterators? </summary>

An iterator is an object that defines a sequence and gives access to its elements one at a time. It must have a method called next() that returns an object.

```js
const arr = [10, 20, 30];
const iterator = arr[Symbol.iterator]();

console.log(iterator.next()); // { value: 10, done: false }
console.log(iterator.next()); // { value: 20, done: false }
console.log(iterator.next()); // { value: 30, done: false }
console.log(iterator.next()); // { value: undefined, done: true }

// Each call to next() pulls the next value until finished.
```

A generator function (declared with function*) automatically creates an iterator.
It can pause and resume execution using the yield keyword.

```js
function* countUp() {
  yield 1;
  yield 2;
  yield 3;
}

const counter = countUp();
console.log(counter.next().value); // 1
console.log(counter.next().value); // 2
console.log(counter.next().value); // 3
// Each yield pauses the function until next() is called again.
```

</details>

####
<details>
<summary> 🟩 What is the module pattern in JS? </summary>

The Module Pattern is a design pattern used to encapsulate related variables and functions into a single unit (module), exposing only what’s necessary while keeping everything else private.

</details>

####
<details>
<summary> 🟩 How are ES6 modules different from CommonJS? </summary>

ES6
```js
// math.js
export const add = (a, b) => a + b;
export default function multiply(a, b) { return a * b; }

// main.js
import multiply, { add } from "./math.js";
console.log(add(2, 3));       // 5
console.log(multiply(2, 3));  // 6
```

CommonJs
```js
// math.js
exports.add = (a, b) => a + b;
module.exports.multiply = (a, b) => a * b;

// main.js
const { add, multiply } = require("./math");
console.log(add(2, 3));       // 5
console.log(multiply(2, 3));  // 6
```

</details>



####
<details>
<summary> 🟩 Difference between stack overflow and memory leak. </summary>

Stack Overflow = Happens when the call stack exceeds its limit (too many nested or recursive calls).

Memory Leak = Happens when unused memory is not released, causing memory usage to grow over time.

</details>

####
<details>
<summary> 🟩 What are polyfills? Give examples. </summary>

A polyfill is a piece of code (usually JS) that adds modern features to older browsers or environments that don’t support them natively.

a fallback implementation that mimics newer JavaScript functionality for backward compatibility.

Older browsers (like IE) don’t support includes().
```js
if (!Array.prototype.includes) {
    Array.prototype.includes = function (value) {
        return this.indexOf(value) !== -1;
    };
}
// Now ["a", "b"].includes("b") will work even in older environments.
```

</details>

####
<details>
<summary> 🟩 Explain tail call optimization in JS </summary>

Tail Call Optimization (TCO) is a performance optimization where a function call in the “tail position” (i.e., the last action of a function) allows the JS engine to reuse the current stack frame instead of creating a new one.

Conditions for TCO (per ES6 spec)
- The function must be in strict mode ("use strict").
- The recursive call must be in tail position (last operation).
- The result must be returned directly.
- No further computation or pending work after the call.

</details>

####
<details>
<summary> 🟩 Explain how to implement your own Promise.all() and Promise.race() </summary>

- Promise.all() — Waits for all Promises to resolve
```js
function myPromiseAll(promises) {
  return new Promise((resolve, reject) => {
    const results = [];
    let completed = 0;

    promises.forEach((p, i) => {
      Promise.resolve(p)
        .then(value => {
          results[i] = value;
          completed++;

          if (completed === promises.length) {
            resolve(results); // ✅ all done
          }
        })
        .catch(reject); // ❌ reject immediately
    });

    if (promises.length === 0) resolve([]); // edge case
  });
}

// Example
myPromiseAll([
  Promise.resolve(10),
  Promise.resolve(20),
  Promise.resolve(30)
]).then(console.log); // [10, 20, 30]
```

- Promise.race() — Returns first settled Promise
```js
function myPromiseRace(promises) {
  return new Promise((resolve, reject) => {
    promises.forEach(p => {
      Promise.resolve(p)
        .then(resolve)
        .catch(reject);
    });
  });
}

// Example
myPromiseRace([
  new Promise(res => setTimeout(() => res("A"), 500)),
  new Promise(res => setTimeout(() => res("B"), 200))
]).then(console.log); // "B" (first settled)
```

</details>

####
<details>
<summary> 🟩 What’s the difference between Object.seal() and Object.freeze() </summary>

- Object.seal()
```js
const user = { name: "Anurag", age: 30 };
Object.seal(user);

user.age = 31;       // ✅ can modify existing
user.city = "NY";    // ❌ can't add new
delete user.name;    // ❌ can't delete

console.log(user); // { name: "Anurag", age: 31 }
```

- Object.freeze()
```js
const config = { mode: "dark", version: 1 };
Object.freeze(config);

config.mode = "light"; // ❌ ignored or error in strict mode
config.newKey = 10;    // ❌ not added
delete config.version; // ❌ not deleted

console.log(config); // { mode: "dark", version: 1 }
```

</details>

####
<details>
<summary> 🟩 What are WeakMap and WeakSet? </summary>

WeakMap and WeakSet are special collection types similar to Map and Set,
but they hold “weak” references to their keys (or values).

A “weak reference” means — if no other references exist, the object can be garbage-collected automatically, preventing memory leaks.

- WeakMap
    - Stores key–value pairs, where keys must be objects.
    - Keys are weakly referenced → if an object key is garbage-collected, its entry disappears automatically.
    - Not iterable (no for...of, .keys(), or .size).

```js
const wm = new WeakMap();
let user = { name: "Anurag" };

wm.set(user, "Active session");
console.log(wm.get(user)); // "Active session"

user = null; // Object becomes unreachable → entry auto-removed

// Great for storing metadata or private data about objects without preventing GC.
```

- WeakSet
    - Similar to Set, but only stores objects (no primitives).
    - Objects are held weakly, so they can be garbage-collected if no other reference exists.
    - Also not iterable or size-checkable.

```js
const ws = new WeakSet();
let obj = { id: 1 };

ws.add(obj);
console.log(ws.has(obj)); // true

obj = null; // auto-removed from WeakSet

// Useful for tracking objects without preventing cleanup (e.g., caching, DOM node tracking).
```

</details>

####
<details>
<summary> 🟩 Explain CORS and preflight requests (OPTIONS). </summary>

- CORS - CORS (Cross-Origin Resource Sharing) is a browser security mechanism that controls how web pages can request resources from a different origin (domain, protocol, or port). By default, browsers enforce the Same-Origin Policy — scripts can only call APIs from the same domain.
CORS relaxes this restriction safely, using HTTP headers.

- preflight - A preflight request is an automatic “check” request the browser sends (using the OPTIONS method) before the actual API call — to ask the server if the real request is safe to send.

</details>

####
<details>
<summary> 🟩 Difference between localStorage, sessionStorage, and cookies </summary>

- localStorage
    - Key–value (Web Storage API)
    - Persistent (until manually cleared)
    - ~5–10 MB
    - Same-origin pages
    ```js
    localStorage.setItem("theme", "dark");
    console.log(localStorage.getItem("theme")); // "dark"
    ```
- sessionStorage
    - Key–value (Web Storage API)
    - Ends when tab/window closes
    - ~5 MB
    - Same tab + origin
    ```js
    sessionStorage.setItem("temp", "123");
    console.log(sessionStorage.getItem("temp")); // "123"
    ```
- Cookies
    - Key–value (HTTP header + JS)
    - Can be session-based or set with expiration
    - ~4 KB
    - Server and client
    ```js
    document.cookie = "user=Anurag; expires=Fri, 31 Dec 2025 23:59:59 GMT; path=/";
    ```

</details>

####
<details>
<summary> 🟩 What are service workers and how do they power PWAs? </summary>

A Service Worker is a background script that runs separately from the main browser thread. It intercepts network requests, caches assets, and enables offline access — making web apps faster, more reliable, and installable like native apps.

```js
// Register service worker (main.js)
if ("serviceWorker" in navigator) {
  navigator.serviceWorker.register("/sw.js")
    .then(() => console.log("Service Worker registered"));
}

// sw.js
self.addEventListener("install", e => {
  e.waitUntil(
    caches.open("v1").then(cache => cache.addAll(["/", "/index.html", "/style.css"]))
  );
});

self.addEventListener("fetch", e => {
  e.respondWith(
    caches.match(e.request).then(res => res || fetch(e.request))
  );
});
```

</details>

####
<details>
<summary> 🟩 Explain debouncing, throttling, and rate-limiting — real use cases. </summary>

All three are performance optimization techniques used to control how frequently functions execute, especially for events that fire very often (like scroll, resize, or keyup).

- Debouncing - Run after user stops triggering events - Waits for a “quiet period”
- Throttling - Run at regular intervals, ignoring extra triggers - Limits execution rate
- Rate-Limiting - Restrict total calls per time window (common in APIs) - Reject or queue excess calls

Debouncing — “Wait until things stop happening”
```js
function debounce(fn, delay) {
  let timer;
  return (...args) => {
    clearTimeout(timer);
    timer = setTimeout(() => fn(...args), delay);
  };
}

// Usage: search box autocomplete
window.addEventListener("keyup", debounce(() => {
    console.log("Searching...");
}, 500));

// Use Case: Search inputs, resize events, validation — run only after user stops typing or resizing.
```

Throttling — “Run every X milliseconds at most”
```js
function throttle(fn, limit) {
    let inThrottle;
    return (...args) => {
        if (!inThrottle) {
            fn(...args);
            inThrottle = true;
            setTimeout(() => inThrottle = false, limit);
        }
    };
}

// Usage: scroll event handler
window.addEventListener("scroll", throttle(() => {
  console.log("Scroll position:", window.scrollY);
}, 200));

// Use Case: Scroll, window resize, button spam — prevent high-frequency firing.
```

Rate-Limiting — “Limit total requests per time window”
```js
import rateLimit from "express-rate-limit";

const limiter = rateLimit({
    windowMs: 1 * 60 * 1000, // 1 minute
    max: 5, // limit each IP to 5 requests
});

app.use("/api", limiter);

// Use Case: API protection — prevent DoS attacks, bot abuse, or excessive requests.
```

</details>