package main.course;

public class CourseConstructorInjection {
	private ICourse cou;
	
	public CourseConstructorInjection(ICourse course) {
		this.cou = course;
	}
	
	public void purchageCourse(double price) {
		cou.purchageCourse(price);
	}
}
