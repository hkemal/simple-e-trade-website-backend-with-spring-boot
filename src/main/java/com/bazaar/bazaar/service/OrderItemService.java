package com.bazaar.bazaar.service;

import com.bazaar.bazaar.domain.Customer;
import com.bazaar.bazaar.domain.Order;
import com.bazaar.bazaar.domain.OrderItem;
import com.bazaar.bazaar.domain.Product;
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
                orderItemResponseDTO.setProduct(item.getProduct());
                orderItemResponseDTO.setAmount(item.getAmount());
                orderItemResponseDTO.setOrderId(item.getOrder().getId());
                resultOrderItemResponseDTO.add(orderItemResponseDTO);
            }
        }
        return resultOrderItemResponseDTO;
    }

    public OrderItemResponseDTO getOrderItemById(Integer id) {
        List<OrderItem> result = orderItemRepository.findById(id);
        if (!result.isEmpty()) {
            OrderItem item = result.get(0);
            OrderItemResponseDTO orderItemResponseDTO = new OrderItemResponseDTO();
            orderItemResponseDTO.setId(item.getId());
            orderItemResponseDTO.setProduct(item.getProduct());
            orderItemResponseDTO.setAmount(item.getAmount());
            orderItemResponseDTO.setOrderId(item.getOrder().getId());
            return orderItemResponseDTO;
        }
        return null;
    }

    public List<OrderItemResponseDTO> getOrderItemByOrderId(Integer orderId) {
        List<OrderItemResponseDTO> resultOrderItemResponseDTOOrderId = new ArrayList<>();
        List<OrderItem> result = orderItemRepository.findByOrder_Id(orderId);
        if (!result.isEmpty()) {
            for (OrderItem item : result) {
                OrderItemResponseDTO orderItemResponseDTO = new OrderItemResponseDTO();
                orderItemResponseDTO.setId(item.getId());
                orderItemResponseDTO.setAmount(item.getAmount());
                orderItemResponseDTO.setProduct(item.getProduct());
                orderItemResponseDTO.setOrderId(item.getOrder().getId());
                resultOrderItemResponseDTOOrderId.add(orderItemResponseDTO);
            }

            return resultOrderItemResponseDTOOrderId;
        } else {
            return null;
        }
    }


    //POST
    public boolean create(OrderItemRequestDTO newOrderItem) {
        OrderItem orderItem = new OrderItem();
        Product product = new Product();
        product.setId(newOrderItem.getProductId());
        orderItem.setProduct(product);
        orderItem.setAmount(newOrderItem.getAmount());
        Order order = new Order();
        orderItem.setOrder(order);
        orderItemRepository.save(orderItem);
        return true;
    }

    //PUT
    public boolean update(Integer id, OrderItemRequestDTO updatingOrderItem) {
        OrderItem orderItem = new OrderItem();
        Product product = new Product();
        product.setId(updatingOrderItem.getProductId());
        orderItem.setProduct(product);
        orderItem.setAmount(updatingOrderItem.getAmount());
        Order order = new Order();
        orderItem.setOrder(order);
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
