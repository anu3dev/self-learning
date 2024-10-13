package com.anu3dev.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="contact_email_details")
public class Email {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	@Column(name="email_id")
	private String emailId;
	@Column(columnDefinition="TEXT")
	private String message;
}
