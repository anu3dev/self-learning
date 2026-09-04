package com.example.demo.decorator;

import com.example.demo.component.Coffee;

public abstract class CoffeeDecorator implements Coffee {
	protected Coffee coffee;
	
	public CoffeeDecorator(Coffee coffee) {
		this.coffee = coffee;
	}
}
