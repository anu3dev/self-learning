/*
 * hiding implementation from user
 * can be acheived by abstract keyword (we can acheive 0% or 50 % or 100% abstraction)
 * or interface (we can acheive 100% abstraction)
 * 
 * abstract method are such methods which only has signature and no body or without implementation
 * If we have one method in a class as abstract then we must declare class also abstract.
 * 
 * an abstract class can have all abstract method or no abstract method or few abstract method and 
 * all concerte method or no concerte method or few concerte method.
 * 
 * abstract class cannot be initiated (new keyword) bcos it is incomplete class and we can't create object method
 * 
 * we can't use abstract keyword for variable.
 * 
 * an abstract method can have contructor, and constructor can't be abstracted bcos a constructor has either super or this method.
 */
package oopsInJava;

/*
 *  partial abstraction example, in below example, 66% abstraction bcos 2 of 3 are abstract method.
 */
abstract class Plane4 {
	Plane4() {
		System.out.println("calling from Plane4 constructor.");
	}
	abstract public void takeoff();
	
	abstract public void landing();
	
	public void disp() {
		System.out.println("Printing from abstraction ex...");
	}
}

class CargoPlane4 extends Plane4 {
	@Override
	public void takeoff() {
		System.out.println("Cargo plane takeoff.....");
	}

	public void landing() {
		System.out.println("CargoPlane landing....");
	}

}

class FighterPlane4 extends Plane4 {
	public void takeoff() {
		System.out.println("Fighter plane takeoff.....");
	}

	public void landing() {
		System.out.println("FighterPlane landing....");
	}
}

/*
 * final keyword is used to restrict class to participate in inheritance.
 * final keyword can be applied to class and method.
 * we can inheritate final method from a class 
 * however we can't override final method in child class.
 * we can't make abstact class as final.
 * we can't make abstact method as final bcos child class won't be able to provide implementation
 * 
 * inheritance promotes code reusability.
 */

/*
 * below class can't be extended due to final keyword.
 */
//final class Human1 {
//	public void disp() {
//		System.out.println("Printing from Human1 class");
//	}
//}


/*
 *  ilegal to use final and abstract together like below.
 */
//final abstract class Human1 {
class Human1 {
	/*
	 *  final keyword can be applied to a variable and it will behave like a const.
	 */
	final float pi = 3.14f;
	
	/*
	 * we can't override final method in child.
	 */
	final public void disp() {
		System.out.println("Printing from Human1 class");
	}
}

class Employee extends Human1 {
	
/*
 * we can't override final method here.
 */
//	public void disp() {
//		System.out.println("Printing from Human1 class");
//	}
}

public class Abstraction {
	public static void main(String[] args) {
		new CargoPlane4();
		new FighterPlane4();
		
		Employee e1 = new Employee();
		e1.disp();
	}
}
