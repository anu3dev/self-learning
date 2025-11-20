### javascript and java

####
<details>
<summary>🟩 Primitive vs Non-Primitive data types in JavaScript and Java</summary>

- JavaScript
    - Primitive Data Types (immutable)
        - These are stored by value.
        - Primitives are immutable (cannot be changed).
        - Assigned/stored by value.
        - Copying creates a new independent value.
        
        ```javascript
        let a = 10;
        let b = a; 
        b = 20;   // does NOT affect a
        ```

        - types
            - Number
            - String
            - Boolean
            - Null
            - Undefined
            - BigInt
            - Symbol

    - Non-Primitive Data Types (Reference)
        - Stored by reference (memory address).
        - Mutable
        - Copying shares the same memory object

        ```javascript
        let obj1 = { x: 1 };
        let obj2 = obj1;
        obj2.x = 5;
        console.log(obj1.x); // 5  (same reference)
        ```

        - types
            - Object
            - Array
            - Function
            - Date, Map, Set etc.

- java
    - Primitive Data Types (stored in stack)
        - Stored by value
        - Faster, fixed size
        - Cannot be null (except using wrappers)

        ```java
        int a = 10;
        int b = a;
        b = 20; // a stays 10
        ```

        - types
            - byte
            - short
            - int
            - long
            - float
            - double
            - char
            - boolean

    - Non-Primitive / Reference Types (stored in heap)
        - Stored by reference
        - Can be null
        - Created using new (mostly)

        ```java
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;
        arr2[0] = 99;
        System.out.println(arr1[0]); // 99 (same reference)

        ```

        - types
            - String
            - Arrays
            - Class objects
            - Interfaces
            - Collections (List, Map, Set)
</details>

####
<summary>🟩 Closure in JavaScript and Encapsulation in Java</summary>

- A closure in JavaScript is a function that remembers the variables from its outer scope even after that outer function has finished executing. A closure is formed when:
    - A function is created inside another function.
    - The inner function uses variables from the outer function.
    - The inner function still has access to those variables even after the outer function returns.
    - Helps implement encapsulation in JavaScript.
        - Encapsulation means hiding internal data and exposing only what is necessary.
        - Keeping variables private.
        - Access only through public methods.

```javascript
function counter1(){
    let counter = 0;

    function insc(){
        return counter++;
    }
    function desc(){
        return counter--;
    }
    function getValue(){
        return counter;
    }

    return {insc, desc, getValue}
}

const fn1 = counter1()

fn1.insc()
console.log(fn1.getValue()) // 1
fn1.insc()
console.log(fn1.getValue()) // 2
fn1.insc()
console.log(fn1.getValue()) // 3
fn1.insc()
console.log(fn1.getValue()) // 4
fn1.desc()
console.log(fn1.getValue()) // 3

const counter2 = () => {
    let counter = 0;

    insc = () => {
        return counter++;
    }
    desc = () => {
        return counter--;
    }
    getValue = () =>{
        return counter;
    }

    return {insc, desc, getValue}
}

const fn2 = counter2()

fn2.insc()
console.log(fn2.getValue()) // 1
fn2.insc()
console.log(fn2.getValue()) // 2
fn2.insc()
console.log(fn2.getValue()) // 3
fn2.insc()
console.log(fn2.getValue()) // 4
fn2.desc()
console.log(fn2.getValue()) // 3
```

</details>

####
<summary>🟩 Async in JavaScript? and in Java</summary>

- A Promise is an object in JavaScript that represents the result of an asynchronous operation that will complete in the future. It can be in one of three states:
    - Pending – still running, not finished yet
    - Fulfilled (Resolved) – success result
    - Rejected – failed with an error

    ```javascript
    const fetchData = new Promise((resolve, reject) => {
    const data = "data received"

    if(data === "data received"){
        resolve("response")
    } else {
        reject("error")
    }
    })

    fetchData
    .then(response => console.log(response))
    .catch(error => console.log(error))
    .finally(() => console.log("Completed"));
    ```

    - Promise Utility Methods
        - Promise.all()
            - Runs all promises in parallel.
            - Resolves only if all promises succeed.
            - If any promise fails → entire thing fails.
            
            ```javascript
            Promise.all([p1, p2, p3]);
            ```

        - Promise.race()
            - Returns the first promise that settles (resolved or rejected).

        - Promise.allSettled()
            - Returns results of all promises, even if some fail.

        - Promise.any()
            - Returns the first successfully resolved promise.
            - If all fail → returns an error.

    ```javascript
    console.log("A");

    setTimeout(() => {
        console.log("B");
    }, 0);

    Promise.resolve().then(() => {
        console.log("C");
    });

    console.log("D");

    // output
    // A -> A → sync
    // D -> D → sync
    // C -> Promise .then() → microtask (runs before setTimeout)
    // B -> setTimeout → macrotask
    ```

- we can't hold promis that is why settimeout or async/await comes into picture

    ```javascript
    setTimeout(() => {
        console.log('hello')
    }, 1000)
    ```

    ```javascript
    async function test() {
        console.log(1);

        await new Promise(resolve => {
            setTimeout(() => {
                console.log(2);
                resolve();
            }, 1000);
        });

        console.log(3);
    }

    test();
    console.log(4);

    // output
    // async function starts → prints 1
    // await pauses test()
    // main thread prints 4
    // setTimeout prints 2
    // after resolve, await continues → prints 3
    ```

    ```javascript
    function counter() {
        let count = 0;

        setTimeout(() => {
            count += 5;
        }, 1000);

        return function get() {
            return count;
        }
    }

    const c = counter();

    console.log(c()); // ?
    setTimeout(() => console.log(c()), 1500); // ?

    // output
    // 0 -> Immediately, count is still 0
    // 5 -> After 1.5 sec, the setTimeout has updated count to 5, Closure allows c() to access updated value
    ```

    ```javascript
    console.log(1);

    setTimeout(() => console.log(2), 0);

    Promise.resolve().then(() => {
        console.log(3);
        setTimeout(() => console.log(4), 0);
    });

    (async function () {
        console.log(5);
        await null;
        console.log(6);
    })();

    console.log(7);

    // output
    // 1  -> synchronous: first console.log runs immediately
    // 5  -> synchronous: inside the IIFE (async function starts executing)
    // 7  -> synchronous: last console.log in main thread
    // 3  -> microtask: Promise.resolve().then(...) callback runs
    // 6 -> microtask: async function continues after await null
    // 2 -> macrotask: first setTimeout(..., 0) executes
    // 4 -> macrotask: second setTimeout(..., 0) inside the .then() callback
    ```

- Java
```java
// Using CompletableFuture
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread starts");

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> {
                    try { Thread.sleep(1000); } catch(Exception e){}
                    return "Async result";
                });

        future.thenAccept(result -> System.out.println(result));

        System.out.println("Main thread continues...");
    }
}

// output ->
// Main thread starts
// Main thread continues...
// Async result
```

```java
// Using ExecutorService
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<String> future = service.submit(() -> {
            Thread.sleep(1000);
            return "Task complete";
        });

        System.out.println("Doing other work...");
        System.out.println(future.get()); // waits for result

        service.shutdown();
    }
}

// output ->
// Doing other work...
// Task complete
```

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Start");

        new Thread(() -> {
            try { Thread.sleep(1000); } catch (Exception e) {}
            System.out.println("Async task done");
        }).start();

        System.out.println("End");
    }
}

// output ->
// Start
// End
// Async task done
```

- Thread in java
```java
// inheriting Thread class
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running...");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();   // NOT run() — start() creates a new thread
    }
}
```

```java
// implementing Runnable interface
class MyTask implements Runnable {
    public void run() {
        System.out.println("Runnable running...");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyTask());
        t.start();
    }
}
```

```java
// using thread with lambda
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("Lambda thread running...");
        });
        t.start();
    }
}
```

- start() -> Starts a new thread
- run()	-> Defines thread logic
- sleep(ms) -> Pause thread
- join() -> Wait for another thread to finish
- interrupt() -> Interrupt a sleeping/waiting thread
- isAlive() -> Checks if running
</details>

####
<details>
<summary> 🟩 abstract class and interface in typescript </summary>

- Abstraction in TypeScript and Java is conceptually the same, abstraction is hiding internal details and exposing only what’s necessary, it can be achieved using Abstract Classes(partial abstraction) and Interfaces(full abstraction)

```typescript
// abstract
abstract class Vehicle {
  // abstract method → no body, must be implemented by subclass
  abstract start(): void;

  // normal method → shared logic
  stop(): void {
    console.log("Vehicle stopped.");
  }
}

class Car extends Vehicle {
  start(): void {
    console.log("Car started with key or button.");
  }
}

const myCar = new Car();
myCar.start(); // ✅ "Car started with key or button."
myCar.stop();  // ✅ "Vehicle stopped."



// interface
interface PaymentGateway {
  makePayment(amount: number): void;
}

class PayPal implements PaymentGateway {
  makePayment(amount: number): void {
    console.log(`Paid $${amount} using PayPal.`);
  }
}

const payment = new PayPal();
payment.makePayment(100); // ✅ "Paid $100 using PayPal."
```

</details>