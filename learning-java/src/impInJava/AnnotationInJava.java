/*
 * Annonation - meta data or extra information
 * It won't pass to the compiler, it is only for dev understanding
 * 
 * few meta data info can also be passed, for eg. @Override
 */

/*
 * this is the parent class where I have defined abstract level requirement about plane
 */
package impInJava;

class PlaneEx1{
	public void fliesAtHighHeight() {
		System.out.println("Plane flies at high height");
	}
}

/*
 * this is child class of Plane which is implementing parent class Plane
 */
class CargoPlaneEx1 extends PlaneEx1{
	@Override
	public void fliesAtHighHeight() {
		System.out.println("Cargo Plane flies at lower height then other plane");
	}
}

class AnnotationInJavaEx1{
	public AnnotationInJavaEx1() {
		
		/*
		 * here dev is thinking, he has over-ridden the parent method but not
		 * as soon as compiler will see @Override, then it will produce error for dev
		 * annotation like @Override will also be passed to compiler
		 */
		PlaneEx1 cargoPlane = new CargoPlaneEx1();
		cargoPlane.fliesAtHighHeight();
	}
}

/*
 * this is example of functional interface
 * 
 * after adding @FunctionalInterface, if dev will try to add any other method then
 * compiler will show error.
 */
@FunctionalInterface
interface CountryEx1 {
	void india();
	
//	void nepal();
}

public class AnnotationInJava {
	public static void main(String[] args) {
		new AnnotationInJavaEx1();
	}
}
