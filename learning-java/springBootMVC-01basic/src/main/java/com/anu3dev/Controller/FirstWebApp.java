package com.anu3dev.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

// controller is mix of component plus extra features
@Controller
public class FirstWebApp {
	// http://localhost:8090
	@GetMapping
	public ModelAndView displayMessage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Welcome...!");
		mav.setViewName("index");
		return mav;
	}
	
	// http://localhost:8090/student
	@GetMapping("/student")
	public ModelAndView displayDiffMessage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Student...!");
		mav.setViewName("index");
		return mav;
	}
	
	// http://localhost:8090/employee
	@GetMapping("/employee")
	public String displayDiffMessage(Model model){
		model.addAttribute("message","Employee...!");
		return "index";
	}
}
