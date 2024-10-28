package com.sb.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course1")
public class Course1Controller {
	@GetMapping("/courseDetails1")
	public String getCourseDetails(Model model){
		model.addAttribute("cid", "T1");
		model.addAttribute("cname", "Rest Full Services and Microservices");
		model.addAttribute("cprice", " 8445 INR");
		return "course1";
	}
}
