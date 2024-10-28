package com.anu3dev.main.payment;

public class DebitCard implements IPay{
	@Override
	public boolean makePayment(Double amount) {
		System.out.println("payment using debit card with " + amount + " INR");
		return true;
	}
}
