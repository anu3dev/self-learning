### 💥 Full-Stack + Frontend + Java Interview Preparation (By Anurag Kumar)

---

<details>
<summary> 🟩 JavaScript </summary>

1. Event loop, call stack, microtasks/macrotasks




    #### concept
    JavaScript is single-threaded. The **call stack** executes synchronous code line by line.  
    **Async tasks** (Promises, timers, I/O) are delegated to the Web APIs and queued back in:
    - **Microtask queue** → `Promise.then`, `MutationObserver`
    - **Macrotask queue** → `setTimeout`, `setInterval`, `setImmediate`

    The **event loop** constantly checks:
    1. Is the call stack empty?  
    2. If yes → push next microtask(s).  
    3. When microtasks finish → take one macrotask → repeat.

    #### example code
    ```js
    console.log("start");

    setTimeout(() => console.log("timeout"), 0);

    Promise.resolve()
        .then(() => console.log("promise1"))
        .then(() => console.log("promise2"));

    console.log("end");
    ```

    #### output
    ```json
    start
    end
    promise1
    promis2
    timeout
    ```




    #### concept
    **async/await** is syntactic sugar for Promises. When you await something, JavaScript pauses that async function at that point, allowing other tasks (in the event loop) to run. When the awaited Promise resolves, the async function resumes in a new microtask.

    #### example code
    ```js
    console.log("A");

    setTimeout(() => console.log("B (timeout)"), 0);

    (async function() {
        console.log("C (start async)");
        await Promise.resolve();
        console.log("D (after await)");
    })();

    console.log("E");
    ```

    #### output
    ```json
    A
    C (start async)
    E
    D (after await)
    B (timeout)
    ```
    



    #### concept
    When JavaScript runs, it creates an **execution context** for each scope and pushes it onto the **call stack**.  
    Every context has two phases:

    1. **Creation Phase (Hoisting)**  
    - `var` → hoisted & initialized as `undefined`  
    - `let` / `const` → hoisted but not initialized (Temporal Dead Zone)  
    - **Function declarations** → hoisted with full definition  
    - **Function expressions / arrow functions** → treated as variables (undefined until assigned)

    2. **Execution Phase**  
    - Code executes line-by-line  
    - Variables get assigned values  
    - Functions execute → new execution context pushed to stack  

    #### example code
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
    ```

    #### output
    ```json
    Hello from function declaration
    undefined
    ReferenceError
    Hi from function expression
    ```

    - During creation, JS reserves memory for all variables & function declarations.
    - Function declarations are hoisted with body → can be called before definition.
    - Variables declared with var exist but are undefined until assigned.
    - let & const stay in TDZ until their line executes.
    - Function expressions i.e. arrow function act like variables → not callable before assignment.
    - Each function call creates a new stack frame (own local variables, arguments).
    - Once the function returns, its frame is popped from the call stack.




    #### concept
    A **closure** is created when an inner function **remembers and accesses variables** from its outer (lexical) scope **even after** that outer function has finished executing.

    Every time a function is pushed on the **call stack**, a new **lexical environment** is created.  
    When the outer function finishes and is popped from the stack, the inner function keeps a **reference (not copy)** of the outer variables through the closure.

    #### 🧩 example code
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




    #### concept
    In JavaScript, **objects inherit properties and methods** from other objects via the **prototype chain**.  
    Every object has an internal reference called `[[Prototype]]` (accessible as `__proto__`), which points to another object.  
    If a property or method isn’t found on the current object, JS looks it up the chain until it reaches `Object.prototype`.

    #### 🧩 Example Code
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




    ### ES6 example
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




2. var / let / const + hoisting  
3. Closures and use cases  
4. Prototype inheritance  
5. `this` in arrow vs normal functions  
6. async / await internals  
7. Debounce vs Throttle (+ implementation)  
8. Deep vs Shallow copy  
9. Currying  
10. IIFE & module pattern  
11. call / apply / bind  
12. Event delegation  
13. Memory leaks & GC  
14. Service workers & PWAs  
15. CORS & pre-flight  
16. localStorage / sessionStorage / cookies  
17. WeakMap / WeakSet  
18. Polyfills  
19. Custom Promise.all / race  
20. Temporal Dead Zone  
21. Tail call optimization  
22. Spread vs Rest  
23. Destructuring  
24. Map vs Object  
25. JSON pitfalls  
26. Optional chaining / nullish coalescing  
27. Custom iterator  
28. Symbols  
29. Event bubbling / capturing  
30. Chrome DevTools profiling  

</details>

---

<details>
<summary>🟩 TypeScript </summary>

1. interface vs type  
2. Generics  
3. Utility types (Partial, Pick, Omit, Record)  
4. Union & Intersection  
5. Type guards and narrowing  
6. keyof / typeof  
7. Discriminated unions  
8. Enums & const enums  
9. Declaration merging  
10. Ambient modules  
11. Structural typing  
12. Function overloads  
13. never type  
14. Type inference vs assertion  
15. tsconfig options  
16. Decorators basics  

</details>

---

<details>
<summary>🟩 HTML & Accessibility</summary>

1. Semantic HTML importance  
2. Block / inline / inline-block  
3. Lazy loading media  
4. ARIA roles / tabindex  
5. SEO & OpenGraph meta tags  
6. Responsive images (srcset / picture)  
7. Shadow DOM  
8. CSR vs SSR for SEO  

</details>

---

<details>
<summary>🟩 CSS & Design Systems</summary>

1. Box Model & stacking context  
2. position: relative / absolute / fixed / sticky  
3. Specificity hierarchy  
4. Reflow vs Repaint  
5. Flexbox vs Grid  
6. CSS variables & theming  
7. Responsive design (media queries, fluid layouts)  
8. BEM methodology  
9. CSS Modules / Styled Components / Emotion  
10. Critical CSS & PurgeCSS  
11. Building scalable design systems  

</details>

---

<details>
<summary>🟩 React</summary>

1. Virtual DOM & reconciliation  
2. Fiber architecture  
3. Hooks overview (useState, useEffect)  
4. useMemo / useCallback / React.memo  
5. Controlled vs Uncontrolled components  
6. useLayoutEffect vs useEffect  
7. Context API  
8. Error boundaries  
9. Suspense / concurrent rendering  
10. Custom hooks  
11. Portals  
12. Keys in lists  
13. Prop drilling vs Context  
14. React Profiler  
15. SSR vs Hydration  
16. Code-splitting / lazy loading  
17. Virtualized lists  
18. Accessibility in React  
19. React 18 transitions  
20. Re-render optimization  

</details>

---

<details>
<summary>🟩 Redux & State Management</summary>

1. Redux core flow (store, action, reducer)  
2. Redux Toolkit (createSlice)  
3. Selector memoization (reselect)  
4. Thunk vs Saga  
5. RTK Query  
6. Immutable updates with Immer  
7. Global error / loading pattern  

</details>

---

<details>
<summary>🟩 Vite & Webpack </summary>

1. Vite vs Webpack differences  
2. Tree-shaking  
3. HMR mechanism  
4. Dynamic imports & code splitting  
5. Babel vs SWC vs esbuild  
6. Bundle analyzer usage  
7. Source maps  
8. Caching & content hashing  
9. Multi-env build config  

</details>

---

<details>
<summary>🟩 Java </summary>

1. JVM / JRE / JDK
2. Classloader hierarchy  
3. OOP pillars  
4. Abstract vs interface  
5. Overloading vs overriding  
6. final / finally / finalize  
7. == vs equals  
8. hashCode contract  
9. Immutability pattern  
10. transient / volatile  
11. Shallow vs deep copy  
12. GC algorithms  
13. Functional interfaces / lambdas  
14. Stream API  
15. Optional usage  
16. Checked vs unchecked exceptions  
17. try-with-resources  
18. StringBuilder vs StringBuffer  
19. List / Set / Map  
20. Comparator vs Comparable 

</details>

---

<details>
<summary>🟩 Spring Boot </summary>

1. @Component / @Service / @Repository  
2. Dependency Injection  
3. @Autowired types  
4. Bean scopes  
5. @Configuration / @Bean  
6. CrudRepository vs JpaRepository  
7. @Transactional  
8. @RestController vs @Controller  
9. @ControllerAdvice  
10. @Valid validation  
11. Spring Security + JWT  
12. Pagination / sorting  
13. Profiles  
14. Actuator  
15. Health checks  
16. AOP advices  
17. YAML vs properties  
18. Multi-datasource setup  
19. @Cacheable  
20. @Async   

</details>

---

<details>
<summary>🟩 Rest & GraphQL </summary>

1. REST vs GraphQL  
2. Schema + resolver design  
3. N+1 problem solution  
4. File upload via GraphQL  
5. API versioning  
6. RestTemplate vs WebClient  
7. GraphQL global exception handling  
8. DTO pattern  
9. Logging (SLF4J)  
10. Dockerize + deploy Spring Boot  

</details>

---

<details>
<summary>🟩 DSA (Java & JS) </summary>

1. Reverse string  
2. Palindrome check  
3. Factorial recursion  
4. Fibonacci series  
5. Missing number (1..N)  
6. Duplicates in array  
7. Merge sorted arrays  
8. Remove duplicates  
9. Move zeros to end  
10. Second largest number  
11. Bubble / Insertion / Selection sort  
12. Binary search  
13. Reverse linked list  
14. Detect cycle (Floyd’s)  
15. Merge linked lists  
16. Find middle node  
17. Balanced parentheses  
18. Stack using queues  
19. Queue using stacks  
20. Min / Max stack  
21. LRU cache  
22. Intersection of arrays  
23. Subarray sum = K  
24. Sliding window max  
25. Word frequency count  
26. Longest substring (no repeat)  
27. Anagram check  
28. Tree traversals  
29. LCA in binary tree  
30. Detect graph cycle  

</details>

---

<details>
<summary>🟩 System Design, LLD & HLD </summary>

**Frontend-centric**
1. Micro-frontend dashboard  
2. RBAC in SPA  
3. Notification system (WebSocket)  
4. Chat UI  
5. Offline-first PWA  
6. File upload progress  
7. Component library (Storybook)  
8. Client-side caching (IndexedDB)  
9. Multi-env CI/CD  
10. Frontend logging (Sentry)

**Backend-centric**
11. URL shortener  
12. Rate limiter  
13. Polling / Survey system  
14. E-commerce checkout  
15. Payment gateway  
16. Scheduler (Quartz)  
17. Messaging system (Kafka + WS)  
18. Auth + refresh tokens  
19. Logging microservice  
20. Search autocomplete

**LLD Scenarios**
21. Parking lot  
22. Elevator  
23. ATM  
24. Hotel booking  
25. Splitwise  
26. Library mgmt  
27. Inventory system  
28. Rate limiting filter  
29. Audit logger  
30. Task scheduler  

</details>