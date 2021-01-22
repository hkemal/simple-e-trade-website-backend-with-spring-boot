package com.bazaar.bazaar.webRest;

import com.bazaar.bazaar.dtos.OrderItemRequestDTO;
import com.bazaar.bazaar.dtos.OrderItemResponseDTO;
import com.bazaar.bazaar.dtos.OrderResponseDTO;
import com.bazaar.bazaar.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class OrderItemResource {

    @Autowired
    private OrderItemService orderitemService;

    @GetMapping("/get-all-order-item")
    private List<OrderItemResponseDTO> getAllOrderItem() {
        return orderitemService.getAllOrderItem();
    }

    @GetMapping("/get-by-order-item-id/{id}")
    private OrderItemResponseDTO getOrderItemByName(@PathVariable Integer id) {
        return orderitemService.getOrderItemById(id);
    }

    @GetMapping("/get-order-item-by-order-id/{orderId}")
    private List<OrderItemResponseDTO> getOrderItemByOrderId(@PathVariable Integer orderId) {
        return orderitemService.getOrderItemByOrderId(orderId);
    }

    @PostMapping("/order-item-create")
    private boolean createOrderItem(@RequestBody OrderItemRequestDTO newOrderItem) {
        return orderitemService.create(newOrderItem);
    }

    @PutMapping("/order-item-update/{id}")
    private boolean updateOrderItem(@PathVariable Integer id, @RequestBody OrderItemRequestDTO updateOrderItem) {
        return orderitemService.update(id, updateOrderItem);
    }

    @DeleteMapping("/delete-order-item-by-id/{id}")
    private String deleteOrderItemById(@PathVariable Integer id) {
        return orderitemService.deleteById(id);
    }
}
