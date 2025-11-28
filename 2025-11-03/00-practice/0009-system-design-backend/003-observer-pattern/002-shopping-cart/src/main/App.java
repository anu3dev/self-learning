package main;

import main.model.Product;
import main.observer.AndroidObserver;
import main.observer.IosObserver;
import main.observer.WebObserver;
import main.service.CartService;

public class App {
    public static void main(String[] args) throws Exception {
    	CartService cartService = new CartService();

        // Add observers
        cartService.addObserver(new AndroidObserver());
        cartService.addObserver(new IosObserver());
        cartService.addObserver(new WebObserver());

        // Simulate user actions
        Product iphone = new Product("iPhone 16", 1199.99);
        Product mac = new Product("MacBook Air M4", 1899.99);

        cartService.addProduct(iphone);
        cartService.addProduct(mac);
        cartService.removeProduct(iphone);

        System.out.println("\n🛒 Final cart contents:");
        cartService.getCartList().forEach(System.out::println);
    }
}
