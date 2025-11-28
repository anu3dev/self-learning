package main.observer;

public class SpendingTracker implements IObserver {
    @Override
    public void update(double newBalance){
        System.out.println("[Tracker] new balance: INR " + newBalance);
    }
}
