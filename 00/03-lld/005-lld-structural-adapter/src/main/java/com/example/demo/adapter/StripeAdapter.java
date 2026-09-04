package com.example.demo.adapter;

import com.example.demo.adaptee.Stripe;
import com.example.demo.target.PaymentGateway;

public class StripeAdapter implements PaymentGateway {
	private Stripe stripe;
	
	public StripeAdapter(Stripe stripe) {
		this.stripe = stripe;
	}
	
	@Override
	public void pay(double amount) {
		stripe.makePayment(amount);
	}
}
