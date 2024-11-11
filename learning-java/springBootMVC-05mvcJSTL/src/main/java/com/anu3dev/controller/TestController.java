package com.anu3dev.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	// http://localhost:8090/home
	@GetMapping("/home")
	public String showHome() {
		return "home";
	}
	
	// http://localhost:8090/response
	@GetMapping("/response")
	public String showResponse(Map<String, Object> map){
		String []booksName = new String[] { "Java", "Spring Boot", "JUnit" };
		map.put("books", booksName);
		return "response";
	}
}
