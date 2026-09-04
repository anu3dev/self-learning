package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.adaptee.Stripe;
import com.example.demo.adapter.StripeAdapter;
import com.example.demo.client.PaymentClient;
import com.example.demo.implementation.RazorpayGateway;
import com.example.demo.target.PaymentGateway;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		
		
		PaymentGateway razorpay = new RazorpayGateway();
		PaymentClient client = new PaymentClient(razorpay);
		client.checkout(499.97);
		
		
		
		PaymentGateway stripe = new StripeAdapter(new Stripe());
		client = new PaymentClient(stripe);
		client.checkout(999.97);
	}
}



/**
 * Notes -
 * 
 * @Override is used whenever a method from a superclass or an implemented interface is being overridden. 
 * 		An interface implementation is also considered overriding in Java.
 */