import java.util.Scanner;

class MultipleTaskEx1 implements Runnable {
	public void run() {
		
		String tname = Thread.currentThread().getName();
		
		if(tname.equals("BANKDETAILS")) {
			banking();
		} else if(tname.equals("PRINTNUM")) {
			printingNum();
		} else {
			printingAlpha();
		}
		
	}
	
	public void banking() {
		System.out.println("banking activity started");
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter you account num");
		
		int ac = scan.nextInt();
		System.out.println("Enter you account password");
		
		int pw = scan.nextInt();
		System.out.println("please see the account details " + ac + " and " + pw);
		
		System.out.println("banking activity ended");
	}
	
	public void printingNum() {
		System.out.println("printingNum activity started");
		
		for(int i=0;i<5;i++) {
			System.out.println("printingNum page no.: " + i);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("printingNum activity ended");
	}
	
	public void printingAlpha() {
		System.out.println("printingAlpha activity started");
		
		for(int i=65;i<70;i++) {
			System.out.println("printingAlpha page no.: " + (char)i);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("printingAlpha activity ended");
	}
}

/*
 * 
 * implementation of multi-threading
 * 
 */
class ThreadsMultiEx1{
	public ThreadsMultiEx1() {
		MultipleTaskEx1 mt = new MultipleTaskEx1();
		
		Thread t1 = new Thread(mt);
		Thread t2 = new Thread(mt);
		Thread t3 = new Thread(mt);
		
		t1.setName("BANKDETAILS");
		t2.setName("PRINTNUM");
		t3.setName("PRINTCHAR");
		
		t1.start();
		t2.start();
		t3.start();
	}
}

/*
 * 
 * example of custom exception in thread handling
 * 
 */
@SuppressWarnings("serial")
class UnderAgeException extends Exception {
	public UnderAgeException(String msg) {
		super(msg);
	}
}

@SuppressWarnings("serial")
class OverAgeException extends Exception {
	public OverAgeException(String msg) {
		super(msg);
	}
}

class Applicant {
	int age;
	
	public void input() {
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter your age");
		age=scan.nextInt();
	}
	
	public void verify() throws UnderAgeException, OverAgeException {
		if(age<18 ) {
			UnderAgeException uae = new UnderAgeException("You're too young! Please have patience");
			System.out.println(uae.getMessage());
			throw uae;
			
		} else if(age > 60) {
			OverAgeException oae=new OverAgeException("Your time is near! Be careful ");
			System.out.println(oae.getMessage());
			throw oae;
			
		} else {
			System.out.println("You're eligible for driving license");
		}
	}
}

class RTO {
	public void initiate() {
		Applicant a = new Applicant();
		try {
			a.input();
			a.verify();
		}
		catch(OverAgeException oae) {
			try {
				a.input();
				a.verify();
			}
			catch(Exception e) {
				System.out.println("You cannot apply! BLOCKED");
			}
		} catch(UnderAgeException uae) {
			try {
				a.input();
				a.verify();
			}
			catch(Exception e) {
				System.out.println("You cannot apply! BLOCKED");
			}
		}
	}
}

class ThreadsMultiEx2{
	public ThreadsMultiEx2() {
		RTO rt = new RTO();
		rt.initiate();
	}
}


public class P06ThreadsMulti {
	public static void main(String[] args) {
		//new ThreadsMultiEx1();
		
		//new ThreadsMultiEx2();
	}
}
