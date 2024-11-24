package com.anu3dev.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.anu3dev.model.Employee;

@Controller
public class RegisterController {
	// http://localhost:8090/register
	@GetMapping("/register")
	public String responseHome(){
		return "register";
	}
	
	@PostMapping("/register")
	public String registerdata(Map<String, Object> map, @ModelAttribute("emp")Employee employee){
		map.put("employee", employee);
		return "result";
	}
}