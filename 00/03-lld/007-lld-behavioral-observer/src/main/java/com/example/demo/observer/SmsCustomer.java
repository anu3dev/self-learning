package com.example.demo.observer;

public class SmsCustomer implements Observer{
	private String phone;
	
	public SmsCustomer(String phone) {
		this.phone = phone;
	}
	
	@Override
	public void update(String message) {
		System.out.println("Email sent to " + phone + " : " + message);
	}
}
