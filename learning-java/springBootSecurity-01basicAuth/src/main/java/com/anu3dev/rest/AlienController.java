package com.anu3dev.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anu3dev.model.Alien;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AlienController {
	List<Alien> list =	new ArrayList<>(List.of(
			new Alien(1,"Rohan","Bengaluru"), 
			new Alien(2,"Rohit","Delhi"), 
			new Alien(3,"Ramesh","Mumbai")));
	
	// select basic auth in postman and enter user and password which has been written in application.properties
	
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
	
	/*
	 * http.csrf(csrf -> csrf.disable());
	 * post request will not work until adding above into securityFilterChain method.
	 */
	// http://localhost:8080/add-alien
	@PostMapping("/add-alien")
	public List<Alien> addAlien(@RequestBody Alien alien){
		list.add(alien);
		return list;
	}
}