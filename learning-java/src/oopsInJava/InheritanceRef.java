package oopsInJava;

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
		System.out.println("Cargo plane requires longer runway to land.....");
	}

	public void carryGoods() {
		System.out.println("CargoPlane carry goods....");
	}

}

class FighterPlane0 extends Plane0 {
	public void landing() {
		System.out.println("Fighter plane requires shorter runway to land.....");
	}

	public void carryWeapons() {
		System.out.println("FighterPlane carry Weapons....");
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
		System.out.println("CargoPlane is requires longer runway to take off......");
	}

	@Override
	public void landing() {
		System.out.println("Cargo plane requires longer runway to land.....");
	}
}

class FighterPlane2 extends Plane2 {
	public void takeOff() {
		System.out.println("FighterPlane is requires shorter runway to take off......");
	}

	public void landing() {
		System.out.println("Fighter plane requires shorter runway to land.....");
	}
}

class PassengerPlane2 extends Plane2 {
	public void takeOff() {
		System.out.println("PassengerPlane is requires medium runway to take off......");
	}

	public void landing() {
		System.out.println("Passenger plane requires medium size runway to land.....");
	}
}

class Airport {
	public void permit(Plane2 ref) {
		ref.takeOff();
		ref.landing();

	}
}

public class InheritanceRef {
	public static void main(String[] args) {

		Plane0 cp = new CargoPlane0();
		cp.takeOff();
		cp.landing();
		((CargoPlane0) cp).carryGoods();
		FighterPlane0 fp = new FighterPlane0();
		fp.takeOff();
		fp.landing();
		fp.carryWeapons();

		Airport a2 = new Airport();
		CargoPlane2 cp2 = new CargoPlane2();
		FighterPlane2 fp2 = new FighterPlane2();
		PassengerPlane2 pp2 = new PassengerPlane2();
		a2.permit(cp2);
		a2.permit(fp2);
		a2.permit(pp2);
	}
}
