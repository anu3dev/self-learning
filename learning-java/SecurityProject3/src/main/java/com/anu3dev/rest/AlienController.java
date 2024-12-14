package com.anu3dev.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anu3dev.model.Alien;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AlienController
{
	List<Alien> list=new ArrayList<>(List.of(new Alien(1,"Rohan","Bengaluru"), 
			new Alien(2,"Rohit","Delhi"), new Alien(3,"Ramesh","Mumbai")));
	
	@GetMapping("/get-aliens")
	public List<Alien> getAliens()
	{
		return list;
	}
	
	@PostMapping("/add-aliens")
	public void addAlien(@RequestBody Alien alien)
	{
		list.add(alien);
		System.out.println(list);
	}
	
	@GetMapping("/get-info")
	public String getCourseInfo(HttpServletRequest request)
	{
		return "Telusko launched DevOps with AWS course from scratch "+ request.getSession().getId();
	}
	
	@GetMapping("/get-moreinfo")
	public String getCourseMorwInfo(HttpServletRequest request)
	{
		return "its 4 month weekend course "+ request.getSession().getId();
	}
	
	@GetMapping("/csrf")
	public CsrfToken getCsrfToken(HttpServletRequest request)
	{
		return (CsrfToken) request.getAttribute("_csrf");
	}
}
