# Eureka Registry Server

The **Eureka Registry Server** is the central **Service Registry** in a microservices architecture.

Every microservice registers itself with Eureka when it starts.

Other services can then discover it dynamically without knowing its IP address or port.

To create a Eureka Server, simply add:

```java
@EnableEurekaServer
```

This annotation tells Spring Boot to start a **Eureka Registry Server**.

---

# The Problem Before OpenFeign

Suppose a customer places an order.

```
Place Order
```

Question:

> **Should the Order Service know the product price?**

**No.**

Who owns the product information?

**Product Service.**

Therefore, whenever Order Service needs product details, it must ask Product Service.

The architecture looks like this:

```text
                Browser
                    │
                    ▼
              API Gateway
                    │
                    ▼
             ORDER-SERVICE
                    │
                    ▼
           PRODUCT-SERVICE
```

---

# Without OpenFeign

Most beginners write something like this:

```java
RestTemplate restTemplate = new RestTemplate();

Product product = restTemplate.getForObject(
    "http://localhost:8082/products/101",
    Product.class
);
```

Although this works, it introduces several problems.

---

# Problem 1 — Hardcoded URL

The request is sent to:

```text
http://localhost:8082
```

Suppose tomorrow the Product Service moves to:

```text
http://localhost:8085
```

Now every application using that URL must be updated.

Everything breaks.

---

# Problem 2 — Multiple Instances

Suppose the Product Service has been scaled.

```text
PRODUCT-SERVICE

├── 8082
├── 8083
├── 8084
├── 8085
└── 8086
```

Question:

> **Which instance should Order Service call?**

It has no idea.

---

# Problem 3 — Instance Failure

Suppose one Product Service instance crashes.

```text
PRODUCT-SERVICE

8082 ❌ Down
8083 ✅ Running
8084 ✅ Running
```

If Order Service still calls:

```text
http://localhost:8082
```

The request fails.

Again...

Everything breaks.

---

# The Solution

Instead of remembering:

- IP Address
- Host
- Port

remember only the **Service Name**.

```text
PRODUCT-SERVICE
```

Exactly what **Eureka** provides.

---

# Enter OpenFeign

Instead of writing **30–40 lines** of HTTP client code,

we simply write an interface.

```java
@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductClient {

    @GetMapping("/products/{id}")
    Product getProduct(@PathVariable Integer id);

}
```

That's it.

No `RestTemplate`.

No `WebClient`.

No manual HTTP request construction.

Spring generates the HTTP client automatically.

---

# What Happens Internally?

Suppose Order Service executes:

```java
productClient.getProduct(101);
```

Spring performs all of these steps automatically.

```text
Ask Eureka
      │
      ▼
Find PRODUCT-SERVICE
      │
      ▼
Retrieve All Healthy Instances
      │
      ▼
Spring Cloud LoadBalancer
Chooses One Instance
      │
      ▼
Send HTTP Request
      │
      ▼
Receive JSON Response
      │
      ▼
Convert JSON to Product Object
      │
      ▼
Return Product
```

Everything happens automatically.

---

# Complete Request Flow

```text
                ORDER-SERVICE
                      │
                      ▼
       productClient.getProduct(101)
                      │
                      ▼
                 OpenFeign Proxy
                      │
                      ▼
                Ask Eureka Server
                      │
                      ▼
        PRODUCT-SERVICE Instances

           :8082
           :8083
           :8084

                      │
                      ▼
      Spring Cloud LoadBalancer
         Chooses One Instance
                      │
                      ▼
               HTTP GET Request
                      │
                      ▼
                JSON Response
                      │
                      ▼
        Deserialize into Product DTO
                      │
                      ▼
             Return Product Object
```

---

# Why Interviewers Love This Question

Suppose the interviewer asks:

> **"What exactly happens when you call a Feign Client?"**

A strong answer is:

1. Spring creates a proxy implementation of the Feign interface.
2. The proxy asks Eureka for all healthy instances of the target service.
3. Spring Cloud LoadBalancer selects one healthy instance.
4. OpenFeign constructs the HTTP request.
5. The remote service processes the request and returns JSON.
6. OpenFeign deserializes the JSON into the target Java object.
7. The calling service receives the object as if it were a local method call.

This demonstrates that you understand **how OpenFeign works internally**, not just how to use the annotation.

---

# Why OpenFeign Is Better Than RestTemplate

| RestTemplate | OpenFeign |
|--------------|-----------|
| Manual HTTP calls | Declarative interface |
| Hardcoded URLs | Uses Service Name |
| More boilerplate code | Minimal code |
| Manual object mapping | Automatic JSON mapping |
| No built-in service discovery | Integrates with Eureka |
| Manual load balancing | Automatic load balancing |

---

# Our Hands-on Project

So far, our architecture looks like this:

```text
             Browser
                 │
                 ▼
            API Gateway
                 │
                 ▼
          ORDER-SERVICE

          PRODUCT-SERVICE
```

Notice that **Order Service** and **Product Service** are completely independent.

Order Service cannot communicate with Product Service yet.

---

# Our Next Architecture

We'll now introduce **OpenFeign**.

```text
              Browser
                  │
                  ▼
             API Gateway
                  │
                  ▼
            ORDER-SERVICE
                  │
                  ▼
             OpenFeign Client
                  │
                  ▼
           PRODUCT-SERVICE
```

Now Order Service can simply call:

```java
productClient.getProduct(101);
```

without knowing:

- IP Address
- Port Number
- Number of running instances

OpenFeign, Eureka, and Spring Cloud LoadBalancer handle everything automatically.

---

# Key Takeaways

| Concept | Explanation |
|----------|-------------|
| **Eureka Server** | Central registry where all microservices register themselves. |
| **OpenFeign** | Declarative HTTP client used for service-to-service communication. |
| **`@FeignClient`** | Creates a dynamic HTTP client for another microservice. |
| **Service Discovery** | OpenFeign asks Eureka to locate the target service. |
| **Load Balancing** | Spring Cloud LoadBalancer selects one healthy instance. |
| **JSON Mapping** | OpenFeign automatically converts JSON into Java objects. |
| **Developer Experience** | Calling another microservice feels like calling a normal Java method. |

---

# Resilience4j Circuit Breaker

So far, our architecture looks like this:

```text
              Browser
                  │
                  ▼
             API Gateway
                  │
                  ▼
            ORDER-SERVICE
                  │
                  ▼
             OpenFeign Client
                  │
                  ▼
           PRODUCT-SERVICE
```

Both services are running.

When a customer places an order:

1. Order Service receives the request.
2. Order Service calls Product Service using **OpenFeign**.
3. Product Service returns product details.
4. Order Service completes the order.

Everything works perfectly.

---

# The Problem

Now imagine this situation.

```
ORDER-SERVICE   ✅ Running
PRODUCT-SERVICE ❌ Down
```

A customer places an order.

What happens?

```text
Customer
     │
     ▼
ORDER-SERVICE
     │
     ▼
OpenFeign
     │
     ▼
PRODUCT-SERVICE ❌ Down
```

The HTTP request fails.

OpenFeign throws an exception.

If nothing handles it,

Order Service also fails.

The customer receives an error such as:

- 500 Internal Server Error
- 503 Service Unavailable
- Timeout Exception

One failed microservice causes another microservice to fail.

This is known as **Cascading Failure**.

---

# What Is a Cascading Failure?

Imagine this architecture.

```text
Browser
    │
    ▼
Gateway
    │
    ▼
Order Service
    │
    ▼
Product Service
    │
    ▼
Inventory Service
```

Suppose **Product Service** goes down.

Order Service keeps trying to call it.

Every request waits until it times out.

Soon:

- Request threads become blocked.
- CPU usage increases.
- Memory usage increases.
- Thread pool becomes exhausted.

Eventually,

Order Service also becomes unavailable.

One failure spreads throughout the system.

This is called a **Cascading Failure**.

---

# The Solution

Instead of continuously calling a failing service,

we place a **Circuit Breaker** between the caller and the remote service.

```text
ORDER-SERVICE
      │
      ▼
Circuit Breaker
      │
      ▼
OpenFeign
      │
      ▼
PRODUCT-SERVICE
```

The Circuit Breaker monitors every request.

If too many requests fail,

it stops calling the remote service temporarily.

This prevents cascading failures.

---

# Real-Life Analogy

Think about an electrical circuit in your home.

When too much current flows,

the circuit breaker trips.

```
Electric Fault
       │
       ▼
Circuit Breaker Trips
       │
       ▼
Electricity Stops
```

Why?

To protect the wiring and appliances.

Similarly,

a software Circuit Breaker protects your application from repeatedly calling an unhealthy service.

---

# Three States of a Circuit Breaker

A Circuit Breaker has **three states**.

## 1. Closed State

Everything is healthy.

Requests are allowed to pass through.

```text
ORDER-SERVICE
      │
      ▼
Circuit Breaker (Closed)
      │
      ▼
PRODUCT-SERVICE ✅
```

Every request succeeds.

The Circuit Breaker simply monitors failures.

---

## 2. Open State

Suppose many requests start failing.

After the configured failure threshold is reached,

the Circuit Breaker opens.

```text
ORDER-SERVICE
      │
      ▼
Circuit Breaker (Open)
      │
      ✖
PRODUCT-SERVICE
```

No requests are sent.

Instead,

the Circuit Breaker immediately returns a fallback response or an exception.

This avoids wasting resources waiting for timeouts.

---

## 3. Half-Open State

After waiting for a configured period,

the Circuit Breaker allows a small number of requests.

```text
ORDER-SERVICE
      │
      ▼
Circuit Breaker (Half-Open)
      │
      ▼
PRODUCT-SERVICE
```

If those requests succeed,

the Circuit Breaker closes again.

If they fail,

it immediately returns to the Open state.

---

# State Transition

```text
           Success
              ▲
              │
        +-------------+
        |   CLOSED    |
        +-------------+
              │
     Too Many Failures
              ▼
        +-------------+
        |    OPEN     |
        +-------------+
              │
      Wait Duration Ends
              ▼
        +-------------+
        | HALF-OPEN   |
        +-------------+
         │          │
     Success     Failure
         │          │
         ▼          ▼
     CLOSED       OPEN
```

---

# Why Not Simply Use try-catch?

A very common interview question.

Suppose we write:

```java
try {
    Product product = productClient.getProduct(id);
}
catch (Exception ex) {
    return null;
}
```

Does this solve the problem?

**No.**

---

# Why?

A `try-catch` only handles the exception **after making the remote call**.

The sequence is still:

```text
HTTP Request
      │
      ▼
Wait...
      │
      ▼
Timeout
      │
      ▼
Exception
      │
      ▼
catch Block
```

Every request still:

- Opens a network connection.
- Waits for a timeout.
- Consumes CPU.
- Uses memory.
- Blocks a thread.

If thousands of requests arrive,

all of them still wait before failing.

The application becomes slow and may eventually become unavailable.

---

# Circuit Breaker vs try-catch

With a Circuit Breaker:

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

No HTTP request is made.

No timeout occurs.

No waiting.

No unnecessary resource consumption.

---

# Benefits of a Circuit Breaker

- Prevents cascading failures.
- Reduces unnecessary network calls.
- Protects thread pools.
- Improves application responsiveness.
- Allows unhealthy services time to recover.
- Supports graceful degradation using fallback methods.

---

# Why Companies Use Resilience4j

Large companies such as Amazon, Netflix, Uber, and Google cannot afford one failing service to bring down the entire system.

Instead of continuously retrying failed requests,

they temporarily stop calling unhealthy services.

Once the service recovers,

traffic resumes automatically.

This makes the entire system more resilient.

---
