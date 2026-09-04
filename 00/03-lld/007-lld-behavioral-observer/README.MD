# Observer Design Pattern

The **Observer Design Pattern** is a **Behavioral Design Pattern** that defines a **one-to-many relationship** between objects.

When one object (called the **Subject**) changes its state, **all dependent objects (Observers)** are automatically notified and updated.

This pattern is one of the most widely used design patterns in modern software development, especially in **event-driven architectures**.

---

# Why Do We Need the Observer Pattern?

Imagine Amazon is selling an iPhone.

Initially:

```text
iPhone

Status : Out of Stock
```

Thousands of customers are waiting for it.

Should Amazon manually send emails to every customer when stock becomes available?

❌ No.

Instead, customers subscribe to stock updates.

Whenever the stock changes:

```text
Out of Stock

↓

In Stock

↓

Everyone receives a notification
```

This is exactly what the **Observer Pattern** solves.

---

# Real-World Analogy

Think about a YouTube channel.

```text
YouTube Channel

↓

Subscriber 1

Subscriber 2

Subscriber 3

Subscriber 4
```

Whenever a new video is uploaded:

```text
Channel uploads video

↓

All subscribers receive notification
```

The channel doesn't know **who** the subscribers are or **how** they receive notifications.

It simply broadcasts an event.

---

# Another Everyday Example

Weather App

```text
Weather Station

↓

Phone

Tablet

Smart Watch

Laptop
```

When temperature changes,

all devices automatically receive the latest update.

---

# What Problem Does Observer Solve?

Without Observer:

```text
Product

↓

Customer A

Customer B

Customer C

Customer D
```

The product needs to know every customer individually.

This creates **tight coupling**.

---

With Observer:

```text
Customers Subscribe

↓

Product Stores Observers

↓

Stock Changes

↓

Notify Everyone
```

The product doesn't care what each observer does.

It simply calls:

```java
update()
```

---

# Structure

```text
              Subject
                 │
     ┌───────────┼───────────┐
     ▼           ▼           ▼
 Observer1   Observer2   Observer3
```

The subject maintains a list of observers and notifies them whenever its state changes.

---

# Components of the Observer Pattern

## 1. Subject

Responsible for:

- Registering observers
- Removing observers
- Notifying observers

---

## 2. Observer

Defines the method that every subscriber must implement.

Typically:

```java
update()
```

---

## 3. Concrete Subject

Maintains the application's state and triggers notifications.

Example:

```text
Amazon Product

Stock Price

Weather Station

News Channel
```

---

## 4. Concrete Observer

Receives notifications and performs some action.

Example:

```text
Customer

Mobile App

Email Service

SMS Service
```

---

# Java Implementation

## Step 1 — Observer Interface

```java
interface Observer {

    void update(String message);

}
```

Every observer must implement the `update()` method.

---

## Step 2 — Concrete Observer

```java
class Customer implements Observer {

    private String name;

    Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {

        System.out.println(name + " received : " + message);

    }

}
```

Each customer reacts differently when notified.

---

## Step 3 — Subject Interface

```java
interface Subject {

    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObservers();

}
```

The subject provides methods to manage subscribers.

---

## Step 4 — Concrete Subject

```java
import java.util.*;

class Product implements Subject {

    private List<Observer> observers = new ArrayList<>();

    private String productName;

    Product(String productName) {

        this.productName = productName;

    }

    @Override
    public void subscribe(Observer observer) {

        observers.add(observer);

    }

    @Override
    public void unsubscribe(Observer observer) {

        observers.remove(observer);

    }

    @Override
    public void notifyObservers() {

        for (Observer observer : observers) {

            observer.update(productName + " is available!");

        }

    }

}
```

The product maintains a list of observers and notifies each one whenever necessary.

---

## Step 5 — Client

```java
public class Main {

    public static void main(String[] args) {

        Product iphone = new Product("iPhone");

        iphone.subscribe(new Customer("Anurag"));
        iphone.subscribe(new Customer("Rahul"));

        iphone.notifyObservers();

    }

}
```

---

## Output

```text
Anurag received : iPhone is available!

Rahul received : iPhone is available!
```

---

# What Happens Internally?

```text
Customer A subscribes

↓

Customer B subscribes

↓

Product stores observers

↓

Stock becomes available

↓

notifyObservers()

↓

Customer A.update()

↓

Customer B.update()
```

Every registered observer receives the notification automatically.

---

# UML Diagram

```text
                    +----------------------+
                    |       Subject        |
                    +----------------------+
                    | + subscribe()        |
                    | + unsubscribe()      |
                    | + notifyObservers()  |
                    +----------▲-----------+
                               │
                         implements
                               │
                    +----------------------+
                    |       Product        |
                    +----------------------+
                    | - observers          |
                    | - productName        |
                    +----------│-----------+
                               │
                 notifies      │
                               ▼
                    +----------------------+
                    |      Observer        |
                    +----------------------+
                    | + update(message)    |
                    +----------▲-----------+
                               │
                         implements
                               │
                    +----------------------+
                    |      Customer        |
                    +----------------------+
```

---

# Before vs After Observer

## Without Observer

```text
Product

↓

Customer A

Customer B

Customer C

Customer D

↓

Product directly calls every customer
```

Tightly coupled.

---

## With Observer

```text
Customers Subscribe

↓

Product

↓

notifyObservers()

↓

All customers receive update()
```

Loosely coupled and easily extensible.

---

# JavaScript Example (You've Already Used It!)

If you've worked with JavaScript, you've already used the Observer Pattern.

```javascript
button.addEventListener("click", function () {

    console.log("Button Clicked");

});
```

Here:

```text
Button

↓

Subject
```

and

```text
Event Listener

↓

Observer
```

Whenever the button is clicked,

every registered listener is automatically notified.

---

# React Example

```javascript
useEffect(() => {

    console.log("State Changed");

}, [count]);
```

Whenever `count` changes,

React automatically invokes the subscribed callback.

This follows the Observer concept.

---

# Spring Boot Examples

The Observer Pattern is everywhere in Spring.

### Application Events

```java
ApplicationEventPublisher
```

publishes events.

```java
@EventListener
```

subscribes to them.

---

### Kafka

Producer

↓

Kafka Topic

↓

Multiple Consumers

Each consumer reacts independently.

---

### RabbitMQ

Publisher

↓

Exchange / Queue

↓

Consumers

---

### WebSocket

Server broadcasts messages.

Every connected client receives the update.

---

### Spring Security

Authentication success and failure events are internally handled using event listeners.

---

# Real Production Examples

- Stock market notifications
- Amazon "Back in Stock" alerts
- YouTube subscriptions
- Email notifications
- SMS alerts
- Push notifications
- Chat applications
- Live sports score updates
- News applications
- Real-time dashboards
- Microservice event handling

---

# Advantages

- Promotes **loose coupling** between sender and receivers.
- New observers can be added without modifying existing code.
- Supports the **Open/Closed Principle**.
- Excellent for event-driven systems.
- Easy to broadcast updates to multiple subscribers.
- Encourages highly scalable architectures.

---

# Disadvantages

- Notification order is usually not guaranteed.
- Too many observers can impact performance.
- Debugging event flows may become difficult.
- Circular notifications can occur if not designed carefully.

---

# When Should You Use Observer?

Use Observer when:

- One object changes state and many others must react.
- Building event-driven applications.
- Implementing publish-subscribe systems.
- Broadcasting updates to multiple listeners.

---

# When Should You Avoid Observer?

Avoid Observer when:

- Only one object needs the information.
- Communication is always one-to-one.
- Event notifications introduce unnecessary complexity.

---

# Observer vs Publisher-Subscriber (Pub/Sub)

This is a common interview discussion.

| Observer | Publisher-Subscriber |
|----------|----------------------|
| Subject directly knows its observers | Publisher doesn't know subscribers |
| Usually in-memory | Often distributed |
| Direct object references | Uses a message broker |
| Same application | Cross-application communication |
| Example: Java listeners | Example: Kafka, RabbitMQ |

> **Note:** Pub/Sub is an architectural pattern inspired by the Observer Pattern but implemented using message brokers.

---

# Interview Questions

## What problem does the Observer Pattern solve?

It allows one object to notify multiple dependent objects automatically whenever its state changes.

---

## Why is it called one-to-many?

Because a single subject can have multiple observers.

```text
Subject

↓

Observer 1

Observer 2

Observer 3
```

---

## Why is Observer loosely coupled?

The subject only knows that observers implement the `Observer` interface.

It doesn't know their concrete implementations.

---

## What is the difference between Observer and Pub/Sub?

Observer typically works within the same application using object references.

Pub/Sub uses an intermediary (like Kafka or RabbitMQ), allowing publishers and subscribers to be completely decoupled and even run on different machines.

---

## Can observers unsubscribe?

Yes.

The subject exposes an `unsubscribe()` method to stop receiving future notifications.

---

# Practice Exercise

Build a **Stock Price Notification System**.

Create:

- `Stock` (Subject)
- `MobileApp` (Observer)
- `EmailService` (Observer)
- `SMSService` (Observer)

Whenever the stock price changes,

all registered observers should automatically receive the latest price.

---

# Key Takeaways

- Observer is a **Behavioral Design Pattern**.
- It establishes a **one-to-many relationship**.
- Observers subscribe to a subject.
- The subject notifies all observers whenever its state changes.
- It promotes **loose coupling** and follows the **Open/Closed Principle**.
- It is the foundation of **event-driven programming**.
- Common examples include **JavaScript event listeners**, **Spring Application Events**, **Kafka consumers**, **RabbitMQ**, **WebSockets**, and **React state updates**.

---

# Which Spring Boot features use these patterns?
- Observer: @EventListener, ApplicationEventPublisher

---

> ## Interview Tip
>
> The easiest way to remember the Observer Pattern is:
>
> **"One publisher, many subscribers."**
>
> If one object changes and many others need to react automatically, think **Observer Pattern**.
```