package com.example.demo.context;

import com.example.demo.strategy.PaymentStrategy;

public class Checkout {
	private PaymentStrategy paymentStrategy;
	
	public Checkout(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
	
	public void processPayment(double amount) {
		paymentStrategy.pay(amount);
	}
}
