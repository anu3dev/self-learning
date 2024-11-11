package com.anu3dev.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anu3dev.model.Course;

@Controller
@RequestMapping("/course")
public class CourseController {
	// http://localhost:8090/course
	@GetMapping
	public String getCourseDetails(Model model){
		model.addAttribute("cid", "001");
		model.addAttribute("cname", "Rest Full Services and Microservices");
		model.addAttribute("cprice", " 8445 INR");
		return "course";
	}
	
	// http://localhost:8090/course/courseInfoJava
	// http://localhost:8090/course/courseInfoSpring
	@GetMapping({"/courseInfoJava", "/courseInfoSpring"})
	public String getCourseInfo(Model model){
		Course course = new Course();
		course.setCid(44);
		course.setCname("Spring Boot");
		course.setPrice(4994.9);
		model.addAttribute("courseThroughObj", course);
		return "courseThroughObj";
	}
	
	// http://localhost:8090/course/courseDesc
	@GetMapping("/courseDesc")
	@PostMapping("/courseDesc")
	public String getCourseDesc(Model model){
		Course course = new Course();
		course.setCid(99);
		course.setCname("Spring Boot");
		course.setPrice(4994.9);
		model.addAttribute("courseThroughObj", course);
		return "courseThroughObj";
	}
}
