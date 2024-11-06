package com.anu3dev.main.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	public Employee(){
		
		/*
		 * 
		 * Employee constructor will be printed even without being called due to 
		 * @Component annotation, we don't need to call this class manually, it 
		 * will be handled by application context.
		 * 
		 */
		System.out.println("employee bean created.");
	}
}
