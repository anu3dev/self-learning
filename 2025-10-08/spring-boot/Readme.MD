### 🧩 Spring Boot Basics
---

**Q. What is Spring Boot and how is it different from the Spring Framework?**

Spring Boot is a lightweight extension of the Spring Framework that simplifies setup by providing:
- Auto-configuration
- Embedded servers
- Production-ready features (metrics, health checks, etc.)

Unlike plain Spring (where you manually configure XML files or annotations), Spring Boot reduces boilerplate through convention-over-configuration.

**This single file starts a full Spring app without XML.**
```java
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

`@SpringBootApplication` is a `meta-annotation` combining:
- `@Configuration` - marks this class as a bean configuration source
- `@EnableAutoConfiguration` - triggers Spring Boot's auto-config mechanism
- `@ComponentScan` - scans the package for annotated components

It scans all classes under com.example.demo for `@Component`,` @Service`, and `@Repository`.

Key advantages include:
- No XML configuration required
- Embedded server (Tomcat, Jetty, Undertow)
- Starter dependencies for simplified setup
- Easy integration with JPA, Security, Actuator, etc.
- Ideal for microservices architecture

**Automatically adds Spring MVC + Tomcat.**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

**Q. How does Spring Boot automatically configure beans?**

Spring Boot uses Auto-Configuration classes (from spring-boot-autoconfigure) to detect available libraries and configure required beans automatically, unless overridden manually.

**Adding JPA starter:**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

Auto-creates:
- DataSource
- EntityManagerFactory
- JpaTransactionManager

**Q. What is the difference between application.properties and application.yml?**

Both store externalized configuration, but syntax differs:
- .properties → flat key-value pairs
- .yml → hierarchical, cleaner structure

**Example - application.properties**
```properties
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/testdb
spring.datasource.username=root
spring.datasource.password=root
```

**Example - application.yml**
```yml
server:
    port: 8081
spring:
    datasource:
        url: jdbc:mysql://localhost:3306/testdb
        username: root
        password: root
```

**You can change the port via application.properties configuration.**
```properties
server.port=9090
```

**You can change the port via application.yml configuration.** 
```yml
server:
    port: 9090
```

---
### 🧩 Spring Boot Annotations**
---

**01. @SpringBootApplication**

This is the **main entry point** for any Spring Boot app.  
It automatically sets up configuration, scans components, and starts the app.  
It's actually a shortcut for three annotations:

- `@Configuration` → marks this class as a configuration source
- `@EnableAutoConfiguration` → enables auto bean setup
- `@ComponentScan` → scans your package for components like @Service, @Repository, etc.

```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```

🟢 Think of it as: "Make this class my Spring Boot starter."

**.02 @Component**

Marks a **general-purpose bean** that Spring should manage automatically.  
Spring creates its object and injects it wherever needed.

```java
@Component
public class EmailService {
    public void sendEmail() {
        System.out.println("Sending email...");
    }
}
```

🟢 Think of it as: "Hey Spring, please manage this class as a bean."

**3️⃣ @Service**

Same as @Component, but used for **business logic or service layer** classes.  
It improves code readability and makes intent clear.

```java
@Service
public class PaymentService {
    public void processPayment() {
        System.out.println("Payment processed successfully");
    }
}
```

🟢 Think: "This class contains core business logic."

**4️⃣ @Repository**

Used on **data access** or **DAO layer** classes.  
Spring also automatically converts any database exception into a Spring-friendly one (like DataAccessException).

```java

@Repository

public class UserRepository {

// Database operations

}

```

🟢 Think: "This class talks to the database."

**5️⃣ @Controller**

Marks a class as a **Spring MVC web controller**.  
It handles incoming HTTP requests and returns a view (like an HTML page).

```java

@Controller

public class WebController {

@GetMapping("/home")

public String home() {

return "index"; // Returns view name

}

}

```

🟢 Think: "This class handles web requests and returns pages."

**6️⃣ @RestController**

Combines @Controller and @ResponseBody.  
Used for **REST APIs** - returns JSON or XML instead of HTML.

```java

@RestController

public class UserController {

@GetMapping("/user")

public String getUser() {

return "Anurag Kumar";

}

}

```

🟢 Think: "This controller sends data (JSON), not HTML pages."

**7️⃣ @RequestMapping**

Maps a **URL** to a controller method or class.  
You can specify method type (GET, POST, etc.), consumes, and produces.

```java

@RequestMapping(value = "/hello", method = RequestMethod.GET)

public String sayHello() {

return "Hello Spring Boot";

}

```

🟢 Think: "When this URL is hit, run this method."

**8️⃣ @GetMapping / @PostMapping / @PutMapping / @DeleteMapping**

These are **shortcuts for @RequestMapping** for each HTTP method.  
They make code cleaner and more readable.

```java

@GetMapping("/users")

public List&lt;User&gt; getUsers() { ... }

@PostMapping("/users")

public User addUser(@RequestBody User user) { ... }

```

🟢 Think: "GET = read, POST = create, PUT = update, DELETE = remove."

**9️⃣ @PathVariable**

Used to extract **values from the URL path**.

```java

@GetMapping("/users/{id}")

public String getUser(@PathVariable int id) {

return "User ID: " + id;

}

```

🟢 Think: "Grab part of the URL and use it as input."

**🔟 @RequestParam**

Used to get **query parameters** from the URL.  
(Example: /search?keyword=java)

```java

@GetMapping("/search")

public String search(@RequestParam String keyword) {

return "Searching for: " + keyword;

}

```

🟢 Think: "Grab something from the ?query part of the URL."

**11️⃣ @RequestBody**

Takes JSON or XML from the **HTTP request body** and converts it to a Java object automatically.

```java

@PostMapping("/addUser")

public String addUser(@RequestBody User user) {

return "Added user: " + user.getName();

}

```

🟢 Think: "Convert JSON to Java object automatically."

**12️⃣ @ResponseBody**

Sends the return value directly to the HTTP response body, instead of rendering a view.

```java

@ResponseBody

@GetMapping("/msg")

public String message() {

return "Hello JSON";

}

```

🟢 Think: "Return the data directly as output."

**13️⃣ @Autowired**

Used for **dependency injection**.  
Spring automatically finds and injects the required bean.

```java

@Service

public class OrderService {

@Autowired

private PaymentService paymentService;

}

```

🟢 Think: "Inject this bean automatically."

**14️⃣ @Qualifier**

When there are multiple beans of the same type, @Qualifier tells Spring which one to use.

```java

@Autowired

@Qualifier("emailService")

private NotificationService notificationService;

```

🟢 Think: "Use this specific bean among many."

**15️⃣ @Value**

Injects values directly from application.properties or application.yml.

```java

@Value("\${server.port}")

```

private int port;

🟢 Think: "Read a value from configuration file."

**16️⃣ @Configuration**

Marks a class that defines beans manually.  
Spring treats it as a **Java-based configuration** file (replacement of XML).

```java

@Configuration

public class AppConfig {

@Bean

public EmailService emailService() {

return new EmailService();

}

}

```

🟢 Think: "This class contains bean definitions."

**17️⃣ @Bean**

Used inside a @Configuration class to define a bean.

```java

@Bean

public RestTemplate restTemplate() {

return new RestTemplate();

}

```

🟢 Think: "Manually create and manage this bean."

**18️⃣ @Scope**

Defines how many instances of a bean should exist.  
Common scopes:

- singleton → only one instance (default)
- prototype → new instance every time
- request, session → for web contexts

```java

@Scope("prototype")

@Bean

public User userBean() {

return new User();

}

```

🟢 Think: "Control how many objects Spring should make."

**19️⃣ @Primary**

If there are multiple beans of the same type, the one marked with @Primary is preferred.

```java

@Primary

@Bean

public PaymentService paypalService() {

return new PaypalService();

}

```

🟢 Think: "Use this bean as the default."

**20️⃣ @Conditional**

Used to create beans only if a condition is true (like a property is enabled).

```java

@ConditionalOnProperty(name = "app.feature.enabled", havingValue = "true")

@Bean

public FeatureService featureService() {

return new FeatureService();

}

```

🟢 Think: "Create this bean only when condition matches."

**21️⃣ @EnableAutoConfiguration**

Allows Spring Boot to automatically configure beans based on dependencies present in the classpath.

```java

@EnableAutoConfiguration

public class MyApp { }

```

🟢 Think: "Spring Boot, please auto-configure things for me."

**22️⃣ @ComponentScan**

Tells Spring which packages to scan for components.

```java

@ComponentScan("com.example.polling")

public class PollingApp { }

```

🟢 Think: "Look for beans in this package."

**23️⃣ @Profile**

Used to load beans only in specific environments like dev, test, or prod.

```java

@Profile("dev")

@Bean

public DataSource devDataSource() {

return new H2DataSource();

}

```

🟢 Think: "Activate this bean only in specific environment."

**24️⃣ @EnableScheduling / @Scheduled**

Used for scheduled jobs or cron tasks (like auto email or cleanup jobs).

```java

@EnableScheduling

@SpringBootApplication

public class MyApp { }

@Component

public class MyScheduler {

@Scheduled(fixedRate = 5000)

public void printMsg() {

System.out.println("Runs every 5 seconds");

}

}

```

🟢 Think: "Run this method automatically at intervals."

**25️⃣ @Transactional**

Used to make a method **transactional** - if an error occurs, changes roll back automatically.  
Perfect for database operations.

```java

@Transactional

public void updateUser(User user) {

userRepository.save(user);

}

```

🟢 Think: "If anything fails, undo all DB changes."

**✅ Quick Summary Table**

| **Layer** | **Common Annotations** | **Meaning** |
| --- | --- | --- |
| **Controller Layer** | @Controller, @RestController, @RequestMapping, @GetMapping, @PostMapping | Handle HTTP requests |
| **Service Layer** | @Service, @Transactional | Business logic and transactions |
| **Repository Layer** | @Repository | Database interaction |
| **Configuration** | @Configuration, @Bean, @Value, @Scope, @Primary | Bean and property setup |
| **Dependency Injection** | @Autowired, @Qualifier | Inject beans automatically |
| **Profiles & Conditions** | @Profile, @Conditional, @EnableAutoConfiguration | Environment-specific logic |
| **Scheduler** | @EnableScheduling, @Scheduled | Background tasks |

.

**🧩 3. Spring Boot - Dependency Injection (DI), Bean Scopes, Profiles & AOP**

**⚙️ 1️⃣ What is Dependency Injection (DI)?**

**Definition:**  
Dependency Injection means **Spring automatically provides required objects (dependencies)** to a class, instead of you manually creating them using new.

It helps in:

- **Loose coupling** between classes
- **Reusability** and **testability**
- **Cleaner and more maintainable code**

**🧩 Types of Dependency Injection**

**A. Constructor Injection (Recommended)**

- Dependencies are passed via the **class constructor**.
- Ensures the object is always created with required dependencies.
- Works best for **immutability** and **unit testing**.

```java

@Service

public class OrderService {

private final PaymentService paymentService;

@Autowired

public OrderService(PaymentService paymentService) {

this.paymentService = paymentService;

}

public void placeOrder() {

paymentService.processPayment();

}

}

```

🟢 Think: "Dependencies are fixed when the object is created."

**B. Setter Injection**

- Dependencies are set using **setter methods**.
- Can be used when dependencies are **optional** or **changeable**.

```java

@Service

public class OrderService {

private PaymentService paymentService;

@Autowired

public void setPaymentService(PaymentService paymentService) {

this.paymentService = paymentService;

}

}

```

🟢 Think: "You can set or replace the dependency later."

**C. Field Injection (Not recommended for new projects)**

- Uses @Autowired directly on the field.
- Easy to use, but hard to test.

```java

@Service

public class OrderService {

@Autowired

private PaymentService paymentService;

}

```

🟠 Think: "Quick to use, but not flexible for testing."

**⚙️ 2️⃣ What is a Bean in Spring?**

A **Bean** is any object that is **managed by Spring's IoC (Inversion of Control) container**.  
You can define a bean using:

- @Component, @Service, @Repository (auto-detected)
- or @Bean inside a @Configuration class.

Example:

```java

@Configuration

public class AppConfig {

@Bean

public EmailService emailService() {

return new EmailService();

}

}

```

🟢 Think: "A bean is just a normal object, but Spring controls its creation and lifecycle."

**🧱 3️⃣ Bean Scopes**

Bean scope defines **how long** and **how many instances** of a bean exist in the application.

| **Scope** | **Description** | **Example** |
| --- | --- | --- |
| singleton (default) | Only **one instance** per Spring container | Most common |
| prototype | A **new object** every time it's requested | Used for lightweight beans |
| request | One instance per HTTP request | For web apps |
| session | One instance per user session | For login/user-specific data |
| application | One instance for entire web app | Rarely used |

**Example:**

```java

@Component

@Scope("prototype")

public class Task {

public Task() {

System.out.println("New Task created");

}

}

```

🟢 Think: "Scope controls how many copies of the bean exist."

**⚙️ 4️⃣ @Primary and @Qualifier**

Sometimes you have **multiple beans of the same type**.  
You can tell Spring which one to use.

**Example using @Primary**

```java

@Configuration

public class AppConfig {

@Primary

@Bean

public PaymentService paypal() {

return new PaypalService();

}

@Bean

public PaymentService stripe() {

return new StripeService();

}

}

```

If you autowire PaymentService, Spring will inject the **PayPal bean** by default.

**Example using @Qualifier**

```java

@Autowired

@Qualifier("stripe")

private PaymentService paymentService;

```

🟢 Think: "Use @Primary for default, @Qualifier for specific choice."

**🧭 5️⃣ Profiles in Spring Boot**

Profiles help you create **different configurations for different environments**, like:

- dev (for local development)
- test (for QA/testing)
- prod (for production)

You can activate a profile via:

- application.properties
- spring.profiles.active=dev

**Example:**

```java

@Configuration

@Profile("dev")

public class DevConfig {

@Bean

public DataSource devDataSource() {

return new H2DataSource();

}

}

@Configuration

@Profile("prod")

public class ProdConfig {

@Bean

public DataSource prodDataSource() {

return new MySQLDataSource();

}

}

```

🟢 Think: "Switch configs automatically based on environment."

**🌀 6️⃣ AOP (Aspect Oriented Programming)**

AOP allows you to **add cross-cutting concerns** - logic that applies across many modules - without cluttering your business code.

**Common Use Cases:**

- Logging
- Security checks
- Transaction management
- Performance monitoring

**Core Concepts of AOP**

| **Concept** | **Meaning** | **Example** |
| --- | --- | --- |
| **Aspect** | The reusable cross-cutting logic | LoggingAspect |
| **Advice** | The actual code to run (before/after a method) | @Before, @After, @Around |
| **Join Point** | A specific point in app execution (like method call) | A service method |
| **Pointcut** | Expression to match join points | All methods in a package |
| **Weaving** | Linking aspect with target object | Done automatically by Spring |

**Example: Logging with AOP**

```java

@Aspect

@Component

public class LoggingAspect {

@Before("execution(\* com.example.service.\*.\*(..))")

public void beforeMethod() {

System.out.println("➡️ Before method execution");

}

@After("execution(\* com.example.service.\*.\*(..))")

public void afterMethod() {

System.out.println("✅ After method execution");

}

}

```

🟢 Think:

"AOP lets you plug in logic (like logging or security) around your main code without touching it."

**🧩 7️⃣ Types of Advice in AOP**

| **Advice Type** | **When it Runs** | **Example Use** |
| --- | --- | --- |
| @Before | Before method starts | Input validation, Logging start |
| @After | After method ends (always runs) | Cleanup, Logging end |
| @AfterReturning | After method successfully returns | Post-processing results |
| @AfterThrowing | When method throws exception | Error logging |
| @Around | Runs both before & after | Performance tracking, timing execution |

**Example with @Around**

```java

@Around("execution(\* com.example.service.\*.\*(..))")

public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {

long start = System.currentTimeMillis();

Object result = joinPoint.proceed(); // execute method

long end = System.currentTimeMillis();

System.out.println("Execution Time: " + (end - start) + " ms");

return result;

}

```

**✅ 8️⃣ Summary Quick Table**

| **Concept** | **Keyword** | **Purpose** |
| --- | --- | --- |
| Dependency Injection | @Autowired, @Qualifier, Constructor/Setter Injection | Inject dependencies automatically |
| Bean Scopes | @Scope("singleton/prototype") | Define bean lifecycle |
| Primary Bean | @Primary | Choose default bean |
| Profiles | @Profile("dev") | Load environment-specific beans |
| AOP | @Aspect, @Before, @Around | Add cross-cutting logic cleanly |