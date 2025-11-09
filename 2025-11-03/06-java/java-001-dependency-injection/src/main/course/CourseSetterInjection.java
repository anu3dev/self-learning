package main.course;

public class CourseSetterInjection {
	private ICourse cou;
	
	public void setCourse(ICourse course) {
		this.cou = course;
	}
	
	public void purchageCourse(double price) {
		cou.purchageCourse(price);
	}
}
