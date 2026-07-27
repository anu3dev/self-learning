/**
 * Factory Pattern
 * 
 * Suppose you have a notification system.
 * 
 * EmailNotification email = new EmailNotification();
 * SMSNotification sms = new SMSNotification();
 * PushNotification push = new PushNotification();
 * 
 * Every client decides which concrete class to instantiate.
 * 
 * Problems:
 * Tight coupling
 * Hard to add new notification types
 * Repeated new logic everywhere
 * 
 * The Factory pattern centralizes object creation.
 * Step 1: Product Interface
 * Step 2: Concrete Products
 * Step 3: Factory
 */


package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		INotification notificationEmail = NotificationFactory.create("EMAIL");
		notificationEmail.send("Welcome");
		
		INotification notificationSMS = NotificationFactory.create("SMS");
		notificationSMS.send("Welcome");
	}
}


/**
 * Benefits -
 * Client depends on the interface, not concrete classes.
 * Easy to introduce new implementations.
 * Centralized creation logic.
 * Spring Boot Connection
 * 
 * Spring itself is full of factory-based APIs:
 * BeanFactory
 * ApplicationContext
 * FactoryBean<T>
 */
