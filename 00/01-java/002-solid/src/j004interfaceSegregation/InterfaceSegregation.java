package j004interfaceSegregation;

/**
 * Don't force classes to implement methods they don't need.
 */

// bad example
interface Worker {
	void work();
	void eat();
	void sleep();
}
class Robot01 implements Worker {
	public void work() {
		// code
	}
	public void eat() {
		// this method is not needed but have to implement
	}
	public void sleep() {
		// this method is not needed but have to implement
	}
}



// good example
interface Workable {
	void work();
}
interface Eatable {
	void eat();
}
interface Sleepable {
	void sleep();
}
class Human implements Workable, Eatable, Sleepable {
	public void work() {
		// code
	}
	public void eat() {
		// this method is not needed but have to implement
	}
	public void sleep() {
		// this method is not needed but have to implement
	}
}
class Robot implements Workable {
	public void work() {
		// code
	}
}



public class InterfaceSegregation {
	public static void main(String[] args) {}
}
