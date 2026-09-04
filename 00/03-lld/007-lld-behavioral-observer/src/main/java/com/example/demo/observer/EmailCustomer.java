package com.example.demo.observer;

public class EmailCustomer implements Observer {
	private String email;
	
	public EmailCustomer(String email) {
		this.email = email;
	}
	
	@Override
	public void update(String message) {
		System.out.println("Email sent to " + email + " : " + message);
	}
}
