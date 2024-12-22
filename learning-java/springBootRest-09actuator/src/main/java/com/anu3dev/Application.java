package com.anu3dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

/* 
 * 
 * Developing and Managing an application are the two most important aspects of 
 * the application’s life cycle. It is very crucial to know what’s going on beneath 
 * the application. Also when we push the application into production, managing 
 * it gradually becomes critically important. 
 * Therefore, it is always recommended to monitor the application both while at the 
 * development phase and at the production phase. 
 * 
 * Advantages of Actuator the Application- 
 * It increases customer satisfaction.
 * It reduces down time.
 * It boosts productivity.
 * It improves Cyber security Management.
 * It increases the conversion rate.
 * 
 * http://localhost:8284/actuator - actuator path
 * 
 */