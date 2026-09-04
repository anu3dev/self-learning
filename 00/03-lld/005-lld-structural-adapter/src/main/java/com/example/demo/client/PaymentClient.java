package com.example.demo.client;

import com.example.demo.target.PaymentGateway;

public class PaymentClient {
	private PaymentGateway gateway;
	
	public PaymentClient(PaymentGateway gateway) {
		this.gateway = gateway;
	}
	
	public void checkout(double amount) {
		gateway.pay(amount);
	}
}
