# Adapter Design Pattern

The **Adapter Design Pattern** is a **Structural Design Pattern** that allows two incompatible interfaces to work together **without modifying their existing code**.

It acts as a bridge between your application's expected interface and a third-party or legacy interface.

---

# Why Do We Need the Adapter Pattern?

Imagine your application already uses a payment gateway.

```java
pay(amount)
```

Now the business decides to integrate **Stripe**.

Stripe provides a different method.

```java
makePayment(value)
```

Your application expects:

```java
pay(amount)
```

Stripe exposes:

```java
makePayment(value)
```

Since you **cannot modify third-party code**, how do you integrate Stripe without changing your entire application?

The answer is the **Adapter Pattern**.

---

# Real-World Analogy

Think of an electrical adapter.

```text
Indian Plug
      │
      ▼
 Power Adapter
      │
      ▼
US Socket
```

The electricity is the same.

Only the interface is different.

The adapter converts one interface into another.

---

# Another Everyday Example

A laptop charger.

```text
Laptop
   │
   ▼
Power Adapter
   │
   ▼
Wall Socket
```

Without the adapter:

❌ The plug doesn't fit.

With the adapter:

✅ Everything works seamlessly.

---

# What Problem Does Adapter Solve?

The Adapter Pattern solves the problem of **interface incompatibility**.

Instead of modifying existing code, it creates a wrapper that converts one interface into another.

This allows existing code and third-party libraries to work together without affecting either side.

---

# Structure

```text
               Client
                  │
                  ▼
         Target Interface
                  │
                  ▼
              Adapter
                  │
                  ▼
             Adaptee
```

---

# Payment Gateway Example

```text
Client
    │
    ▼
PaymentGateway
    │
    ▼
StripeAdapter
    │
    ▼
Stripe API
```

The client communicates only with the `PaymentGateway` interface.

The adapter translates those calls into Stripe's API.

---

# Java Implementation

## Step 1 — Target Interface

```java
interface PaymentGateway {

    void pay(double amount);

}
```

This is the interface expected throughout the application.

---

## Step 2 — Existing Implementation

```java
class RazorpayGateway implements PaymentGateway {

    @Override
    public void pay(double amount) {

        System.out.println("Paid using Razorpay : " + amount);

    }
}
```

This already matches our application's interface.

---

## Step 3 — Third-Party Library (Adaptee)

Imagine Stripe is an external SDK.

We cannot modify it.

```java
class Stripe {

    public void makePayment(double value) {

        System.out.println("Paid using Stripe : " + value);

    }

}
```

Notice that Stripe does **not** implement `PaymentGateway`.

---

## Step 4 — Adapter

```java
class StripeAdapter implements PaymentGateway {

    private Stripe stripe;

    public StripeAdapter() {

        stripe = new Stripe();

    }

    @Override
    public void pay(double amount) {

        stripe.makePayment(amount);

    }

}
```

The adapter converts:

```java
pay(amount)
```

into

```java
makePayment(amount)
```

without changing the Stripe SDK.

---

## Step 5 — Client

```java
public class Main {

    public static void main(String[] args) {

        PaymentGateway gateway = new StripeAdapter();

        gateway.pay(500);

    }

}
```

---

## Output

```text
Paid using Stripe : 500.0
```

---

# What Happens Internally?

```text
Client

    │

    ▼

gateway.pay(500)

    │

    ▼

StripeAdapter.pay(500)

    │

    ▼

stripe.makePayment(500)

    │

    ▼

Stripe API Executes
```

The client believes it called `pay()`.

Behind the scenes, the adapter invokes `makePayment()`.

---

# UML Diagram

```text
              +----------------------+
              |  PaymentGateway      |
              +----------------------+
              | + pay(amount)        |
              +----------▲-----------+
                         │
          implements     │
                         │
              +----------------------+
              |   StripeAdapter      |
              +----------------------+
              | - stripe : Stripe    |
              | + pay(amount)        |
              +----------│-----------+
                         │
                         ▼
              +----------------------+
              |       Stripe         |
              +----------------------+
              | + makePayment()      |
              +----------------------+
```

---

# Before vs After Adapter

## Without Adapter

```text
Application

      │

      ▼

pay()

      │

      ▼

Stripe

makePayment()

❌ Method mismatch
```

---

## With Adapter

```text
Application

      │

      ▼

pay()

      │

      ▼

StripeAdapter

      │

      ▼

makePayment()

✅ Compatible
```

---

# Production Examples

## 1. Spring MVC

When returning:

```java
ResponseEntity
```

Spring internally converts it into:

```text
HttpServletResponse
```

using adapter-like components.

---

## 2. JDBC

Your application uses:

```text
Connection

Statement

ResultSet
```

Different databases implement these differently:

- Oracle
- MySQL
- PostgreSQL
- SQL Server

JDBC provides a common interface, allowing your application to work with any supported database driver.

---

## 3. SLF4J

Your application writes logs using:

```java
Logger
```

Behind the scenes, SLF4J can delegate to:

- Logback
- Log4j
- java.util.logging

without changing application code.

---

## 4. React / Frontend

Suppose an API returns:

```json
{
  "first_name": "John",
  "last_name": "Doe"
}
```

Your React application expects:

```json
{
  "firstName": "John",
  "lastName": "Doe"
}
```

Create an adapter.

```javascript
function adaptUser(apiUser) {
    return {
        firstName: apiUser.first_name,
        lastName: apiUser.last_name
    };
}
```

The UI never knows the backend format was different.

---

# Advantages

- Decouples your application from third-party libraries.
- Allows integration without modifying existing code.
- Encourages the Open/Closed Principle.
- Makes third-party libraries interchangeable.
- Improves maintainability and testability.

---

# Disadvantages

- Introduces an additional layer of abstraction.
- Can slightly increase code complexity.
- Too many adapters may make the design harder to follow.

---

# When Should You Use Adapter?

Use Adapter when:

- You integrate third-party SDKs.
- You cannot modify existing classes.
- Two systems expose incompatible interfaces.
- You need to support legacy code.

---

# When Should You NOT Use Adapter?

Avoid Adapter when:

- You own both classes and can modify them.
- The interfaces already match.
- A simple refactoring solves the problem.

In those cases, an adapter only adds unnecessary complexity.

---

# Adapter vs Decorator

| Adapter | Decorator |
|----------|-----------|
| Changes the interface | Keeps the same interface |
| Makes incompatible classes work together | Adds new behaviour |
| Focuses on compatibility | Focuses on enhancement |
| Structural Pattern | Structural Pattern |

---

# Interview Questions

## What problem does the Adapter Pattern solve?

It allows classes with incompatible interfaces to work together without modifying their existing code.

---

## Why not directly use Stripe?

Because Stripe doesn't implement the interface expected by the application.

The adapter converts Stripe's interface into the application's expected interface.

---

## When should you use the Adapter Pattern?

Whenever you need to integrate a third-party library, legacy code, or any component with an incompatible interface.

---

## When should you avoid using Adapter?

If you own both classes and can modify them directly.

An adapter would introduce unnecessary complexity.

---

# Practice Exercise

Create support for **PayPal**.

PayPal exposes:

```java
sendMoney(double amount)
```

Create:

```text
PaypalAdapter
```

that implements:

```java
PaymentGateway
```

and internally delegates:

```java
pay(amount)
```

to

```java
sendMoney(amount)
```

---

# Key Takeaways

- Adapter is a **Structural Design Pattern**.
- It converts one interface into another.
- It enables integration with third-party or legacy code.
- It follows the **Open/Closed Principle** by extending behaviour without modifying existing code.
- The client communicates only with the target interface.
- The adapter translates requests to the adaptee.
- Common real-world examples include **JDBC**, **SLF4J**, **Spring MVC**, and **frontend API data transformation**.

---

# Which Spring Boot features use these patterns?
- Adapter: JDBC, SLF4J adapters

---

> ## Interview Tip
>
> A simple way to remember the Adapter Pattern is:
>
> **"Adapter changes the interface, Decorator changes the behaviour."**
>
> If two classes cannot communicate because their method signatures differ, think **Adapter**.