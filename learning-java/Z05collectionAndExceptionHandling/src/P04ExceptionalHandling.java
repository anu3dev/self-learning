import java.util.Scanner;

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
 * 
 * if user enters invalid denominator value then exception handler object will be created 
 * 
 * exception handler object will have name, description and stack trace of the exception.
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
 * whenever we are ducking the exception then just inform to caller, like if we are not writing exception 
 * in alpha method i.e. ducking the exception then we should inform caller so that caller method should handle this.
 * 
 */
class ExceptionalHandlingP02Ex1 {
	ExceptionalHandlingP02Ex1(){
		System.out.println("connection is established");
		
		/*
		 * 
		 * exception is not being handle by either caller or called.
		 * 
		 */
		Demo ob = new Demo();
		ob.alpha();
		
		/*
		 * 
		 * alpha method inside ob1 is ducking the exception and handled by caller here
		 * 
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
 * 
 * checked exception is being ducked by compiler, but it is just a kind of warning bcos if 
 * exception will be there then it will occur on run time only
 * for exp, in below example, child using throws keyword for checked exception
 * and it is being handled by caller i.e. main method
 * 
 */
class ExceptionalHandlingP02Ex2 {
	ExceptionalHandlingP02Ex2() throws Exception{
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
	}
}

/*
 * 
 * exp of throwing exception using throw keyword, if exception occurs then lines below throw keyword will not 
 * be executed, if want to execute those lines then we have to add finally
 * throw keyword is being used to re-throw the exception
 * 
 */
class ExceptionalHandlingP02Ex3 {
	ExceptionalHandlingP02Ex3(){
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
 * 
 * finally keyword is dominating the throw and it will always be executed, exception occurs or not,
 * it will be executed., ideal way to write a code with try, catch and finally
 * if abrupt termination happen, then also finally will be executed.
 */
class ExceptionalHandlingP02Ex4 {
	ExceptionalHandlingP02Ex4(){
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
 * 
 * if we write System.exit(); then only finally will not executed
 * priority order -> System.exit() > finally > throw
 * 
 */
class ExceptionalHandlingP02Ex5 {
	ExceptionalHandlingP02Ex5(){
		System.out.println("connection is established");
		
		try {			
			Demo3 ob = new Demo3();
			ob.alpha();
		} catch(Exception e) {
			System.out.println("exception is being handled by caller");
		}
	}
}

public class P04ExceptionalHandling {
	public static void main(String[] args) {
		//new ExceptionalHandlingP02Ex1();
		
		//try {
			//new ExceptionalHandlingP02Ex2();
		//} catch(Exception e) {
			//System.out.println("checked exception is being ducked by child using throws and handled by caller");
		//}
		
		//new ExceptionalHandlingP02Ex3();
		
		//new ExceptionalHandlingP02Ex4();
		
		//new ExceptionalHandlingP02Ex5();
	}
}