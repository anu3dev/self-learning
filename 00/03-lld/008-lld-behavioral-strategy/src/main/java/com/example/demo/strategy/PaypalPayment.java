package com.example.demo.strategy;

public class PaypalPayment implements PaymentStrategy {
	@Override
	public void pay(double amount) {
		System.out.println("Paid INR:" + amount + " using Paypal");
	}
}
