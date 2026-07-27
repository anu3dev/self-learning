package com.example.demo;

/**
 * this is thread safe but every call acquires a lock even after object already exists so performance suffers.
 */

public class Singleton2 {
	private static Singleton2 instance;
	
	private Singleton2() {}
	
	public static synchronized Singleton2 getInstance() {
		if(instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}
}
