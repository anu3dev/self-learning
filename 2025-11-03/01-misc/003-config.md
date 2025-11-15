###

####
<details>
<summary> 🟩 how to set rules in sonarqube </summary>

For example, to set a rule that should enforce dev to have max 200 lines of code in a file.

- Quality Profile - A collection of active rules.
    - Log in to SonarQube as an Administrator or Project Admin
    - Go to Quality Profiles → select your language (e.g., JavaScript, Java, TypeScript)
    - Edit the rule if required and make it active if it is not already.

- Enforce via Quality Gate 
    - Go to Quality Gates → Create / Edit
    - Add a condition

- Create a Custom Rule 
    - Use SonarQube Custom Plugin API.
    - Implement a rule using Java (for Java projects) or JavaScript (for JS/TS projects).
    - Register it in SonarQube under a custom Quality Profile.

</details>

####
<details>
<summary> 🟩 deploy a java or react app through docker </summary>

Developer → Push Code → Build → Test → Docker Build → Push Image → Deploy Container

- React app
    - 1. Build stage
         FROM node:20 AS build
         WORKDIR /app
         COPY package*.json ./
         RUN npm install
         COPY . .
         RUN npm run build

    - 2. Serve static build using Nginx
         FROM nginx:alpine
         COPY --from=build /app/dist /usr/share/nginx/html
         EXPOSE 80
         CMD ["nginx", "-g", "daemon off;"]

- Java app
    - 1. Build stage
         FROM maven:3.9.6-eclipse-temurin-17 AS build
         WORKDIR /app
         COPY pom.xml .
         COPY src ./src
         RUN mvn clean package -DskipTests

    - 2. Runtime stage
         FROM eclipse-temurin:17-jdk-alpine
         WORKDIR /app
         COPY --from=build /app/target/*.jar app.jar
         EXPOSE 8080
         ENTRYPOINT ["java","-jar","/app/app.jar"]

</details>

####
<details>
<summary> 🟩 activate a profile in spring </summary>

- via Command Line
    - java -jar app.jar --spring.profiles.active=it
    - java -jar app.jar --spring.profiles.active=uat
- via application.properties
    - spring.profiles.active=it
- via Environment Variable
    - export SPRING_PROFILES_ACTIVE=uat
    - java -jar app.jar

</details>

####
<details>
<summary> 🟩 working with multiple DB in spring </summary>

- At enterprise scale, apps often:
    - Use Postgres for main app data
    - Use MongoDB for audit/log
    - Use Redis for caching
    - Use Oracle for legacy read operations

- Step 1: Folder Structure
    src/main/java/com/example/multidb/
    ├── config/
    │     ├── PostgresConfig.java
    │     └── MySQLConfig.java
    ├── postgres/
    │     ├── entity/User.java
    │     └── repo/UserRepository.java
    └── mysql/
        ├── entity/Order.java
        └── repo/OrderRepository.java

- Step 2: application.properties
    - PostgreSQL
    spring.postgres.datasource.url=jdbc:postgresql://localhost:5432/postgresdb
    spring.postgres.datasource.username=postgres
    spring.postgres.datasource.password=postgres

    - MySQL
    spring.mysql.datasource.url=jdbc:mysql://localhost:3306/mysqldb
    spring.mysql.datasource.username=root
    spring.mysql.datasource.password=root

- Step 3: PostgresConfig.java

```java
@Configuration
@EnableJpaRepositories(
    basePackages = "com.example.multidb.postgres.repo",   // Repos for Postgres
    entityManagerFactoryRef = "postgresEntityManager",
    transactionManagerRef = "postgresTransactionManager"
)
public class PostgresConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.postgres.datasource")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean postgresEntityManager(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(postgresDataSource())
                .packages("com.example.multidb.postgres.entity") // Entities for Postgres
                .persistenceUnit("postgresPU")
                .build();
    }

    @Bean
    public PlatformTransactionManager postgresTransactionManager(
            @Qualifier("postgresEntityManager") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
```

- Step 4: MySQLConfig.java

```java
@Configuration
@EnableJpaRepositories(
    basePackages = "com.example.multidb.mysql.repo",   // Repos for MySQL
    entityManagerFactoryRef = "mysqlEntityManager",
    transactionManagerRef = "mysqlTransactionManager"
)
public class MySQLConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.mysql.datasource")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean mysqlEntityManager(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(mysqlDataSource())
                .packages("com.example.multidb.mysql.entity") // Entities for MySQL
                .persistenceUnit("mysqlPU")
                .build();
    }

    @Bean
    public PlatformTransactionManager mysqlTransactionManager(
            @Qualifier("mysqlEntityManager") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}

```

- Step 5: Postgres Entity & Repo

```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // getters/setters
}
```

- Step 6: MySQL Entity & Repo

```java
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    // getters/setters
}

```

- Step 7: Service Layer — Using both

```java
@Service
public class DataService {

    @Autowired
    private UserRepository userRepo;   // belongs to Postgres
    @Autowired
    private OrderRepository orderRepo; // belongs to MySQL

    public void saveData() {
        userRepo.save(new User("Anurag"));
        orderRepo.save(new Order("MacBook"));
    }
}

```

- Spring will create one connection to PostgreSQL and another to MySQL, UserRepository will use the Postgres datasource, OrderRepository will use the MySQL datasource.

```java
@EnableJpaRepositories(
   basePackages = "com.example.multidb.postgres.repo",
   entityManagerFactoryRef = "postgresEntityManager"
)
```

</details>

####
<details>
<summary> 🟩 What is Client-Side Rendering (CSR)? </summary>

- Client-Side Rendering means:
    - The browser (client) downloads a mostly empty HTML page.
    - Then it downloads JavaScript.
    - The JavaScript builds the UI in the browser.
- How it works
    - Browser loads index.html (usually empty <div id="root"></div>).
    - Browser downloads JS bundle.
    - React/Vue/Angular builds the UI on the client.
- Pros
    - Very interactive, dynamic UI
    - Fast navigation after first load
    - Good for dashboards, SPAs
- Cons
    - Slow first page load (JS must download first)
    - Bad for SEO
    - Not ideal for slow devices (heavy JS)

</details>

####
<details>
<summary> 🟩 What is Server-Side Rendering (SSR)? </summary>

- Server-Side Rendering means:
    - HTML is generated on the server.
    - Browser receives fully rendered HTML, then JS hydrates it.
- How it works
    - User requests a page.
    - Server (Node.js in case of React/Next.js) renders HTML on the server.
    - Browser receives ready-made HTML → fast first load.
    - JS loads to add interactivity (hydration).
- Pros
    - Fast first page load
    - Great for SEO
    - Good for marketing pages, blogs, ecommerce, banking
- Cons
    - Requires a server (Node.js runtime)
    - More expensive hosting
    - More complex build & deployment

</details>

####
<details>
<summary> 🟩 What is an S3 Bucket? </summary>

- An Amazon S3 Bucket is:
    - A storage service on AWS
    - Used to host static files (HTML, CSS, JS, images, videos)
    - Often used for static website hosting
- What S3 CAN host
    - Static React/Vite builds
    - HTML/CSS/JS
    - Images/videos
    - Static websites
- What S3 CANNOT host
    - No server-side code
    - No Node.js
    - No backend rendering
    - No API logic
</details>

####
<details>
<summary> 🟩 SEO implementation </summary>

```html
<Head>
    <title>SEO Demo Page - Learn How SEO Tags Are Handled</title>
    <meta name="description" content="This page demonstrates how SEO tags are handled in a Next.js app." />
    <meta name="keywords" content="SEO, Next.js, SEO tags, meta tags, Open Graph" />
    <meta name="robots" content="index, follow" />
        
    {/* Open Graph Tags */}
    <meta property="og:title" content="SEO Demo Page - Learn How SEO Tags Are Handled" />
    <meta property="og:description" content="See how Next.js handles SEO tags with dynamic content!" />
    <meta property="og:image" content="https://via.placeholder.com/1200x630.png" />
    <meta property="og:url" content="http://localhost:3000/seo-demo" />

    {/* Twitter Card Tags */}
    <meta name="twitter:card" content="summary_large_image" />
    <meta name="twitter:title" content="SEO Demo Page - Learn How SEO Tags Are Handled" />
    <meta name="twitter:description" content="An example page to show how SEO tags are handled in Next.js." />
    <meta name="twitter:image" content="https://via.placeholder.com/1200x630.png" />
        
    {/* Additional meta tags for better SEO */}
    <meta name="author" content="Your Name" />
    <meta name="publisher" content="Your Company" />
</Head>
```

</details>

####
<details>
<summary> 🟩 SEO implementation </summary>

- Use Semantic HTML -> <h1>, <h2>, <form>, <input>, <label>, <nav>
- Provide Alt Text for Images
- Ensure Keyboard Accessibility -> tabindex, aria-label
- Provide Proper Color Contrast
- Use ARIA (Accessible Rich Internet Applications) Attributes -> aria-label, aria-hidden, aria-live

</details>

####
<details>
<summary> 🟩 Micro Frontend Architecture </summary>

- Micro Frontends is an architectural approach where a single application is split into multiple smaller, independent frontend applications. Each frontend application is responsible for a part of the user interface and can be developed, deployed, and scaled independently of the others.

- The main goal of micro frontends is to break down a monolithic frontend into smaller, more manageable pieces, similar to how microservices work in the backend. This approach allows multiple teams to work on different parts of the frontend simultaneously, enabling better scalability, faster development cycles, and improved maintenance.

- Key Concepts of Micro Frontends:
    - Independent Deployment: Each micro frontend is self-contained and can be deployed independently, reducing deployment complexity.
    - Separation of Concerns: Micro frontends divide the UI into different sections, which can be developed using different technologies or frameworks (React, Angular, Vue, etc.).
    - Team Ownership: Different teams can own different micro frontends, enabling them to work on them independently without affecting other parts of the application.
    - Integration via Composition: The smaller frontend applications are composed together to form the complete user interface.

- How It Works:
    - Micro frontends are usually implemented in one of the following ways:
        - URL-Based Routing: Different micro frontends are served based on different routes in the application.
        - Iframe-Based: Each micro frontend is loaded as an iframe, which isolates the application from others.
        - Web Components: Micro frontends are built as web components, which can be embedded into any part of the application.

- Advantages of Micro Frontends:
    - Scalability: Teams can work on independent parts of the application, allowing for easier scaling of the development process.
    - Technology Flexibility: Different micro frontends can use different technologies (e.g., one micro frontend can use React, while another uses Angular).
    - Faster Development & Deployment: Since micro frontends are independent, teams can deploy and update them without affecting the entire application.
    - Isolation: Bugs or issues in one micro frontend do not affect others, increasing stability.

- Challenges of Micro Frontends:
    - Complexity in Integration: Integrating multiple micro frontends into a seamless user experience can be complex.
    - Performance Overhead: Loading multiple independent frontends could lead to performance issues, especially when dealing with different frameworks.
    - Shared State Management: Handling state between different micro frontends can be tricky, as each part may have its own state.

</details>

####
<details>
<summary> 🟩 Module Federation </summary>

- Module Federation is a feature in Webpack 5 that allows the sharing of code between different JavaScript applications at runtime. It enables multiple applications or micro frontends to load and share code dynamically, allowing them to function as a single cohesive unit.

- The key concept of Module Federation is that it allows one application (known as the host application) to dynamically load and execute modules from other independent applications (known as remotes).

- How Module Federation Works:
    - Each application can expose some of its modules or components, which can then be shared with other applications (this is called the remote).
    - The host application can dynamically load these remote modules at runtime.
    - Both the host and the remote applications can use the same or different versions of dependencies.
    - Module Federation uses Webpack to manage and share dependencies and code across applications.

- Example Use Case of Module Federation:
    - Imagine you have two independent micro frontend applications:
    - Host Application (the main shell).
    - Remote Application (a smaller, independent feature like a product listing).

- The remote application (Product List) exposes its components via Module Federation. The host application dynamically loads these components at runtime as needed.

- Advantages of Module Federation:
    - Code Sharing: Modules can be shared across multiple applications, reducing the need for duplicate code.
    - Dynamic Loading: The host app can load only the parts of the application it needs, improving the performance and user experience.
    - Independence: The remote application can be developed and deployed independently from the host application.
    - Avoid Version Conflicts: Module Federation ensures that multiple versions of dependencies can coexist, eliminating the potential issues of versioning conflicts.

- Challenges of Module Federation:
    - Complex Configuration: Setting up Module Federation can be complex, especially in larger applications with multiple micro frontends.
    - Dependency Management: Managing shared dependencies and ensuring that they work seamlessly between remote and host applications can be tricky.
    - Performance: There can be some performance overhead when loading remote modules dynamically, especially for large applications.

</details>

####
<details>
<summary> 🟩 diff between webpack and vite </summary>

- Webpack: Think of Webpack like a chef who prepares all dishes first, then serves the meal.
    - It reads all files, builds a big dependency graph, Bundles everything into final JS/CSS before starting the server, So when you change something, it needs to rebuild a lot → slow reloads
- Vite: Vite is like a chef who cooks only what you order right now, not the whole menu.
    - It doesn’t bundle everything upfront, Uses browser’s native ES modules — loads only the file you’re viewing, When you edit a file, it reloads only that file, not the full app → blazing fast.

</details>

####
<details>
<summary> 🟩 consume a app through through remote entry </summary>

- Remote App -> vite.config.js
```js
import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";
import federation from "@originjs/vite-plugin-federation";

export default defineConfig({
  plugins: [
    react(),
    federation({
      name: "remoteApp",
      filename: "remoteEntry.js", // remote entry that host will import dynamically.
      exposes: { // components you want to share.
        "./Button": "./src/components/Button.jsx",
      },
      shared: ["react", "react-dom"],
    }),
  ],
  server: { port: 3001 },
});
```

- Host App -> vite.config.js
```js
import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";
import federation from "@originjs/vite-plugin-federation";

export default defineConfig({
  plugins: [
    react(),
    federation({
      name: "hostApp",
      remotes: {
        remoteApp: "http://localhost:3001/assets/remoteEntry.js",
      },
      shared: ["react", "react-dom"],
    }),
  ],
  server: { port: 3000 },
});
```

- Consuming Remote Component -> HostApp.jsx
```js
import React from "react";

const RemoteButton = React.lazy(() => import("remoteApp/Button"));

function App() {
  return (
    <div>
      <h1>Host App (Vite)</h1>
      <React.Suspense fallback={<div>Loading Remote Button...</div>}>
        <RemoteButton />
      </React.Suspense>
    </div>
  );
}

export default App;
```

</details>

####
<details>
<summary>🟩 Jenkins (CI/CD Tool):</summary>

- Jenkins is an open-source automation server used for Continuous Integration (CI) and Continuous Deployment (CD). It automates the process of building, testing, and deploying code. Jenkins helps developers by automatically running tests, generating build artifacts, and deploying applications with every code change. It integrates with version control systems like Git and supports a wide range of plugins for tasks such as testing, code quality analysis, and deployment. Jenkins improves development speed, ensures code quality, and reduces human errors by automating repetitive tasks.

</details>

####
<details>
<summary>🟩 Artifactory (Repository Manager):</summary>

- Artifactory is a repository manager that stores and manages software artifacts (like JAR files, Docker images, or npm packages). It acts as a central hub for storing versions of artifacts and dependencies, ensuring teams can reuse and share code efficiently. Artifactory supports various package formats and integrates with CI/CD tools like Jenkins. By versioning and controlling dependencies, Artifactory ensures consistency across environments, facilitating easier collaboration between teams and enabling smoother, reliable software delivery.

</details>