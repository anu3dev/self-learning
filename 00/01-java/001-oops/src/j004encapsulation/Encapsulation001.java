package j004encapsulation;

/**
 * Hide internal implementation and expose only what consumers need.
 * 
 * Below is read world example, balance is protected so no one can directly update the value.
 * One more benefit is that, suppose company wants to modify deposit or withdrawal rules, only these methods
 * 	will be touched, rest will be untouched.
 * 
 * It can be also achieved through getter and setter.
 */

class BankAccountJ004 {
	private double balance;
	
	public void deposit(double amount) {
		if(amount > 0) {
			balance = balance + amount;
		}
	}
	
	public void withdraw(double amount) {
		if(amount < balance) {
			balance = balance - amount;
		}
	}
	
	public double getBalance() {
		return balance;
	}
}

class StudentJ004 {
	private String name;
	
	public String getName () {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
}

public class Encapsulation001 {
	public static void main(String[] args) {
		BankAccountJ004 acc = new BankAccountJ004();
		acc.deposit(9000.57);
		System.out.println(acc.getBalance());
		acc.withdraw(1999.99);
		System.out.println(acc.getBalance());
		
		StudentJ004 std = new StudentJ004();
		std.setName("seema");
		System.out.println(std.getName());
	}
}
