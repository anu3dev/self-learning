# SOLID Principles - Quick Revision Notes

## Why SOLID?

SOLID principles help create code that is:

* Easy to extend
* Easy to maintain
* Easy to test
* Loosely coupled
* Flexible for future changes

---

# S - Single Responsibility Principle (SRP)

### Definition

A class should have only one reason to change.

### Bad

```text
OrderService
    Save Order
    Send Email
    Generate Invoice
```

### Good

```text
OrderService       → Order Processing
EmailService       → Email Sending
InvoiceService     → Invoice Generation
OrderRepository    → Data Persistence
```

### Interview One-Liner

> One class = One responsibility = One reason to change.

---

# O - Open Closed Principle (OCP)

### Definition

Software entities should be open for extension but closed for modification.

### Goal

Add new functionality without changing existing code.

### Bad

```java
if(paymentType.equals("UPI"))
if(paymentType.equals("CARD"))
if(paymentType.equals("PAYPAL"))
```

Every new payment method modifies existing code.

### Good

```java
PaymentProcessor
    ├── UpiPaymentProcessor
    ├── CardPaymentProcessor
    └── PaypalPaymentProcessor
```

Add:

```java
StripePaymentProcessor
```

No existing code changes.

### Interview One-Liner

> Extend behavior through new classes, not by modifying old classes.

---

# L - Liskov Substitution Principle (LSP)

### Definition

A child class should be replaceable by its parent abstraction without breaking behavior.

### Bad

```text
Bird
   └── Penguin
```

If Bird has:

```java
fly()
```

and Penguin cannot fly:

```java
throw new RuntimeException()
```

LSP is violated.

### Good

```text
Bird

Flyable
   └── Sparrow

Bird
   └── Penguin
```

### Interview One-Liner

> Child classes must honor the contract of the parent.

---

# I - Interface Segregation Principle (ISP)

### Definition

Clients should not be forced to depend on methods they do not use.

### Bad

```java
interface Worker {
    work();
    eat();
    sleep();
}
```

Robot:

```java
eat() -> UnsupportedOperationException
sleep() -> UnsupportedOperationException
```

### Good

```java
Workable
Eatable
Sleepable
```

Robot:

```java
implements Workable
```

### Interview One-Liner

> Prefer multiple small interfaces over one large interface.

---

# D - Dependency Inversion Principle (DIP)

### Definition

Depend on abstractions, not concrete implementations.

### Bad

```java
OrderService
    new UpiPaymentProcessor()
```

Tightly coupled.

### Good

```java
OrderService
    PaymentProcessor processor
```

Constructor Injection:

```java
OrderService(PaymentProcessor processor)
```

### Interview One-Liner

> High-level modules should depend on interfaces, not implementations.

---

# Relationship Between O, I and D

These three principles usually work together.

```text
ISP
 ↓
Creates small interfaces

DIP
 ↓
Depends on those interfaces

OCP
 ↓
Extends behavior using new implementations
```

Example:

```java
PaymentProcessor
```

Implementations:

```java
UpiPaymentProcessor
CardPaymentProcessor
PaypalPaymentProcessor
```

Benefits:

✅ OCP → Add new payment methods easily

✅ DIP → Depend on PaymentProcessor interface

✅ ISP → Keep interface focused and small

---

# Composition Over Inheritance

## Prefer HAS-A over IS-A

### Inheritance

```java
class Car extends Engine
```

Question:

```text
Is Car an Engine?
```

No.

Wrong relationship.

### Composition

```java
class Car {

    private Engine engine;
}
```

```text
Car HAS-A Engine
```

Correct relationship.

---

# Modern Spring Boot Design

Rare:

```java
class UserService extends UserRepository
```

Common:

```java
class UserService {

    private UserRepository repository;
}
```

Why?

```text
Composition
+
Interfaces
+
Dependency Injection
+
SOLID
```

---

# Final Interview Cheat Sheet

```text
SRP → One Class, One Job

OCP → Extend, Don't Modify

LSP → Child Must Behave Like Parent

ISP → Small Focused Interfaces

DIP → Depend on Interfaces

Composition > Inheritance

HAS-A → Composition

IS-A → Inheritance
```
