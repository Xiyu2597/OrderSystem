package com.order.service;

import com.order.entity.Order;
import com.order.entity.OrderStatus;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class OrderServiceImpl implements OrderService {
    private final Map<String, Order> orderMap = new HashMap<>();

    @Override
    public void createOrder(Order order) {
        orderMap.put(order.getOrderId(), order);
    }
    @Override
    public void updateOrderStatus(String orderId, OrderStatus status) {
        Order order = orderMap.get(orderId);
        if (order != null) {
            order.setStatus(status);
        } else {
            throw new IllegalArgumentException("订单ID不存在：" + orderId);
        }
    }
    @Override
    public double calculateOrderAmount(String orderId) {
        Order order = orderMap.get(orderId);
        if (order == null) {
            throw new IllegalArgumentException("订单ID不存在：" + orderId);
        }
        return order.getProductMap().entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
    @Override
    public List<Order> queryOrdersByUser(String userId) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orderMap.values()) {
            if (order.getUserId().equals(userId)) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }
    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orderMap.values());
    }
}
