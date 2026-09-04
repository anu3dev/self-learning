package com.example.demo.client;

import com.example.demo.component.Coffee;

public class CoffeeShop {
	public void placeOrder(Coffee coffee) {
		System.out.println("Order : " + coffee.description());
		System.out.println("Cost : " + coffee.cost());
	}
}
