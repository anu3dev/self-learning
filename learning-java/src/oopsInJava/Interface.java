/*
 * we can't implement another interface in java, only we can extend other interface
 *
 * A way to achieve abstraction
 * we can specify the application requirement using interface.
 * this can be created using interface keyword.
 * by default all method under interface is public abstract
 * an interface can have any number of implementation classes.
 * we can create refrence of interface type although we can't create objects of an interface.
 * means interface can't be instantiated.
 * interface can be implemented by classes using implements keyword.
 * 
 * a class can implemnet multiple interfaces.
 * 
 * an interface can't implement another interface
 * an interface can extend another interface
 * 
 * a class can extends as well as implements
 * 
 * an interface can have variables and it will be public static and final.
 * it can't be modified.
 * 
 * after java 8, interface can have method with body but we have to use default keyword.
 * 
 * implement interface is public, but while defining it can be abstract
 */
package oopsInJava;

interface InterfaceCalculator1 {
	void add();
	/*
	 * behind the scene void add(); is public abstract void add();
	 */
	void sub();
}

class myCalculator1 implements InterfaceCalculator1 {
	public void add() {
		int a = 10;
		int b = 5;
		int res = a + b;
		System.out.println(res);
	}
	public void sub() {
		int a = 10;
		int b = 5;
		int res = a - b;
		System.out.println(res);
	}
}

interface InterfaceCalculator2 {
	void mul();
	void div();
}
interface InterfaceCalculator3 {
	void mul();
	void div();
}

class myCalculator2 implements InterfaceCalculator2, InterfaceCalculator3 {
	/*
	 * no diamond shape problem like inheritance
	 * a class can implementes multiple interface
	 */
	public void mul() {
		int a = 10;
		int b = 5;
		int res = a * b;
		System.out.println(res);
	}
	public void div() {
		int a = 10;
		int b = 5;
		int res = a / b;
		System.out.println(res);
	}
}

interface InterfaceCalculator4 {
	float pi = 3.14f;
	/*
	 * it is actually - public final static float pi = 3.13f;
	 */
	void add();
}

class myCalculator3 {
	void disp() {
		System.out.println("Disp from myCalculator3...");
	}
}

class myCalculator4 extends myCalculator3 implements InterfaceCalculator4 {
	public void add() {
		int a = 10;
		float res = a + pi;
		System.out.println(res);
	}
}

interface InterfaceCalculator5 {
	/*
	 * after java 8, we can have method with body as well.
	 * but if you want to use body in method, we must use default else error will be there.
	 */
	void draw();
	default void disp() {
		System.out.println("disp from InterfaceCalculator5");
	}
	public static void sleep() {
		System.out.println("sleep from InterfaceCalculator5");
	}
}

class myCalculator5 implements InterfaceCalculator5 {
	public void draw() {
		System.out.println("draw");
	}
	public void disp() {
		/*
		 * it is optional to override.
		 */
		System.out.println("disp");
	}
	public void sleep() {
		/*
		 * it is optional to override.
		 */
		System.out.println("sleeping");
	}
}

public class Interface {
	public static void main(String[] args) {
		myCalculator1 ex1 = new myCalculator1();
		ex1.add();
		ex1.sub();
		
		InterfaceCalculator1 ex2 = new myCalculator1();
		/*
		 * we can create refrence of interface type although we can't create objects of an interface.
		 * means interface can't be instantiated.
		 */
		ex2.add();
		ex2.sub();
		
		myCalculator2 ex3 = new myCalculator2();
		ex3.mul();
		ex3.div();
		
		myCalculator4 ex4 = new myCalculator4();
		ex4.add();
		
		myCalculator5 ex5 = new myCalculator5();
		ex5.draw();
		ex5.disp();
		ex5.sleep();
	}
}
