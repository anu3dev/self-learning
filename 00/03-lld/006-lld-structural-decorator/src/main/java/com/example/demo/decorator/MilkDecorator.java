package com.example.demo.decorator;

import com.example.demo.component.Coffee;

public class MilkDecorator extends CoffeeDecorator {
	
	public MilkDecorator(Coffee coffee) {
		super(coffee);;
	}
	
	@Override
	public String description() {
		return coffee.description() + " + Milk";
	}
	
	@Override
	public double cost() {
		return coffee.cost() + 20;
	}
}
