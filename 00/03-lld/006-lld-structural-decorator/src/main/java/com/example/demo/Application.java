package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.client.CoffeeShop;
import com.example.demo.component.Coffee;
import com.example.demo.concrete.BasicCoffee;
import com.example.demo.decorator.ChocolateDecorator;
import com.example.demo.decorator.MilkDecorator;
import com.example.demo.decorator.SugarDecorator;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		
		
		Coffee coffeeBasic = new BasicCoffee();
		
		CoffeeShop order = new CoffeeShop();
		order.placeOrder(coffeeBasic);
		
		
		
		coffeeBasic = new BasicCoffee();
		coffeeBasic = new MilkDecorator(coffeeBasic);
		coffeeBasic = new SugarDecorator(coffeeBasic);
		coffeeBasic = new ChocolateDecorator(coffeeBasic);
		order = new CoffeeShop();
		order.placeOrder(coffeeBasic);
	}
}

/**
 * Notes -
 * 
 * An abstract class in Java is a class that cannot be instantiated (you cannot create an object of it directly). 
 * 		It is used when you want to provide a common base implementation while forcing child classes to implement certain methods.
 * 		It represents an "is-a" relationship where all subclasses share common properties and behaviour.
 */