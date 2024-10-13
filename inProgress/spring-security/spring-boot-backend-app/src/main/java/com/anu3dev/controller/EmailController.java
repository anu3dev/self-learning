package com.anu3dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anu3dev.model.Email;
import com.anu3dev.service.IEmailService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/email/v1/")
public class EmailController {
	@Autowired
	private IEmailService emailService;
	
	@PostMapping("/contact")
	public ResponseEntity<?> sendWelcomeEmail(@RequestBody Email email) {
		try {
			return new ResponseEntity<String>(emailService.sendContactEmail(email), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>("request can't be completed.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
