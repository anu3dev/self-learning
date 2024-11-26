package com.anu3dev.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.anu3dev.model.Passenger;
import com.anu3dev.model.Ticket;
@Service
public class TicketService implements ITicketService{

	private String url="http://localhost:8091/TicketBookingAPI/book-ticket/get-ticketnumber";
	private String get_url="http://localhost:8091/TicketBookingAPI/book-ticket/get-ticket/{ticketNumber}";

	@Override
	public Integer registerPassengerUsingRestTemplate(Passenger passenger){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Integer> response = restTemplate.postForEntity(url, passenger, Integer.class);
		Integer ticketNumber = response.getBody();
		return ticketNumber;
	}
	
	@Override
	public Integer registerPassengerUsingWebClient(Passenger passenger){
		WebClient webClient = WebClient.create();
		Integer ticketNumber = webClient.post()
		.uri(url)
		.bodyValue(passenger)
		.retrieve()
		.bodyToMono(Integer.class)
		.block();
		return ticketNumber;
	}

	@Override
	public Ticket getFullTicketUsingRestTemplate(Integer ticketNumber){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Ticket> response = restTemplate.getForEntity(get_url, Ticket.class, ticketNumber);
		Ticket ticket = response.getBody();
		return ticket;
	}
	
	@Override
	public Ticket getFullTicketUsingWebClient(Integer ticketNumber){
		WebClient webClient = WebClient.create();
		Ticket ticket = webClient.get()
		.uri(get_url, ticketNumber)
		.retrieve()
		.bodyToMono(Ticket.class)
		.block();
		return ticket;
	}
}
