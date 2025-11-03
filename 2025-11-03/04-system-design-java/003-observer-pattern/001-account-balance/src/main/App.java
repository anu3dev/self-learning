package main;
import main.observable.BankAccount;
import main.observable.IObservable;
import main.observer.IObserver;
import main.observer.SMSAlert;
import main.observer.SpendingTracker;

/**
 * Observer design pattern example in Java.
 * 
 * This is a simple implementation of the Observer pattern where observers 
 * can subscribe to a subject to receive updates when the subject's state changes.
 * 
 * real world example is - suppose on Amazon you can subscribe to a product to 
 * get notified when the price drops or when it is back in stock.
 * 
 * another example is - in a news application, users can subscribe to different
 * news categories (like sports, technology, politics) and get notified when
 * new articles are published in those categories.
 * 
 * simply, When something happens here, let others who care about it know.
 */

public class App {
    public static void main(String[] args) {
        IObservable account = new BankAccount(50000.0);

        IObserver sms = new SMSAlert();
        account.addObserver(sms);

        IObserver tracker = new SpendingTracker();
        account.addObserver(tracker);

        account.withdraw(20000.0);
        account.deposit(30000.0);
    }
}
