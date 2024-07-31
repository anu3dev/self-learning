package com.sb.springMVCQueryParam.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QueryController {
	@GetMapping
	public String displayDefaultMessage(Model model) {
		model.addAttribute("message", "Welcome Alien!");
		return "index";
	}
	
	@GetMapping("/user")
	public String displayUserMessage(@RequestParam("name")String name, Model model) {
		String msg = "Welcome " + name + "!";
		model.addAttribute("message", msg);
		return "index";
	}
	
	@GetMapping("/admin")
	public String displayAdminMessage(@RequestParam("name")String name, @RequestParam("role")String role, Map<String, Object> map) {
		String msg = "Welcome " + name + " and role is " + role + "!";
		map.put("message", msg);
		return "index";
	}
}
