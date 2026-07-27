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