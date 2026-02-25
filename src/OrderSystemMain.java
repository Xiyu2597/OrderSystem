import com.order.entity.Order;
import com.order.entity.OrderStatus;
import com.order.entity.Product;
import com.order.service.OrderService;
import com.order.service.OrderServiceImpl;
import com.order.util.OrderFileUtil;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OrderSystemMain {
        private static final OrderService orderService = new OrderServiceImpl();
        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
                Map<String, Order> savedOrders = OrderFileUtil.loadOrders();
                for (Order order : savedOrders.values()) {
                        orderService.createOrder(order);
                }
                System.out.println("已加载历史订单：" + savedOrders.size() + "条");

                while (true) {
                        System.out.println("\n=====订单与商品综合管理系统=====");
                        System.out.println("1. 创建新订单");
                        System.out.println("2. 计算订单金额");
                        System.out.println("3. 更新订单状态");
                        System.out.println("4. 查询用户所有订单");
                        System.out.println("5. 保存订单到文件");
                        System.out.println("6. 退出系统");
                        System.out.print("请输入操作编号：");

                        int choice;
                        try {
                                choice = scanner.nextInt();
                                scanner.nextLine();
                        } catch (Exception e) {
                                System.out.println("输入错误！请输入数字1-6");
                                scanner.nextLine();
                                continue;
                        }

                        switch (choice) {
                                case 1:
                                        createNewOrder();
                                        break;
                                case 2:
                                        calculateOrderAmount();
                                        break;
                                case 3:
                                        updateOrderStatus();
                                        break;
                                case 4:
                                        queryUserOrders();
                                        break;
                                case 5:
                                        saveOrdersToFile();
                                        break;
                                case 6:
                                        saveOrdersToFile();
                                        System.out.println("系统已退出，感谢使用！");
                                        System.exit(0);
                                        break;
                                default:
                                        System.out.println("输入错误！请输入数字1-6");
                        }
                }
        }

        private static void createNewOrder() {
                System.out.println("\n-----创建新订单-----");
                System.out.print("请输入订单ID：");
                String orderId = scanner.nextLine();
                System.out.print("请输入用户ID：");
                String userId = scanner.nextLine();
                Map<Product, Integer> productMap = new HashMap<>();
                System.out.println("请添加商品（示例：输入2个商品）：");
                System.out.print("商品1 ID：");
                String p1Id = scanner.nextLine();
                System.out.print("商品1 名称：");
                String p1Name = scanner.nextLine();
                System.out.print("商品1 单价：");
                double p1Price = scanner.nextDouble();
                System.out.print("商品1 数量：");
                int p1Count = scanner.nextInt();
                scanner.nextLine();
                productMap.put(new Product(p1Id, p1Name, p1Price), p1Count);

                // 商品2
                System.out.print("商品2 ID：");
                String p2Id = scanner.nextLine();
                System.out.print("商品2 名称：");
                String p2Name = scanner.nextLine();
                System.out.print("商品2 单价：");
                double p2Price = scanner.nextDouble();
                System.out.print("商品2 数量：");
                int p2Count = scanner.nextInt();
                scanner.nextLine();
                productMap.put(new Product(p2Id, p2Name, p2Price), p2Count);

                Order order = new Order(
                        orderId,
                        userId,
                        LocalDateTime.now(),
                        OrderStatus.CREATED,
                        productMap
                );
                orderService.createOrder(order);
                System.out.println("订单创建成功！订单信息：" + order);
        }

        // 2. 计算订单金额
        private static void calculateOrderAmount() {
                System.out.println("\n-----计算订单金额-----");
                System.out.print("请输入订单ID：");
                String orderId = scanner.nextLine();
                try {
                        double amount = orderService.calculateOrderAmount(orderId);
                        System.out.println("订单" + orderId + "的总金额：" + amount + "元");
                } catch (IllegalArgumentException e) {
                        System.out.println("错误：" + e.getMessage());
                }
        }

        private static void updateOrderStatus() {
                System.out.println("\n-----更新订单状态-----");
                System.out.print("请输入订单ID：");
                String orderId = scanner.nextLine();
                System.out.println("请选择新状态：1-已创建 2-处理中 3-已完成");
                int statusChoice = scanner.nextInt();
                scanner.nextLine();
                OrderStatus status;
                switch (statusChoice) {
                        case 1:
                                status = OrderStatus.CREATED;
                                break;
                        case 2:
                                status = OrderStatus.PROCESSING;
                                break;
                        case 3:
                                status = OrderStatus.FINISHED;
                                break;
                        default:
                                System.out.println("状态选择错误！");
                                return;
                }

                try {
                        orderService.updateOrderStatus(orderId, status);
                        System.out.println("订单" + orderId + "状态已更新为：" + status.getDesc());
                } catch (IllegalArgumentException e) {
                        System.out.println("错误：" + e.getMessage());
                }
        }

        private static void queryUserOrders() {
                System.out.println("\n-----查询用户订单-----");
                System.out.print("请输入用户ID：");
                String userId = scanner.nextLine();

                List<Order> userOrders = orderService.queryOrdersByUser(userId);
                if (userOrders.isEmpty()) {
                        System.out.println("用户" + userId + "暂无订单");
                } else {
                        System.out.println("用户" + userId + "的订单列表：");
                        for (Order order : userOrders) {
                                System.out.println(order);
                        }
                }
        }

        private static void saveOrdersToFile() {
                OrderServiceImpl serviceImpl = (OrderServiceImpl) orderService;
                Map<String, Order> allOrders = new HashMap<>();
                for (Order order : serviceImpl.getAllOrders()) {
                        allOrders.put(order.getOrderId(), order);
                }
                OrderFileUtil.saveOrders(allOrders);
        }
}