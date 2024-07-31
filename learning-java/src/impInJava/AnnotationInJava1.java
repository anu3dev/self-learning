package impInJava;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Annotation works based on mechanism of an interface
//@ --> compiler that annotation type is being created and its not interface




@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
@interface RunsScored
{
	
}

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.CONSTRUCTOR)
@interface Beauty
{
	
}

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
@interface Setter
{
	
}

@Target(ElementType.TYPE)
//@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.TYPE, 
//	ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@interface CricketPlayer
{
	String country() default "India";
	int age() default 43;
}


//@CricketPlayer(country="India", age=34)

@CricketPlayer
class ViratKohli
{
	@RunsScored
	int runs;
	
	@Beauty
	public ViratKohli()
	{
		System.out.println("Kohli is the best");
	}
	
	@Setter
	public void setRuns(int runs)
	{
		this.runs=runs;
			
	}
	
}


public class AnnotationInJava1 
{

	public static void main(String[] args) 
	{
		
		
		ViratKohli vk=new ViratKohli();
		
		vk.setRuns(12000);
		
		Class cl=vk.getClass();
		Annotation an=cl.getAnnotation(CricketPlayer.class);
		CricketPlayer cp=(CricketPlayer)an;
		int age=cp.age();
		System.out.println(age);
		String country=cp.country();
		System.out.println(country);

	}

}
