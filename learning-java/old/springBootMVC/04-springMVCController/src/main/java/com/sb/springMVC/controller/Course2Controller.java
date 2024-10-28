package com.sb.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sb.springMVC.model.Course;

@Controller
@RequestMapping("/course2")
public class Course2Controller {
	@GetMapping({"/courseDetails1"})
	public String getCourseInfo1(Model model){
		Course course = new Course();
		course.setCid(44);
		course.setCname("Spring Boot");
		course.setCourseDuration("4 Months");
		course.setPrice(4994.9);
		model.addAttribute("course2", course);
		return "course2";
	}
	
	@GetMapping("/courseDetails2")
	@PostMapping("/courseDetails2")
	public String getCourse(Model model){
		Course course = new Course();
		course.setCid(44);
		course.setCname("Spring Boot");
		course.setCourseDuration("6 Months");
		course.setPrice(2994.9);
		model.addAttribute("course2", course);
		return "course2";
	}
	
	@GetMapping({"/courseInfo", "/course", "/courseDetails"})
	public String getCourseInfo(Model model){
		Course course = new Course();
		course.setCid(44);
		course.setCname("Spring Boot");
		course.setCourseDuration("9 Months");
		course.setPrice(4994.9);
		model.addAttribute("course2", course);
		return "course2";
	}
}
