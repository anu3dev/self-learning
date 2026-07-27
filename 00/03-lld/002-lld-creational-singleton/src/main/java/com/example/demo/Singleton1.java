package com.example.demo;

/**
 * Is below example thread safe -> no
 * Imagine Thread A `instance == null` -> true
 * Imagine Thread B `instance == null` -> true
 * both is true so both will create object and now Singleton gets broken
 */

public class Singleton1 {
	private static Singleton1 instance;
	
	private Singleton1() {}
	
	public static Singleton1 getInstance() {
		if(instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}
