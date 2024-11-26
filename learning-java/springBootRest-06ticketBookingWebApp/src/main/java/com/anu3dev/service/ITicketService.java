package com.anu3dev.service;

import com.anu3dev.model.Passenger;
import com.anu3dev.model.Ticket;

public interface ITicketService {
	public Integer registerPassengerUsingRestTemplate(Passenger passenger);
	public Integer registerPassengerUsingWebClient(Passenger passenger);
	public Ticket getFullTicketUsingRestTemplate(Integer ticketNumber);
	public Ticket getFullTicketUsingWebClient(Integer ticketNumber);
}
