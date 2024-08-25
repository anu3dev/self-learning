package part02OOPS;

/*
 * 
 * class -> blue print
 * object -> instance
 * new -> used to create object using refrence to a class
 * 
 * 
 * object -> memory allocated inside heap area
 * 
 * 
 * instance variable -> created directly within class, memory allocated inside heap area (within object)
 * Default value will be assigned and can be accessed within class and outside as well if object is not private
 * 
 * 
 * local variable -> created inside class within a method or a loop or a block, memory allocated inside stack area
 * Default values can't be assigned, can be accessed only within a method or block whereever they are defined and scope is local
 * 
 * 
 * control will go to main and it will create a main area inside stack then memory allocation will happen inside heap 
 * and default value will be assigned, then all the operations will be taken place inside stack.
 * 
 * 
 * Heap is only used for instance variables and rest happens inside stack
 * 
 * 
 * Heap memory error -> out of memory error
 * Stack memory error -> stack overflow error
 * 
 * 
 * Garbage collection in Java is the automated process of deleting code that's no longer needed or used.
 * 
 * 
 * function and method => if we write function inside a class then it is method 
 * and if we write only function like javascript then it is function.
 * 
 * 
 * Main method can be overloaded in java. However JVM always invokes main method having String[] args as parameter.
 * 
 */

class OopsDog {		
	/*
	 * a class can have mix of variable and / or methods.
	 * object variables are instance variable.
	 */
	String name;
	int cost;
	
	void eat() {
		System.out.println("Eating");
		
		// int marks;
		// System.out.println(marks);
		
		/*
		 * local variable can't have default value, it will produce errors
		 */
		
		System.out.println(cost);
		/*
		 * instance variable can have default value
		 */
	}
	
	void sleep() {
		System.out.println("Sleeping");
	}
	
	int num = 18;				
	int marks;
	/*
	 * instance variable -> can be used anywhere in program.
	 */
	
	void demo() {
		int numb = 20;	
		/*
		 * local variable -> can be used where it declared   
		 */
		System.out.println(numb);
	}
}

class OopsCalculator {
	int num1;
	int num2;
	int res;
	
	void add() {
		num1 = 10;
		num2 = 20;
		res = num1 + num2;
		System.out.println(res);
	}
	
	void add1(int a, int b) {
		num1 = a;
		num2 = b;
		res = num1 + num2;
		System.out.println(res);
	}
}

public class Part01OOPS {
	public static void main(String[] args) {
		/*
		 * example of reference variable and object creation
		 */
		OopsDog dg = new OopsDog();
		dg.eat();
		dg.sleep();
		
		/*
		 * with using single class, we can create multiple objectS.
		 */
		OopsDog dg1 = new OopsDog();
		dg1.eat();
		dg1.sleep();
		
		OopsCalculator cal = new OopsCalculator();
		cal.add();
		
		int a = 15;
		int b = 25;
		
		cal.add1(a, b);
	}
}


