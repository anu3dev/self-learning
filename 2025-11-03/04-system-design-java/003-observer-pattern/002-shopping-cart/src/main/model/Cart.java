package main.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    List<Product> cartList = new ArrayList<>();

    public void addProduct(Product product) {
        cartList.add(product);
    }

    public void removeProduct(Product product) {
        cartList.removeIf(p -> p.getName().equalsIgnoreCase(product.getName()));
    }

    public List<Product> getCartList() {
        return Collections.unmodifiableList(cartList);
    }
}
