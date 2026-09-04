package com.example.demo.client;

import com.example.demo.subject.Product;

public class AmazonStore {
	private Product product;
	
	public AmazonStore(Product product) {
		this.product = product;
	}
	
	public void productArrived() {
		System.out.println("stock updated.");
		product.notifyObservers();
	}
}
