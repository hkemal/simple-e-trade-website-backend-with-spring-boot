package com.bazaar.bazaar.service;

import com.bazaar.bazaar.domain.OrderItem;
import com.bazaar.bazaar.dtos.OrderItemRequestDTO;
import com.bazaar.bazaar.dtos.OrderItemResponseDTO;
import com.bazaar.bazaar.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    //GET
    public List<OrderItemResponseDTO> getAllOrderItem() {
        List<OrderItemResponseDTO> resultOrderItemResponseDTO = new ArrayList<>();
        List<OrderItem> result = orderItemRepository.findAll();
        if (!result.isEmpty()) {
            for (OrderItem item : result) {
                OrderItemResponseDTO orderItemResponseDTO = new OrderItemResponseDTO();
                orderItemResponseDTO.setId(item.getId());
                orderItemResponseDTO.setProductId(item.getProductId());
                orderItemResponseDTO.setAmount(item.getAmount());
                orderItemResponseDTO.setOrderId(item.getOrderId());
                resultOrderItemResponseDTO.add(orderItemResponseDTO);
            }
        }
        return resultOrderItemResponseDTO;
    }

    public List<OrderItemResponseDTO> getAllOrderItemById(Integer id) {
        List<OrderItemResponseDTO> resultOrderItemResponseDTO = new ArrayList<>();
        List<OrderItem> result = orderItemRepository.findById(id);
        if (!result.isEmpty()) {
            for (OrderItem item : result) {
                OrderItemResponseDTO orderItemResponseDTO = new OrderItemResponseDTO();
                orderItemResponseDTO.setId(item.getId());
                orderItemResponseDTO.setProductId(item.getProductId());
                orderItemResponseDTO.setAmount(item.getAmount());
                orderItemResponseDTO.setOrderId(item.getOrderId());
                resultOrderItemResponseDTO.add(orderItemResponseDTO);
            }
        }
        return resultOrderItemResponseDTO;
    }
    //POST
    public boolean create(OrderItemRequestDTO newCustomer) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(newCustomer.getProductId());
        orderItem.setAmount(newCustomer.getAmount());
        orderItem.setOrderId(newCustomer.getOrderId());
        orderItemRepository.save(orderItem);
        return true;
    }
    //PUT
    public boolean update(Integer id, OrderItemRequestDTO updatingOrderItem) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(updatingOrderItem.getProductId());
        orderItem.setAmount(updatingOrderItem.getAmount());
        orderItem.setOrderId(updatingOrderItem.getOrderId());
        orderItem.setId(id);
        orderItemRepository.save(orderItem);
        return true;
    }

    //DELETE
    public String deleteById(Integer id) {
        orderItemRepository.deleteById(id);
        return "Order item deleted.";
    }

}
