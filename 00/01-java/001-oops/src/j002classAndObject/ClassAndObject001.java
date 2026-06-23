package j002classAndObject;

/**
 * A class is a blueprint/template/design for creating objects. 
 * A class is a blueprint/template that defines properties (state) and behaviors (methods) of objects.
 * 
 * An object is a real instance of a class.
 * An object is a runtime instance of a class that occupies memory and contains actual data.
 * 
 * In below example, car is class and car1, car2 are examples of objects.
 */

class CarJ002 {
	String brand;
	String color;
	
	void status() {
		System.out.println(brand + " of color " + color + " is running.");
	}
}

class EmployeeJ002 {
	String name;
	
	void action() {
		System.out.println(name + " is working.");
	}
}

public class ClassAndObject001 {
	public static void main(String[] args) {
		
		CarJ002 car1 = new CarJ002();
		car1.brand = "maruti";
		car1.color = "red";
		car1.status();
		
		CarJ002 car2 = new CarJ002();
		car2.brand = "tata";
		car2.color = "black";
		car2.status();
		
		EmployeeJ002 emp = new EmployeeJ002();
		emp.name = "anurag";
		emp.action();
	}
}
