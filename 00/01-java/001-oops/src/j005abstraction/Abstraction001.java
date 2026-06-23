package j005abstraction;

/**
 * Show WHAT an object does, hide HOW it does it.
 * 
 * A class can extend only one parent class, if you try to extend multiple then Java will be confused
 * 	and this is called Diamond Problem
 */

public class Abstraction001 {
	public static void main(String args[]) {
		Course course1 = new Java();
		course1.coursePurchase(6999.00);
		course1.bookRequested();
		
		Course course2 = new React();
		course2.coursePurchase(2999.00);
		course2.bookRequested();
	}
}
