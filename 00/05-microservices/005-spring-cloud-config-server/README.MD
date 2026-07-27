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

