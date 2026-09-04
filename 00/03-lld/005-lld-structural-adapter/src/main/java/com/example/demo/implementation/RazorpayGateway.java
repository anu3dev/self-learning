package com.example.demo.implementation;

import com.example.demo.target.PaymentGateway;

public class RazorpayGateway implements PaymentGateway{
	
	@Override
	public void pay(double amount) {
		System.out.println("payment made through razorpay with amount : " + amount);
	}
}
