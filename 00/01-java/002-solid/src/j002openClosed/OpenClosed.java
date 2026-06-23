package j002openClosed;

/**
 * Open for extension, closed for modification.
 */

// below is bad example as existing code needs to modified repeatedly in case of new requirement.
class PaymentService {
	void pay(String type) {
		if(type.equals("CARD")) {
			System.out.println("Card Payment");
		}
		
		if(type.equals("UPI")) {
			System.out.println("UPI Payment");
		}
	}
}

// below is good example as no need to modify existing implementation for new requirement, new requirements can be added.
interface Payment {
	void pay();
}
class CardPaymnet implements Payment {
	public void pay() {}
}
class UpiPaymnet implements Payment {
	public void pay() {}
}

public class OpenClosed {
	public static void main(String[] args) {}
}
