### java

####
<details>
<summary>🟩 Java Functional Interface</summary>

- A functional interface that takes one input and returns one output.
- in Java 8+
```java
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Function<Integer, Integer> square = n -> n * n;

        System.out.println(square.apply(5)); // 25



        // quick exmaple of stream
        List<Integer> nums = List.of(1, 2, 3, 4);

        Function<Integer, Integer> doubleIt = n -> n * 2;

        nums.stream().map(doubleIt).forEach(System.out::println);
    }
}
```
- Interface	-> Meaning
    - Function<T, R> -> Takes input, returns output
    - BiFunction<T, U, R> -> Takes 2 inputs, returns output
    - Predicate<T> -> Returns boolean
    - Consumer<T> -> Takes input, no return
    - Supplier<T> -> No input, returns value
    - UnaryOperator<T> -> Function where input & output same type
    - BinaryOperator<T> -> Two same-type inputs, one output
</details>

####
<details>
<summary>🟩 6 Core REST Principles</summary>

- Client–Server Architecture
    - Client and server must be separated -> Client handles UI and Server handles data & logic, This separation allows both to evolve independently.

- Statelessness
    - Each request from the client must contain all the information needed to process it -> Server does NOT store client session, No memory of previous requests, Every request is independent, Example: Client must send token every time.

- Cacheability
    - Responses must define whether they are cacheable or not -> Improves performance, Reduces server load, Uses headers like Cache-Control, ETag, Expires

- Uniform Interface (MOST IMPORTANT)
    - All communication between client and server must be done in a standard, consistent way.

    - Includes:
        - Resource-based URLs
            - /users/10/orders
        - Standard HTTP methods
            - GET → Read
            - POST → Create
            - PUT → Update (replace)
            - PATCH → Partial update
            - DELETE → Delete
        - Standard response codes
            - 200 OK
            - 201 Created
            - 400 Bad Request
            - 404 Not Found
            - 500 Server Error

- Layered System
    - REST allows multiple layers between client and server:
        - Load balancers
        - Proxies
        - Gateways
        - Security layers -> Client doesn’t know how many layers exist.

- Code on Demand (Optional)
    - Server can send executable code to the client. Example: Send JavaScript to browser.
</details>

####
<details>
<summary>🟩 What is Singleton?</summary>

- A Singleton is a design pattern that ensures:
    - Only one instance of a class exists
    - That instance is globally accessible
    - Used for:
        - Database connection
        - Logger
        - Configuration manager
        - Caches
        - Thread pools

```java
public class Singleton {
    // To prevent object creation using new. -> constructor private
    private Singleton() {}

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

```java
// In Spring, every bean is singleton by default.
// @Service, @Component, @Repository, @Controller -> They are automatically Singleton beans unless you change the scope.

@Service
@Scope("singleton")   // optional, because default is singleton
public class MyService {

}
```
</details>

####
<details>
<summary>🟩 What is an Exception? </summary>

- Compile time always happens before runtime, Checked Exceptions are Compile-Time Exceptions and Unchecked Exceptions are Runtime Exceptions

- An exception is an event that interrupts normal program flow.
    - Checked Exceptions - Compile-Time Exceptions
        - Checked at compile time
        - Must be handled using try/catch OR declared with throws
        - Examples:
            - IOException
            - SQLException
            - ClassNotFoundException
            - InterruptedException
            - FileNotFoundException
        - If you don’t handle them → compiler error

        ```java
        // create your own checked exception
        // Must use throws
        // Must use try/catch

        class MyCheckedException extends Exception {
            public MyCheckedException(String message) {
                super(message);
            }
        }

        public class Main {
            static void test() throws MyCheckedException {
                throw new MyCheckedException("This is a checked exception");
            }

            public static void main(String[] args) {
                try {
                    test();
                } catch (MyCheckedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        ```
    - Unchecked Exceptions - Runtime Exceptions
        - Checked at runtime
        - Do NOT need to be declared or caught
        - Occur usually due to programming errors
        - Examples:
            - NullPointerException
            - ArrayIndexOutOfBoundsException
            - ArithmeticException
            - IllegalArgumentException
            - RuntimeException
        - Compiler does not force you to handle these.

        ```java
        // To create an unchecked exception
        // No need for throws
        // Optional to catch

        class MyUncheckedException extends RuntimeException {
            public MyUncheckedException(String message) {
                super(message);
            }
        }

        public class Main {
            static void test() {
                throw new MyUncheckedException("This is an unchecked exception");
            }

            public static void main(String[] args) {
                test();  // no try/catch needed
            }
        }
        ```
</details>

