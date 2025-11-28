package main.vehicle;

public class Car implements IVehicle {
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
	public void drive() {
		System.out.println("car is driving.");
	}
}
