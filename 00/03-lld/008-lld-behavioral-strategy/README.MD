# Strategy Design Pattern

The **Strategy Design Pattern** is a **Behavioral Design Pattern** that allows you to **encapsulate multiple algorithms or behaviours into separate classes and choose one at runtime**.

Instead of writing large `if-else` or `switch` statements, each algorithm becomes its own strategy class.

This makes the code:

- Cleaner
- Easier to maintain
- Easy to extend
- Open for extension but closed for modification

---

# Why Do We Need the Strategy Pattern?

Imagine an e-commerce checkout.

Initially, you support only Card payments.

Later, the business asks for:

- UPI
- PayPal
- Wallet
- Net Banking
- Crypto

A common implementation looks like this:

```java
if (paymentType.equals("CARD")) {

    // Card Logic

} else if (paymentType.equals("UPI")) {

    // UPI Logic

} else if (paymentType.equals("PAYPAL")) {

    // PayPal Logic

}
```

Next month:

```text
Wallet
```

Then:

```text
Net Banking
```

Then:

```text
Apple Pay
```

Then:

```text
Google Pay
```

Your `Checkout` class keeps growing.

Every new payment method requires modifying existing code.

This violates the **Open/Closed Principle (OCP)**.

---

# Problems with if-else

```text
Checkout

↓

if (CARD)

↓

else if (UPI)

↓

else if (PAYPAL)

↓

else if (WALLET)

↓

else if (CRYPTO)

↓

...
```

Problems:

- Large if-else blocks
- Difficult to maintain
- Hard to test
- High coupling
- Violates OCP
- Higher chance of introducing bugs

---

# Solution — Strategy Pattern

Instead of embedding every payment algorithm inside the checkout,

create a separate class for each payment method.

```text
Checkout

      │

      ▼

PaymentStrategy

      ▲
      │
 ┌────┼──────────┐
 │    │          │
 ▼    ▼          ▼
Card  UPI     PayPal
```

The checkout doesn't know **how** payment happens.

It simply delegates the work to the selected strategy.

---

# Real-World Analogy

Think about Google Maps.

You choose:

- Drive
- Walk
- Bike
- Public Transport

Each uses a completely different routing algorithm.

```text
Google Maps

↓

Route Strategy

↓

Driving

Walking

Cycling

Transit
```

The application remains the same.

Only the routing strategy changes.

---

# Another Everyday Example

Navigation Apps

```text
Destination

↓

Fastest Route

Shortest Route

Toll-Free Route

Scenic Route
```

Each is a different strategy.

---

# Structure

```text
                 Context
                    │
                    ▼
             Strategy Interface
                    ▲
         ┌──────────┼──────────┐
         ▼          ▼          ▼
      Card       UPI       PayPal
```

---

# Components of Strategy Pattern

## 1. Strategy Interface

Defines the common contract.

Example:

```java
pay()
```

---

## 2. Concrete Strategies

Each class implements one algorithm.

Example:

- CardPayment
- UpiPayment
- PaypalPayment

---

## 3. Context

Uses the selected strategy.

Example:

```text
Checkout
```

---

## 4. Client

Chooses which strategy should be used.

---

# Java Implementation

## Step 1 — Strategy Interface

```java
interface PaymentStrategy {

    void pay(double amount);

}
```

Every payment method must implement this interface.

---

## Step 2 — Concrete Strategies

### Card Payment

```java
class CardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {

        System.out.println("Paid ₹" + amount + " using Card");

    }

}
```

---

### UPI Payment

```java
class UpiPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {

        System.out.println("Paid ₹" + amount + " using UPI");

    }

}
```

---

### PayPal Payment

```java
class PaypalPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {

        System.out.println("Paid ₹" + amount + " using PayPal");

    }

}
```

Each strategy contains only its own payment logic.

---

## Step 3 — Context

```java
class Checkout {

    private PaymentStrategy paymentStrategy;

    public Checkout(PaymentStrategy paymentStrategy) {

        this.paymentStrategy = paymentStrategy;

    }

    public void processPayment(double amount) {

        paymentStrategy.pay(amount);

    }

}
```

Notice that `Checkout` never knows whether it's using Card, UPI, or PayPal.

It only communicates with the `PaymentStrategy` interface.

---

## Step 4 — Client

```java
public class Main {

    public static void main(String[] args) {

        Checkout checkout = new Checkout(new UpiPayment());
        checkout.processPayment(999);

        checkout = new Checkout(new CardPayment());
        checkout.processPayment(4999);

    }

}
```

---

## Output

```text
Paid ₹999.0 using UPI

Paid ₹4999.0 using Card
```

---

# What Happens Internally?

```text
Client

↓

Checkout

↓

PaymentStrategy

↓

Selected Strategy

↓

Payment Executed
```

For UPI:

```text
Checkout

↓

UpiPayment

↓

pay(999)

↓

UPI Transaction
```

For Card:

```text
Checkout

↓

CardPayment

↓

pay(4999)

↓

Card Transaction
```

---

# UML Diagram

```text
                 +--------------------------+
                 |    PaymentStrategy       |
                 +--------------------------+
                 | + pay(amount)            |
                 +------------▲-------------+
                              │
          ┌───────────────────┼────────────────────┐
          ▼                   ▼                    ▼
+----------------+   +----------------+   +------------------+
| CardPayment    |   | UpiPayment     |   | PaypalPayment    |
+----------------+   +----------------+   +------------------+

                              ▲
                              │
                     uses
                              │
                 +--------------------------+
                 |        Checkout          |
                 +--------------------------+
                 | - paymentStrategy        |
                 | + processPayment()       |
                 +--------------------------+
```

---

# Before vs After Strategy

## Without Strategy

```text
Checkout

↓

if(Card)

↓

else if(UPI)

↓

else if(PayPal)

↓

else if(Wallet)

↓

else if(Crypto)
```

Every new payment type modifies the checkout class.

---

## With Strategy

```text
Checkout

↓

PaymentStrategy

↓

Card

UPI

PayPal

Wallet

Crypto
```

Need a new payment method?

Simply create another strategy class.

No existing code changes.

---

# Why Is Strategy Better?

Instead of modifying existing code,

you simply add a new strategy.

Example:

```text
Existing

Card

UPI

PayPal
```

Need Crypto?

Create:

```java
CryptoPayment
```

Done.

No modifications to `Checkout`.

This follows the **Open/Closed Principle**.

---

# Real Production Examples

## 1. Spring Security

```java
PasswordEncoder
```

Implementations:

- BCryptPasswordEncoder
- Pbkdf2PasswordEncoder
- SCryptPasswordEncoder
- NoOpPasswordEncoder

Spring chooses one strategy at runtime.

---

## 2. Java Comparator

```java
Collections.sort(list, comparator);
```

Different comparators provide different sorting algorithms.

Each comparator is a strategy.

---

## 3. Spring Authentication

Authentication providers:

- Database
- LDAP
- OAuth2
- JWT

Each authentication mechanism is implemented as a separate strategy.

---

## 4. React

Sorting products:

```javascript
products.sort(priceComparator);

products.sort(nameComparator);
```

Each comparator implements a different sorting strategy.

---

## 5. Payment Gateways

```text
Checkout

↓

Razorpay

Stripe

PayPal

UPI

Wallet
```

Exactly the same pattern.

---

# Advantages

- Eliminates large `if-else` and `switch` blocks.
- Follows the Open/Closed Principle.
- Easy to add new algorithms.
- Promotes loose coupling.
- Each algorithm is independently testable.
- Runtime flexibility.

---

# Disadvantages

- Increases the number of classes.
- The client must choose the appropriate strategy.
- Slightly more complex than a small `if-else` for very simple cases.

---

# When Should You Use Strategy?

Use Strategy when:

- Multiple algorithms solve the same problem.
- Algorithms can change at runtime.
- You want to remove large conditional logic.
- Different business rules need to be swapped easily.

---

# When Should You Avoid Strategy?

Avoid Strategy when:

- There is only one algorithm.
- Behaviour never changes.
- Adding separate classes would overcomplicate a very simple solution.

---

# Strategy vs State

A common interview question.

| Strategy | State |
|----------|-------|
| Client chooses the algorithm | Object changes behaviour based on its internal state |
| Focuses on interchangeable algorithms | Focuses on state transitions |
| Behaviour selected externally | Behaviour changes internally |
| Example: Payment methods | Example: Order status (New → Paid → Shipped) |

---

# Strategy vs Command

| Strategy | Command |
|----------|----------|
| Represents an algorithm | Represents an action or request |
| Chooses *how* to perform work | Encapsulates *what* work to execute |
| Focuses on behaviour selection | Focuses on request execution |

---

# Interview Questions

## What problem does Strategy solve?

It eliminates large conditional statements by moving each algorithm into its own class.

---

## Why is Strategy better than if-else?

Because adding a new algorithm does not require modifying existing code.

Only a new strategy class is created.

---

## Does Strategy follow the Open/Closed Principle?

Yes.

Existing classes remain unchanged.

New behaviour is added through new strategy implementations.

---

## Who decides which strategy is used?

The client (or dependency injection framework like Spring).

---

## Can the strategy change at runtime?

Yes.

That's one of the biggest advantages of the Strategy Pattern.

---

# Practice Exercise

Implement a **Shipping Cost Calculator**.

Create strategies:

- StandardShipping
- ExpressShipping
- OvernightShipping

Each should calculate shipping differently.

Create:

```text
ShippingCalculator
```

which accepts any shipping strategy.

Switch strategies without changing the calculator.

---

# Key Takeaways

- Strategy is a **Behavioral Design Pattern**.
- It encapsulates algorithms into separate classes.
- It removes large `if-else` and `switch` statements.
- It promotes **composition over inheritance**.
- It follows the **Open/Closed Principle**.
- Algorithms can be changed at runtime.
- Common examples include **Spring PasswordEncoder**, **Comparator**, **Spring Security**, **React sorting functions**, and **payment gateway selection**.

---

# Which Spring Boot features use these patterns?
- Strategy: PasswordEncoder, Comparator, authentication providers

---

> ## Interview Tip
>
> Remember this simple rule:
>
> **"If you're choosing between multiple ways of doing the same task, think Strategy."**
>
> Examples:
>
> - Payment methods
> - Sorting algorithms
> - Authentication mechanisms
> - Shipping calculations
> - Compression algorithms
>
> All are classic use cases for the **Strategy Design Pattern**.