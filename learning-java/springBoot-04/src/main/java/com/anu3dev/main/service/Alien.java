package com.anu3dev.main.service;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Alien {
	static {
		System.out.println("static block - Alien Bean");
	}
	
	{
		System.out.println("Instance Block - Alien Bean");
	}
	
	public Alien(){
		System.out.println("Constructor block - Alien Bean");
	}
	
	@PostConstruct
	public void init(){
		System.out.println("@PostConstruct method of Alien");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("@PreDestroy - Bean Destroyed");
	}
	
	public void disp(){
		System.out.println("Business logic of Alien class");
	}
	
}
