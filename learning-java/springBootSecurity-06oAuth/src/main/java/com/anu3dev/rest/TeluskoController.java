package com.anu3dev.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeluskoController{

	// http://localhost:8080/info
	@GetMapping("/info")
	public String getCourseInfo(){
		return "Telusko has Launched DevOps with AWS Course";
	}
}
