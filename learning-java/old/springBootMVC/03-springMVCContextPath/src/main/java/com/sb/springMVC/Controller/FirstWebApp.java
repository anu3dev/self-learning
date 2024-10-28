package com.sb.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstWebApp {
	@GetMapping
	public String welcomeDefault(Model model){
		model.addAttribute("message","Welcome user...!");
		return "index";
	}
	
	@GetMapping("/employee")
	public String welcomeEmployee(Model model){
		model.addAttribute("message","Welcome employee...!");
		return "index";
	}
}
