/*
 * 
 * Purpose is to hide the implementation from user.
 * Can be achieved by abstract keyword (we can achieve 0% or 50 % or 100% abstraction)
 * With interface (we can achieve 100% abstraction)
 * 
 * Abstract methods are such methods which only has signature and no body / without implementation.
 * If we have one method in a class as abstract then we must declare class as abstract.
 * An abstract class can have all abstract method or no abstract method or few abstract method or
 * all concrete method or no concrete method or few concrete method.
 * Abstract class cannot be initiated (new keyword) because it is incomplete class and 
 * we can't create object method.
 * We can't use abstract keyword for variable.
 * An abstract method can have constructor, and constructor can't be abstracted because 
 * a constructor has either super or this method.
 * 
 */

abstract class Plane4 {
	/*
	 * 
	 *  partial abstraction example, in below example, 66% abstraction because 2 of 3 are abstract method.
	 *  
	 */
	Plane4() {
		System.out.println("calling from constructor.");
	}
	abstract public void takeoff();
	
	abstract public void landing();
	
	public void disp() {
		System.out.println("Printing from abstraction ex...");
	}
}

class CargoPlane4 extends Plane4 {
	public void takeoff() {
		System.out.println("Cargo plane takeoff.....");
	}

	public void landing() {
		System.out.println("CargoPlane landing....");
	}

}

abstract class Abs {
	public abstract void drive();
}

public class P09Abstract {
	public static void main(String[] args) {
		Plane4 one = new CargoPlane4();
		one.disp();
		one.takeoff();
		one.landing();
		
		System.out.println();
		/*
		 * we can instantiate abstract by anonymous inner class
		 */
		Abs ex = new Abs() {
			@Override
			public void drive() {
				System.out.println("calling from Abc class drive method");
			};
		};
		ex.drive();
	}
}
