/**
 * below code looks absolutely fine but... 
 * 
 * 1. every class needs its own dependency and it is called tight coupling.
 * suppose tomorrow we have to use SMSService, instead of EmailService then in OrderService, EmailService needs to be changed with SMSService.
 * It will need code change means every dependency is hard coded.
 * 
 * 2. if OrderService needs PaymentService, InventoryService, ShippingService
 * imagine 100 class and each creating 20 objects then it will be a nightmare
 * 
 * 3. Testing is difficult due to hard coding
 * 
 * 4. In below example, class is creating objects and this is biggest issue
 * Spring says --> Why should your business classes create objects?
 * Instead --> I'll create and manage all objects for you.
 * This is called --> Inversion of Control (IoC)
 * 
 * normal java --> developer - create objects - use objects
 * spring java --> developer - asks spring - spring creates objects - spring gives object
 * 
 * IoC is basically object manager
 * 
 * normal java --> Employee employee = new Employee();
 * spring java --> Employee Object -> Bean
 * 
 * A Bean is simply an object created and managed by the Spring IoC Container.
 * 
 * Without Spring -> Employee employee = new Employee();
 * Spring -> 
 * 
 * @Component
 * class Employee {}
 * 
 * 
 * Suppose Spring created
 * 1. PaymentService Bean
 * 2. EmailService Bean
 * How does PaymentService get EmailService? Answer is Dependency Injection
 * Spring injects one bean into another.
 * 
 * without DI
 * class PaymentService {
 * 	EmailService email = new EmailService();
 * }
 * 
 * With DI
 * class PaymentService {
 * private EmailService email;
 * }
 * 
 * 
 * IoC ---> Spring Creates Objects
 * DI ---> Spring Connects Objects
 * 
 * 
 * 
 * Why was Spring created?
 * To reduce tight coupling, manage object creation, simplify dependency management, and improve testability.
 * 
 * What is IoC?
 * A design principle where the control of object creation is transferred from the application code to the Spring IoC Container.
 * 
 * What is Dependency Injection?
 * A technique where Spring injects required dependencies into a class instead of the class creating them itself.
 * 
 * What is a Bean?
 * A Java object that is created, managed, and destroyed by the Spring IoC Container.
 */

class EmailService {
	void sendEmail(){
		System.out.println("email sent");
	}
}

class OrderService {
	void placeOrder(){
		System.out.println("order placed");
		
		EmailService emailService = new EmailService();
		emailService.sendEmail();
	}
}

class PaymentService {
	void makePayment() {
		System.out.println("payment done");
		
		OrderService orderService = new OrderService();
		orderService.placeOrder();
	}
}
public class App {
	public static void main(String[] args) {
		PaymentService paymentService = new PaymentService();
		paymentService.makePayment();
	}
}
