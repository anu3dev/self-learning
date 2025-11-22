package main.pizza;

public class PlainPizza implements IBasePizza {
	@Override
	public String getDescription() {
		return "plain pizza";
	}
	
	@Override
	public double getCost() {
		return 220.00;
	}
}
