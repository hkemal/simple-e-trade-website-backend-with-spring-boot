package com.bazaar.bazaar.webRest;

import com.bazaar.bazaar.dtos.OrderRequestDTO;
import com.bazaar.bazaar.dtos.OrderResponseDTO;
import com.bazaar.bazaar.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderResource {
    @Autowired
    private OrderService orderService;

    @GetMapping("/get-all-order")
    private List<OrderResponseDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/get-by-order-id/{id}")
    private List<OrderResponseDTO> getOrderByName(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/order-create")
    private boolean createOrder(@RequestBody OrderRequestDTO newCustomer) {
        return orderService.create(newCustomer);
    }

    @PutMapping("/order-update/{id}")
    private boolean updateOrder(@PathVariable Integer id,@RequestBody OrderRequestDTO updatingCustomer) {
        return orderService.update(id,updatingCustomer);
    }
    @DeleteMapping("/delete-order-by-id/{id}")
    private String deleteOrderById(@PathVariable Integer id) {
        return orderService.deleteById(id);
    }

}
