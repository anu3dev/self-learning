package main.observer;

import main.model.Product;

public interface IObserver {
	void onProductAdded(Product product);
    void onProductRemoved(Product product);
}
