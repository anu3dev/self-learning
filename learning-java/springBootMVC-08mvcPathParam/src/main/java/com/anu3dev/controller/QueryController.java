package com.anu3dev.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QueryController {
	// http://localhost:8090/
	@GetMapping
	public String displayDefaultMessage(Model model) {
		model.addAttribute("message", "Welcome Alien!");
		return "index";
	}
	
	// http://localhost:8090/student/anurag
	@GetMapping("/student/{name}")
	public String displayUserMessage(@PathVariable("name")String name, Model model) {
		String msg = "Welcome " + name + "!";
		model.addAttribute("message", msg);
		return "index";
	}
	
	// http://localhost:8090/student/anurag/admin
	@GetMapping("/student/{name}/{role}")
	public String displayAdminMessage(@PathVariable("name")String name, @PathVariable("role")String role, Map<String, Object> map) {
		String msg = "Welcome " + name + " and role is " + role + "!";
		map.put("message", msg);
		return "index";
	}
}
