# Internal Flow of Spring Cloud Config Server

Let's understand what actually happens when a microservice starts.

Suppose **Order Service** is starting.

The complete startup flow looks like this:

```text
Order Service Starts
        │
        ▼
Read Local Bootstrap Configuration
        │
        ▼
spring.application.name=order-service
        │
        ▼
spring.config.import=configserver:http://localhost:8888
        │
        ▼
HTTP GET Request
http://localhost:8888/order-service/default
        │
        ▼
Spring Config Server
        │
        ▼
Read Git Repository
        │
        ▼
Find order-service.properties
        │
        ▼
Return Configuration (JSON)
        │
        ▼
Spring Boot Builds Environment
        │
        ▼
Application Starts
```

---

# What Does Each Step Mean?

## Step 1 – Order Service Starts

When the application starts,

Spring Boot first looks for the local bootstrap configuration.

---

## Step 2 – Read Local Bootstrap Configuration

The bootstrap configuration contains only the information required to locate the Config Server.

Example:

```properties
spring.application.name=order-service

spring.config.import=configserver:http://localhost:8888
```

Notice that **no business configuration** is stored here.

Only:

- Application name
- Config Server location

---

## Step 3 – Contact Config Server

Using the values above,

Spring Boot automatically sends an HTTP request.

```http
GET http://localhost:8888/order-service/default
```

Where:

- `order-service` → Application Name
- `default` → Active Profile

---

## Step 4 – Config Server Reads Git

The Config Server receives the request.

It already knows where the Git repository is located.

It searches for:

```text
order-service.properties
```

or

```text
order-service.yml
```

depending on your configuration.

---

## Step 5 – Configuration Is Returned

The Config Server reads the configuration from Git

and returns it as JSON.

Example:

```json
{
  "name": "order-service",
  "profiles": [
    "default"
  ],
  "propertySources": [
    {
      "name": "order-service.properties",
      "source": {
        "server.port": "8081",
        "message": "Hello from Config Server"
      }
    }
  ]
}
```

Spring Boot internally converts this into application properties.

---

## Step 6 – Spring Boot Builds the Environment

Spring Boot now creates its internal **Environment** object.

Every property becomes available through:

- `@Value`
- `@ConfigurationProperties`
- `Environment`

Example:

```java
@Value("${message}")
private String message;
```

The application can now access configuration normally.

---

## Step 7 – Application Starts

Only after the configuration has been loaded

does the application finish starting.

```text
Configuration Loaded
        │
        ▼
Application Ready
```

---

# Important Observation

Notice something very important.

```text
Order Service
      │
      ▼
Config Server
      │
      ▼
Git Repository
```

The **Order Service never talks directly to Git**.

Only the Config Server knows:

- Git URL
- Git credentials
- Repository structure

The microservices know nothing about Git.

---

# Why Is This Architecture Better?

Imagine your company has:

```text
100 Microservices
```

---

## Without Config Server

Every application contains its own configuration.

```text
100 Applications
        │
        ▼
100 Property Files
        │
        ▼
100 Deployments
```

Changing one configuration means updating every affected service.

---

## With Config Server

Everything becomes centralised.

```text
Git Repository
        │
        ▼
Spring Config Server
        │
        ▼
100 Microservices
```

One configuration change.

Every service retrieves the updated configuration from the same source.

---

# Interview Question

## Q. Why don't microservices connect directly to Git?

This is a very common Spring Cloud interview question.

### Answer

Because the Config Server provides several advantages.

- Git credentials remain inside the Config Server.
- Git implementation details are hidden.
- Centralised security.
- Centralised caching.
- Centralised auditing.
- Easier migration to HashiCorp Vault, AWS Secrets Manager, Azure Key Vault, or similar secret-management solutions.

The microservices simply consume configuration.

They never need direct access to Git.

---

# The Next Problem

Suppose your Git repository contains:

```properties
message=Hello from Config Server
```

Later, someone changes it to:

```properties
message=Hello Spring Cloud
```

Question:

> **Does Order Service automatically see the new value?**

**No.**

---

# Why Not?

Spring Boot loads configuration only once,

during application startup.

The sequence is:

```text
Git Repository
        │
        ▼
Config Server
        │
        ▼
Spring Environment
        │
        ▼
Application Memory
```

Once the properties are loaded into memory,

changing the Git repository has **no effect** on the running application.

---

# The Problem

Imagine you're in production.

The CTO says:

> **"Change the logging level to DEBUG immediately."**

Without any refresh mechanism, you must:

```text
Edit Git
      │
      ▼
Restart 40 Microservices
      │
      ▼
Downtime
```

This is not ideal.

---

# The Solution – `@RefreshScope`

Spring Cloud provides one of its most useful annotations:

```java
@RefreshScope
```

This annotation allows certain Spring beans to be **recreated** when configuration changes.

Instead of restarting the entire application,

only the affected beans are refreshed.

---

# How `@RefreshScope` Works

```text
Git Repository
        │
        ▼
Config Server
        │
        ▼
Configuration Updated
        │
        ▼
Refresh Triggered
        │
        ▼
Bean Recreated
        │
        ▼
New Configuration Loaded
        │
        ▼
No Application Restart
```

Only beans annotated with `@RefreshScope` receive the updated values.

The rest of the application continues running normally.

---

# Real Production Example

Suppose your configuration contains:

```properties
logging.level.root=INFO
```

Later, you update Git:

```properties
logging.level.root=DEBUG
```

With `@RefreshScope`:

```text
Edit Git
      │
      ▼
Config Server
      │
      ▼
Refresh Bean
      │
      ▼
Logging Level Changes
      │
      ▼
Application Continues Running
```

No restart required.

---

# End-to-End Configuration Flow

```text
                  Git Repository
                        │
                        ▼
              Spring Config Server
                        │
                        ▼
              Order Service Starts
                        │
                        ▼
         Downloads Configuration
                        │
                        ▼
       Spring Builds Environment
                        │
                        ▼
            Application Starts
                        │
                        ▼
      Configuration Changes in Git
                        │
                        ▼
             Refresh Triggered
                        │
                        ▼
          @RefreshScope Bean Recreated
                        │
                        ▼
          New Values Available Immediately
```

---

# Key Takeaways

| Concept | Explanation |
|----------|-------------|
| **Bootstrap Configuration** | Contains only the application name and Config Server location. |
| **Config Server** | Retrieves configuration from Git and serves it to microservices. |
| **Spring Environment** | Stores all configuration after startup. |
| **Configuration Loading** | Happens only during application startup by default. |
| **`@RefreshScope`** | Recreates Spring beans so they can use updated configuration without restarting the application. |
| **Centralised Configuration** | All services retrieve configuration from a single source. |
| **Git Isolation** | Microservices never need Git credentials or direct Git access. |

---

# Spring Cloud Fundamentals — Completed ✅

Congratulations!

You've now completed the **Spring Cloud Fundamentals** section of your roadmap.

Here's the complete architecture you've built so far.

```text
                    Client
                       │
                       ▼
                 API Gateway
                       │
                       ▼
                 Eureka Server
                       │
            ┌──────────┴──────────┐
            ▼                     ▼
     Order Service         Product Service
            │
            ▼
        OpenFeign
            │
            ▼
    Circuit Breaker
            │
            ▼
           Retry
            │
            ▼
      Config Server
            │
            ▼
       Git Repository
```

This architecture already demonstrates many of the core building blocks used in production microservices.

You've implemented:

- API Gateway
- Service Discovery (Eureka)
- Service-to-Service Communication (OpenFeign)
- Fault Tolerance (Resilience4j Circuit Breaker)
- Retry Mechanism
- Centralised Configuration (Spring Cloud Config Server)

This is already more than what many developers have implemented end-to-end.

---

# What's Next?

Now we move into one of the most important topics in distributed systems:

# Apache Kafka

This is where microservices evolve from **synchronous communication** to **event-driven architecture**.

---

# Current Architecture

Today, your services communicate using REST APIs.

```text
Order Service
      │
      ▼
   REST Call
      │
      ▼
Product Service
```

Order Service sends an HTTP request and waits for a response.

---

# Problems with Synchronous REST Calls

Although REST is simple, it introduces several challenges.

### 1. Blocking Calls

If Product Service is slow,

Order Service must wait.

```text
Order Service
      │
      ▼
Waiting...
      │
      ▼
Product Service
```

The request cannot continue until Product Service responds.

---

### 2. Failure Propagation

If Product Service crashes,

Order Service also fails.

```text
Order Service
      │
      ▼
Product Service ❌ Down
      │
      ▼
Request Failed
```

One failed service affects another.

---

### 3. Tight Coupling

Order Service depends directly on Product Service.

Both services must be available at the same time.

---

### 4. Difficult to Scale

As more services communicate synchronously,

response times increase,

network traffic increases,

and failures become more difficult to manage.

---

# Event-Driven Architecture

Instead of calling another service directly,

a service publishes an **event**.

Other services react to that event whenever they are ready.

Instead of:

```text
Order Service
      │
      ▼
Product Service
```

we have:

```text
Order Service
      │
      ▼
Kafka Topic
      │
      ▼
Product Service
```

No service waits.

No service blocks.

Communication becomes asynchronous.

---

# Companies That Use Event-Driven Architecture

Large-scale systems rely heavily on event-driven messaging.

Examples include:

- Amazon
- Netflix
- Uber
- LinkedIn
- Banks
- Financial Institutions

These companies use technologies such as **Apache Kafka** to process millions of events every day.

---

# Real-World Example

## Today (Synchronous)

A customer clicks:

> **Place Order**

The request flow looks like this:

```text
Browser
      │
      ▼
API Gateway
      │
      ▼
Order Service
      │
      ▼
OpenFeign
      │
      ▼
Inventory Service
      │
      ▼
Payment Service
      │
      ▼
Notification Service
```

This involves several synchronous HTTP calls.

If any service fails,

the entire request may fail.

---

# With Kafka (Asynchronous)

Instead of waiting for every service,

Order Service simply publishes an event.

```text
Browser
      │
      ▼
Order Service
      │
      ▼
Save Order
      │
      ▼
Publish Event
      │
      ▼
Kafka
```

Now each downstream service works independently.

### Inventory Service

```text
Consume Event
      │
      ▼
Update Stock
```

### Payment Service

```text
Consume Event
      │
      ▼
Charge Customer
```

### Notification Service

```text
Consume Event
      │
      ▼
Send Email
```

All of these happen independently.

No service waits for another.

---

# Why Kafka?

Imagine your application processes:

```text
10,000 Orders Per Minute
```

### Using REST

```text
Order Service
      │
      ▼
Wait
      │
      ▼
Inventory
      │
      ▼
Wait
      │
      ▼
Payment
      │
      ▼
Wait
      │
      ▼
Notification
```

Every request blocks until each service responds.

Throughput decreases as traffic grows.

---

### Using Kafka

```text
Order Service
      │
      ▼
Kafka Topic
      │
 ┌────┼──────────────┐
 ▼    ▼              ▼
Inventory       Payment
                    │
                    ▼
               Notification
                    │
                    ▼
               Analytics
```

Each service consumes the event independently.

Everyone works at their own speed.

---

# The Big Picture

One event can trigger many independent consumers.

```text
                    Kafka

          +----------------------+

Order ───►    order-topic
                   │
         ┌─────────┼─────────┐
         ▼         ▼         ▼
   Inventory   Payment   Notification
                              │
                              ▼
                         Analytics
```

A single published event can be processed by multiple services.

The producer does not need to know who consumes it.

---

# Why Is This Powerful?

Suppose tomorrow the business wants to add:

- Fraud Detection
- Recommendation Engine
- Loyalty Points
- Audit Logging

With REST,

Order Service must call each new service.

With Kafka,

those services simply subscribe to the same topic.

No changes are required in Order Service.

This demonstrates **loose coupling**.

---

# Interview Question

## Q. Why Kafka instead of REST?

A strong answer is:

Kafka enables:

- Asynchronous communication
- Loose coupling between services
- High throughput
- Horizontal scalability
- Fault tolerance
- Event replay
- Back-pressure handling
- Independent deployment of services

REST remains useful for request-response scenarios,

while Kafka is ideal for asynchronous event processing.

---

# Kafka Terminology

Over the next few sessions, we'll build and understand each of these concepts.

```text
Producer
      │
      ▼
Topic
      │
      ▼
Partition
      │
      ▼
Broker
      │
      ▼
Consumer
      │
      ▼
Consumer Group
      │
      ▼
Offset
```

By the end,

you'll understand exactly how each component works internally.

---

# What We Will Build

We'll extend the existing microservices project instead of creating isolated examples.

Our final architecture will look like this:

```text
Customer
     │
     ▼
Order Service
     │
     ▼
Kafka
     │
 ┌───┼──────────────┐
 ▼   ▼              ▼
Inventory      Payment     Notification
 Service         Service        Service
```

When a customer places an order,

you'll see events flowing through Kafka.

```text
Order Created
      │
      ▼
Stock Reserved
      │
      ▼
Payment Processed
      │
      ▼
Email Sent
```

Each step is triggered by Kafka events rather than synchronous REST calls.

---

# Roadmap Ahead

Our Kafka journey will cover:

1. Producer
2. Broker
3. Topic
4. Partition
5. Consumer
6. Consumer Group
7. Offset
8. Replication
9. Message Ordering
10. Delivery Guarantees
11. Dead Letter Topics (DLT)
12. Spring Boot + Kafka Integration
13. Kafka in Our Microservices Project

By the end of this section, you'll understand how modern distributed systems use Kafka to build highly scalable, fault-tolerant, and event-driven applications.

---

# Key Takeaways

| Concept | Explanation |
|----------|-------------|
| **Synchronous Communication** | Services wait for each other using REST APIs. |
| **Event-Driven Architecture** | Services communicate by publishing and consuming events. |
| **Apache Kafka** | A distributed event-streaming platform for asynchronous communication. |
| **Loose Coupling** | Producers and consumers are independent of each other. |
| **High Throughput** | Kafka can process massive volumes of events efficiently. |
| **Scalability** | Producers and consumers can scale independently. |
| **Fault Tolerance** | Events remain available even if consumers are temporarily unavailable. |
| **Extensibility** | New consumers can subscribe to existing events without changing producers. |

---
