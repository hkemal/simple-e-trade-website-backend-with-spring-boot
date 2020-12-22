package com.bazaar.bazaar.webRest;

import com.bazaar.bazaar.dtos.OrderItemRequestDTO;
import com.bazaar.bazaar.dtos.OrderItemResponseDTO;
import com.bazaar.bazaar.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderItemResource {

    @Autowired
    private OrderItemService orderitemService;

    @GetMapping("/get-all-order-item")
    private List<OrderItemResponseDTO> getAllOrderItem() {
        return orderitemService.getAllOrderItem();
    }

    @GetMapping("/get-by-order-item-id/{id}")
    private List<OrderItemResponseDTO> getOrderItemByName(@PathVariable Integer id) {
        return orderitemService.getAllOrderItemById(id);
    }

    @PostMapping("/order-item-create")
    private boolean createOrderItem(@RequestBody OrderItemRequestDTO newCustomer) {
        return orderitemService.create(newCustomer);
    }

    @PutMapping("/order-item-update/{id}")
    private boolean updateOrderItem(@PathVariable Integer id,@RequestBody OrderItemRequestDTO updatingCustomer) {
        return orderitemService.update(id,updatingCustomer);
    }

    @DeleteMapping("/delete-order-item-by-id/{id}")
    private String deleteOrderItemById(@PathVariable Integer id) {
        return orderitemService.deleteById(id);
    }
}
