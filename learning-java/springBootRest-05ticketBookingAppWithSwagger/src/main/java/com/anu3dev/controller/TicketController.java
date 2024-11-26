package com.anu3dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anu3dev.model.Passenger;
import com.anu3dev.model.Ticket;
import com.anu3dev.service.ITicketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/book-ticket")
@Tag(name="TicketBookingAPI", description = "There are two api's, one will accept passenger info and generate ticket number and other will generate full ticket info based on ticket number")
public class TicketController {
	@Autowired
	private ITicketService service;
	
	// http://localhost:8091/TicketBookingAPI/book-ticket/get-ticketnumber
	@PostMapping("/get-ticketnumber")
	@Operation(summary = "POST operation", description = "This API will accept passenger info and generate ticket number")
	public ResponseEntity<Integer> registerPassenger(@RequestBody Passenger passenger){
		Passenger pass = service.registerPassenger(passenger);
		Integer ticketNumber = pass.getPid();
		return new ResponseEntity<Integer>(ticketNumber, HttpStatus.CREATED);
	}
	
	// http://localhost:8091/TicketBookingAPI/book-ticket/get-ticket/{ticketNumber}
	@GetMapping("/get-ticket/{ticketNumber}")
	@Operation(summary = "Get operation", description = "This API will accept ticket number and generate full ticket")
	public ResponseEntity<Ticket> getTicket(@PathVariable("ticketNumber") Integer ticketNumber){
		Passenger passenger = service.fetchPassenger(ticketNumber);
		
		Ticket ticket = new Ticket();
		ticket.setTicketNumber(passenger.getPid());
		ticket.setName(passenger.getName());
		ticket.setDeparture(passenger.getDeparture());
		ticket.setArrival(passenger.getArrival());
		ticket.setDateOfJourney(passenger.getDateOfJourney());
		ticket.setStatus("confirmed");
		ticket.setTicketPrice(5555.5);
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}
}
