package com.anu3dev.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anu3dev.entity.Users;
import com.anu3dev.model.Alien;
import com.anu3dev.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AlienController {
	@Autowired
	private UserService service;
	
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(12);
	
	/*
	 * select basic auth in postman and enter user and password 
	 * which has been entered in DB, password should be in hash text
	 * 
	 * website to generate https://bcrypt-generator.com/
	 * 
	 */
	
	List<Alien> list=new ArrayList<>(List.of(
			new Alien(1,"Rohan","Bengaluru"), 
			new Alien(2,"Rohit","Delhi"),
			new Alien(3,"Ramesh","Mumbai")
		));
	
	// http://localhost:8080/get-aliens
	@GetMapping("/get-aliens")
	public List<Alien> getAliens(){
		return list;
	}
	
	// http://localhost:8080/add-alien
	@PostMapping("/add-alien")
	public List<Alien> addAlien(@RequestBody Alien alien){
		list.add(alien);
		return list;
	}
	
	// http://localhost:8080/get-info
	@GetMapping("/get-info")
	public String getCourseInfo(HttpServletRequest request){
		return "session ID "+ request.getSession().getId();
	}
	
	// http://localhost:8080/get-courseinfo
	@GetMapping("/get-courseinfo")
	public String getCourseInfo(){
		return "cousre info";
	}
	
	// http://localhost:8080/add-user-without-pass
	@PostMapping("/add-user-without-pass")
	public Users registerNewUserWithoutPass(@RequestBody Users user){
		String encoded = bcrypt.encode(user.getPassword());
		user.setPassword(encoded);
		return service.register(user);
	}
	
	// http://localhost:8080/add-user-with-pass
	@PostMapping("/add-user-with-pass")
	public Users registerNewUserWithPass(@RequestBody Users user){
		String encoded = bcrypt.encode(user.getPassword());
		user.setPassword(encoded);
		return service.register(user);
	}
}
