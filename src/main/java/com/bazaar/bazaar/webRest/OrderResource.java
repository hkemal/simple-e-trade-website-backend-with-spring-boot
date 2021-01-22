package com.bazaar.bazaar.webRest;

import com.bazaar.bazaar.dtos.OrderRequestDTO;
import com.bazaar.bazaar.dtos.OrderResponseDTO;
import com.bazaar.bazaar.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class OrderResource {
    @Autowired
    private OrderService orderService;

    @GetMapping("/get-all-order")
    private List<OrderResponseDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/get-by-order-id/{id}")
    private OrderResponseDTO getOrderByName(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/get-all-order-by-customer-id/{customerId}")
    private List<OrderResponseDTO> getOrderByCustomerId(@PathVariable Integer customerId) {
        return orderService.getOrderByCustomerId(customerId);
    }

    @PostMapping("/order-create")
    private boolean createOrder(@RequestBody OrderRequestDTO newOrder) {
        return orderService.createOrder(newOrder);
    }

    @PutMapping("/order-update/{id}")
    private boolean updateOrder(@PathVariable Integer id, @RequestBody OrderRequestDTO updateOrder) {
        return orderService.updateOrder(id, updateOrder);
    }

    @DeleteMapping("/delete-order-by-id/{id}")
    private String deleteOrderById(@PathVariable Integer id) {
        return orderService.deleteById(id);
    }

}
