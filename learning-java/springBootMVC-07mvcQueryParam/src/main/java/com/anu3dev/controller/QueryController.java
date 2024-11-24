package com.anu3dev.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QueryController {
	// http://localhost:8090/
	@GetMapping
	public String displayDefaultMessage(Model model) {
		model.addAttribute("message", "Welcome Alien!");
		return "index";
	}
	
	// http://localhost:8090/user?name=anurag
	@GetMapping("/user")
	public String displayUserMessage(@RequestParam("name")String name, Model model) {
		String msg = "Welcome " + name + "!";
		model.addAttribute("message", msg);
		return "index";
	}
	
	// http://localhost:8090/admin?name=anurag&role=admin
	@GetMapping("/admin")
	public String displayAdminMessage(@RequestParam("name")String name, @RequestParam("role")String role, Map<String, Object> map) {
		String msg = "Welcome " + name + " and role is " + role + "!";
		map.put("message", msg);
		return "index";
	}
}
