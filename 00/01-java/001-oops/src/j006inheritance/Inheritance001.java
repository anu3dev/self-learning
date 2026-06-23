package j006inheritance;

/**
 * One class acquires properties and behaviors of another class.
 * 
 * In below example - A Dog is an Animal. - this is called - IS-A Relationship
 * 
 * In below example, sound method is getting overridden, this is called method overriding.
 * Method overriding also called as run time polymorphism.
 */

class Animal {
	void eat() {
		System.out.println("eating");
	}
	
	void sound() {
        System.out.println("Animal Sound");
    }
}

class Dog extends Animal {
	void bark() {
		System.out.println("barking");
	}
	
	 @Override
	 void sound() {
		 System.out.println("Bark");
	 }
}
public class Inheritance001 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.eat();
		dog.bark();
		
		Animal animal = new Animal();
		animal.sound();
		Dog dog1 = new Dog();
		dog1.sound();
	}
}
