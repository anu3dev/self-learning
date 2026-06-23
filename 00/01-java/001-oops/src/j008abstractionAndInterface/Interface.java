package j008abstractionAndInterface;

interface Flyable {
	void fly();
}

interface Swimable {
	void swim();
}

interface Walkable {
	void walk();
}

class Duck implements Flyable, Swimable, Walkable {
	public void fly() {
		System.out.println("Duck can fly.");
	}
	
	public void swim() {
		System.out.println("Duck can swim.");
	}
	
	public void walk() {
		System.out.println("Duck can walk.");
	}
}

public class Interface {}
