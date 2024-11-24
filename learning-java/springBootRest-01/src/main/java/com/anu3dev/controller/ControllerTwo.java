package com.anu3dev.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RestController is similar to @Controller
@RequestMapping("/two")
public class ControllerTwo {
	// http://localhost:8090/two/greet
	@GetMapping("/greet")
	@ResponseBody
	public ResponseEntity<String> generateGreetings() {
		LocalDateTime dateTime = LocalDateTime.now();
		int hour = dateTime.getHour();
		String body = null;
		if(hour < 12)
			body = "Good morning...!";
		else if(hour < 16)
			body = "Good afternoon...!";
		else if(hour < 20)
			body = "Good evening...!";
		else
			body = "Good night...!";
		ResponseEntity<String> responseBody = new ResponseEntity<>(body, HttpStatus.OK);
		return responseBody;
	}
}
