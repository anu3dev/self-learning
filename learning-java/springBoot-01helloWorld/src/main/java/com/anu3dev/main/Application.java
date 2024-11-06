package com.anu3dev.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anu3dev.main.model.Student;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		
		/*
		 * 
		 * SB is indirectly calling ApplicationContext here, first it is calling 
		 * ConfigurableApplicationContext, and inside ConfigurableApplicationContext, 
		 * ApplicationContext is being called.
		 * since it is ApplicationContext, eager loading will be there.
		 * 
		 * below is example of object creation like plain java way, manually we are creating objects.
		 * 
		 */
		SpringApplication.run(Application.class, args);
		
		Student student1 = new Student();
		System.out.println(student1);
		
		Student student2 = new Student();
		student2.setId(1);
		student2.setName("anu");
		student2.setAge(29);
		student2.setCity("patna");
		System.out.println(student2);
	}
}

/*
 *
 * @SpringBootApplication - provides a convenient entry point for Spring Boot application.
 * behind the scene, it calls below annotations.
 *
 *
 * @Configuration - annotation indicates that the class contains configuration methods that should be processed 
 * by the Spring container during application startup. 
 * Configuration classes in Spring Boot are used to define beans and configure various aspects of the application.
 * 
 * @EnableAutoConfiguration - annotation enables Spring Boot’s auto-configuration mechanism. Auto-configuration 
 * automatically configures the Spring application based on the dependencies present in the class path. 
 * It helps eliminate boilerplate configuration and provides sensible defaults for various components.
 * 
 * @ComponentScan - annotation enables component scanning for the specified packages. Component scanning is a process
 * where Spring discovers and registers beans (components, services, controllers, etc.) in the application context. 
 * By default, it scans the package of the class with the @SpringBootApplication annotation and its sub-packages.
 * 
 * @SpringBootConfiguration - annotation is a specialized form of @Configuration specifically designed for Spring Boot. 
 * It is a meta-annotation that extends the functionality of @Configuration and provides additional features related 
 * to Spring Boot’s conventions.
 *
 */

/*
 * 
 * @Component - is a stereotype class-level annotation, it is used to denote a class as a Component.
 * have to add @Component annotation if we want to call this class from ApplicationContext.
 * component is a general-purpose object that is managed by the Spring IoC container.
 * 
 * A Spring IoC container is a program that injects dependencies into objects, making them 
 * ready for use. It's part of the Spring Framework and is based on the 
 * Inversion of Control (IoC) principle, also known as dependency injection (DI).
 * 
 */