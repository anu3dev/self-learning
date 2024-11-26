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
public class TikcketController {
	@Autowired
	private ITicketService service;
	
	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute Passenger passenger, Model model){
		Integer ticketNumber=service.registerPassengerUsingWebClient(passenger);
		model.addAttribute("ticketNumber", ticketNumber);
		return "index";
	}
	
	@GetMapping("/passenger-form")
	public String bookTicketFrom(@ModelAttribute Passenger passenger, Model model){
		model.addAttribute("passenger", new Passenger());
		return "index";
	}
	
	@GetMapping("/ticket-form")
	public String ticketForm(@ModelAttribute Passenger passenger, Model model){
		model.addAttribute("passenger", new Passenger());
		return "ticket-form";
	}
	@GetMapping("/get-ticket")
	public String getTicket(@RequestParam("ticketNumber")Integer ticketNumber, Model model){
		Ticket ticket = service.getFullTicketUsingWebClient(ticketNumber);
		model.addAttribute("ticket", ticket);
		return "ticket-info";
	}
}
