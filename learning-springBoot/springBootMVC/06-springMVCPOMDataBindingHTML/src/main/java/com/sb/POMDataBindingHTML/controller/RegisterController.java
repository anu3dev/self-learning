package com.sb.POMDataBindingHTML.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sb.POMDataBindingHTML.model.Employee;

@Controller
public class RegisterController {
	@GetMapping("/register")
	public String responseHome(){
		return "register";
	}
	
	@PostMapping("/register")
	public String registerdata(Map<String, Object> map, @ModelAttribute("emp")Employee employee){
		System.out.println(employee);
		map.put("employee", employee);
		return "result";
	}
}