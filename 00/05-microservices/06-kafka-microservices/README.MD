# Apache Kafka — Roadmap Summary

Congratulations! 🎉

You've now completed the **Kafka Fundamentals** section of your roadmap. :contentReference[oaicite:0]{index=0}

By this point, you understand not only **how Kafka works**, but also **why it exists** and **how it solves real-world distributed system problems**.

---

# Spring Cloud Fundamentals — Completed

You have successfully built the following Spring Cloud components:

- ✅ API Gateway
- ✅ Eureka Service Registry
- ✅ OpenFeign
- ✅ Resilience4j Circuit Breaker
- ✅ Retry Mechanism
- ✅ Spring Cloud Config Server
- ✅ Centralized Configuration
- ✅ Dynamic Configuration using `@RefreshScope`

---

# Kafka Fundamentals — Completed

You now understand:

- ✅ Why Kafka was invented
- ✅ REST vs Event-Driven Architecture
- ✅ Producer
- ✅ Broker
- ✅ Topic
- ✅ Partition
- ✅ Why Partitions exist
- ✅ Ordering Guarantees
- ✅ Replication
- ✅ Leader & Followers
- ✅ Acknowledgements (`acks=0`, `acks=1`, `acks=all`)
- ✅ Consumer
- ✅ Consumer Groups
- ✅ Rebalancing
- ✅ Offsets
- ✅ Offset Commits
- ✅ Delivery Guarantees
  - At Most Once
  - At Least Once
  - Exactly Once
- ✅ When to use REST vs Kafka

---

# Architecture Built So Far

```text
                           Client
                              │
                              ▼
                        API Gateway
                              │
                              ▼
                      Eureka Registry
                              │
               ┌──────────────┴──────────────┐
               ▼                             ▼
        Order Service                 Product Service
               │
               ▼
         OpenFeign Client
               │
               ▼
      Circuit Breaker + Retry
               │
               ▼
       Spring Config Server
               │
               ▼
          Git Repository


              ─────────────────────────────


                 Event-Driven Layer

                  Order Service
                        │
                        ▼
                 Kafka Producer
                        │
                        ▼
                 order-created Topic
                        │
        ┌───────────────┼───────────────┐
        ▼               ▼               ▼
 Inventory Group   Payment Group   Notification Group
        │               │               │
        ▼               ▼               ▼
 Inventory         Payment        Email Service
```

---

# The Mental Model

Whenever you're designing a microservice, ask yourself one simple question:

## Does the caller need an immediate response?

### ✅ YES → Use REST (OpenFeign)

Example:

```text
Order Service
      │
      ▼
GET Product Details
      │
      ▼
Product Service
```

The Order Service **cannot continue** until it receives the product information.

REST is the correct choice.

---

### ❌ NO → Use Kafka

Example:

```text
Order Created
      │
      ▼
Kafka
      │
 ┌────┼──────────────┐
 ▼    ▼              ▼
Inventory      Payment      Email
```

The producer simply publishes the event and continues.

Each consumer processes the event independently.

---

# Think Like a Senior Engineer

Instead of asking:

> **"Should I use Kafka?"**

Ask:

> **"Is this a Command or an Event?"**

---

## Command

A command expects an immediate response.

Examples:

```text
Create Order

Get Product Details

Update User

Cancel Order
```

➡ **Use REST**

---

## Event

An event represents something that has already happened.

Examples:

```text
Order Created

Payment Completed

User Registered

Stock Updated

Invoice Generated

Email Sent
```

➡ **Use Kafka**

---

# REST vs Kafka

| REST | Kafka |
|------|-------|
| Request / Response | Event Streaming |
| Synchronous | Asynchronous |
| Tight Coupling | Loose Coupling |
| Caller waits | Producer continues immediately |
| One-to-One | One-to-Many |
| Best for CRUD operations | Best for Events |

---

# When Should You Use REST?

Use REST when:

- A response is required immediately.
- Business logic cannot continue without the result.
- CRUD operations are being performed.
- Client expects synchronous communication.

Example:

```text
Order Service
      │
      ▼
GET /products/101
      │
      ▼
Product Service
      │
      ▼
Product Details
```

---

# When Should You Use Kafka?

Use Kafka when:

- Something has already happened.
- Multiple services should react independently.
- High scalability is required.
- Loose coupling is important.
- Background processing is acceptable.

Example:

```text
Order Created
      │
      ▼
Kafka
      │
 ┌────┼───────────────┐
 ▼    ▼               ▼
Inventory     Payment     Notification
```

---

# Event Lifecycle

```text
Customer Places Order
        │
        ▼
Order Service (Producer)
        │
        ▼
Kafka Topic (order-created)
        │
        ▼
Partition
        │
        ▼
Leader Broker
        │
        ▼
Followers Replicate
        │
        ▼
Consumer Group
        │
        ▼
Consumer Reads Message
        │
        ▼
Business Logic Executes
        │
        ▼
Database Updated
        │
        ▼
Offset Committed
```

---

# Kafka Components You Understand

```text
Producer
    │
    ▼
Broker
    │
    ▼
Topic
    │
    ▼
Partition
    │
    ▼
Replication
    │
    ▼
Leader / Followers
    │
    ▼
Consumer
    │
    ▼
Consumer Group
    │
    ▼
Offset
    │
    ▼
Offset Commit
```

---

# Current Learning Journey

```text
Java Core
      │
      ▼
Spring Framework
      │
      ▼
Spring Boot
      │
      ▼
REST APIs
      │
      ▼
Microservices
      │
      ▼
Spring Cloud
      │
      ▼
Resilience
      │
      ▼
Configuration Management
      │
      ▼
Apache Kafka
      │
      ▼
Event-Driven Architecture
      │
      ▼
Next → Production Kafka
```

---

# What's Next?

Now that the concepts are clear, we'll move into hands-on implementation.

## Phase 1 — Kafka Installation

- Install Apache Kafka
- KRaft Mode (No ZooKeeper)
- Understand Folder Structure
- Start Kafka Broker
- Create Topics
- Kafka CLI Commands

---

## Phase 2 — Spring Boot + Kafka

- Spring Boot Kafka Producer
- Spring Boot Kafka Consumer
- KafkaTemplate
- `@KafkaListener`
- JSON Serialization
- JSON Deserialization

---

## Phase 3 — Extend Our Microservices

Current:

```text
Order Service
      │
      ▼
Feign
      │
      ▼
Inventory Service
```

Future:

```text
Order Service
      │
      ▼
Kafka
      │
 ┌────┼──────────────┐
 ▼    ▼              ▼
Inventory      Payment      Notification
```

---

## Phase 4 — Production Kafka

We'll cover:

- Multiple Partitions
- Consumer Groups
- Dead Letter Topics (DLT)
- Retry Topics
- Idempotent Consumers
- Transactions
- Exactly-Once Processing
- Schema Registry (Avro)
- Kafka UI
- Performance Tuning

---

# Final Key Takeaways

- REST is best for synchronous request-response communication.
- Kafka is best for asynchronous event-driven communication.
- Producers publish events, not requests.
- Consumers process events independently.
- Topics organize related events.
- Partitions provide scalability and parallelism.
- Replication provides fault tolerance.
- Consumer Groups provide horizontal scaling.
- Offsets track consumer progress.
- Offset commits provide reliable message processing.
- Kafka guarantees ordering only within a single partition.
- Modern microservice architectures commonly use **both REST and Kafka**, each for the scenarios where it fits best.

---

# Apache Kafka — Producing and Consuming Messages Manually

Before integrating Kafka with Spring Boot, it's important to understand **what Kafka is actually doing behind the scenes**. :contentReference[oaicite:0]{index=0}

Once you understand these concepts, the Spring Boot code becomes very easy to follow.

---

# Life Before Kafka

Suppose a customer places an order.

Without Kafka, the services communicate synchronously.

```text
Customer
    │
    ▼
Order Service
    │
    ▼
Product Service
    │
    ▼
Inventory Service
    │
    ▼
Notification Service
    │
    ▼
Analytics Service
```

Every service waits for the previous service to finish.

This increases response time and tightly couples the services.

---

# Life With Kafka

Instead of directly calling every service,

Order Service simply publishes an event.

```text
Customer
    │
    ▼
Order Service
    │
    ▼
Kafka
    │
 ┌──┼──────────────┬──────────────┐
 ▼  ▼              ▼              ▼
Inventory     Notification    Analytics
                               │
                               ▼
                           Payment
```

Order Service finishes immediately after publishing the event.

Each consumer processes the event independently.

This is called **Event-Driven Architecture**.

---

# Producer vs Consumer

These are the two most important Kafka terms.

## Producer

A **Producer** writes data into Kafka.

```text
Order Service
      │
      ▼
   Producer
      │
      ▼
    Kafka
```

Example:

- Order Service
- Payment Service
- User Service

Any application that **publishes messages** is a Producer.

---

## Consumer

A **Consumer** reads data from Kafka.

```text
Kafka
   │
   ▼
Consumer
   │
   ▼
Notification Service
```

Examples:

- Inventory Service
- Payment Service
- Notification Service
- Analytics Service

Any application that **receives messages** is a Consumer.

---

# Kafka Is a Giant Commit Log

Internally, Kafka behaves like a giant append-only log file.

Imagine a notebook.

```text
Offset 0 → Order 101

Offset 1 → Order 102

Offset 2 → Order 103

Offset 3 → Order 104
```

Every new message is written **at the end**.

Kafka continues appending messages until the topic's retention policy removes older records.

---

# Why Is Kafka So Fast?

Traditional databases often perform operations like:

```text
Read
   │
   ▼
Modify
   │
   ▼
Write
```

This may involve random disk access.

Kafka follows a much simpler approach.

```text
Append
   │
   ▼
Done
```

Appending data sequentially to the end of a log file minimizes disk movement and achieves extremely high throughput.

---

# Interview Questions

## Why is Kafka so fast?

Kafka is fast because it:

- Writes data sequentially by appending to a commit log
- Avoids random disk writes
- Batches requests efficiently
- Uses the operating system's page cache effectively

---

## What does `--from-beginning` do?

It instructs a consumer to read **all available retained messages** from the earliest offset instead of consuming only new messages.

---

## Does Kafka delete messages after a consumer reads them?

No.

Consumers only advance their offsets.

Messages remain in Kafka until the configured retention policy expires or they are otherwise removed.

---

# How Does Kafka Choose a Partition?

Suppose a producer only sends:

```text
Order Created
```

How does Kafka know which partition should store it?

Kafka solves this using **Message Keys**.

Instead of sending only a value,

we send:

```text
Key   = Customer1001

Value = Order Created
```

Kafka hashes the key.

```text
hash(Customer1001)
        │
        ▼
   Partition 2
```

Every future message with the same key is routed to the same partition.

---

# Why Are Message Keys Important?

Suppose Customer A performs these actions.

```text
Create Order
      │
      ▼
Pay
      │
      ▼
Ship
      │
      ▼
Deliver
```

Kafka stores them like this:

```text
Partition 0

Offset 0 → Create

Offset 1 → Pay

Offset 2 → Ship

Offset 3 → Deliver
```

The order is preserved exactly as the business expects.

---

# Kafka's Golden Rule

Kafka guarantees ordering:

```text
✅ Within a Partition

❌ Across Partitions
```

This is one of Kafka's most important interview concepts.

---

# Frequently Asked Questions

## Why do we use Message Keys?

To ensure that related events are routed to the same partition so Kafka can preserve their ordering.

---

## What happens if no key is supplied?

Kafka uses its default partitioning strategy to distribute records across partitions, aiming for balanced load.

Ordering for related events is **not guaranteed**.

---

## Is ordering guaranteed across partitions?

No.

Kafka guarantees ordering **only within a single partition**.

---

## Can different keys map to the same partition?

Yes.

Different keys may hash to the same partition, especially when the topic has a limited number of partitions.

---

## Does Kafka guarantee one partition per key?

No.

Kafka guarantees that the **same key consistently maps to the same partition** (unless the partition count changes).

Multiple different keys can still share the same partition.

---

# What Is `bootstrap-servers`?

This is one of the most misunderstood Kafka properties.

Many beginners think it is:

> "The server that stores all Kafka messages."

It is not.

It is simply **the first broker your application contacts**.

```text
Spring Boot
      │
      ▼
localhost:9092
      │
      ▼
Kafka Broker
```

Once connected,

Kafka returns metadata about the cluster.

Example:

```text
Broker 1

Broker 2

Broker 3
```

Connecting to **any one broker** is enough.

The client learns about the rest of the cluster automatically.

---

# What Is Serialization?

Suppose we have a Java object.

```java
OrderCreatedEvent event =
        new OrderCreatedEvent(101, 5, 2);
```

Can Kafka store Java objects?

**No.**

Kafka stores only **bytes**.

Before sending the message,

Spring Boot must serialize the object.

```text
Java Object
      │
      ▼
Serializer
      │
      ▼
JSON / Bytes
      │
      ▼
Kafka Broker
```

---

# Without Serialization

Imagine Kafka receives:

```text
OrderCreatedEvent
```

Kafka doesn't understand:

- Java classes
- Constructors
- Integer objects
- Java methods

Kafka understands only bytes.

```text
010101010101...
```

Therefore every Java object must first be converted into bytes.

---

# Default Spring Boot Behaviour

By default, Spring Boot assumes:

```java
KafkaTemplate<String, String>
```

This works:

```java
kafkaTemplate.send(
    "order-created",
    "101",
    "Order Created"
);
```

Because String serialization is already configured.

However, this fails:

```java
kafkaTemplate.send(
    "order-created",
    "101",
    event
);
```

unless Spring knows how to serialize `OrderCreatedEvent`.

---

# Solution — `JsonSerializer`

Spring Boot already provides a JSON serializer.

We simply configure Spring to convert Java objects into JSON before publishing.

---

# Why `StringSerializer`?

Our key is:

```text
"101"
```

which is a String.

Therefore Spring uses:

```text
StringSerializer
```

---

# Why `JsonSerializer`?

Our value is a Java object.

```java
OrderCreatedEvent
```

Spring converts it into JSON.

```json
{
  "orderId": 101,
  "productId": 5,
  "quantity": 2
}
```

before sending it to Kafka.

---

# Internal Flow

## Without Spring Boot

```text
Java Object
      │
      ▼
Write JSON Manually
      │
      ▼
Convert to Bytes
      │
      ▼
Open Socket
      │
      ▼
Kafka
```

---

## With Spring Boot

```text
Java Object
      │
      ▼
JsonSerializer
      │
      ▼
Bytes
      │
      ▼
Kafka
```

A few configuration properties replace dozens of lines of manual serialization code.

---

# What Does Kafka Actually Store?

Suppose we publish:

```java
new OrderCreatedEvent(
    101,
    5,
    2
);
```

Kafka stores something equivalent to:

```json
{
  "orderId": 101,
  "productId": 5,
  "quantity": 2
}
```

Kafka never stores Java objects.

It stores only serialized bytes.

---

# Why JSON?

JSON is language-independent.

The same event can be consumed by applications written in:

- Java
- Python
- Node.js
- Go
- C#
- Rust

If Kafka stored Java objects directly,

only Java applications could read them.

JSON enables true language-independent microservices.

---

# Interview Question

## Why do we use `JsonSerializer`?

Because Kafka stores bytes, not Java objects.

`JsonSerializer` converts Java objects into JSON bytes before publishing, allowing applications written in different programming languages to consume the same event.

---

# Do We Need a Kafka Configuration Class?

Many older tutorials create a class like:

```java
@Configuration
public class KafkaProducerConfig {
    ...
}
```

For most Spring Boot 3.x applications,

**No.**

Simply configure:

```properties
spring.kafka.bootstrap-servers=localhost:9092

spring.kafka.producer.key-serializer=...

spring.kafka.producer.value-serializer=...
```

Spring Boot automatically creates:

- ProducerFactory
- KafkaTemplate

No additional configuration class is required.

---

# When Do We Need a Custom Kafka Configuration?

Create one only for advanced scenarios such as:

- Multiple Kafka clusters
- Custom retries
- Compression
- Transactions
- Custom partitioners
- SSL / SASL security

For most applications, Spring Boot's auto-configuration is sufficient.

---

# Publishing Events from Order Service

## Current Flow

```text
Client
   │
   ▼
POST /orders
   │
   ▼
OrderController
   │
   ▼
OrderService
   │
   ▼
Save Order in Database
   │
   ▼
Return Response
```

---

## Desired Flow

```text
Client
   │
   ▼
POST /orders
   │
   ▼
OrderController
   │
   ▼
OrderService
   │
   ├────────► Save Order
   │
   └────────► Publish Event
                   │
                   ▼
              Kafka Topic
```

Notice that the client has no idea Kafka is involved.

Kafka is completely hidden behind the service layer.

---

# Why Publish After Saving?

A common beginner question is:

> **Why not publish first?**

Imagine this sequence:

```text
Publish Event
      │
      ▼
Database Save Fails
```

Kafka now contains:

```text
Order Created
```

But the database contains:

```text
No Order
```

The system becomes inconsistent.

---

# Correct Flow

Always follow this sequence.

```text
Save Order
      │
      ▼
Database Commit Successful
      │
      ▼
Publish Kafka Event
```

Only after the database operation succeeds should the event be published.

---

# What's Next?

This approach still has one small reliability gap.

Suppose:

```text
Database Save ✔

↓

Application Crashes

↓

Kafka Event Never Published
```

The order exists,

but no downstream service is notified.

Large-scale companies such as Amazon, Uber, and Netflix solve this using the **Transactional Outbox Pattern**, which we'll cover in a later chapter.

---

# Key Takeaways

| Concept | Explanation |
|----------|-------------|
| **Producer** | Publishes messages to Kafka. |
| **Consumer** | Reads messages from Kafka. |
| **Commit Log** | Kafka stores messages by appending them sequentially. |
| **Message Key** | Determines which partition stores the message and preserves ordering for related events. |
| **Ordering Guarantee** | Guaranteed only within a single partition. |
| **bootstrap-servers** | Initial broker used to discover the Kafka cluster. |
| **Serialization** | Converts Java objects into bytes before sending to Kafka. |
| **StringSerializer** | Serializes String keys. |
| **JsonSerializer** | Converts Java objects into JSON bytes. |
| **Publishing Order** | Save data first, then publish the event. |
| **Spring Boot Auto Configuration** | Automatically creates `KafkaTemplate` and `ProducerFactory` for most applications. |

---
