/**
 * Interface: just a job posting saying “We need someone who can make shapes.” 
 * 
 * Abstract class: a training manual + the job posting → every employee follows some 
 * standard process before making shapes
 * 
 * Suppose we want to add logs, each subclass needs to write duplicate code in case of
 * inheritance but in case of abstract, all subclasses can use from abstract class
 */

/**
 * Factory - creates one product from a group
 * ShapeFactory (e.g., Circle/Square)  → returns one Shape
 * 
 * Abstract Factory - creates families of related products
 * GUIFactory → returns Button + Checkbox for same OS
 */

/**
 * Factory Pattern in Java-
 * 
 * The Factory Pattern is a creational design pattern that provides an interface
 * for creating objects in a superclass, but allows subclasses to alter the type
 * of objects that will be created.
 * 
 * real world example is - In a logistics management system, a factory can be
 * used to create different types of transport vehicles (like Truck, Ship, 
 * Airplane) based on the delivery requirements.
 * 
 * Abstract Factory pattern in Java-
 * 
 * The Abstract Factory Pattern is a creational design pattern that provides an
 * interface for creating families of related or dependent objects without
 * specifying their concrete classes.
 * 
 * real world example is - In a cross-platform UI toolkit, an abstract factory
 * can be used to create UI components (like Buttons, TextFields, CheckBoxes)
 * for different operating systems (like Windows, macOS, Linux) without
 * specifying the exact classes of the components.
 * 
 * 
 * 
 * Factory - Let a subclass decide which specific object to create —
 * the parent just defines the method to “make” it.
 * It’s about creating one object from a family of similar types like circle / square from shape.
 * 
 * Abstract factory - Create factories of factories — each factory creates related sets of objects.
 * It’s about creating families of related objects without specifying their exact classes.
 */

package main;

import main.constant.ShapeType;
import main.factoryWay.ShapeFactory;
import main.shape.IShape;
import main.simpleWay.ShapeFactorySimple;

public class App {
	public static void main(String[] args) {
		ShapeType circle = ShapeType.CIRCLE;
		ShapeType square = ShapeType.SQUARE;
		
		// static method creates object based on param
		// not a true design patter
		// violates the open/close principle while adding new types
		IShape shapeCircleSimple = ShapeFactorySimple.createShapeInstance(circle);
		System.out.println("simple way:");
		shapeCircleSimple.computeArea();
		shapeCircleSimple.draw();
		
		IShape shapeSquareSimple = ShapeFactorySimple.createShapeInstance(square);
		shapeSquareSimple.computeArea();
		shapeSquareSimple.draw();
		
		// uses inheritance and polymorphism
		// each concrete creator handles one product type
		// follow the open/close principle 
		IShape shapeCircle = ShapeFactory.createShapeInstance(circle);
		System.out.println("\nfactory pattern way:");
		shapeCircle.computeArea();
		shapeCircle.draw();
		
		IShape shapeSquare = ShapeFactory.createShapeInstance(square);
		shapeSquare.computeArea();
		shapeSquare.draw(); 

		/**
		 * Abstract-
		 * A method without a body (no implementation).
		 * It just says “what to do”, not “how to do it”.
		 * Must be inside an abstract class or interface.
		 * The child class must override (implement) it.
		 * 
		 * Abstract is like half-built house; you need to finish it.
		 * it can have both abstract and non-abstract methods.
		 * An abstract class cannot be instantiated directly.
		 * It is meant to be subclassed.
		 */
		abstract class Animal {
			abstract void makeSound(); // no body
		}

		class Dog extends Animal {
			void makeSound() {          // implemented here
				System.out.println("Bark");
			}
		}
		Dog dog = new Dog();
		dog.makeSound();

		/**
		 * Static-
		 * A method that belongs to the class, not the object.
		 * Can be called without creating an object.
	Cannot use non-static (instance) variables or methods.
		 */
		class MathUtils {
			static int add(int a, int b) {
				return a + b;
			}
		}
		System.out.println(MathUtils.add(15, 17));;
	}
}
