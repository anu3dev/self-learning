/*
 * 
 * class -> blue print
 * object -> instance
 * new -> used to create object using reference to a class
 * 
 * object -> memory allocated inside heap area
 * 
 * instance variable -> created directly within class, memory allocated inside heap area (within object)
 * Default value will be assigned and can be accessed within class and outside as well if object is not private
 * 
 * local variable -> created inside class within a method or a loop or a block, memory allocated inside stack area
 * Default values can't be assigned, can be accessed only within a method or block where ever they are defined and scope is local
 * 
 * control will go to main and it will create a main area inside stack then memory allocation will happen inside heap 
 * and default value will be assigned, then all the operations will be taken place inside stack.
 * 
 * Heap is only used for instance variables and rest happens inside stack
 * 
 * Heap memory error -> out of memory error
 * Stack memory error -> stack overflow error
 * 
 * Garbage collection in Java is the automated process of deleting code that's no longer needed or used.
 * 
 * function and method => if we write function inside a class then it is method 
 * and if we write only function like java script then it is function.
 * 
 * Main method can be overloaded in java. However JVM always invokes main method having String[] args as parameter.
 * 
 */

class OopsDog {		
	/*
	 * 
	 * a class can have mix of variable and/or methods.
	 * variables declared outside of method are instance variables.
	 * 
	 */
	int cost;
	
	void eat() {
		
		/*
		 * 
		 * local variable can't have default value, it will produce errors
		 * 
		 */
		// int marks;
		// System.out.println(marks);
		
		/*
		 * 
		 * instance variable can have default value
		 * instance variables can be used anywhere in program.
		 * 
		 */
		System.out.println("cost: " + cost);
		System.out.println("num: " + num);
		System.out.println("color: " + color);
	}
	
	int num = 18;				
	int color;
	
	void demo() {
		
		/*
		 * 
		 * local variable -> can be used where it declared 
		 *   
		 */
		int numb = 20;	
		System.out.println("numb: " + numb);
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

public class P01OOPS {
	public static void main(String[] args) {
		
		/*
		 * 
		 * example of object creation
		 * 
		 */
		OopsDog dg = new OopsDog();
		dg.eat();
		dg.demo();
		
		/*
		 * 
		 * Using single class, we can create multiple objectS.
		 * 
		 */
		OopsDog dg1 = new OopsDog();
		dg1.eat();
		dg1.demo();
		
		OopsCalculator cal = new OopsCalculator();
		cal.add();
		
		/*
		 * 
		 * example of reference variable
		 * 
		 */
		int a = 15;
		int b = 25;
		cal.add1(a, b);
	}
}


