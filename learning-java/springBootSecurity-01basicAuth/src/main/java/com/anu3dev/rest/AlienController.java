package com.anu3dev.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anu3dev.model.Alien;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AlienController {
	List<Alien> list =	new ArrayList<>(List.of(
				new Alien(1,"Rohan","Bengaluru"), 
				new Alien(2,"Rohit","Delhi") 
			));
	
	/*
	 * select basic auth in postman and enter user and password 
	 * which has been written in application.properties
	 * 
	 * GetMapping will work by default but Postmapping will only work if
	 * http.csrf(customizer->customizer.disable()); will be added to securityFiltersChain
	 * 
	 */
	
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
}
