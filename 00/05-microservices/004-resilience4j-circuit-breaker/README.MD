# What happens when Product Service goes down in your application?

Order Service calls Product Service through an OpenFeign client. The call is protected by a Resilience4j Circuit Breaker. When Product Service becomes unavailable, Feign throws an exception, which the Circuit Breaker intercepts. After the configured failure threshold is reached, the circuit transitions from CLOSED to OPEN. While OPEN, no remote calls are attempted, and the fallback method returns a controlled response. After the configured wait duration, the circuit enters HALF_OPEN, allows a limited number of test requests, and if they succeed, it transitions back to CLOSED.

---

# Retry vs Circuit Breaker

Both **Retry** and **Circuit Breaker** are resilience patterns used in microservices.

However, they solve **different problems**.

---

# Retry

A **Retry** mechanism simply tries the same request again after it fails.

It assumes the failure is **temporary**.

For example:

- Temporary network glitch
- Brief timeout
- Service is starting up
- Short-lived connectivity issue

### Example

```text
Request
    │
    ▼
PRODUCT-SERVICE ❌
    │
Retry #1
    │
    ▼
PRODUCT-SERVICE ❌
    │
Retry #2
    │
    ▼
PRODUCT-SERVICE ✅
```

Eventually, the request succeeds.

The user never notices the temporary failure.

---

# Circuit Breaker

A **Circuit Breaker** assumes the service is **continuously failing**.

Instead of repeatedly calling the unhealthy service,

it temporarily stops sending requests.

```text
Request
    │
    ▼
Circuit Breaker
    │
    ▼
Circuit Open?
    │
 ┌──┴──┐
 │ Yes │
 └──┬──┘
    ▼
Immediate Fallback
```

No unnecessary network request is made.

The application responds immediately.

---

# Comparison

| Retry | Circuit Breaker |
|--------|-----------------|
| Calls the service again after a failure. | Stops calling the failing service after repeated failures. |
| Best for temporary failures. | Best for prolonged service outages. |
| Assumes the next attempt may succeed. | Assumes the service is unhealthy. |
| Can increase load if overused. | Reduces load on failing services. |
| Waits before trying again. | Fails fast without waiting. |
| Improves reliability for transient issues. | Prevents cascading failures. |

---

# Real-Life Analogy

### Retry

Imagine calling a friend.

The phone doesn't connect.

You immediately try again.

```
Call
   │
   ▼
Busy
   │
Retry
   │
   ▼
Connected
```

The problem was temporary.

---

### Circuit Breaker

Now imagine your friend's phone is switched off.

Calling 100 times won't help.

Instead, you stop calling for a while.

Later, you try once again.

```
Call
   │
   ▼
Phone Switched Off
   │
   ▼
Stop Calling
   │
Wait 30 Seconds
   │
   ▼
Try Again
```

That's exactly how a Circuit Breaker behaves.

---

# When Should You Use Retry?

Retry is appropriate when failures are expected to be temporary.

Examples:

- Temporary network hiccups
- Short-lived timeouts
- DNS resolution delays
- Service startup delays

Retry gives the service another chance to respond.

---

# When Should You Use Circuit Breaker?

Circuit Breaker is appropriate when failures continue for an extended period.

Examples:

- Product Service is down
- Database server is unavailable
- Third-party payment API is offline
- Dependency is overloaded

Instead of wasting resources,

the Circuit Breaker immediately rejects further requests until the dependency recovers.

---

# Retry + Circuit Breaker Together

In most production systems, these patterns are used together.

The request flow typically looks like this:

```text
Client
    │
    ▼
Retry
    │
    ▼
Still Failing?
    │
    ▼
Circuit Breaker
    │
    ▼
Fallback Response
```

Sequence:

1. Retry handles temporary failures.
2. If failures continue, the Circuit Breaker opens.
3. Further requests fail fast.
4. After a configured wait time, the Circuit Breaker enters the Half-Open state.
5. If the service has recovered, normal traffic resumes.

---

# Real Production Example

Suppose **Order Service** calls **Product Service**.

### Temporary Network Issue

```text
Request
     │
     ▼
Timeout
     │
Retry
     │
     ▼
Success
```

Retry solves the problem.

---

### Product Service Is Down

```text
Request
     │
     ▼
Retry #1 ❌
Retry #2 ❌
Retry #3 ❌
     │
     ▼
Circuit Opens
     │
     ▼
Immediate Fallback
```

Now every new request is rejected immediately until Product Service recovers.

---

# Key Takeaways

| Feature | Retry | Circuit Breaker |
|----------|-------|-----------------|
| Purpose | Retry temporary failures | Stop calling unhealthy services |
| Best For | Transient issues | Long-running outages |
| Behaviour | Calls again | Stops calling |
| Network Calls | More | Fewer |
| System Protection | Low | High |
| Prevents Cascading Failures | ❌ No | ✅ Yes |

---

# Spring Cloud Config Server

## Why Does It Exist?

Imagine you have only **one application**.

```
Order Service
```

Inside its `application.properties`:

```properties
server.port=8081

spring.datasource.url=...

spring.datasource.username=...

spring.datasource.password=...

jwt.secret=...

api.key=...
```

Everything is simple.

Everything is in one place.

---

# Company Starts Growing

Now your application becomes a microservices architecture.

```text
Gateway

Order Service

Product Service

User Service

Payment Service

Inventory Service

Notification Service
```

Every service now has its own configuration file.

```text
Gateway
    application.properties

Order
    application.properties

Product
    application.properties

Payment
    application.properties

Inventory
    application.properties

Notification
    application.properties
```

At first, this still looks manageable.

---

# Problem 1 – Database Password Changes

One day your DBA says:

> **"The database password has changed."**

Now you need to update:

```text
Gateway
Order
Product
Payment
Inventory
Notification
```

Then you must:

- Update every project
- Rebuild every application
- Redeploy every microservice

This quickly becomes painful.

---

# Problem 2 – Logging Configuration Changes

Suppose the company wants more detailed logging.

Current configuration:

```properties
logging.level.root=INFO
```

New configuration:

```properties
logging.level.root=DEBUG
```

Imagine making this change in:

- 10 microservices
- 20 microservices
- 30 microservices

The same configuration must be updated everywhere.

---

# Problem 3 – External API Changes

Suppose your Payment Service URL changes.

Old configuration:

```properties
payment.url=http://payment:8084
```

New configuration:

```properties
payment.url=https://payment.company.com
```

Again,

every microservice that calls the Payment Service must be updated.

---

# The Core Problem

Every service owns its own configuration.

This causes:

- Duplicate configuration
- Manual updates
- Multiple rebuilds
- Multiple deployments
- Increased chance of inconsistent settings

---

# The Solution

Instead of every microservice storing its own configuration,

store all configuration in **one central location**.

```text
                 Git Repository
                        ▲
                        │
                Config Server
          ▲         ▲          ▲
          │         │          │
      Order     Product     Gateway
```

Now every service simply asks:

> **"Config Server, please give me my configuration."**

The Config Server retrieves the configuration and returns it to the requesting service.

---

# Why Git?

Spring Cloud Config Server commonly stores configuration inside a Git repository.

Why?

Because Git already provides:

- Version history
- Rollback
- Audit trail
- Pull Requests
- Branches
- Code Review

Configuration becomes version-controlled just like application code.

This approach is called:

# Configuration as Code

---

# Architecture

```text
                    GitHub

          application.properties

          order-service.properties

          product-service.properties

          api-gateway.properties

                    ▲
                    │
          Spring Config Server
          ▲         ▲         ▲
          │         │         │
      Gateway   Product   Order
```

Every microservice downloads its configuration from the Config Server during startup.

---

# Startup Sequence

When **Order Service** starts:

```text
Order Service
      │
      ▼
Config Server
      │
      ▼
Git Repository
      │
      ▼
order-service.properties
      │
      ▼
Configuration Loaded
      │
      ▼
Application Starts
```

The application does not rely on a local configuration file.

Instead,

it retrieves its configuration from the Config Server.

---

# Advantages

## 1. One Place for Configuration

Instead of managing configuration in:

```text
15 Applications
```

You manage:

```text
1 Git Repository
```

Configuration becomes much easier to maintain.

---

## 2. Version Control

Yesterday:

```text
jwt.secret=ABC123
```

Today:

```text
jwt.secret=XYZ789
```

Git records every change.

You can:

- View history
- Compare versions
- Roll back if necessary

---

## 3. Environment Support

Different environments can have different configuration files.

```text
application-dev.properties

application-qa.properties

application-uat.properties

application-prod.properties
```

Same application.

Different configuration.

No code changes required.

---

## 4. No Rebuild Required

Later we'll learn about:

```java
@RefreshScope
```

Using this annotation,

certain configuration changes can be applied **without rebuilding or restarting** the application.

---

# Real Production Example

Imagine your company has:

```text
50 Microservices
```

Every service requires:

- Database URL
- Redis Host
- Kafka Broker
- JWT Secret
- SMTP Server
- Payment Service URL
- Logging Level

---

## Without Config Server

Every microservice stores its own configuration.

```text
Service 1
    Database URL

Service 2
    Database URL

Service 3
    Database URL

...

Service 50
    Database URL
```

The same configuration is duplicated many times.

---

## With Config Server

Everything is centralised.

```text
One Git Repository
        │
        ▼
Spring Config Server
        │
        ▼
50 Microservices
```

Each service downloads only the configuration it needs.

---

# What We Are Going to Build

Our workspace will look like this:

```text
microservices-workspace

│
├── service-registry
├── api-gateway
├── order-service
├── product-service
└── config-server
```

We'll introduce a brand-new microservice:

```text
config-server
```

Its responsibility is to serve configuration to all other services.

---

# Configuration Repository

We'll also create a separate Git repository dedicated to configuration.

Example:

```text
config-repo

│
├── application.properties
├── api-gateway.properties
├── order-service.properties
└── product-service.properties
```

Notice:

This repository contains:

- Properties files
- Configuration only

It contains:

- No Java code
- No Controllers
- No Services
- No Business Logic

Its only purpose is configuration management.

---

# Life Before Config Server

```text
Order Service
      │
      ▼
Local application.properties
```

Every service maintains its own configuration.

---

# Life After Config Server

```text
Order Service
      │
      ▼
Spring Config Server
      │
      ▼
Git Repository
      │
      ▼
Configuration Returned
```

Configuration is fetched dynamically during startup.

---

# What Happens If Config Server Is Down?

This is a common interview question.

Suppose the Config Server is unavailable.

```text
Order Service
      │
      ▼
Config Server ❌ Down
```

During startup,

Order Service cannot retrieve its configuration.

As a result,

the application may fail to start.

---

# How Production Systems Handle This

Production teams improve resilience by:

- Running multiple Config Server instances behind a Load Balancer
- Caching configuration locally after a successful startup
- Configuring retry mechanisms for temporary Config Server outages

This ensures higher availability.

---

# Interview Questions

## Q1. Why not store configuration inside every microservice?

Because configuration changes would require updating, rebuilding, and redeploying many services.

A central Config Server eliminates duplication and reduces operational effort.

---

## Q2. Why use Git?

Git provides:

- Version Control
- History
- Rollback
- Auditability
- Collaboration through Pull Requests
- Branching
- Code Reviews

It is already a mature and trusted configuration management system.

---

## Q3. What Kind of Configuration Belongs in Config Server?

Examples include:

- Database URLs
- Kafka Brokers
- Redis Hosts
- External Service URLs
- Feature Flags
- Logging Levels
- Environment-specific properties

Sensitive information such as:

- Passwords
- API Keys
- Secrets
- Tokens

should not be stored in plain text.

Instead,

they should be protected using encryption or dedicated secret-management solutions such as HashiCorp Vault, AWS Secrets Manager, Azure Key Vault, or similar services.

---

# End-to-End Flow

```text
                 Microservice Starts
                         │
                         ▼
              Request Configuration
                         │
                         ▼
             Spring Config Server
                         │
                         ▼
                 Git Repository
                         │
                         ▼
            Return Configuration
                         │
                         ▼
             Application Starts
```

---

# Key Takeaways

| Concept | Explanation |
|----------|-------------|
| **Spring Cloud Config Server** | Centralised server that manages configuration for all microservices. |
| **Configuration as Code** | Storing configuration in Git with version control. |
| **Git Repository** | Stores configuration files for all services and environments. |
| **Environment Support** | Different property files for Dev, QA, UAT, and Production. |
| **Centralised Configuration** | One place to manage application settings. |
| **Version Control** | Git provides history, rollback, and auditability. |
| **Startup Process** | Services retrieve configuration from the Config Server before starting. |
| **High Availability** | Production systems use multiple Config Server instances and retry mechanisms. |

---
