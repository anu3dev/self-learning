package main.observable;

import main.model.Product;
import main.observer.IObserver;

public interface IObservable {
    public void addObserver(IObserver observer);
    void notifyProductAdded(Product product);
    void notifyProductRemoved(Product product);
}
