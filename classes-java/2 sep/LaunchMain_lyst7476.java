
public class LaunchMain 
{

	public static void main(String[] args) 
	{
		
		JavaCourse jc=new JavaCourse();
//	    CoursePurchase cp=new CoursePurchase(new JavaCourse());
		
		//Constructor Injection
		 CoursePurchase cp=new CoursePurchase(jc);
		 
		 
		 //setterInjection
		 cp.setCourse(new SQLCourse());
		 
	    boolean status=cp.buyTheCourse(10000);
	    if(status)
	    {
	    	System.out.println("Course purchase success!");
	    }
	    else
	    {
	    	System.out.println("Course purchase failed!");
	    }

	}

}
