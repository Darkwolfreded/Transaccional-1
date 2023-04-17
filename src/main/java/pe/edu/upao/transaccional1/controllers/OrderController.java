package pe.edu.upao.transaccional1.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.transaccional1.models.Order;
import pe.edu.upao.transaccional1.services.OrderService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        order.setId(orderService.getOrders().size() + 1);
        order.setCreationTime(LocalDateTime.now().toString());
        orderService.addOrder(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable("id") int id, @RequestBody String newStatus) {
        orderService.updateOrderStatus(id, newStatus);
        return new ResponseEntity<>("Estado del pedido actualizado", HttpStatus.OK);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<String> cancelOrder(@PathVariable("id") int id) {
        orderService.cancelOrder(id);
        return new ResponseEntity<>("Pedido cancelado", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderService.getOrders(), HttpStatus.OK);
    }
}
