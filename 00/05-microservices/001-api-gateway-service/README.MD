# API Gateway

> **Note**
>
> Gateway does **NOT** need **Spring Web** because **Spring Cloud Gateway** is built on **Spring WebFlux**, a **reactive** technology stack.

---

# The Hidden Problem

Everything we've built so far has one hidden assumption:

> **The Gateway always knows where every service is.**

In real production systems, that assumption is **false**.

---

# Day 1

Suppose your User Service is running at:

```text
User Service
10.10.20.15:8081
```

The Gateway configuration is:

```text
Gateway
      │
      ▼
http://10.10.20.15:8081
```

Everything works perfectly.

---

# Day 2

The DevOps team deploys a new version.

What actually happens?

- The old container is deleted.
- A new container starts.
- The service gets a **new IP address**.

```text
Old Instance
10.10.20.15:8081
        ❌ Deleted

New Instance
10.10.20.41:8081
```

Unfortunately, the Gateway still contains:

```text
10.10.20.15:8081
```

Result:

```text
Gateway
      │
      ▼
Old IP Address
      │
      ▼
Connection Refused
```

The Gateway is trying to contact a machine that no longer exists.

Possible errors include:

- 404 Not Found
- 503 Service Unavailable
- Connection Refused

---

# An Even Bigger Problem

Suppose the **User Service** is under heavy load.

The DevOps team decides to create **three instances**.

```text
User Service

├── Instance 1 → 10.10.20.11
├── Instance 2 → 10.10.20.12
└── Instance 3 → 10.10.20.13
```

Now ask yourself:

- Which instance should the Gateway call?
- How does the Gateway even know these three instances exist?
- What happens if another instance is added later?
- What if one instance crashes?

Hardcoding IP addresses is no longer practical.

---

# The Solution

Instead of making the Gateway remember every service address,

let's create one **central directory**.

Think of it like a **phone book**.

This is called a:

# Service Registry

---

# Real-Life Analogy

Imagine a company receptionist.

Every employee checks in when they arrive.

```
User Service
      │
      ▼
"Hi, I am User Service."
```

Receptionist replies:

```
"Noted."
```

Another service starts.

```
Payment Service
      │
      ▼
"Hi, I am Payment Service."
```

Receptionist replies:

```
"Added."
```

Now the Gateway doesn't remember addresses.

Instead, it simply asks the receptionist:

```
"Where is User Service?"
```

Receptionist replies:

```
Here are all currently running instances.
```

---

# This Receptionist Is Called

# Eureka Server

- Originally created by **Netflix**
- Later adopted by **Spring Cloud**

Eureka acts as the **Service Registry** for your entire microservices architecture.

---

# What Happens If One Instance Crashes?

Suppose this instance crashes:

```text
10.10.20.11
```

How does Eureka know?

Every few seconds, every service sends a **Heartbeat**.

Think of it as saying:

```
"I'm still alive."
```

As long as Eureka keeps receiving heartbeats,

the service remains registered.

If heartbeats stop,

Eureka automatically removes that instance.

```text
User Service

Instance 1 ❌ Removed
Instance 2 ✅ Healthy
Instance 3 ✅ Healthy
```

Now the Gateway automatically stops sending requests to the failed instance.

No manual configuration is required.

Beautiful.

---

# Life Without Eureka

```text
Client
   │
   ▼
Gateway
   │
   ▼
Hardcoded URL
   │
   ▼
Dead Server
   │
   ▼
Failure
```

---

# Life With Eureka

```text
Client
   │
   ▼
Gateway
   │
   ▼
Ask Eureka
   │
   ▼
Healthy Instance
   │
   ▼
Forward Request
```

---

# What Is Load Balancing?

Suppose Eureka returns three running instances of the **User Service**.

```text
USER-SERVICE

├── Instance A
├── Instance B
└── Instance C
```

The Gateway still needs to decide:

> **Which instance should receive the request?**

This is where **Load Balancing** comes in.

---

# The Most Common Strategy — Round Robin

A load balancer distributes incoming requests evenly across all healthy instances.

Example:

```text
Request 1
     │
     ▼
Instance A

Request 2
     │
     ▼
Instance B

Request 3
     │
     ▼
Instance C

Request 4
     │
     ▼
Instance A

Request 5
     │
     ▼
Instance B
```

Traffic becomes evenly distributed across all running instances.

By default, **Spring Cloud LoadBalancer** uses the **Round Robin** strategy.

---

# Configuration Difference

## Before (Hardcoded URL)

```properties
spring.cloud.gateway.server.webflux.routes[0].uri=http://localhost:8081
```

The Gateway always calls the same machine.

---

## After (Service Discovery)

```properties
spring.cloud.gateway.server.webflux.routes[0].uri=lb://USER-SERVICE
```

Notice the difference:

- No IP Address
- No Port Number
- Only the **Service Name**

The `lb://` prefix means:

> **Ask the Load Balancer to find a healthy instance of this registered service.**

---

# Real Production Flow

Suppose a customer requests:

```http
GET /users
```

The complete flow looks like this:

```text
Customer
     │
     ▼
API Gateway
     │
     ▼
Find USER-SERVICE
     │
     ▼
Ask Eureka
     │
     ▼
Returns

Instance A
Instance B
Instance C
     │
     ▼
Spring Cloud LoadBalancer
     │
     ▼
Chooses Instance B
     │
     ▼
Gateway Forwards Request
     │
     ▼
Response Returned to Customer
```

Everything happens automatically.

The client never knows which instance handled the request.

---

# Why Companies Love This

Imagine **Amazon** during **Black Friday**.

Normally, the **Product Service** runs with:

```text
20 Instances
```

Traffic suddenly increases.

The DevOps team scales it to:

```text
500 Instances
```

What changes?

- Gateway configuration? ❌ No
- Frontend application? ❌ No
- Client requests? ❌ No

Everything continues working automatically.

This is the power of:

> **Dynamic Service Discovery**

---

# Eureka Dashboard

When you open the Eureka Dashboard, you'll see something similar to this:

| Application | Instances |
|-------------|----------:|
| USER-SERVICE | 3 |
| PRODUCT-SERVICE | 5 |
| ORDER-SERVICE | 4 |
| PAYMENT-SERVICE | 2 |
| INVENTORY-SERVICE | 3 |

Think of this as the company's **phone directory**.

Every running service registers itself with Eureka.

Whenever a service starts or stops, the directory is updated automatically.

The API Gateway simply asks Eureka for the latest information instead of relying on hardcoded IP addresses.

---

# End-to-End Flow

```text
                    Client
                       │
                       ▼
                API Gateway
                       │
                       ▼
              Ask Eureka Server
                       │
                       ▼
        Returns Healthy Instances
                       │
                       ▼
       Spring Cloud LoadBalancer
        Chooses One Instance
                       │
                       ▼
             USER-SERVICE Instance
                       │
                       ▼
                 Returns Response
                       │
                       ▼
                    Client
```

---
