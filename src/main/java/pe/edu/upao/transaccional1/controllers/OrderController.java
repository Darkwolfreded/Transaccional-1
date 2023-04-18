package pe.edu.upao.transaccional1.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.transaccional1.models.Food;
import pe.edu.upao.transaccional1.models.Order;
import pe.edu.upao.transaccional1.services.OrderService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order( 27, "Shond", "shond@gmail.com", "En proceso", LocalDateTime.now(), "30 minutos", items));
        return ResponseEntity.ok(orders);
    }
}
