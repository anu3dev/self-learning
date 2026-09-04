package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.client.PaymentService;
import com.example.demo.context.Checkout;
import com.example.demo.strategy.CryptoPaymant;
import com.example.demo.strategy.PaypalPayment;
import com.example.demo.strategy.UpiPayment;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		
			
		PaymentService paymentService = new PaymentService();
		
		Checkout checkout = new Checkout(new UpiPayment());
		paymentService.makePayment(checkout, 997);
		
		checkout = new Checkout(new PaypalPayment());
		paymentService.makePayment(checkout, 998);
		
		checkout = new Checkout(new CryptoPaymant());
		paymentService.makePayment(checkout, 999);
	}
}
