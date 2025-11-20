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

####
<details>
<summary> 🟩 autowiring in java </summary>

Spring automatically injects (provides) the required dependency object into a class, instead of you creating it manually using new.

```java
// manually created
private Engine engine = new Engine();

// Spring will inject it automatically
@Autowired
private Engine engine;
```

- Key Points
    - @Autowired -> Tells Spring to inject (wire) the dependency automatically
    - @Component / @Service / @Repository -> Marks a class as a Spring Bean (managed by Spring container)
    - IOC (Inversion of Control) -> Spring manages the object lifecycle, not you
    - DI (Dependency Injection) -> Injecting dependencies automatically (via constructor, field, or setter)
- Common Autowiring Types
    - Field Injection -> @Autowired private Engine engine;
    - Constructor Injection ->	public Car(Engine engine);
    - Setter Injection -> setEngine(Engine engine);

- Constructor Injection Example
```java
@Component
public class Car {
    private final Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }
}

```

</details>

####
<details>
<summary> 🟩 Serializable in java </summary>

- Serialization	=> Converting object → byte stream → Packing your object into a suitcase of bytes
- Deserialization => Converting byte stream → object → Unpacking it back into a Java object

- It simply tells the Java Virtual Machine (JVM) that objects of this class can be converted into a byte stream.

```java
import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;

    // constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // getter
    public String getName() {
        return name;
    }
}
```

- Java objects exist only in memory (RAM) while the program is running. If you want to Save the object somewhere (like in a file or database), or Send the object to another system (like over a network or via API), then you must convert that object into a format that can travel or be stored. That’s where serialization comes in.

</details>

####
<details>
<summary> 🟩 join in java </summary>

join() is a Thread method in Java that lets one thread wait for another thread to finish before continuing.

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t1.join();   // main thread waits for t1 to finish

        t2.start();  // this runs only after t1 is done

        System.out.println("Main thread ends");
    }
}

```

</details>

####
<details>
<summary> 🟩 join in sql </summary>

A JOIN in SQL is used to combine data from two or more tables
based on a related column between them (usually a key like id).

- INNER JOIN -> Returns rows that have matching values in both tables.

```sql
SELECT e.emp_name, d.dept_name
FROM employees e
INNER JOIN departments d
ON e.dept_id = d.dept_id;
```

- LEFT JOIN -> Returns all rows from the left table, and matching rows from the right table.

```sql
SELECT e.emp_name, d.dept_name
FROM employees e
LEFT JOIN departments d
ON e.dept_id = d.dept_id;
```

- RIGHT JOIN -> Opposite of LEFT JOIN -> Returns all rows from the right table and matching ones from left.

```sql
SELECT e.emp_name, d.dept_name
FROM employees e
RIGHT JOIN departments d
ON e.dept_id = d.dept_id;
```

- FULL JOIN -> Returns all records from both tables, with NULLs where there’s no match.

```sql
SELECT e.emp_name, d.dept_name
FROM employees e
FULL OUTER JOIN departments d
ON e.dept_id = d.dept_id;
```

- CROSS JOIN -> Returns all possible combinations (Cartesian Product).

```sql
SELECT e.emp_name, d.dept_name
FROM employees e
CROSS JOIN departments d;
```

- SELF JOIN -> A table joins with itself (useful for hierarchy, manager-employee).

```sql
SELECT e1.emp_name AS Employee, e2.emp_name AS Manager
FROM employees e1
JOIN employees e2
ON e1.manager_id = e2.emp_id;
```

| Join Type | Description | Visual |
|------------|--------------|--------|
| **INNER JOIN** | Matching rows only | 🔵🟢 overlap |
| **LEFT JOIN** | All left + matching right | 🔵🟢 (keep all 🔵) |
| **RIGHT JOIN** | All right + matching left | 🟢🔵 (keep all 🟢) |
| **FULL JOIN** | All rows from both | 🔵 + 🟢 |
| **CROSS JOIN** | Every combination | 🔵×🟢 |
| **SELF JOIN** | Table joins itself | 🔵↔🔵 |

</details>

####
<details>
<summary> 🟩 Circular Dependency in Java? </summary>

- A circular dependency occurs when two or more components, classes, or beans depend on each other directly or indirectly, creating a loop in the dependency chain. e.g. Class A depends on Class B, and Class B depends back on Class A —
making it impossible for the system to resolve which one to create first.

```java
// Spring tried to create Bean A → saw it needed Bean B → tried to create Bean B → saw it needed Bean A → loop detected.
@Component
public class ServiceA {
    @Autowired
    private ServiceB serviceB;
}

@Component
public class ServiceB {
    @Autowired
    private ServiceA serviceA;
}

// two ways to solve it, either through interface or dependency injection.

// interface
interface CommonService { void doSomething(); }

@Component
public class ServiceA implements CommonService { ... }

@Component
public class ServiceB {
    @Autowired
    private CommonService service;
}

// dependency injection using Lazy
@Component
public class ServiceA {
    @Autowired
    @Lazy
    private ServiceB serviceB;
}
```

</details>

####
<details>
<summary> 🟩 method overriding and overloading </summary>

- Method Overloading - Compile-time Polymorphism
```java
class Calculator {
    // Method to add two integers
    int add(int a, int b) {
        return a + b;
    }

    // Method to add three integers
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method to add two doubles
    double add(double a, double b) {
        return a + b;
    }
}
```

- Method Overriding - Runtime Polymorphism
```java
class Animal {
    // Parent class method
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    // Child class method overriding the parent class method
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```
</details>

####
<details>
<summary> 🟩 Inheritance & Runtime Polymorphism </summary>

```java
// Inheritance – Reuse existing things from parent
class Vehicle {
    void stop() {
        System.out.println("Vehicle stopped");
    }

    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Car extends Vehicle {
    // stop method can also be used here
    void start() {
        System.out.println("Car started");
    }

    // Method Overriding is also called Runtime Polymorphism
    @@Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

</details>

####
<details>
<summary> 🟩 Method Overloading & Compile-time polymorphism </summary>

```java
// Method Overloading means having multiple methods with the same name but different parameters (type, number, or order) in the same class, also it is Compile-time polymorphism
class Calculator {
    // Method 1: two int parameters
    int add(int a, int b) {
        return a + b;
    }

    // Method 2: three int parameters
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method 3: double parameters
    double add(double a, double b) {
        return a + b;
    }
}
```

</details>

####
<details>
<summary> 🟩 interface </summary>

```java
// Interface – Define rules - have to implement both even it is not required
interface Vehicle {
    void start();
    void stop();
}

// here optional to implement honk method, can be overridden or directly used
interface Vehicle {
    void start();
    default void honk() {
        System.out.println("Honking...");
    }
}
```

</details>

####
<details>
<summary> 🟩 abstract class </summary>

```java
// Abstraction – Abstraction means showing only what is necessary and hiding complex logic.
// Achieved using abstract classes (partial abstraction) or interfaces (full abstraction).
abstract class Shape {
    // Abstract method → only declaration, no body
    abstract void draw();

    // Concrete (implemented) method → has body
    void areaFormula() {
        System.out.println("Area = length × breadth (general formula)");
    }
}

class Circle extends Shape {
    // Must implement the abstract method
    @Override
    void draw() {
        System.out.println("Drawing a circle...");
    }

    // Optional: override the concrete method if you want
    @Override
    void areaFormula() {
        System.out.println("Area = π × r × r");
    }
}
```

</details>

####
<details>
<summary> 🟩 OOPS </summary>

- Encapsulation -> class, private, getter/setter
- Inheritance -> extends
- Polymorphism -> @Override, method overloading
- Abstraction -> abstract, interface

</details>
