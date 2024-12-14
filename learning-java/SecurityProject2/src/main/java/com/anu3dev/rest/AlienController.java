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
public class AlienController {
	List<Alien> list=new ArrayList<>(List.of(
			new Alien(1,"Rohan","Bengaluru"), 
			new Alien(2,"Rohit","Delhi"), 
			new Alien(3,"Ramesh","Mumbai")
			));
	
	// pass {"name": "anurag", "password": "anurag"} as body
	
	// http://localhost:8080/get-aliens
	@GetMapping("/get-aliens")
	public List<Alien> getAliens(){
		return list;
	}
	
	// http://localhost:8080/get-info
	@GetMapping("/get-info")
	public String getCourseInfo(HttpServletRequest request){
		return "session ID "+ request.getSession().getId();
	}
	
	@PostMapping("/add-aliens")
	public void addAlien(@RequestBody Alien alien){
		list.add(alien);
		System.out.println(list);
	}
	
	
	
	@GetMapping("/csrf")
	public CsrfToken getCsrfToken(HttpServletRequest request){
		return (CsrfToken) request.getAttribute("_csrf");
	}
}
