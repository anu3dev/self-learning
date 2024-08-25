/*
 * sample package creation
 */
package part01Basics;
/*
 * 
 * Created in 1995-1996 by Green team of Sun microsystems, James gosling was lead.
 * At that time C was available for functional programming and C++ was ruling the world with OOPS programming and it was from Bell labs.
 * Sun made Java free, open sourced, object oriented and portable or platform independent, these were the reasons of popularity of java.
 * In 2011, Oracle acquired Sun microsystems and made it closed sourced.
 * 
 * 
 * Hardware => OS => JDK => JRE => JVM, Basically JRE has libraries and JVM
 * Java is a platform independent but JVM is not, JVM is platform dependent and it only understands byte code.
 * When we write java code in english, it is compiled by javac i.e. Java compiler converts into byte code.
 * JVM takes this byte code and covert it for respective platform.
 * Extension of java code is .java and extension for byte code is .class
 * 
 * 
 * Java is object oriented, platform independent or WORA and case-sensetive language.
 * 
 * 
 * Java can have multiple files so first file needs to have main method with signature public static void main(String[] args)
 * if return will be there then we can't use void.
 * 
 */

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

public class Part01HelloWorld {
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
