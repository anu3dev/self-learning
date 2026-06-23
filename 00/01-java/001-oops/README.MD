# Java OOP Fundamentals - Quick Revision Notes

## What is a Class?

### Definition

A class is a blueprint/template that defines:

* State (variables)
* Behavior (methods)

### Example

```java
class Employee {

    String name;
    int age;

    void work() {
    }
}
```

### Interview One-Liner

> A class is a blueprint used to create objects.

---

# What is an Object?

### Definition

An object is an instance of a class.

### Example

```java
Employee emp = new Employee();
```

### Interview One-Liner

> An object is a runtime instance of a class that occupies memory.

---

# How Objects Live in Memory

```java
Employee emp = new Employee();
```

Java performs:

```text
new Employee()
    ↓
Object created in Heap Memory
    ↓
Reference stored in Stack Memory
```

```text
Stack
-----
emp ---> Address 100

Heap
----
Employee Object
```

### Important

```java
Employee emp1 = new Employee();

Employee emp2 = emp1;
```

Only ONE object exists.

Both references point to the same object.

### Interview One-Liner

> Reference variables store addresses, not actual objects.

---

# What is a Constructor?

### Definition

A special method used to initialize an object.

### Characteristics

* Same name as class
* No return type
* Called automatically during object creation

### Example

```java
Employee() {
    System.out.println("Created");
}
```

### Types

```text
Default Constructor
Parameterized Constructor
```

### Interview One-Liner

> Constructors initialize object state during creation.

---

# Method Overloading

### Definition

Multiple methods with the same name but different parameters.

### Example

```java
add(int a, int b)

add(int a, int b, int c)

add(double a, double b)
```

### Rules

Must differ by:

```text
Number of parameters
Type of parameters
Order of parameters
```

### Interview One-Liner

> Method Overloading is Compile-Time Polymorphism.

---

# Method Overriding

### Definition

Child class provides its own implementation of a parent method.

### Example

```java
class Animal {

    void sound() {
    }
}

class Dog extends Animal {

    @Override
    void sound() {
    }
}
```

### Interview One-Liner

> Method Overriding is Runtime Polymorphism.

---

# Overloading vs Overriding

| Overloading              | Overriding           |
| ------------------------ | -------------------- |
| Same class               | Parent & Child       |
| Compile Time             | Runtime              |
| Different parameters     | Same signature       |
| Inheritance not required | Inheritance required |

---

# Encapsulation

### Definition

Hide internal data and expose controlled access.

### Example

```java
private String email;
```

Access through:

```java
getEmail()

setEmail()
```

### Benefits

```text
Data Protection
Validation
Maintainability
```

### Interview One-Liner

> Encapsulation = Data Hiding + Controlled Access.

---

# Getter and Setter

### Getter

Used to read private data.

```java
getName()
```

### Setter

Used to update private data.

```java
setName()
```

### Why?

Because direct access can violate business rules.

---

# Abstraction

### Definition

Show WHAT an object does and hide HOW it does it.

### Example

```java
Payment
    pay()
```

Consumer knows:

```text
pay()
```

Consumer does not know:

```text
API Calls
Database Operations
Internal Logic
```

### Interview One-Liner

> Abstraction hides implementation details.

---

# Inheritance

### Definition

One class acquires properties and behaviors of another class.

### Relationship

```text
IS-A Relationship
```

### Example

```text
Dog IS-A Animal

SavingsAccount IS-A BankAccount
```

### Benefits

```text
Code Reuse
Extensibility
Polymorphism
```

### Interview One-Liner

> Inheritance models IS-A relationships.

---

# Polymorphism

### Definition

Same method call, different behavior.

### Types

```text
Compile-Time Polymorphism
    → Method Overloading

Runtime Polymorphism
    → Method Overriding
```

### Example

```java
Payment payment =
    new UpiPayment();

payment.pay();
```

### Interview One-Liner

> One interface, many implementations.

---

# Interface

### Definition

A contract that defines behavior.

### Example

```java
interface PaymentProcessor {

    void pay();
}
```

### Benefits

```text
Loose Coupling
Polymorphism
Extensibility
Testability
```

### Interview One-Liner

> Interface defines WHAT should happen, not HOW.

---

# Interface vs Abstract Class

| Interface           | Abstract Class            |
| ------------------- | ------------------------- |
| Contract only       | Contract + Implementation |
| Multiple allowed    | Single inheritance        |
| Loose coupling      | Shared behavior           |
| Preferred in Spring | Less common               |

### Interview One-Liner

> Interface = Capability, Abstract Class = Shared Base Behavior.

---

# Abstraction vs Interface

### Abstraction

Concept.

```text
Hide implementation details.
```

### Interface

Tool used to achieve abstraction.

### Easy Memory Trick

```text
Abstraction = Goal

Interface = One way to achieve the goal
```

---

# Association

### Definition

Two objects know about each other.

### Example

```text
Teacher ↔ Student
```

### Relationship

```text
Uses-A
```

---

# Aggregation

### Definition

Weak HAS-A relationship.

### Example

```text
Department HAS-A Employee
```

Employees can exist without Department.

### Ownership

```text
Weak Ownership
```

---

# Composition

### Definition

Strong HAS-A relationship.

### Example

```text
Car HAS-A Engine
```

Engine belongs to Car.

### Ownership

```text
Strong Ownership
```

---

# Composition Over Inheritance

### Prefer

```text
HAS-A
```

over

```text
IS-A
```

when possible.

### Bad

```java
Car extends Engine
```

### Good

```java
Car {

    private Engine engine;
}
```

### Why?

```text
Flexible
Loosely Coupled
Easy to Test
Easy to Maintain
```

### Modern Spring Style

```java
UserService {

    private UserRepository repository;
}
```

Not:

```java
UserService extends UserRepository
```

### Interview One-Liner

> Favor Composition over Inheritance for better flexibility and maintainability.

---

# Final Interview Cheat Sheet

```text
Class → Blueprint

Object → Instance of Class

Constructor → Initializes Object

Encapsulation → Hide Data

Getter/Setter → Controlled Access

Abstraction → Hide Implementation

Inheritance → IS-A Relationship

Polymorphism → Same Interface, Different Behavior

Overloading → Compile Time

Overriding → Runtime

Interface → Contract

Association → Uses-A

Aggregation → Weak HAS-A

Composition → Strong HAS-A

Composition > Inheritance
```
