/**
 * What is SpringApplication.run() actually doing?
 * Application Starts --> Reads @SpringBootApplication --> Scans Entire Project --> Finds Beans --> Creates Objects --> 
 * Injects Dependencies --> Starts Embedded Server --> Application Ready
 * 
 * 
 * How does Spring know OrderService exists?
 * through Component Scanning.
 * looks for @Component, @Service, @Repository, @Controller, @RestController, whenever it finds, it creates bean.
 * 
 * 
 * How many EmailService objects exist?
 * Singleton by Default, it creates only one, Every class shares it
 * 
 * 
 * What is Dependency Injection?
 * instead of creating objects from classes with new keyword, With Spring it can be done using @Autowired
 * 
 * @Autowired
 * EmailService email;
 * 
 * Who creates EmailService? --> Spring. Who assigns it? --> Spring.
 * This assignment is called Dependency Injection
 * 
 * 
 * Bean Life cycle
 * Container Starts --> Create Bean --> Inject Dependencies --> Initialize Bean --> Bean Ready --> 
 * Application Running --> Destroy Bean --> Container Stops
 * 
 * 
 * Dependency Injection (DI) in Spring can be done in three ways.
 * Constructor Injection (Recommended)
 * Setter Injection
 * Field Injection ❌ (Not Recommended)
 * 
 * 
 * Spring supports Constructor Injection, Setter Injection, and Field Injection. Constructor Injection is the recommended 
 * approach because it makes dependencies mandatory, supports immutability, and is easier to test.
 * 
 * 
 * What is IoC Container?
 * The Spring container that creates, manages, injects, and destroys beans.
 * 
 * 
 * Spring Boot Startup Cheat Sheet
 * Application Starts --> @SpringBootApplication --> Component Scan --> Create Bean --> Dependency Injection --> Bean Initialization --> 
 * @PostConstruct --> Bean Ready --> Application Running --> @PreDestroy --> Bean Destroyed --> Application Shutdown
 * 
 * 
 * Every Spring Boot company follows 3-Layer Architecture
 * Browser --> Controller --> Service --> Repository --> Database --> Repository --> Service --> Controller --> Browser
 * 
 * 
 * Real Layer Responsibilities
 * Controller --> HTTP Request & Response
 * Service --> Business Logic
 * Repository --> Database Operations
 * 
 * 
 * Real Company Folder Structure
 */



/*
Project Structure

src
└── main
    └── java
        └── com.company.employee
            ├── controller
            │     └── EmployeeController.java
            │
            ├── service
            │     └── EmployeeService.java
            │
            ├── repository
            │     └── EmployeeRepository.java
            │
            ├── entity
            │     └── Employee.java
            │
            ├── dto
            │     └── EmployeeDTO.java
            │
            ├── exception
            │     └── CustomException.java
            │
            ├── config
            │     └── AppConfig.java
            │
            └── DemoApplication.java
*/

/*
Spring Boot Project Structure

com.company.employee
│
├── controller   -> REST APIs
├── service      -> Business Logic
├── repository   -> Database Access
├── entity       -> Database Tables
├── dto          -> Request/Response Objects
├── exception    -> Custom Exception Handling
├── config       -> Spring Configuration
└── DemoApplication.java
*/


/**
 * Why do we need a Service layer?
 * To keep business logic separate from HTTP handling and database access.
 * 
 * Why shouldn't Controller access Repository directly?
 * Because business logic, validation, caching, logging, transactions, and security belong in the Service layer.
 * 
 * What is an Entity?
 * A class that maps to a database table.
 * 
 * What is a DTO?
 * A Data Transfer Object used to send or receive data between the client and server.
 * 
 * 
 * flow should be
 * main() --> Controller --> Service --> Repository --> Database --> Repository --> Service --> Return List<Employee> --> 
 * Convert to EmployeeDTO --> Print Result
 * 
 * 
 * to get response in JSON format, spring boot by default uses Jackson
 * 
 * 
 * HTTP Methods
 * GET --> Read
 * POST --> Create
 * PUT --> Update Entire Resource
 * PATCH --> Partial Update
 * DELETE --> Delete
 * 
 * 
 * HTTP Status Codes
 * 200	Success
 * 201	Created
 * 204	No Content
 * 400	Bad Request
 * 404	Not Found
 * 500	Internal Server Error
 * 
 * 
 * Why ResponseEntity<T>?
 * Instead of returning only data, return Data + HTTP Status + Headers
 * 
 * instead of this ->
 * @GetMapping("/{id}")
 * public EmployeeDTO getEmployee(){}
 * 
 * use ->
 * @GetMapping("/{id}")
 * public ResponseEntity<EmployeeDTO> getEmployee(){}
 * 
 * Successful Response ->
 * return ResponseEntity.ok(employeeDTO);
 * http --> 200 OK
 * Response --> {"id":1, "name":"anurag"}
 * 
 * Created Response ->
 * return ResponseEntity.status(HttpStatus.CREATED).body(dto);
 * http -> 200
 * Response --> 201 Created
 * 
 * Delete Response
 * Delete Response
 * http -> 200
 * Response --> 204 No Content
 * 
 * 
 * Custom Exception
 * @ControllerAdvice - handle every controller
 * Global Exception Handler
 * @Valid - validate client response
 * 
 * 
 * Complete Production Flow
 * Client --> HTTP Request --> DispatcherServlet --> @RestController --> @Valid --> DTO --> Service --> Repository --> 
 * Database --> Entity --> Repository --> Service --> Entity → DTO Mapping --> Controller --> ResponseEntity --> JSON --> Client
 * 
 * 
 * Why @ControllerAdvice?
 * To handle exceptions globally instead of repeating try-catch blocks.
 * 
 * Why @Valid?
 * To automatically validate incoming request data.
 * 
 * Why Custom Exceptions?
 * To make business errors meaningful and easier to handle.
 * 
 * Why not expose stack traces? 
 * Security. Clients should receive business-friendly messages, not internal implementation details.
 */


/**
 * Module 1 — Spring Stereotype Annotations
 * 
 * @SpringBootApplication ---> Application Starts --> @SpringBootApplication --> Component Scan --> Scan Base Packages --> 
 * Detect Spring Beans --> Create Bean Objects --> Perform Dependency Injection --> Store Beans in IoC Container --> Application Ready
 * 
 * @Component (parent stereotype) ---> Spring, Please create an object of this class. Manage it. Store it inside IoC Container.
 * 
 * @Service (inherited from @Component) ---> Represents Business Logic
 * 
 * @Repository (inherited from @Component) ---> Represents Database Layer
 * Special Feature of @Repository ---> Suppose Database throws SQLException Spring automatically converts it into DataAccessException 
 * called Exception Translation
 * 
 * @Controller (inherited from @Component) ---> Used in Spring MVC Returns HTML Page
 * 
 * @RestController (inherited from @Controller) ---> Instead of HTML returns JSON
 * @RestController is internally @Controller + @ResponseBody
 */

/**
 * Module 2 - Complete HTTP Request Life cycle
 * 
 * Browser/Postman --> Embedded Tomcat --> DispatcherServlet --> Handler Mapping --> @RestController --> Service --> Repository --> 
 * Database --> Entity --> Repository --> Service --> Entity → DTO --> Jackson --> JSON Response --> Browser/Postman
 */


/**
 * example
 * 
 * @RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(
            @PathVariable Long id) {

        return employeeService.getEmployee(id);
    }

    @PostMapping
    public EmployeeDTO createEmployee(
            @RequestBody EmployeeDTO dto) {

        return employeeService.save(dto);
    }

    @GetMapping("/search")
    public List<EmployeeDTO> search(
            @RequestParam String department) {

        return employeeService.search(department);
    }

    @GetMapping("/profile")
    public String profile(
            @RequestHeader("Authorization")
            String token) {

        return "Token = " + token;
    }
}
 */

/**
 * What is DispatcherServlet?
 * The front controller of Spring MVC. Every HTTP request first reaches the DispatcherServlet, which finds the appropriate 
 * controller and coordinates request processing.
 * 
 * What is HandlerMapping?
 * A Spring MVC component that maps an incoming HTTP request (URL + HTTP method) to the correct controller method.
 */


/**
 * Module 3 - Response & JSON Processing
 * 
 * Most Used Methods
 * ok() --> return ResponseEntity.ok(dto); --> 200 OK
 * status() --> return ResponseEntity.status(HttpStatus.CREATED).body(dto); --> 201 Created
 * noContent() --> return ResponseEntity.noContent().build(); --> 204 No Content
 * badRequest() --> return ResponseEntity.badRequest().body("Invalid Request"); --> 400 Bad Request
 * notFound() --> return ResponseEntity.notFound().build(); --> 404 Not Found
 * 
 * 
 * 
 * Jackson is a Java library.
 * Its job is convert Java Object to JSON and JSON to Java Object automatically
 * 
 * Serialization -> Jackson convert Java object to JSON using Serialization process
 * Deserialization -> Jackson convert JSON to Java object using Deserialization process
 * 
 * @JsonIgnore - can be used to hide some fields in DTO
 * @JsonProperty - Suppose frontend wants employee_name instead of name --> @JsonProperty("employee_name")
 * @JsonFormat - use @JsonFormat(pattern="dd-MMM-yyyy") to format date
 */


/**
 * Module 1 — Why Spring Data JPA Exists
 * 
 * ORM means Object Relational Mapping
 * Object --> Java Object
 * Relational --> Relational Database
 * Mapping --> Convert between both.
 * 
 * JPA is a Specification
 * Interface doesn't implement anything. Someone implements it. Same with JPA.
 * JPA Defines Rules, It says - An ORM must support Save Object, Update Object, Delete Object, Find Object, Relationships, Transactions 
 * 	But JPA itself doesn't implement them.
 * 
 * Then Who Implements JPA?
 * Several frameworks, Most popular is Hibernate and Others are EclipseLink, OpenJPA
 * 
 * What is Hibernate?
 * Hibernate is JPA Implementation Meaning It actually writes SQL.
 * 
 * JDBC	 -> Talks directly to database
 * JPA	-> Specification (rules/API)
 * Hibernate -> JPA implementation
 * Spring Data JPA	-> Makes Hibernate easier to use
 * 
 * Instead of EntityManager, write -> public interface EmployeeRepository extends JpaRepository<Employee,Long>{}
 * 
 * 
 * What is ORM?
 * A technique that maps Java objects to relational database tables and vice versa.
 * 
 * Is JPA an ORM?
 * No. JPA is a specification that defines how ORM frameworks should work.
 * 
 * What is Hibernate?
 * Hibernate is the most popular implementation of the JPA specification.
 * 
 * What is Spring Data JPA?
 * A Spring project that simplifies database access by providing repository interfaces and integrating with JPA implementations like Hibernate.
 * 
 * Controller --> Service --> Repository --> Spring Data JPA --> Hibernate --> JPA Specification --> JDBC Driver --> SQL Query --> 
 * 	Database --> Result --> Entity --> Service --> Controller --> Response
 */


/**
 * @Entity - This Java class represents a database table.
 * 
 * @Table(name="employee_master")
 * 
 * @Id - Primary Key
 * 
 * @GeneratedValue(strategy=GenerationType.IDENTITY)
 * IDENTITY	- MySQL
 * SEQUENCE	- Oracle/PostgreSQL
 * AUTO	- Hibernate chooses
 * UUID	- Distributed systems
 * 
 * @Column(name="employee_name")
 */

/**
 * @Entity

@Table(name="employees")

public class Employee{

    @Id

    @GeneratedValue(
        strategy=GenerationType.IDENTITY)

    private Long id;

    @Column(nullable=false)

    private String name;

    @Column(length=50)

    private String department;

    @Column

    private double salary;

}
 */

/**
 * What is Persistence Context?
 * A memory area managed by Hibernate that stores managed entities during a transaction. 
 * It tracks changes and serves as the first-level cache.
 * 
 * What is the First-Level Cache?
 * The Persistence Context itself. Within the same transaction, repeated lookups of the 
 * same entity are served from memory instead of querying the database again.
 * 
 * What is Dirty Checking?
 * Hibernate automatically detects changes made to managed entities and generates the 
 * required UPDATE statements during transaction commit without requiring an explicit 
 * update call.
 */


/**
 * Module 3 — Entity Relationships
 * 
 * @Entity
	public class User{
	    @Id
	    private Long id;
	    
	    private String name;
	    
	    @OneToMany(mappedBy="user")
	    private List<Order> orders;
	}
 * 
 * @Entity
	public class Order{
	    @Id
	    private Long id;
	
	    private double amount;
	
	    @ManyToOne
	    private User user;
	}
 */


/**
 * Relationship Summary
 * @OneToOne	--> Person → Passport
 * @OneToMany	--> User → Orders
 * @ManyToOne	--> Order → User
 * @ManyToMany	--> Student ↔ Course
 */

/**
 * Eager loading {Load Immediately} --> @OneToMany( fetch=FetchType.EAGER )
 * 
 * Lazy loading (Load only if needed) --> @OneToMany( fetch=FetchType.LAZY )
 * 
 * 
 * 
 * Difference between @OneToMany and @ManyToOne?
 * @OneToMany				- @ManyToOne
 * Parent side				- Child side
 * Collection				- Single object
 * Usually inverse side		- Usually owning side
 * 
 * 
 * What is mappedBy?
 * It tells Hibernate that this side does not own the relationship. The relationship is managed by the field specified in mappedBy.
 * 
 * Which side owns the relationship?
 * The side that contains the foreign key.
 * 
 * Why use FetchType.LAZY?
 * To avoid loading unnecessary related data, improving performance and reducing memory usage.
 * 
 * What does CascadeType.ALL do?
 * It propagates all persistence operations (persist, merge, remove, refresh, detach) from the parent entity to its child entities.
 */



package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
