package com.example.demo.subject;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.observer.Observer;

public class Product implements Subject{
	private List<Observer> observers = new ArrayList<Observer>();
	
	private String productName;
	
	public Product(String productName) {
		this.productName = productName;
	}
	
	@Override
	public void subscribe(Observer observer) {
		observers.add(observer);
	}
	
	@Override
	public void unsubscribe(Observer observer) {
		observers.remove(observer);
	}
	
	@Override
	public void notifyObservers() {
		for(Observer item : observers) {
			item.update(productName + " is back in stock.");
		}
	}
}
