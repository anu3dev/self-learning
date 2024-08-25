package part01Basics;

/*
 * method overloading - we can have method with same name but signature should be different.
 * signature means parameter type or number of parameter should be different.
 * method will be called on the basis of param here.
 * 
 * method overloading is also called compiled time polymorphism.
 */

class MethodOverloadingEx1 {
	
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	
	public int add(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
	
	public double add(double num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
}

public class Part07MethodOverloading {

	public static void main(String[] args) {
		MethodOverloadingEx1 ex1 = new MethodOverloadingEx1();

		int result = ex1.add(5,3);
		/*
		 * calling method with two values.
		 * 
		 * output -> 8
		 */
		System.out.println(result);
		
		int result1 = ex1.add(5,3,8);
		/*
		 * calling method with 3 values.
		 * 
		 * output -> 16
		 */
		System.out.println(result1);
		
		double result2 = ex1.add(5.3,3,7);
		/*
		 * calling method with three values but param type is different.
		 * 
		 * output -> 15.3
		 */
		System.out.println(result2);
	}
}
