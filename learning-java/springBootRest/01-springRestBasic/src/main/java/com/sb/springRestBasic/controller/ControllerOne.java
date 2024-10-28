package com.sb.springRestBasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/one")
public class ControllerOne {
	// normal end point which will return string value.
	// http://localhost:8090/one/message1
	@GetMapping("/message1")
	public String generateGreetings1() {
		String text = "Hello world!";
		return text;
	}
	
	// normal end point which will return string value and will take name pay-load as required.
	// http://localhost:8090/one/message2?name=Anu
	@GetMapping("/message2")
	public String generateGreetings2(@RequestParam("name") String name) {
		String text = "Hello " + name + "!";
		return text;
	}
	
	// normal end point which will return string value and will take name payload as not required.
	// http://localhost:8090/one/message3
	// http://localhost:8090/one/message3?name=Anu
	@GetMapping("/message3")
	public String generateGreetings3(@RequestParam(value = "name", required = false) String name) {
		String text = "Hello " + name + "!";
		return text;
	}
	
	// normal end point which will return string value and will take name payload as required from url.
	// http://localhost:8090/one/message4/anurag
	@GetMapping("/message4/{name}")
	public String generateGreetings4(@PathVariable(value = "name") String name) {
		String text = "Hello " + name + "!";
		return text;
	}
}
