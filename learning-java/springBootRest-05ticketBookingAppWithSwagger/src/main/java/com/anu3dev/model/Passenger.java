package com.anu3dev.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Passenger {
	@Id
	private Integer pid;
	private String name;
	private String departure;
	private String arrival;
	private String dateOfJourney;
}
