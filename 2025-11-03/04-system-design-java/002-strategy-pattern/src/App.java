/**
 * Strategy design pattern is a behavioral design pattern that enables 
 * selecting an algorithm's behavior at runtime.
 * 
 * It defines a family of algorithms, encapsulates each one, 
 * and makes them interchangeable.
 */


public class App {
    public static void main(String[] args) {
        // Using setter injection
        ShoppingCartOne cart1 = new ShoppingCartOne();
        cart1.setPaymentStrategy(new CreditCardPayment());
        cart1.checkout(1000);  // Paid 1000 using Credit Card.
        
        // Using constructor injection
        ShoppingCartTwo cart2 = new ShoppingCartTwo(new UPIPayment());
        cart2.checkout(750);  // Paid 750 using UPI.
    }
}
