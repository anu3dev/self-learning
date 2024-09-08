/*
 *
 * A way to achieve abstraction using interface keyword.
 * Through interface, we can achieve 100% abstraction.
 * Interface can be used to specify our requirement which to be implemented.
 * All the methods present inside interface is by default public abstract.
 * It's compulsory for implementing class to override every method of an interface.
 * One interface can have any number of implementing classes.
 * A class can implement multiple interfaces.
 * We can create reference to an interface to achieve polymorphism but can't create object/instance of an interface.
 * An interface cannot implements another interface, an interface can extend another interface.
 * An interface can have variables and it will be public, static and final, it can't be modified.
 * We cannot have constructor in an interface.
 * We can't implement another interface in java, only we can extend other interface.
 * A class can extends as well as implement, it can implement one or more interfaces at a time.
 * At first it must extends a class then implements an interface.
 * We can have static methods in an interface but it must not be abstract, it must have implementation. 
 * Static method of an interface will not get inherited in implementing classes.
 * An interface can have method with body/implementation but we have to use default keyword.
 * Default methods will get inherited, it's not compulsory for to override, if need arises we can override as well.
 * A class can have specialized methods, but using interface type reference, we can't directly access, can be done through down casting.
 * We can instantiate interface by two ways, one is implements keyword and second is by anonymous inner class.
 *  
 */

interface Interface1 {
	/*
	 * 
	 * Behind the scene void add(int a, int b); is public abstract void add(int a, int b);
	 * 
	 */
	void add(int a, int b);
	public abstract void sub(int a, int b);
}

/*
 * 
 * Example of using a interface
 * 
 */
class MYCal1 implements Interface1 {
	@Override
	public void add(int a, int b) {
		int c = a + b;
		System.out.println("method MYCal1: Sum of two number is: " + c);
	}
	@Override
	public void sub(int a, int b) {
		int c = a - b;
		System.out.println("method MYCal1: Sub of two number is: " + c);
	}
}

interface Interface2 {
	int mul(int a, int b);
	public abstract int div(int a, int b);
}

class MYCal2 implements Interface2 {
	@Override
	public int mul(int a, int b) {
		int c = a * b;
		return c;
	}
	@Override
	public int div(int a, int b) {
		int c = a / b;
		return c;
	}
}

/*
 * 
 * A class can implements multiple interfaces as well
 * 
 */
class MYCal3 implements Interface1, Interface2 {
	@Override
	public void add(int a, int b) {
		int c = a + b;
		System.out.println("method MyCal3: Sum of two number is: " + c);
	}
	@Override
	public void sub(int a, int b) {
		int c = a - b;
		System.out.println("method MyCal3: Sub of two number is: " + c);
	}
	@Override
	public int mul(int a, int b) {
		int c = a * b;
		return c;
	}
	@Override
	public int div(int a, int b) {
		int c = a / b;
		return c;
	}
}

class Utils {
	/*
	 * 
	 * Static Methods-
	 * A static method in Java is a method that is part of a class rather than an instance of that class.
	 * To access a static method, we don't need an object of the class, methods can be only accessed by class name.
	 * Syntax: className.methodname()
	 * Static method can access only the static attribute of a class.
	 * It is an example of pass-by-reference programming.
	 * 
	 */
	public static String getNumberType(int num) {
		String type = num%2 == 0 ? "even" : "odd";
		return type;
	}
}

/*
 * 
 * Each implementation can have different body.
 * 
 */
class MYCal4 implements Interface1, Interface2 {
	@Override
	public void add(int a, int b) {
		int c = a + b;
		String d = Utils.getNumberType(c);
		System.out.println("method MyCal4: Sum of two number is: " + d);
	}
	@Override
	public void sub(int a, int b) {
		int c = a - b;
		String d = Utils.getNumberType(c);
		System.out.println("method MyCal4: Sub of two number is: " + d);
	}
	@Override
	public int mul(int a, int b) {
		int c = a * b;
		return c;
	}
	@Override
	public int div(int a, int b) {
		int c = a / b;
		return c;
	}
}

interface Interface3 {
	/*
	 * 
	 * It is actually - public final static float pi = 3.13f;
	 * 
	 */
	float pi = 3.14f;
	void areaOfCircle(int r);

	/*
	 * 
	 * After java 8, we can have method with body as well.
	 * But if you want to use body in method, we must use default else error will be there.
	 * 
	 */
	default void printHelloText() {
		System.out.println("Hello world!");
	}
	default void printHeyText() {
		System.out.println("Hey!");
	}
}

class MYCal5 implements Interface3 {
	public void areaOfCircle(int r) {
		float res = pi*r*r;
		System.out.println("mathod MYCal5: Area of circle is: " + res);
	}
	
	/*
	 * 
	 * it is optional to override.
	 * 
	 */
	public void printHeyText() {
		System.out.println("Hey Ram!");
	}
}

interface Interface4 {
	void drive();
}

public class Interface {
	public static void main(String[] args) {
		MYCal1 cal1 = new MYCal1();
		cal1.add(8,  4);
		cal1.sub(8, 4);
		
		MYCal2 cal2 = new MYCal2();
		System.out.println("method MyCal2: Sub of two number is: " + cal2.mul(8, 4));
		System.out.println("method MyCal2: Sub of two number is: " + cal2.div(8, 4));
		
		MYCal3 cal3 = new MYCal3();
		cal3.add(8,  4);
		cal3.sub(8, 4);
		System.out.println("method MyCal3: Sub of two number is: " + cal3.mul(8, 4));
		System.out.println("method MyCal3: Sub of two number is: " + cal3.div(8, 4));
		
		MYCal4 cal4 = new MYCal4();
		cal4.add(8,  4);
		cal4.sub(7,  4);
		System.out.println("method MyCal4: Sub of two number is: " + Utils.getNumberType(cal4.mul(7, 5)));
		System.out.println("method MyCal4: Sub of two number is: " + Utils.getNumberType(cal4.div(8, 4)));
		
		MYCal5 cal5 = new MYCal5();
		cal5.areaOfCircle(4);
		cal5.printHelloText();
		cal5.printHeyText();
		
		/*
		 * 
		 * we can instantiate interface by anonymous inner class
		 * 
		 */
		Interface4 cal6 = new Interface4() {
			public void drive() {
				System.out.println("drive method: Interface4");
			};
		};
		cal6.drive();
	}
}
