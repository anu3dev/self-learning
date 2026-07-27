# Why Did Companies Like Amazon, Netflix, Uber, and Google Move from Monoliths to Microservices?

Let's go back 20 years.

Suppose you're building an online shopping application. Initially, it's very small.

```text
Shopping App

├── User
├── Product
├── Order
└── Payment
```

Everything is inside:

- One project
- One codebase
- One deployment
- One database
- One server

This architecture is called a **Monolith**.

---

# What is a Monolith?

A **Monolith** is an application where **all business functionalities are packaged and deployed as a single unit.**

```text
+------------------------------------------------------+
|              Shopping Application                    |
|------------------------------------------------------|
| User Module                                          |
| Product Module                                       |
| Order Module                                         |
| Payment Module                                       |
| Inventory Module                                     |
| Notification Module                                  |
+------------------------------------------------------+

One Application
One Deployment
One Database
Everything lives together
```

---

# Why Were Monoliths Popular?

For small applications, they're fantastic.

## Advantages

- Easy to develop
- Easy to debug
- Easy to deploy
- Simple architecture
- One repository
- One build process

> **For a startup with three developers, a monolith is usually the best choice.**

---

# Imagine Success...

Your application becomes successful.

```
100 Users
      ↓
10 Million Users
```

Now problems begin.

---

# Problem 1 — Huge Codebase

```
200 Java files
        ↓
20,000 Java files
```

The codebase becomes difficult to understand, maintain, and debug.

---

# Problem 2 — One Small Change Requires Full Deployment

Even though you changed only **one class**, you must:

- Rebuild the entire application
- Deploy the entire application
- Restart the entire application

A tiny change causes a full deployment.

---

# Problem 3 — Scaling Problems

Suppose your traffic looks like this:

| Module | Traffic |
|---------|--------:|
| Product Search | **90%** |
| Payment | 5% |
| Orders | 5% |

Which part needs more servers?

**Obviously, Product Search.**

But in a monolith:

❌ You cannot scale only Product Search.

Instead, you must duplicate the **entire application**.

---

# Problem 4 — Team Conflicts

Suppose your company grows.

Now you have **50 developers** working in the same repository.

Common problems:

- Merge conflicts
- Long pull requests
- Huge code reviews
- Difficult releases
- Accidental code changes

---

# Problem 5 — Technology Lock-in

Suppose your application is written in **Java**.

Later,

- AI team wants **Python**
- Analytics team wants **Go**
- Search team wants **Rust**

Can they?

**Not easily.**

Because the entire application is one deployable unit, everyone must continue using Java—even if another language is better suited for a particular problem.

---

# Problem 6 — Slow Startup

Suppose your application contains:

- Authentication
- Orders
- Payments
- AI Recommendation
- Analytics
- Inventory
- Reporting

To start the application,

**Everything starts.**

Even if you're only working on **Orders**, the entire application boots.

Startup may take several minutes.

---

# Problem 7 — Single Point of Failure

Imagine this situation:

The **Notification Module** has a memory leak.

Eventually,

```
JVM Crashes
```

What happens?

```
Everything Stops
```

---

# Did Everyone Suddenly Switch to Microservices?

**No.**

This is an important interview point.

The evolution looked like this:

```
Small Application
        ↓
Simple Monolith
        ↓
Layered Monolith
        ↓
Modular Monolith
        ↓
Microservices
```

---

# Why Not Build Every Application as Microservices from Day One?

Because microservices introduce significant operational complexity.

They require:

- Multiple deployments
- Network communication
- Distributed transactions
- Service discovery
- API Gateway
- Monitoring
- Logging
- Security between services
- Docker
- Kubernetes
- Higher infrastructure cost

If you have:

- A small team
- A simple application

then a **well-designed modular monolith** is often the better choice.

---

# Interview Point

❌ **Microservices are always better than monoliths.**

This statement is **incorrect.**

The correct perspective is:

> **Microservices solve scaling and organizational problems, but they introduce distributed system complexity. Choose the architecture that matches your application's size, team structure, and operational needs.**

---

# Bounded Context — The Heart of Microservices

This concept comes from **Domain-Driven Design (DDD)** by **Eric Evans**.

Instead of thinking about **classes**, think about **Business Capabilities**.

Ask yourself:

> **What business responsibility does this functionality own?**

For Amazon, natural business capabilities are:

- Users
- Products
- Orders
- Payments
- Inventory
- Shipping
- Notifications

Each service owns one complete business responsibility.

That ownership defines a **Bounded Context**.

## Definition

A **Bounded Context** is a clear boundary within which:

- A specific business model exists
- Terminology is consistent
- Data is owned by one service

### Simplified

```
One Business Responsibility
            =
One Bounded Context
```

### Real-Life Analogy

Think of a **Hospital**.

Different departments own different responsibilities:

- Reception
- Cardiology
- Pharmacy
- Radiology
- Billing

Each department owns its own work, staff, and records.

Microservices work the same way.

---

# Database Ownership

This is one of the biggest differences between **Monoliths** and **Microservices**.

## Monolith

Everyone reads and writes to the **same database**.

```
Application
      │
      ▼
Shared Database
```

## Microservices

Each service owns its own data.

This pattern is called:

> **Database per Service**

```
User Service
      │
User Database

Product Service
      │
Product Database

Order Service
      │
Order Database

Payment Service
      │
Payment Database
```

### Why?

Suppose **Product Service** changes its schema.

If every service accesses the Product database directly,

```
Schema Changes
       ↓
Everything Breaks
```

### Golden Rule

> **A service never directly accesses another service's database.**

---

# If Every Service Is Independent, How Does the Client Talk to Them?

This leads us to one of the most important components in a microservices architecture:

# API Gateway

Suppose Amazon has become a microservice application.

| Service | Port |
|----------|------|
| User Service | 8081 |
| Product Service | 8082 |
| Order Service | 8083 |
| Payment Service | 8084 |
| Inventory Service | 8085 |
| Shipping Service | 8086 |

Without an API Gateway, several problems arise.

## Problem 1 — Client Must Know Every Service

The client must know:

```
User Service       -> localhost:8081
Product Service    -> localhost:8082
Order Service      -> localhost:8083
Payment Service    -> localhost:8084
...
```

---

## Problem 2 — Authentication Everywhere

Suppose every request requires **JWT validation**.

Without a Gateway,

every service must implement authentication separately.

---

## Problem 3 — Logging Everywhere

Every service now writes its own:

- Request logs
- Response logs
- Error logs

---

## Problem 4 — Rate Limiting

Suppose one hacker sends:

```
100,000 Requests / Second
```

Without a Gateway,

every service gets attacked directly.

---

## Problem 5 — Load Balancing

Every client must know which service instance to call.

---

# Solution — API Gateway

Put one application in front of everything.

The client knows only **ONE URL**.

Example:

```
amazon.com
```

Everything else is hidden.

```
               Browser
                  │
                  ▼
            API Gateway
        ┌──────┼───────┐
        ▼      ▼       ▼
     User   Product   Order
    Service Service  Service
```

### Real-Life Analogy

Think of a **Hotel**.

The **Reception Desk** is like the **API Gateway**.

Guests never go directly to:

- Kitchen
- Housekeeping
- Laundry
- Maintenance

Instead, they speak with Reception, which routes the request to the correct department.

---

# Responsibilities of an API Gateway

The Gateway is much more than simple routing.

It can perform:

- Authentication
- Authorization
- Logging
- Rate Limiting
- SSL Termination
- Request Routing
- Response Transformation
- Monitoring
- CORS
- Load Balancing

---

# Request Flow

Customer opens:

```
amazon.com/products
```

Flow:

```
Browser
    │
    ▼
API Gateway
    │
    ▼
Matches Route
    │
    ▼
Product Service
    │
    ▼
Returns JSON
    │
    ▼
API Gateway
    │
    ▼
Browser
```

---

# Does the API Gateway Contain Business Logic?

**No.**

The API Gateway should only handle cross-cutting concerns such as:

- Authentication
- Authorization
- Routing
- Logging
- Monitoring
- Rate Limiting
- SSL
- CORS
- Load Balancing

Business logic always belongs inside the appropriate microservice.

---