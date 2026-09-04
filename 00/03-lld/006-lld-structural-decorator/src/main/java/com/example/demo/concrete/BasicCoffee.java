package com.example.demo.concrete;

import com.example.demo.component.Coffee;

public class BasicCoffee implements Coffee{
	@Override
	public String description() {
		return "Coffee";
	}
	
	@Override
	public double cost() {
		return 100;
	}
}
