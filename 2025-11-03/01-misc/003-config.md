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
