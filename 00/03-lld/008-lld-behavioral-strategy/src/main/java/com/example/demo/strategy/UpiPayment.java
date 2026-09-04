package com.example.demo.strategy;

public class UpiPayment implements PaymentStrategy {
	@Override
	public void pay(double amount) {
		System.out.println("Paid INR:" + amount + " using UPI");
	}
}
