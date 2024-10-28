package com.sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatorsController {
	@GetMapping("/wish")
	public String SomeWish() {
		return "java course...!";
	}
}
