package com.anu3dev.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anu3dev.entity.Users;
import com.anu3dev.model.Alien;
import com.anu3dev.service.JwtTokenService;
import com.anu3dev.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AlienController {
	/*
	 * first login with user and password to get token
	 * send those bearer token with headers to access other API's
	 * 
	 * all api's can we either via bearer token in headers or user and pass.
	 * 
	 * removing dev tools because after each refresh, token will be treated as expired.
	 */
	
	@Autowired
	private UserService service;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private JwtTokenService jwtService;
	
	BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder(12);
	
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
	
	// http://localhost:8080/session-info
	@GetMapping("/session-info")
	public String getCourseInfo(HttpServletRequest request){
		return "session ID "+ request.getSession().getId();
	}
	
	// http://localhost:8080/course-info
	@GetMapping("/course-info")
	public String getCourseInfo(){
		return "Telusko launched DevOps with AWS course from scratch ";
	}
	
	// http://localhost:8080/add-user
	@PostMapping("/add-user")
	public Users registerNewUser(@RequestBody Users user){
		String encoded = bcrypt.encode(user.getPassword());
		user.setPassword(encoded);
		return service.register(user);
	}
	
	// http://localhost:8080/login
	@PostMapping("/login")
	public String loginUser(@RequestBody Users user){
		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));
		if(authentication.isAuthenticated()){
			String jwt= jwtService.generateToken(user.getName());
			return jwt;
		}
		else
			return "Invalid credentials";
	}
}
