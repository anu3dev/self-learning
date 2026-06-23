package j005abstraction;

abstract class Course {
	String name = "Anurag";
	
	void bookRequested () {
		System.out.println("Book requested to admin = " + name);
	}
	
	abstract void coursePurchase(double amount);
}
