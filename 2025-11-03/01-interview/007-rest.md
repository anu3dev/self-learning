### rest

####
<details>
<summary>🟩 6 Core REST Principles</summary>

- Client–Server Architecture
    - Client and server must be separated -> Client handles UI and Server handles data & logic, This separation allows both to evolve independently.

- Statelessness
    - Each request from the client must contain all the information needed to process it -> Server does NOT store client session, No memory of previous requests, Every request is independent, Example: Client must send token every time.

- Cacheability
    - Responses must define whether they are cacheable or not -> Improves performance, Reduces server load, Uses headers like Cache-Control, ETag, Expires

- Uniform Interface (MOST IMPORTANT)
    - All communication between client and server must be done in a standard, consistent way.

    - Includes:
        - Resource-based URLs
            - /users/10/orders
        - Standard HTTP methods
            - GET → Read
            - POST → Create
            - PUT → Update (replace)
            - PATCH → Partial update
            - DELETE → Delete
        - Standard response codes
            - 200 OK
            - 201 Created
            - 400 Bad Request
            - 404 Not Found
            - 500 Server Error

- Layered System
    - REST allows multiple layers between client and server:
        - Load balancers
        - Proxies
        - Gateways
        - Security layers -> Client doesn’t know how many layers exist.

- Code on Demand (Optional)
    - Server can send executable code to the client. Example: Send JavaScript to browser.
</details>

####
<details>
<summary>🟩 GraphQL</summary>

- GraphQL is a query language for APIs and a runtime environment for executing queries against your data. It allows clients to request exactly the data they need and nothing more, making it more efficient than traditional REST APIs.
- A GraphQL schema defines the types of data you can query for and the operations (queries, mutations) that can be executed. The schema defines types, queries, and mutations.

</details>

####
<details>
<summary> 🟩 REST vs GraphQL pros/cons </summary>

- REST
    - Pros
        - Simple & widely adopted -> Easy to learn, easy to consume, huge tooling support.
        - Standard HTTP operations -> GET, POST, PUT, DELETE → predictable semantics.
        - Caching is easy -> Built-in browser & CDN caching via URLs.
        - Better for simple CRUD ->Straight forward when resources are isolated.
        - Mature ecosystem -> Monitoring, logging, versioning patterns are established.

    - Cons
        - Over-fetching -> Client gets more data than needed.
        - Under-fetching -> Client must make multiple calls to get required data.
        - Hard to version -> Often need /v1, /v2, etc.
        - Multiple endpoints -> Larger APIs look scattered (many URLs).
        - Not ideal for complex nested data -> Requires multiple round-trips.

- GraphQL
    - Pros
        - No over-fetching / under-fetching -> Clients get exactly the fields they request.
        - Single endpoint -> Everything is queried through /graphql.
        - Strongly typed schema -> Clear contract between client and server.
        - Great for nested/related data -> Fetch everything in one round trip.
        - Self-documenting -> Tools like GraphiQL/Playground generate docs automatically.
        - Perfect for mobile/SPA apps -> Reduces bandwidth and latency.

    - Cons
        - Caching is harder -> Since it uses POST requests by default.
        - More complex server setup -> Requires schema, resolvers, data loaders.
        - Can lead to expensive queries -> Clients can ask for huge nested graphs.
        - Overkill for simple CRUD -> REST is easier for basic APIs.
        - File uploads and streaming require extra effort -> Not as natural as REST.

</details>

####
<details>
<summary> 🟩 RestTemplate vs WebClient </summary>

- RestTemplate is a synchronous HTTP client, part of Spring Framework for making REST API calls.
    - For blocking I/O operations in traditional applications.
    - Works fine when your application isn’t doing many parallel HTTP requests.
    - Suitable for legacy Spring applications, as it has been the default HTTP client for years.
    - Simple, single-threaded use cases (e.g., direct RESTful API calls, or simple CRUD applications).

    ```java
    import org.springframework.web.client.RestTemplate;

    public class RestTemplateExample {
        public static void main(String[] args) {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.example.com/data";
            String result = restTemplate.getForObject(url, String.class);
            System.out.println(result);
        }
    }
    ```

- WebClient is a reactive, asynchronous HTTP client, introduced as part of Spring WebFlux to support non-blocking and reactive programming.
    - Best for high-performance, non-blocking applications, especially when the system is expected to handle many concurrent API calls (e.g., microservices).
    - Use WebClient for reactive programming, as it supports Mono and Flux — the core types for reactive programming in Project Reactor.
    - Ideal for use with Spring WebFlux applications or when you need non-blocking I/O and need to scale horizontally (e.g., handling many API requests simultaneously without blocking).
    - Use WebClient if you're integrating with other reactive systems (e.g., using Spring WebFlux, Spring Cloud, or other asynchronous systems).

    ```java
    import org.springframework.web.reactive.function.client.WebClient;
    import reactor.core.publisher.Mono;

    public class WebClientExample {
        public static void main(String[] args) {
            WebClient webClient = WebClient.create("https://api.example.com");
            
            Mono<String> result = webClient.get()
                .uri("/data")
                .retrieve()
                .bodyToMono(String.class);
            
            result.subscribe(data -> System.out.println(data)); // non-blocking
        }
    }
    ```

</details>

####
<details>
<summary> 🟩 Global GraphQL exception handler </summary>

- In a recent project using Spring GraphQL, I implemented global exception handling using @ControllerAdvice to ensure consistent error responses across the application. First, I created a custom exception handler with @ControllerAdvice to catch GraphQL-specific exceptions like CustomNotFoundException. I then mapped these exceptions to GraphQLError objects with appropriate error types, such as ErrorType.NOT_FOUND. The @ControllerAdvice annotation allowed me to centralize error handling for all controllers. This approach ensured that the client received user-friendly and structured error messages, and it helped in debugging by maintaining detailed logs. It significantly improved error management, reducing inconsistencies and making the codebase more maintainable.

</details>

####
<details>
<summary> 🟩 DTO pattern usage </summary>

- In one of my previous projects, I used the DTO (Data Transfer Object) pattern to simplify data flow between the layers of our application. Our service layer needed to send large, complex data structures to the client, but to improve performance and maintain separation of concerns, I created DTOs. These DTOs contained only the necessary fields for the response, stripping away any irrelevant or sensitive data. For example, I used a UserDTO instead of returning the full UserEntity to the client. This not only improved performance by reducing the data sent over the network but also helped enforce security by excluding fields like passwords or internal system data. The DTO pattern also made the system more maintainable by decoupling the persistence layer from the presentation layer, enabling easier changes to either layer without affecting the other.

</details>

####
<details>
<summary> 🟩 SLF4J logging best practice </summary>

- In one of my projects, we used SLF4J with Logback for logging. The best practice I followed was to use parameterized logging (e.g., logger.info("User {} logged in at {}", username, timestamp)) instead of string concatenation. This approach avoids unnecessary string creation and improves performance. I also ensured that logs had the correct log level (DEBUG, INFO, WARN, ERROR) for the situation — using INFO for general operational logs and ERROR for exceptions. Additionally, I configured Logback with rolling file appender and log rotation to manage log file sizes and avoid filling up the disk. Finally, I made sure logs contained relevant contextual information (e.g., user IDs, request IDs) for better traceability and troubleshooting.

</details>

####
<details>
<summary> 🟩 Dockerize and deploy Spring Boot microservice </summary>

- In one of my recent projects, I dockerized a Spring Boot microservice to ensure portability and consistency across different environments. First, I created a Dockerfile in the root of the project, which built the Spring Boot application as a JAR file using Maven. The Dockerfile was simple, starting with an official openjdk image, copying the JAR into the container, and specifying the command to run it. After building the Docker image, I used Docker Compose to orchestrate the service with dependencies like a PostgreSQL database. For deployment, I pushed the image to a container registry (e.g., Docker Hub or AWS ECR) and deployed it to a Kubernetes cluster using Helm charts, making it easy to scale and manage the microservice in production.

</details>