/**
 * Singleton Pattern
 * 
 * Suppose you have `Database Connection` If every class does `Database db = new Database();`
 * You'll create hundreds of connections. Memory wasted. Resources wasted.
 * 
 * Instead, There should only be ONE object shared everywhere. That's Singleton.
 * 
 * Real World Example
 * CEO of a company - There is only one CEO. Everyone refers to the same person. Nobody creates another CEO.
 */


package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
