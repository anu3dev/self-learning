package com.anu3dev.main.payment;

public class CreditCard implements IPay {
	@Override
	public boolean makePayment(Double amount) {
		System.out.println("payment using credit card with " + amount + " INR");
		return true;
	}
}
