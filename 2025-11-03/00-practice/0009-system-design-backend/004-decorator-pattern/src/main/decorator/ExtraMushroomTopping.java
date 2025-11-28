package main.decorator;

import main.pizza.IBasePizza;

public class ExtraMushroomTopping extends ToppingDecorator {
	public ExtraMushroomTopping(IBasePizza basePizza) {
		super(basePizza);
	}
	
	@Override
	public String getDescription() {
		return basePizza.getDescription() + " + extra mushroom";
	}
	
	@Override
	public double getCost() {
		return basePizza.getCost() + 35;
	}
}
