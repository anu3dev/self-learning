package main.observer;

import main.model.Product;

public class AndroidObserver implements IObserver{
	@Override
    public void onProductAdded(Product product) {
        System.out.println("📱 [Android] Product added: " + product.getName());
    }

    @Override
    public void onProductRemoved(Product product) {
        System.out.println("📱 [Android] Product removed: " + product.getName());
    }
}
