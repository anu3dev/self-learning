package main.course;

public class React implements ICourse {
	/**
	 * @Override is not required, but it is strongly recommended 
	 * — because it provides compiler-level safety and clarity.
	 * 
	 * Always use @Override when:
	 * Implementing an interface method ✅
	 * Overriding a superclass method ✅
	 * Implementing methods from an abstract class ✅
	 */	
	@Override
	public void purchageCourse(double price) {
		System.out.println("react course purchased in INR : " + price);
	}
}