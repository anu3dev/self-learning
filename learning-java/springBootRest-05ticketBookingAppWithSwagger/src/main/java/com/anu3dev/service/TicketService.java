package com.anu3dev.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu3dev.dao.ITicketDao;
import com.anu3dev.model.Passenger;

@Service
public class TicketService implements ITicketService {
	@Autowired
	private ITicketDao dao;
	
	@Override
	public Passenger registerPassenger(Passenger passenger) {
		return dao.save(passenger);
	}

	@Override
	public Passenger fetchPassenger(Integer id) {
		Optional<Passenger> option = dao.findById(id);
		return option.get();
	}
}
