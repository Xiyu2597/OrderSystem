package com.order.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private final String productId;
    private final String name;
    private final double  price;
    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    public double getPrice() {

        return price;
    }
    @Override
    public String toString() {
        return "商品{" +
                "ID='" + productId + '\'' +
                ", 名称='" + name + '\'' +
                ", 单价=" + price +
                '}';
    }
}