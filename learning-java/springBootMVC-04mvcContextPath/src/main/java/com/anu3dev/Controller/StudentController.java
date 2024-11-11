package com.anu3dev.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	// http://localhost:8090/details/student
	@GetMapping
	public String welcomeDefault(Model model){
		model.addAttribute("message","Welcome student...!");
		return "student";
	}
	
	// http://localhost:8090/details/student/registration
	@GetMapping("/registration")
	public String welcomeEmployee(Model model){
		model.addAttribute("message","Student registration done...!");
		return "student";
	}
}
