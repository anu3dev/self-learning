package main.service;

import java.util.List;

import main.model.Cart;
import main.model.Product;
import main.observable.CartObservable;
import main.observable.IObservable;
import main.observer.IObserver;

public class CartService {
    Cart cart = new Cart();
    IObservable cartIObservable = new CartObservable();

    public void addProduct(Product product) {
        cart.addProduct(product);
        cartIObservable.notifyProductAdded(product);
    }

    public void removeProduct(Product product) {
        cart.removeProduct(product);
        cartIObservable.notifyProductRemoved(product);
    }

    public void addObserver(IObserver observer) {
    	cartIObservable.addObserver(observer);
    }

    public List<Product> getCartList() {
        return cart.getCartList();
    }
}
