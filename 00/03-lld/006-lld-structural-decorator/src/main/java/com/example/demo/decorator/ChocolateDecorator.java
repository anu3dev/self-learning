package com.example.demo.decorator;

import com.example.demo.component.Coffee;

public class ChocolateDecorator extends CoffeeDecorator {
	
	public ChocolateDecorator(Coffee coffee) {
		super(coffee);;
	}
	
	@Override
	public String description() {
		return coffee.description() + " + Chocolate";
	}
	
	@Override
	public double cost() {
		return coffee.cost() + 40;
	}
}
