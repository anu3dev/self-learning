package com.anu3dev.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Ticket {
	@Id
	private Integer ticketNumber;
	private String status;
	private Double ticketPrice;
	private String name;
	private String departure;
	private String arrival;
	private String dateOfJourney;
}
