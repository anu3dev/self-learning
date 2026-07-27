/**
 * Builder Pattern
 * Consider a User with many optional fields.
 * Creating it with constructors becomes messy. like new User("Anurag", 35, "a@test.com", "9999999999", "Minneapolis");
 * What if there are 15 optional fields?
 * 
 * The Builder pattern provides a readable, fluent way to construct objects.
 * Step 1: Private Constructor
 * Step 2: Builder Class
 */


package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		User user = new User.Builder()
		        .name("Anurag")
		        .age(35)
		        .email("anurag@test.com")
		        .build();

		System.out.println(user.getName()); // Anurag
	}
}


/**
 * This is the most important part of the Builder pattern. - private constructor
 * Because it is private, this is not allowed:
 * User u = new User();
 * This forces every object to be created through the builder.
 * 
 * Builder is static so it can be created without first creating a User object, avoiding circular dependency.
 * This is called a fluent API because each method returns the builder itself, allowing chained calls.
 */
