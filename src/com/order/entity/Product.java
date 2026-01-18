package com.order.entity;
public class Product {
    private String productId;
    private String name;
    private double price;
    public Product() {}
    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "商品{" +
                "ID='" + productId + '\'' + ", 名称='" + name + '\'' + ", 单价=" + price + '}';
    }
}