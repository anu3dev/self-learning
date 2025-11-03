package main.observer;

public class SMSAlert implements IObserver {
    @Override
    public void update(double newBalance){
        System.out.println("[SMS] new balance: INR " + newBalance);
    }
}
