package j001singleResponsibility;

/**
 * A class should have only ONE reason to change.
 */

// below is bad example as DB changes? OR Email changes? OR PDF changes? -> Same class changes.
class UserService01 {
	void saveUser(){
		// save to DB
	}
	void sendEmail() {
		// send email
	}
	void generateReport() {
		// create PDF
	}
}

// below are good examples as each classes are responsible for one job
class UserService{
	void saveUser() {
		// save user
	}
}
class EmailService{
	void sendEmail() {
		// send email
	}
}
class ReportService{
	void generateReport() {
		// create PDF
	}
}

public class SingleResponsibility {
	public static void main(String[] args) {}
}
