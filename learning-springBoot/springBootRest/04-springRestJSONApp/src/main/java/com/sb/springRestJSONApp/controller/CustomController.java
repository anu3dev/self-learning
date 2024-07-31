package com.sb.springRestJSONApp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.springRestJSONApp.pojo.Company;
import com.sb.springRestJSONApp.pojo.Customer;

@RestController
@RequestMapping("/api/customer")
public class CustomController {
	// http://localhost:8090/RestJson/api/customer/report/101
	@GetMapping("report/{id}")
	public ResponseEntity<Customer> showCustomers(@PathVariable Integer id) {
		Customer cust = new Customer();
		cust.setNo(101);
		cust.setName("anurag");
		cust.setBillAmount(54.5f);
		cust.setTeamNames(new String[] {"IND", "AUS", "SL"});
		cust.setStudies(List.of("SSLC-10th", "12th", "Engineering"));
		cust.setCompany(new Company("RCB", "IPL", "Bengaluru", 24));
		
		ResponseEntity<Customer> entity = new ResponseEntity<Customer>(cust, HttpStatus.OK);
		return entity;
	}
	
	// http://localhost:8090/RestJson/api/customer/save
	@PostMapping(value="/save")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer cust) {
		String body = "data stored!";
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
}
