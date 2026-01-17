package com.order.entity;

import java.time.LocalDateTime;
import java.util.Map;
public class Order {
    private String orderId;
    private String userId;
    private LocalDateTime createTime;
    private OrderStatus status;
    private Map<Product, Integer> productMap;
}

