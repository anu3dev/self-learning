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
<summary> 🟩 activate a profile </summary>

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
<summary> 🟩 autowiring in java </summary>

Spring automatically injects (provides) the required dependency object into a class, instead of you creating it manually using new.

```java
// manually created
private Engine engine = new Engine();

// Spring will inject it automatically
@Autowired
private Engine engine;
```

- Key Points
    - @Autowired -> Tells Spring to inject (wire) the dependency automatically
    - @Component / @Service / @Repository -> Marks a class as a Spring Bean (managed by Spring container)
    - IOC (Inversion of Control) -> Spring manages the object lifecycle, not you
    - DI (Dependency Injection) -> Injecting dependencies automatically (via constructor, field, or setter)
- Common Autowiring Types
    - Field Injection -> @Autowired private Engine engine;
    - Constructor Injection ->	public Car(Engine engine);
    - Setter Injection -> setEngine(Engine engine);

- Constructor Injection Example
```java
@Component
public class Car {
    private final Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }
}

```

</details>



####
<details>
<summary> 🟩 Serializable in java </summary>

- Serialization	=> Converting object → byte stream → Packing your object into a suitcase of bytes
- Deserialization => Converting byte stream → object → Unpacking it back into a Java object

- It simply tells the Java Virtual Machine (JVM) that objects of this class can be converted into a byte stream.

```java
import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;

    // constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // getter
    public String getName() {
        return name;
    }
}
```

- Java objects exist only in memory (RAM) while the program is running. If you want to Save the object somewhere (like in a file or database), or Send the object to another system (like over a network or via API), then you must convert that object into a format that can travel or be stored. That’s where serialization comes in.

</details>




####
<details>
<summary> 🟩 join in java </summary>

join() is a Thread method in Java that lets one thread wait for another thread to finish before continuing.

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t1.join();   // main thread waits for t1 to finish

        t2.start();  // this runs only after t1 is done

        System.out.println("Main thread ends");
    }
}

```

</details>

####
<details>
<summary> 🟩 join in sql </summary>

A JOIN in SQL is used to combine data from two or more tables
based on a related column between them (usually a key like id).

- INNER JOIN -> Returns rows that have matching values in both tables.

```sql
SELECT e.emp_name, d.dept_name
FROM employees e
INNER JOIN departments d
ON e.dept_id = d.dept_id;
```

- LEFT JOIN -> Returns all rows from the left table, and matching rows from the right table.

```sql
SELECT e.emp_name, d.dept_name
FROM employees e
LEFT JOIN departments d
ON e.dept_id = d.dept_id;
```

- RIGHT JOIN -> Opposite of LEFT JOIN -> Returns all rows from the right table and matching ones from left.

```sql
SELECT e.emp_name, d.dept_name
FROM employees e
RIGHT JOIN departments d
ON e.dept_id = d.dept_id;
```

- FULL JOIN -> Returns all records from both tables, with NULLs where there’s no match.

```sql
SELECT e.emp_name, d.dept_name
FROM employees e
FULL OUTER JOIN departments d
ON e.dept_id = d.dept_id;
```

- CROSS JOIN -> Returns all possible combinations (Cartesian Product).

```sql
SELECT e.emp_name, d.dept_name
FROM employees e
CROSS JOIN departments d;
```

- SELF JOIN -> A table joins with itself (useful for hierarchy, manager-employee).

```sql
SELECT e1.emp_name AS Employee, e2.emp_name AS Manager
FROM employees e1
JOIN employees e2
ON e1.manager_id = e2.emp_id;
```

| Join Type | Description | Visual |
|------------|--------------|--------|
| **INNER JOIN** | Matching rows only | 🔵🟢 overlap |
| **LEFT JOIN** | All left + matching right | 🔵🟢 (keep all 🔵) |
| **RIGHT JOIN** | All right + matching left | 🟢🔵 (keep all 🟢) |
| **FULL JOIN** | All rows from both | 🔵 + 🟢 |
| **CROSS JOIN** | Every combination | 🔵×🟢 |
| **SELF JOIN** | Table joins itself | 🔵↔🔵 |

</details>

####
<details>
<summary> 🟩 diff between @Component / @Service / @Repository </summary>

All three are Spring-managed beans — they tell Spring to automatically detect and register the class in the ApplicationContext using component scanning.

- @Repository -> Marks DAO classes that interact with databases.
- @Service -> Marks business logic classes. Helps express “this class contains business rules or service logic.”
- @Component -> General-purpose bean. Used when a class doesn’t fit into service or repository layers.

```java
@Repository
public class UserRepository {
    // Handles DB operations
}

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    // Business logic
}

@Component
public class Utility {
    // General helper methods
}
```

- @Component, @Primary, and @Qualifier

```java
@Component
class EmailService implements MessageService {
    public void send() { System.out.println("Sending Email..."); }
}

@Component
class SMSService implements MessageService {
    public void send() { System.out.println("Sending SMS..."); }
}

@Service
class NotificationService {
    @Autowired
    private MessageService messageService; // ❌ Error! Two beans found
}

// Solution 1: Use @Primary
@Component
@Primary
class EmailService implements MessageService {
    public void send() { System.out.println("Sending Email..."); }
}

// Solution 2: Use @Qualifier
@Service
class NotificationService {
    @Autowired
    @Qualifier("SMSService")  // Bean name or custom qualifier
    private MessageService messageService;
}

```

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
<summary> 🟩 solid principle </summary>

- S – Single Responsibility Principle (SRP): A class should have only one reason to change.
- O – Open/Closed Principle (OCP): Software entities should be open for extension, but closed for modification.
- L – Liskov Substitution Principle (LSP): Subtypes must be replaceable for their base types without breaking the program.
- I – Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they don’t use.
- D – Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules; both should depend on abstractions.

</details>