package com.example.demo.observer;

public class MobileAppCustomer implements Observer{
	private String username;
	
	public MobileAppCustomer(String username) {
		this.username = username;
	}
	
	@Override
	public void update(String message) {
		System.out.println("Email sent to " + username + " : " + message);
	}
}
