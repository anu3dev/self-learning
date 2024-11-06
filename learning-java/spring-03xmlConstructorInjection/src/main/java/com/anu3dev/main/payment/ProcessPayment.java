package com.anu3dev.main.payment;

public class ProcessPayment {
	
	// target class
	private IPay paymentImplementation;
	
	// constructor injection
	public ProcessPayment(IPay pay) {
		this.paymentImplementation = pay;
	}
	
	public boolean processPayment(Double amount) {
		return paymentImplementation.makePayment(amount);
	}
}
