package com.anu3dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anu3dev.model.Tourist;
import com.anu3dev.service.ITouristManagement;

@RestController
@RequestMapping("/tourist/api")
public class TouristController {
	@Autowired
	private ITouristManagement service;
	
	// http://localhost:8090/TicketBookingApp/tourist/api/save
	@PostMapping("/save")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist){
		try {
			String body = service.registerTourist(tourist);
			return new ResponseEntity<String>(body, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("can't able to enroll!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// http://localhost:8090/TicketBookingApp/tourist/api/all
	@GetMapping("/all")
	public ResponseEntity<?> fetchAllTourists(){
		try {
			List<Tourist> list = service.fetchAllTourists();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("can't able to fetch all tourists!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// http://localhost:8090/TicketBookingApp/tourist/api/info/1
	@GetMapping("/info/{id}")
	public ResponseEntity<?> fetchTourist (@PathVariable("id") Integer id){
		try {
			Tourist tourist = service.fetchTourist(id);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// http://localhost:8090/TicketBookingApp/tourist/api/modify
	@PutMapping("/modify")
	public ResponseEntity<String> updateTouristByDetails(@RequestBody Tourist tourist){
		try {
		    String body = service.updateTouristByDetails(tourist);
		    return new ResponseEntity<String>(body, HttpStatus.OK);
		} catch(Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	// http://localhost:8090/TicketBookingApp/tourist/api/modifyBudget/2/9000
	@PatchMapping("/modifyBudget/{id}/{hike}")
	public ResponseEntity<String> updateTouristById(@PathVariable("id") Integer id, 
			@PathVariable("hike") Double budgetHike) {
		try {
		    String body=service.updateTouristById(id, budgetHike);
		    return new ResponseEntity<String>(body, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	// http://localhost:8090/TicketBookingApp/tourist/api/delete/2
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTouristById(@PathVariable("id") Integer id) {
		try {
		    String body=service.deleteTouristById(id);
		    return new ResponseEntity<String>(body, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
