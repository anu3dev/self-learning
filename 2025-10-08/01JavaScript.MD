### 💥 JavaScript Interview Preparation (By Anurag Kumar)

---

####
<details>
<summary> 🟩 Explain rendering pipeline. </summary>

- JavaScript Execution
    - JS runs on the main thread; modifies DOM or CSS.
    - While JS runs, browser can’t render or paint (single-threaded).
- Style Calculation
    - Browser figures out which CSS rules apply to each element and builds a Render Tree.
    - Triggered when CSS or inline styles change.
- Layout
    - Calculates position and size of each element in the viewport.
    - Triggered when geometry-related properties change (width, height, margin, etc.).
- Paint
    - Browser fills pixels for colors, borders, text, and images.
    - Happens when visual (not layout) properties change — like background, color, opacity.
- Composite
    - Combines all painted layers into the final frame displayed on screen (often GPU-accelerated).
    - Happens ~60 times/sec for smooth UI updates.

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

- closure
    A **closure** is created when an inner function **remembers and accesses variables** from its outer (lexical) scope **even after** that outer function has finished executing.

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

- prototype
    In JavaScript, **objects inherit properties and methods** from other objects via the **prototype chain**.  

    Every object has an internal reference called `[[Prototype]]` (accessible as `__proto__`), which points to another object.  

    If a property or method isn’t found on the current object, JS looks it up the chain until it reaches `Object.prototype`.

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
    ```

</details>
