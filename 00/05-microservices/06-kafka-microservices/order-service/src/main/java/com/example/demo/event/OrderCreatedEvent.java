package com.example.demo.event;

public class OrderCreatedEvent {

    private int productId;
    private String productName;
    private double productPrice;
    private String status;

    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(int productId, String productName, double productPrice, String status) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}