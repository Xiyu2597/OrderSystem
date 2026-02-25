package com.order.service;

import com.order.entity.Order;
import com.order.entity.OrderStatus;

import java.util.List;
public interface OrderService {
    void createOrder(Order order);
    void updateOrderStatus(String orderId, OrderStatus status);
    double calculateOrderAmount(String orderId);
    List<Order> queryOrdersByUser(String userId);
    List<Order> getAllOrders();
}