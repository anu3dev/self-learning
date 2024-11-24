package com.anu3dev.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

/*
 * dependencies =>
 * Spring Data JPA
 * Spring Web
 * H2 Database
 * 
 * @Component
 * We can use @Component across the application to mark the 
 * beans as Spring’s managed components.
 * 
 * @Repository
 * job is to catch persistence-specific exceptions and re-throw them as one of 
 * Spring’s unified unchecked exceptions
 * 
 * @Service
 * We mark beans with @Service to indicate that they’re holding the business logic. 
 * 
 * @Entity
 * Entities in JPA are nothing but POJOs representing data that can be 
 * persisted in the database.
 */