# Design Patterns (GoF - Gang of Four)

Design Patterns are **proven, reusable solutions** to commonly occurring software design problems.

The **Gang of Four (GoF)** introduced **23 Design Patterns**, which are divided into **three categories** based on their purpose.

---

# 1. Creational Design Patterns

> **Purpose:** Concerned with **object creation**. They help create objects in a flexible and reusable way.

| Pattern | Purpose |
|---------|---------|
| **Singleton** | Ensures only one instance of a class exists. |
| **Factory Method** | Creates objects without exposing the object creation logic. |
| **Abstract Factory** | Creates families of related objects. |
| **Builder** | Builds complex objects step by step. |
| **Prototype** | Creates new objects by cloning existing ones. |

### Easy Way to Remember

> **"How should I create an object?"**

---

# 2. Structural Design Patterns

> **Purpose:** Concerned with **how classes and objects are connected** to form larger structures.

| Pattern | Purpose |
|---------|---------|
| **Adapter** | Makes incompatible interfaces work together. |
| **Bridge** | Separates abstraction from implementation. |
| **Composite** | Treats individual objects and groups uniformly. |
| **Decorator** | Adds new behavior dynamically without modifying the original class. |
| **Facade** | Provides a simple interface to a complex subsystem. |
| **Flyweight** | Shares common objects to reduce memory usage. |
| **Proxy** | Controls access to another object. |

### Easy Way to Remember

> **"How should objects be connected?"**

---

# 3. Behavioral Design Patterns

> **Purpose:** Concerned with **communication and interaction between objects**.

| Pattern | Purpose |
|---------|---------|
| **Strategy** | Encapsulates interchangeable algorithms. |
| **Observer** | Notifies dependent objects when state changes. |
| **Command** | Encapsulates a request as an object. |
| **Iterator** | Traverses collections without exposing internal structure. |
| **State** | Changes object behavior based on internal state. |
| **Mediator** | Centralizes communication between multiple objects. |
| **Visitor** | Adds new operations without modifying existing classes. |
| **Template Method** | Defines the skeleton of an algorithm while allowing subclasses to customize steps. |
| **Chain of Responsibility** | Passes a request through a chain of handlers until one processes it. |
| **Interpreter** | Defines grammar and interprets language expressions. |
| **Memento** | Saves and restores an object's previous state. |

### Easy Way to Remember

> **"How should objects communicate?"**

---

# Complete Classification

```text
                GoF Design Patterns (23)
                        │
        ┌───────────────┼───────────────┐
        ▼               ▼               ▼

   Creational      Structural      Behavioral
 (Object Creation) (Relationships) (Communication)

    Singleton         Adapter         Strategy
    Factory           Bridge          Observer
    Abstract Factory  Composite       Command
    Builder           Decorator       Iterator
    Prototype         Facade          State
                      Flyweight       Mediator
                      Proxy           Visitor
                                      Template Method
                                      Chain of Responsibility
                                      Interpreter
                                      Memento
```

---

# Quick Revision Trick

## Creational (5)

```text
Singleton
Factory
Abstract Factory
Builder
Prototype
```

**Keyword:** **Create Objects**

---

## Structural (7)

```text
Adapter
Bridge
Composite
Decorator
Facade
Flyweight
Proxy
```

**Keyword:** **Connect Objects**

---

## Behavioral (11)

```text
Strategy
Observer
Command
Iterator
State
Mediator
Visitor
Template Method
Chain of Responsibility
Interpreter
Memento
```

**Keyword:** **Communicate**

---

# Memory Shortcut

```text
Create → Connect → Communicate

Creational → Structural → Behavioral
```

or

```text
Object Creation
        ↓
Object Relationships
        ↓
Object Communication
```

---

# Interview Questions

### Q1. How many GoF Design Patterns are there?

**Answer:** 23

---

### Q2. Who introduced Design Patterns?

**Answer:** The **Gang of Four (GoF)**:
- Erich Gamma
- Richard Helm
- Ralph Johnson
- John Vlissides

---

### Q3. How are GoF Design Patterns classified?

| Category | Count |
|----------|------:|
| Creational | 5 |
| Structural | 7 |
| Behavioral | 11 |
| **Total** | **23** |

---

### Q4. Which category does Singleton belong to?

**Answer:** Creational

---

### Q5. Which pattern is used to notify multiple objects when one object changes?

**Answer:** Observer Pattern

---

### Q6. Which pattern allows behavior to change at runtime?

**Answer:** Strategy Pattern

---

### Q7. Which pattern provides a simplified interface to a complex subsystem?

**Answer:** Facade Pattern

---

### Q8. Which pattern adds functionality without modifying existing code?

**Answer:** Decorator Pattern

---

# Key Takeaways

- **Creational Patterns** → Focus on **object creation**.
- **Structural Patterns** → Focus on **object composition and relationships**.
- **Behavioral Patterns** → Focus on **communication and interaction between objects**.
- The **Gang of Four (GoF)** introduced **23 classic design patterns**, which remain fundamental in Java, Spring Framework, and enterprise software development.

---

> ## Interview Tip
>
> A common interview question is: **"Name the three categories of GoF Design Patterns."**
>
> A simple way to remember them is:
>
> **Create → Connect → Communicate**
>
> - **Creational** → Create Objects
> - **Structural** → Connect Objects
> - **Behavioral** → Communicate Between Objects