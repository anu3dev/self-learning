package main.decorator;

import main.pizza.IBasePizza;

public class ExtraCheeseTopping extends ToppingDecorator {
	public ExtraCheeseTopping(IBasePizza basePizza) {
		super(basePizza);
	}
	
	@Override
	public String getDescription() {
		return basePizza.getDescription() + " + extra cheese";
	}
	
	@Override
	public double getCost() {
		return basePizza.getCost() + 30;
	}
}
