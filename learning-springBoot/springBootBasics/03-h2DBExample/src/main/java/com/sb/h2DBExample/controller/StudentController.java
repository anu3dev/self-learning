package com.sb.h2DBExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.h2DBExample.dao.StudentService;
import com.sb.h2DBExample.model.Student;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String welcomeMessage() {
		return "Hello World";
	}
	
	@GetMapping("/getStudents")
	public List<Student> getStudents() {
		return service.getStudents();
	}
}
