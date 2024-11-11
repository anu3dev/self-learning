package com.anu3dev.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class employeeController {
	// http://localhost:8090/employee
	@GetMapping
	public String welcomeDefault(Model model){
		model.addAttribute("message","Welcome employee...!");
		return "student";
	}
	
	// http://localhost:8090/employee/registration
	@GetMapping("/registration")
	public String welcomeEmployee(Model model){
		model.addAttribute("message","Employee registration done...!");
		return "student";
	}
}
