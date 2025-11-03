package main.observable;

import java.util.ArrayList;
import java.util.List;

import main.model.Product;
import main.observer.IObserver;

public class CartObservable implements IObservable {
    List<IObserver> observers = new ArrayList<>();
    List<Product> cartList = new ArrayList<>();

    @Override
    public void addObserver(IObserver observer){
        observers.add(observer);
    }

    @Override
    public void notifyProductAdded(Product product){
        for(IObserver obserber : observers) {
        	obserber.onProductAdded(product);
        }
    }
    
    @Override
    public void notifyProductRemoved(Product product) {
    	for(IObserver obserber : observers) {
        	obserber.onProductRemoved(product);
        }
    }
}
