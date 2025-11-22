package main.observer;

import main.model.Product;

public class WebObserver implements IObserver {
	@Override
    public void onProductAdded(Product product) {
        System.out.println("💻 [Web] Product added: " + product.getName());
    }

    @Override
    public void onProductRemoved(Product product) {
        System.out.println("💻 [Web] Product removed: " + product.getName());
    }
}
