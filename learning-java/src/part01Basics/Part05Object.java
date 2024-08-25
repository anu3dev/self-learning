package part01Basics;

/*
 * 
 * Java is a strongly typed programming language
 * Every object in world has something and does something
 * Has means variables and does means methods.
 * Class is a blueprint, we crate object with this blueprint using new keyword.
 * 
 */

class ClassObjectEx1 {
	/*
	 * example of method with void, means it won't return anything.
	 */
	public void displayText() {
		System.out.println("Printing from Display method");
	}
	
	/*
	 * example of method which will return a value.
	 */
	int areaOfSquare(int a) {
		return a*a;
	}
}

public class Part05Object {
	public static void main(String[] args) {
		/*
		 * this is how we create object from class in java
		 */
		ClassObjectEx1 obj = new ClassObjectEx1();
		
		obj.displayText();
		
		int area = obj.areaOfSquare(12);
		System.out.println("Area of Square: " + area);
	}
}
