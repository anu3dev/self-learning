package service;

public class Java implements ICourse {

	@Override
	public Boolean getTheCourse(Double amount) {
		System.out.println("Java purchased and fee is: " + amount);
		return true;
	}
}
