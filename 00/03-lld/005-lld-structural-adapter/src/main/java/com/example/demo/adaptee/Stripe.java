package com.example.demo.adaptee;

public class Stripe {
	public void makePayment(double amount) {
		System.out.println("payment made through stripe with amount : " + amount);
	}
}
