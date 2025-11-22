/**
 * Decorator Pattern is a structural design pattern that allows behavior 
 * to be added to individual objects, either statically or dynamically, 
 * without affecting the behavior of other objects from the same class.
 * 
 * real world example is, - suppose you have base pizza, and you want to add
 * extra toppings like cheese, olives, mushrooms etc. Instead of creating
 * a new pizza class for each combination of toppings, you can use the
 * decorator pattern to add toppings dynamically.
 * 
 * suppose i have pizza like framhouse, pacific veggie, veg extravaganza etc.
 * Now, if i want to add extra cheese to any of these pizzas, instead of creating
 * a new pizza class for each combination of toppings, i can use the decorator
 * pattern to add toppings dynamically.
 */


package main;

import main.pizza.PlainPizza;
import main.decorator.ExtraCheeseTopping;
import main.decorator.ExtraMushroomTopping;
import main.pizza.IBasePizza;

public class App {
	public static void main(String[] args) {
		IBasePizza basePizza1 = new PlainPizza();
		System.out.println("order 1: " + basePizza1.getDescription() + " = INR " + basePizza1.getCost());
		
		IBasePizza basePizza2 = new ExtraCheeseTopping(new PlainPizza());
		System.out.println("order 2: " + basePizza2.getDescription() + " = INR " + basePizza2.getCost());
		
		IBasePizza basePizza3 = new ExtraMushroomTopping(new PlainPizza());
		System.out.println("order 3: " + basePizza3.getDescription() + " = INR " + basePizza3.getCost());
		
		IBasePizza basePizza4 = new ExtraMushroomTopping(new ExtraMushroomTopping(new PlainPizza()));
		System.out.println("order 4: " + basePizza4.getDescription() + " = INR " + basePizza4.getCost());
	}
}
