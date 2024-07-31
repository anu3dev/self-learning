/*
 * Hardware => OS => JDK => JRE => JVM, Basically JRE has libraries and JVM
 * Java is a platform independent but JVM is not, JVM is platform dependent and it only understands byte code.
 * Different JVM is designed for different OS and byte code is able to run on different OS.
 * When we write java code, it is compiled by javac and converted into byte code and then JVM runs the code.
 * Extension of java code is .java and extension for byte code is .class
 * 
 * We follow concept of WORA in java - Write Once Run Anywhere
 *  
 * Java can have multiple files so first file needs to have main method with signature public static void main(String[] args)
 * 
 * if return will be there then we can't use void.
 */

/*
 * sample package creation
 */
package basicsInJava;

/*
 * sample class creation
 */
class HelloWorldEx1 {
	
	/*
	 * sample construction creation manually inside a class, 
	 * although whenever object is created, default constructor will be called
	 */
	HelloWorldEx1() {
		System.out.println("Hello World from constructor");
	}
	
	/*
	 * sample method creation inside a class
	 */
	public void Print() {
		System.out.println("Hello World from method");
	}
}

public class HelloWorld {
	public static void main(String[] args) {
		/*
		 * sample message print
		 */
		System.out.print("Hello World");
		
		/*
		 * sample message print in new line
		 */
		System.out.println("Hello World");
		
		/*
		 * creation of a object from a class, as soon as we create an object, constructor will be called.
		 * if Developer didn't write constructor then default constructor will be called.
		 * if developer has already written then it will be called on the basis of parameter, Method overloading concept will be there.
		 */
		HelloWorldEx1 ex1 = new HelloWorldEx1();
		
		/*
		 * calling a method from object created using class.
		 */
		ex1.Print();
	}
}
