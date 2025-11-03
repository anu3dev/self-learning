package main.observable;

import java.util.*;

import main.observer.IObserver;

public class BankAccount implements IObservable {
    private List<IObserver> observers = new ArrayList<>();
    private double balance;

    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }

    @Override
    public void addObserver(IObserver observer){
        observers.add(observer);
    }

    @Override
    public void deposit(double amount){
        balance = balance + amount;
        notifyObservers();
    }

    @Override
    public void withdraw(double amount){
        balance = balance - amount;
        notifyObservers();
    }

    public void notifyObservers(){
        for(IObserver o : observers){
            o.update(balance);
        }
    }
}
