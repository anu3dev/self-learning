package com.sb.springMVC.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/home")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/response")
	public String showResponse(Map<String, Object> map){
		String []booksName = new String[] { "Java", "Spring Boot", "JUnit" };
		map.put("books", booksName);
		return "response";
	}
}
