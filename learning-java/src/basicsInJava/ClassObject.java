package basicsInJava;

class ClassObjectEx1 {
	/*
	 * example of method with void, means it won't return anything.
	 */
	public void displayText() {
		System.out.println("Printing from Display method");
	}
	
	/*
	 * example of method which will retuurn a value.
	 */
	int areaOfSquare(int a) {
		return a*a;
	}
}

public class ClassObject {
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
