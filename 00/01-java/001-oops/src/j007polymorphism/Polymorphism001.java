package j007polymorphism;

/**
 * Same method call, different behavior.
 * One interface, many implementations.
 */

public class Polymorphism001 {
	public static void main(String[] args) {
		Course course1 = new Java();
		course1.coursePurchase(6999.99);
		
		Course course2 = new React();
		course2.coursePurchase(2999.99);
	}
}

/**
 * difference between abstract and interface
 * 1. contract only in interface but contract + shared implementation in abstract
 * 2. interface used for loose coupling but abstract used for common behavior
 * 3. interface is most common in spring, abstract is less common in spring
 * 4. multiple interfaces are allowed but single inheritance only using abstract (Diamond problem) 
 */