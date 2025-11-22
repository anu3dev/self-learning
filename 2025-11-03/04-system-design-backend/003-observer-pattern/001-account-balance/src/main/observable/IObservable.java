package main.observable;

import main.observer.IObserver;

public interface IObservable {
    public void addObserver(IObserver observer);
    public void deposit(double amount);
    public void withdraw(double amount);
}
