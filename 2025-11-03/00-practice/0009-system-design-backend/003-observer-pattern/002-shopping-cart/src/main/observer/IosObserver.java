package main.observer;

import main.model.Product;

public class IosObserver implements IObserver {
	@Override
    public void onProductAdded(Product product) {
        System.out.println("🍏 [iOS] Product added: " + product.getName());
    }

    @Override
    public void onProductRemoved(Product product) {
        System.out.println("🍏 [iOS] Product removed: " + product.getName());
    }
}
