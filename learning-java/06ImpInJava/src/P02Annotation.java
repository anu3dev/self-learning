/*
 * 
 * Annotation - meta data or extra information
 * It won't pass to the compiler, it is only for dev understanding
 * 
 * few meta data info can also be passed, for exp. @Override
 * 
 */

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

class PlaneEx1{
	public void fliesAtHeight() {
		System.out.println("Plane flies at high height");
	}
}

class CargoPlaneEx1 extends PlaneEx1{
	@Override
	public void fliesAtHeight() {
		System.out.println("Cargo Plane flies at lower height then other plane");
	}
}

class AnnotationEx1{
	public AnnotationEx1() {
		
		/*
		 * 
		 * annotation like @Override will be passed to compiler
		 * 
		 */
		PlaneEx1 cargoPlane = new CargoPlaneEx1();
		cargoPlane.fliesAtHeight();
	}
}

/*
 * 
 * this is example of functional interface
 * after adding @FunctionalInterface, if dev will try to add any other method then compiler will show error.
 * 
 */
@FunctionalInterface
interface CountryEx1 {
	void india();
	//void nepal();
}

/*
 * 
 * Annotation works based on mechanism of an interface, when we write like @interface, 
 * it means we are informing compiler that annotation type is being created, it is not interface.
 * we can create custom annotation like below.
 * 
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
@interface RunsScored {}

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.CONSTRUCTOR)
@interface Beauty {}

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
@interface Setter {}

/*
 * 
 * below can be @Target
 * @Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR})
 * 
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface CricketPlayer {
	String country() default "India";
	int age() default 43;
}

@CricketPlayer
class ViratKohli {
	@RunsScored
	int runs;
	
	@Beauty
	public ViratKohli() {
		System.out.println("Kohli is the best");
	}
	
	@Setter
	public void setRuns(int runs) {
		this.runs = runs;		
	}
}

class AnnotationEx2 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AnnotationEx2() {
		ViratKohli vk = new ViratKohli();
		vk.setRuns(12000);
		
		Class cl = vk.getClass();
		Annotation an = cl.getAnnotation(CricketPlayer.class);
		
		CricketPlayer cp = (CricketPlayer)an;
		int age = cp.age();
		System.out.println(age);
		
		String country = cp.country();
		System.out.println(country);
	}
}

public class P02Annotation {
	public static void main(String[] args) {
		//new AnnotationEx1();
		
		//new AnnotationEx2();
	}
}
