package com.anu3dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anu3dev.model.Passenger;

@Repository
public interface ITicketDao extends JpaRepository<Passenger, Integer> {}
