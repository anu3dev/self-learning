###

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

