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

class ExceptionalHandlingEx1 {
	@SuppressWarnings("resource")
	ExceptionalHandlingEx1(){
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
class ExceptionalHandlingEx2 {
	@SuppressWarnings("resource")
	ExceptionalHandlingEx2(){
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
class ExceptionalHandlingEx3 {
	@SuppressWarnings("resource")
	ExceptionalHandlingEx3(){
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
			 * pre-defined exception handler for arithmetic operations
			 */
		} catch(ArithmeticException e) {
			System.out.println("enter non zero denominator");
			/*
			 * pre-defined exception handler for negative size of array
			 */
		} catch(NegativeArraySizeException e) {
			System.out.println("please be positive");
			/*
			 * pre-defined exception handler for array boundary
			 */
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("please be in your limit");
			/*
			 * example of generic exception handler kind of parent exception
			 */
		} catch(Exception e) {
			System.out.println("please enter valid input");
		}
		
		System.out.println("connection is terminated");
	}
}

/*
 * example ExceptionalHandlingEx3 can be written in a better way like below
 * 
 * we can't write pre-defined exception handlwer twice within a method
 */
class ExceptionalHandlingEx4 {
	@SuppressWarnings("resource")
	ExceptionalHandlingEx4(){
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

class Demo{
	void alpha() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Kindly enter numerator");
		int num1 = scan.nextInt();
		System.out.println("Kindly enter denumerator");
		int num2 = scan.nextInt();
		System.out.println("result is: " + num1/num2);
	}
}

/*
 * if user enters invalid denominator value then exception handler object will be created 
 * 
 * exception handler object will have name of exception, description of exception and stack trace of the exception
 * it has throwable exception methods like below
 * 1. e.getMessage() -> print description of exception
 * 2. e.toString() -> print the name and description of the exception
 * 3. e.printStackTrace() -> prints name and description along with stack trace
 * 
 * exception handler object will be passed to the JVM, then JVM will try to find exception handler in same method 
 * like in below example, will try to find inside alpha method and if it doesn't find then it will check with caller 
 * i.e. like in below example, object ob1 and if it still doesn't find then again it will go and check inside main method 
 * and if it still doesn't find then it will call default exception handler and abrupt termination will happen.
 * 
 * whenever we are ducking the exception then just inform to caller, like if we are not writting exception 
 * in alpha method i.e. ducking the exception then we should inform caller so that caller method should handle this.
 */
class ExceptionalHandlingEx5 {
	ExceptionalHandlingEx5(){
		System.out.println("connection is established");
		
		Demo ob = new Demo();
		ob.alpha();
		
		/*
		 * alpha method inside ob is ducking the exception and handled by caller here
		 */
		try {
			Demo ob1 = new Demo();
			ob1.alpha();
		} catch(Exception e) {
			System.out.println("child is ducking and exception is being handled by caller");
		}
	}
}

/*
 * checked exception is being ducked by compiler, but it is just a kind of warning bcos if exception will be there 
 * then it will occur on run time only
 * for example, in below example, child using throws keyword for checked exception
 * and it is being handled by caller i.e. main method
 */
class ExceptionalHandlingEx6 {
	ExceptionalHandlingEx6() throws Exception{
		System.out.println("connection is established");
		/*
		 * without decking it will create error bcos it is checked exception
		 */
		Thread.sleep(5000);
		System.out.println("connection is terminated");
	}
}

class Demo1{
	void alpha() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Kindly enter numerator");
			int num1 = scan.nextInt();
			System.out.println("Kindly enter denumerator");
			int num2 = scan.nextInt();
			System.out.println("result is: " + num1/num2);
		} catch(Exception e) {
			System.out.println("ducking the exception and handled by caller");
			throw e;
		}
		System.out.println("one");
	}
}

/*
 * example of throwing exception using throw keyword, if exception occours then lines below throw keyword will not be executed.
 * if want to execute those lines then we have to add finally
 * throw keyword is being used to re-throw the exception
 */
class ExceptionalHandlingEx7 {
	ExceptionalHandlingEx7(){
		System.out.println("connection is established");
		
		try {			
			Demo1 ob = new Demo1();
			ob.alpha();
		} catch(Exception e) {
			System.out.println("exception is being handled by caller");
		}
	}
}

class Demo2{
	void alpha() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Kindly enter numerator");
			int num1 = scan.nextInt();
			System.out.println("Kindly enter denumerator");
			int num2 = scan.nextInt();
			System.out.println("result is: " + num1/num2);
		} catch(Exception e) {
			System.out.println("re-throwing the exception and handled by caller");
			throw e;
		}
		finally {
			System.out.println("I am from final block");
		}
	}
}

/*
 * finally keyword is dominating the throw and it will always be executed, exception occours or not, it will be executed.
 * ideal way to write a code with try, catch and finally
 * if abrupt termination happen, then also finally will be executed.
 */
class ExceptionalHandlingEx8 {
	ExceptionalHandlingEx8(){
		System.out.println("connection is established");
		
		try {			
			Demo2 ob = new Demo2();
			ob.alpha();
		} catch(Exception e) {
			System.out.println("exception is being handled by caller");
		}
	}
}

class Demo3{
	void alpha() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Kindly enter numerator");
			int num1 = scan.nextInt();
			System.out.println("Kindly enter denumerator");
			int num2 = scan.nextInt();
			System.out.println("result is: " + num1/num2);
		} catch(Exception e) {
			System.out.println("re-throwing the exception and handled by caller");
			throw e;
		}
		//System.exit(0);
		finally {
			System.out.println("I am from final block");
		}
	}
}

/*
 * if we write System.exit(); then only finally will not executed
 * priority order -> System.exit() > finally > throw
 */
class ExceptionalHandlingEx9 {
	ExceptionalHandlingEx9(){
		System.out.println("connection is established");
		
		try {			
			Demo3 ob = new Demo3();
			ob.alpha();
		} catch(Exception e) {
			System.out.println("exception is being handled by caller");
		}
	}
}

public class ExceptionalHandling {
	public static void main(String[] args) {
		//new ExceptionalHandlingEx1();
		
		//new ExceptionalHandlingEx2();
		
		new ExceptionalHandlingEx3();
		
		//new ExceptionalHandlingEx4();
		//new ExceptionalHandlingEx5();
		
		//try {
		//	new ExceptionalHandlingEx6();
		//} catch(Exception e) {
		//	System.out.println("checked exception is being ducked by child using throws and handled by caller");
		//}
		
		//new ExceptionalHandlingEx7();
		//new ExceptionalHandlingEx8();
		//new ExceptionalHandlingEx9();
	}
}