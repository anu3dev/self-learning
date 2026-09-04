package com.example.demo.client;

import com.example.demo.context.Checkout;

public class PaymentService {
	public void makePayment(Checkout checkout, double amount) {
		checkout.processPayment(amount);
	}
}
