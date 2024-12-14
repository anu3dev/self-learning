package com.anu3dev.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anu3dev.entity.Users;
import com.anu3dev.service.UserService;

@RestController
public class TeluskoController 
{
	@Autowired
	private UserService service;
	
	BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder(12);
	
	@PostMapping("/add-user")
	public Users registerNewUser(@RequestBody Users user)
	{
		String encoded=bcrypt.encode(user.getPassword());
		user.setPassword(encoded);
		return service.register(user);
	}
	

	@GetMapping("/get-courseinfo")
	public String getCourseInfo()
	{
		return "Telusko launched DevOps with AWS course from scratch ";
	}
	
}
