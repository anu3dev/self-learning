package main.decorator;

import main.pizza.IBasePizza;

// abstract class not needs to implement all methods from it interface
public abstract class ToppingDecorator implements IBasePizza {
	IBasePizza basePizza;
	
	public ToppingDecorator(IBasePizza pizza){
		this.basePizza = pizza;
	}
}
