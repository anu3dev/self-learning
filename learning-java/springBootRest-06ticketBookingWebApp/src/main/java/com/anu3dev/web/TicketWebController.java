package com.anu3dev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anu3dev.model.Passenger;
import com.anu3dev.model.Ticket;
import com.anu3dev.service.ITicketService;

@Controller
public class TicketWebController {
	@Autowired
	private ITicketService service;
	
	// http://localhost:8484/TicketBookingWebAPP/ticket-form-web-client
	@GetMapping("/ticket-form-web-client")
	public String bookTicketDetailWebClient(@ModelAttribute Passenger passenger, Model model){
		model.addAttribute("passenger", new Passenger());
		return "web-client-ticket-form";
	}
	
	@PostMapping("/book-ticket-web-client")
	public String getBookedTicketWebClient(@ModelAttribute Passenger passenger, Model model){
		Integer ticketNumber = service.registerPassengerUsingWebClient(passenger);
		model.addAttribute("ticketNumber", ticketNumber);
		return "web-client-ticket-form";
	}

	@GetMapping("/ticket-search-web-client")
	public String searchTicketWebClient(@ModelAttribute Passenger passenger, Model model){
		model.addAttribute("passenger", new Passenger());
		return "web-client-ticket-search";
	}
	
	@GetMapping("/get-ticket-web-client")
	public String getTicketInfoWebClient(@RequestParam("ticketNumber")Integer ticketNumber, Model model){
		Ticket ticket = service.getFullTicketUsingWebClient(ticketNumber);
		model.addAttribute("ticket", ticket);
		return "web-client-ticket-info";
	}
	
	// http://localhost:8484/TicketBookingWebAPP/ticket-form-rest-template
	@GetMapping("/ticket-form-rest-template")
	public String bookTicketDetailRestTemplate(@ModelAttribute Passenger passenger, Model model){
		model.addAttribute("passenger", new Passenger());
		return "rest-temp-ticket-form";
	}
		
	@PostMapping("/book-ticket-rest-template")
	public String getBookedTicketRestTemplate(@ModelAttribute Passenger passenger, Model model){
		Integer ticketNumber = service.registerPassengerUsingWebClient(passenger);
		model.addAttribute("ticketNumber", ticketNumber);
		return "rest-temp-ticket-form";
	}

	@GetMapping("/ticket-search-rest-template")
	public String searchTicketRestTemplate(@ModelAttribute Passenger passenger, Model model){
		model.addAttribute("passenger", new Passenger());
		return "rest-temp-ticket-search";
	}
		
	@GetMapping("/get-ticket-rest-template")
	public String getTicketInfoRestTemplate(@RequestParam("ticketNumber")Integer ticketNumber, Model model){
		Ticket ticket = service.getFullTicketUsingRestTemplate(ticketNumber);
		model.addAttribute("ticket", ticket);
		return "rest-temp-ticket-info";
	}
}
