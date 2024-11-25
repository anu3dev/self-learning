package com.anu3dev.service;

import com.anu3dev.model.Passenger;

public interface ITicketService {
	Passenger registerPassenger(Passenger passanger);
	Passenger fetchPassenger(Integer id);
}
