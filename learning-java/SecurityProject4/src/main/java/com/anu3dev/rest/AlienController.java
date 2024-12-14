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
	List<Alien> list=new ArrayList<>(List.of(
			new Alien(1,"Rohan","Bengaluru"), 
			new Alien(2,"Rohit","Delhi"), 
			new Alien(3,"Ramesh","Mumbai")
			));
	
	@GetMapping("/get-aliens")
	public List<Alien> getAliens(){
		return list;
	}
	
	@PostMapping("/add-alien")
	public List<Alien> addAlien(@RequestBody Alien alien){
		list.add(alien);
		return list;
	}
	
	@GetMapping("/get-info")
	public String getCourseInfo(HttpServletRequest request){
		return "session ID "+ request.getSession().getId();
	}
}
