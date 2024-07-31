package com.sb.springMVC.controller.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class GreetService implements IGreetings {
	@Override
	public String greetMe() {
		LocalDateTime dateTime = LocalDateTime.now();
		int hour = dateTime.getHour();
		
		if(hour < 12)
			return "Good morning!";	
		else if(hour < 16)
			return "Good afternoon!";
		else if(hour < 20)
			return "Good evening!";
		return "Good night!";
	}
}
