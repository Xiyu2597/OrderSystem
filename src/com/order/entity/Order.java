package com.order.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
public class Order implements Serializable {
    private String orderId;
    private String userId;
    private LocalDateTime createTime;
    private OrderStatus status;
    private Map<Product, Integer> productMap;
    public Order() {}
    public Order(String orderId, String userId, LocalDateTime createTime, OrderStatus status, Map<Product, Integer> productMap) {
        this.orderId = orderId;
        this.userId = userId;
        this.createTime = createTime;
        this.status = status;
        this.productMap = productMap;
    }
    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public Map<Product, Integer> getProductMap() {
        return productMap;
    }
    @Override
    public String toString() {
        return "订单{" +
                "订单ID='" + orderId + '\'' +
                ", 用户ID='" + userId + '\'' +
                ", 创建时间=" + createTime +
                ", 状态=" + status.getDesc() +
                ", 商品列表=" + productMap +
                '}';
    }
}