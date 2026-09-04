package com.example.demo.decorator;

import com.example.demo.component.Coffee;

public class SugarDecorator extends CoffeeDecorator {
	
	public SugarDecorator(Coffee coffee) {
		super(coffee);;
	}
	
	@Override
	public String description() {
		return coffee.description() + " + Sugar";
	}
	
	@Override
	public double cost() {
		return coffee.cost() + 30;
	}
}
