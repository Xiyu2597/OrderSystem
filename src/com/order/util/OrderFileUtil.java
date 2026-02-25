package com.order.util;

import com.order.entity.Order;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class OrderFileUtil {
    private static final String FILE_PATH = "orders.dat";
    public static void saveOrders(Map<String, Order> orderMap) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(orderMap);
            System.out.println("订单数据已保存到文件！");
        } catch (IOException e) {
            System.out.println("保存订单失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    public static Map<String, Order> loadOrders() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new HashMap<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object obj = ois.readObject();
            return (Map<String, Order>) obj;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("加载订单失败：" + e.getMessage());
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}