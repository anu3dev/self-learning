package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.client.AmazonStore;
import com.example.demo.observer.EmailCustomer;
import com.example.demo.observer.MobileAppCustomer;
import com.example.demo.observer.SmsCustomer;
import com.example.demo.subject.Product;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		
		
		Product iPhone = new Product("iPhone 18");
		iPhone.subscribe(new EmailCustomer("anu3dev@gmail.com"));
		iPhone.subscribe(new SmsCustomer("(612)456-6855"));
		iPhone.subscribe(new MobileAppCustomer("anu3dev"));
		
		AmazonStore amazonStore = new AmazonStore(iPhone);
		amazonStore.productArrived();
	}
}
