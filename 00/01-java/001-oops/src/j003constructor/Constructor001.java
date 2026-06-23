package j003constructor;

/**
 * Special method which same name as class.
 * Called at the time of object creation.
 * 
 * There can be multiple constructor, it will be invoked based of parameters.
 * 
 * Calling same method name with different parameter is called method overloading, it is 
 * 	also called as compile time polymorphism.
 */

class EmployeeJ003 {
	EmployeeJ003(){
		System.out.println("object created");
	}
}

class CarJ003 {
	String color;
	String brand;
	
	CarJ003(String color, String brand){
		this.color = color;
		this.brand = brand;
	}
	
	void status () {
		System.out.println(brand + " of color " + color + " is running.");
	}
}

class StudentJ003 {
	String name;
	Integer age;
	
	StudentJ003(){
		System.out.println("object created.");
	}
	
	StudentJ003(String name){
		System.out.println("object created with name = " + name);
	}
	
	StudentJ003(String name, Integer age){
		System.out.println("object created with name = " + name + " and age = " + age);
	}
}

public class Constructor001 {
	public static void main(String[] args) {
		EmployeeJ003 emp1 = new EmployeeJ003();
		
		CarJ003 car1 = new CarJ003("red", "tata");
		car1.status();
		
		StudentJ003 std1 = new StudentJ003();
		StudentJ003 std2 = new StudentJ003("anurag");
		StudentJ003 std3 = new StudentJ003("anurag", 32);
	}
}
