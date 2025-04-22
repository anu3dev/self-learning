
public class CoursePurchase 
{
	
	private Course course;
	
	
	//Course course=new PythonCourse();
	//Constructor Injection
	public CoursePurchase(Course course)
	{
		this.course=course;
	}
	
	//SetterInjection
	public void setCourse(Course course)
	{
		this.course=course;
	}
	
	
	public boolean buyTheCourse(int amount)
	{
//		JavaCourse jc=new JavaCourse();
//		jc.coursePurchase();
		
		boolean status=course.coursePurchase();
		
		return status;
		
	}

}
