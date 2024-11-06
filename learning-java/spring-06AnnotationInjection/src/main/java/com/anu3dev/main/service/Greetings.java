package com.anu3dev.main.service;

import org.springframework.stereotype.Service;

@Service
public class Greetings {
	public Greetings(){
		System.out.println("Greetings bean created");
	}
	
	public String generateGreeeting(String name) {
		return "Good wishes to you "+ name;
	}
}
