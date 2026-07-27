package com.example.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Double Checked Locking - is optimized solution
 * Without the second check:
 * Thread A creates object 
 * Thread B - gets lock later 
 * creates second object
 * 
 * 
 * Object creation is NOT one step. Actually:
 * 1 - Allocate memory
 * 2 - Initialize object
 * 3 - Assign reference
 * 
 * volatile - prevents this reordering and guarantees visibility between threads.
 * With volatile, Initialization must finish before the reference becomes visible.
 * 
 * 
 * why don't companies always use enum?
 * Because Sometimes Singleton must extend another class. Enums cannot. Sometimes frameworks require normal classes.
 * 
 * 
 * by default, `@Service` beans in Spring are Singleton scoped.
 * Spring creates one instance per Spring IoC container, not one instance per JVM
 * 
 * Is @Service always Singleton?
 * No. @Service is only a stereotype annotation.
 * The scope depends on @Scope.
 */

@Service
class UserService1 {
	// by default it is singleton scoped
}

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class UserService2 {
	// Every request for the bean gets a new object.
	// context.getBean(UserService.class); // Object 1
	// context.getBean(UserService.class); // Object 2
}

@Service
@RequestScope
class UserService3 {
	// One object per HTTP request.
	// Request 1 → Object A
	// Request 2 → Object B
}

@Service
@SessionScope
class UserService4 {
	// One object per user session.
}

/**
 * Why does Spring choose Singleton by default?
 * Most service classes are stateless.
 */


public class Singleton3 {
	private static volatile Singleton3 instance;
	
	private Singleton3() {}
	
	public static Singleton3 getInstance() {
		if(instance == null) {
			synchronized (Singleton3.class) {
				if(instance == null) {
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}
}


/**
 * Q1 Difference between Singleton and Static?
 * Singleton - Object exists
 * Static - No object required
 * 
 * Singleton can - implement interface, extend class, lazy initialize, dependency inject
 * Static cannot.
 * 
 * Q2 Can Singleton have constructor?
 * Yes, Private constructor.
 * 
 * Q3 Can reflection break Singleton?
 * Yes. Reflection can access private constructor. Need safeguards or enum.
 * 
 * Q4 Can serialization break Singleton?
 * Yes. Deserialization creates new object. Need readResolve()
 * 
 * Q5
 * Spring Singleton vs Design Pattern Singleton?
 * Spring - One object per IoC container.
 * Design Pattern - One object per JVM/ClassLoader (with caveats).
 * Not exactly same.
 */
