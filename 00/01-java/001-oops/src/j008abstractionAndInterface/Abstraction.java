package j008abstractionAndInterface;

class Father {
	void drive() {
		System.out.println("Father driving");
	}
}

class Mother {
	void drive() {
		System.out.println("Mother driving");
	}
}

/**
 * Below is wring inheritance as Child child = new Child(); then child.drive();
 * Which drive() should Java call? Father's? OR Mother's?
 * Java cannot decide, This is called the Diamond Problem.
 */

// class Child extends Father, Mother {}

public class Abstraction {}
