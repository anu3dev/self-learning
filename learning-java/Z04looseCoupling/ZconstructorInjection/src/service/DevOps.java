package service;

public class DevOps implements ICourse {

	@Override
	public Boolean getTheCourse(Double amount) {
		System.out.println("DevOps purchased and fee is: " + amount);
		return true;
	}
}
