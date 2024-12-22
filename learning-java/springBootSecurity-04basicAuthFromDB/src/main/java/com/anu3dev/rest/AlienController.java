package com.anu3dev.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anu3dev.entity.Users;
import com.anu3dev.model.Alien;
import com.anu3dev.repo.IUserRepo;

@RestController
public class AlienController {
	@Autowired
	private IUserRepo repo;
	
	List<Alien> list=new ArrayList<>(List.of(
			new Alien(1,"Rohan","Bengaluru"), 
			new Alien(2,"Rohit","Delhi")
		));
	
	/*
	 * select basic auth in postman and enter user and password 
	 * which has been entered in DB, password should be in plain text
	 * 
	 */
	
	// http://localhost:8080/get-aliens
	@GetMapping("/get-aliens")
	public List<Alien> getAliens() {
		return list;
	}
	
	// http://localhost:8080/add-alien
	@PostMapping("/add-alien")
	public List<Alien> addAlien(@RequestBody Alien alien) {
		list.add(alien);
		return list;
	}
	
	// http://localhost:8080/add-user-without-pass
	@PostMapping("/add-user-without-pass")
	public String addUserWithoutPass(@RequestBody Users user) {
		repo.save(user);
		return "user added";
	}
	
	// http://localhost:8080/add-user-with-pass
	@PostMapping("/add-user-with-pass")
	public String addUserWithPass(@RequestBody Users user) {
		repo.save(user);
		return "user added";
	}
}
