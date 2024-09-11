/*
 * 
 * Exception happens only at runtime, not at compile time.
 * we can write custom exception handler using try and catch to handle the smooth termination if 
 * unwanted things happen, else JVM will call default exception handler and abrupt termination will happen.
 * 
 * if exception is generated:
 * 1. handle exception by try and catch
 * 2. duck the exception by throws keyword
 * 3. re-throwing the exception by throw, throws, try, catch , finally etc.
 * 
 * in java two category of exception
 * 1. identify and anticipate possibility of exception called as unchecked exception where compiler will not check
 * 2. compiler will produce warning like at this line, exception might occur, for exp. 
 * ExceptionalHandlingEx6 called checked exception.
 * 
 * checked exception will also occur at runtime only, compiler just produces warning.
 * 
 */

/*
 * 
 * example of code without exception handling - with abrupt termination
 * 
 * suppose user enters some unexpected denominator value like 100 and 0 then program will be abruptly terminated. 
 * Since we have not added exception handler, JVM will call default exception handler so that whole system shouldn't crash.
 * for exp: it should be within java boundary only, it should not impact the whole CPU.
 * default exception handler will not stop the abrupt termination.
 * 
 */

import java.util.Scanner; 

class ExceptionalHandlingP01Ex1 {
	@SuppressWarnings("resource")
	ExceptionalHandlingP01Ex1(){
		System.out.println("connection is established");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Kindly enter numerator");
		int num1 = scan.nextInt();
		
		System.out.println("Kindly enter denominator");
		int num2 = scan.nextInt();
		
		System.out.println("result is: " + num1/num2);
		
		System.out.println("connection is terminated");
	}
}

/*
 * 
 * example of basic exception handling - with smooth termination
 * 
 * As a programmer, you have to figure out, where code can break and use try catch to handle the exception. 
 * Since we have added exception handler, abrupt termination will not happen, if user enters some unexpected denominator value like 100 and 0.
 * 
 */
class ExceptionalHandlingP01Ex2 {
	@SuppressWarnings("resource")
	ExceptionalHandlingP01Ex2(){
		System.out.println("connection is established");
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Kindly enter numerator");
			int num1 = scan.nextInt();
		
			System.out.println("Kindly enter denominator");
			int num2 = scan.nextInt();
			System.out.println("result is: " + num1/num2);
		} catch(Exception e) {
			System.out.println("please enter integer data or non-zero");
		}
	}
}

/*
 * 
 * example of basic exception handling - with smooth termination
 * 
 * suppose user enters size of array either as any negative value or position greater than size of array 
 * then exception will come into picture
 * 
 * in below example, some pre-defined and generic exception handlers are defined
 * 
 * parent exception handler will be called if any error can't be handled by pre-defined handlers,
 * for example enter denominator as any letter like a or size of array as negative
 * 
 */
class ExceptionalHandlingP01Ex3 {
	@SuppressWarnings("resource")
	ExceptionalHandlingP01Ex3(){
		System.out.println("connection is established");
		
		try {
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Kindly enter numerator");
			int num1 = scan.nextInt();
			System.out.println("Kindly enter denominator");
			int num2 = scan.nextInt();
			System.out.println("result is: " + num1/num2);
		
			System.out.println("enter the size of array");
			int size = scan.nextInt();
			int []ar = new int[size];
			System.out.println("enter element to be inserted in array");
			int elem = scan.nextInt();
			System.out.println("enter position where data should be inserted");
			int pos = scan.nextInt();
			ar[pos] = elem;
		
			System.out.println("stored data at position: " + pos + " is: " + ar[pos]);
			/*
			 * 
			 * pre-defined exception handler for arithmetic operations
			 * 
			 */
		} catch(ArithmeticException e) {
			System.out.println("enter non zero denominator");
			/*
			 * 
			 * pre-defined exception handler for negative size of array
			 * 
			 */
		} catch(NegativeArraySizeException e) {
			System.out.println("please be positive");
			/*
			 * 
			 * pre-defined exception handler for array boundary
			 * 
			 */
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("please be in your limit");
			/*
			 * 
			 * example of generic exception handler kind of parent exception
			 * 
			 */
		} catch(Exception e) {
			System.out.println("please enter valid input");
		}
		
		System.out.println("connection is terminated");
	}
}

/*
 * 
 * example ExceptionalHandlingEx3 can be written in a better way like below
 * 
 * we can't write pre-defined exception handler twice within a method
 * 
 */
class ExceptionalHandlingP01Ex4 {
	@SuppressWarnings("resource")
	ExceptionalHandlingP01Ex4(){
		System.out.println("connection is established");
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("Kindly enter numerator");
			int num1 = scan.nextInt();
			System.out.println("Kindly enter denumerator");
			int num2 = scan.nextInt();
			System.out.println("result is: " + num1/num2);
		} catch(ArithmeticException e) {
			System.out.println("enter non zero denometor");
		}
		
		try {
			System.out.println("enter the size of array");
			int size = scan.nextInt();
			int []ar = new int[size];
		
			System.out.println("enter element to be inserted in array");
			int elem = scan.nextInt();
			System.out.println("enter position where data should be inserted");
			int pos = scan.nextInt();
			ar[pos] = elem;
		
			System.out.println("stored data at position: " + pos + " is: " + ar[pos]);
		} catch(NegativeArraySizeException e) {
			System.out.println("please be positive");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("please be in your limit");
		} catch(Exception e) {
			System.out.println("please enter valid input");
		}
		
		System.out.println("connection is terminated");
	}
}

public class P03ExceptionalHandling {
	public static void main(String[] args) {
		//new ExceptionalHandlingP01Ex1();
		
		//new ExceptionalHandlingP01Ex2();
		
		//new ExceptionalHandlingP01Ex3();
		
		//new ExceptionalHandlingP01Ex4();
	}
}