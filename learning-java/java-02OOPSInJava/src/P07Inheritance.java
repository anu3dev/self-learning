

/*
 * 
 * Whenever we create Object of a class , reference variable must be of same type as that of the object.
 * ex. Dog d = new Dog();
 * However in one case reference variable can be of diff type i.e if the reference variable is of Parent type 
 * then it's allowed. 
 * ex. Animal a=new Dog();
 * Using Parent type reference, we can access inherited and overridden methods of a child class 
 * however we cannot access specialized method of child class using parent reference directly. 
 * But that can be achieved by performing Casting(Down casting);
 * 
 * Down casting --> Temporarily changing the behavior from parent type to child type to access specialized method of a child class.
 * Up casting --> Creating parent ref for child type Object. 
 * ex. Plane ref = new CargoPlane();
 * 
 */
class Plane {
	/*
	 * 
	 * inherited method example
	 * 
	 */
	public void takeOff() {
		System.out.println("Plane is taking off.......");
	}

	public void landing() {
		System.out.println("Plane is landing.......");
	}
}

class CargoPlane extends Plane {
	/*
	 * 
	 * Overridden method example
	 * method overriding - run time polymorphism
	 *  
	 */
	public void landing() {
		System.out.println("Cargo plane is landing.......");
	}

	/*
	 * 
	 *  Specialized methods example
	 *  
	 */
	public void carryGoods() {
		System.out.println("cargo plane is carrying goods.......");
	}
}

class Plane0 {
	public void takeOff() {
		System.out.println("Plane is taking off......");
	}

	public void landing() {
		System.out.println("Plane is landing......");
	}

}

class CargoPlane0 extends Plane0 {
	@Override
	public void landing() {
		System.out.println("Cargo plane is landing.....");
	}

	public void carryGoods() {
		System.out.println("Cargo plane carry goods....");
	}

}

class FighterPlane0 extends Plane0 {
	public void landing() {
		System.out.println("Fighter plane is landing.....");
	}

	public void carryWeapons() {
		System.out.println("Fighter plane carry Weapons....");
	}

}

class Plane2 {
	public void takeOff() {
		System.out.println("Plane is taking off......");
	}

	public void landing() {
		System.out.println("Plane is landing......");
	}
}

class CargoPlane2 extends Plane2 {
	public void takeOff() {
		System.out.println("Cargo plane is taking off......");
	}

	@Override
	public void landing() {
		System.out.println("Cargo plane is landing.....");
	}
}

class FighterPlane2 extends Plane2 {
	public void takeOff() {
		System.out.println("Fighter plane is taking off......");
	}

	public void landing() {
		System.out.println("Fighter plane is landing.....");
	}
}

class PassengerPlane2 extends Plane2 {
	public void takeOff() {
		System.out.println("Passenger plane is taking off......");
	}

	public void landing() {
		System.out.println("Passenger plane is landing.....");
	}
}

class Airport {
	public void permit(Plane2 ref) {
		ref.takeOff();
		ref.landing();

	}
}

public class P07Inheritance {
	public static void main(String[] args) {
		System.out.println();
		CargoPlane cp = new CargoPlane();
		cp.carryGoods();
		cp.landing();
		cp.takeOff();
		
		System.out.println();
		Plane cp1 = new CargoPlane();
		cp1.landing();
		cp1.takeOff();

		System.out.println();
		Plane0 cp2 = new CargoPlane0();
		cp2.takeOff();
		cp2.landing();
		((CargoPlane0) cp2).carryGoods();
		
		System.out.println();
		FighterPlane0 fp = new FighterPlane0();
		fp.takeOff();
		fp.landing();
		fp.carryWeapons();

		System.out.println();
		Airport a2 = new Airport();
		CargoPlane2 cp3 = new CargoPlane2();
		FighterPlane2 fp2 = new FighterPlane2();
		PassengerPlane2 pp2 = new PassengerPlane2();
		a2.permit(cp3);
		a2.permit(fp2);
		a2.permit(pp2);
	}
}
