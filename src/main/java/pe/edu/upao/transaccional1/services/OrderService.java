package pe.edu.upao.transaccional1.services;

import pe.edu.upao.transaccional1.models.Food;
import pe.edu.upao.transaccional1.models.Order;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private List<Order> orders;

    public OrderService() {
        this.orders = new ArrayList<Order>();
    }

    public void addOrder(Order order) {
        order.setId(this.orders.size() + 1);
        order.setCreationTime(LocalDateTime.now().toString());
        this.orders.add(order);
    }

    public void updateOrderStatus(int orderId, String newStatus) {
        for (Order order : this.orders) {
            if (order.getId() == orderId) {
                order.setStatus(newStatus);
                break;
            }
        }
    }

    public double calculateTotalPayment(int orderId) {
        double totalPayment = 0;
        for (Order order : this.orders) {
            if (order.getId() == orderId) {
                List<Food> items = order.getItems();
                for (Food item : items) {
                    totalPayment += item.getPrice();
                }
                break;
            }
        }
        return totalPayment;
    }

    public void cancelOrder(int orderId) {
        for (Order order : this.orders) {
            if (order.getId() == orderId) {
                order.setStatus("Cancelado");
                break;
            }
        }
    }

    public List<Order> getOrders() {
        return this.orders;
    }
}
