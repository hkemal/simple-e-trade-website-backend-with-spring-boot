package com.bazaar.bazaar.service;

import com.bazaar.bazaar.domain.Order;
import com.bazaar.bazaar.dtos.OrderRequestDTO;
import com.bazaar.bazaar.dtos.OrderResponseDTO;
import com.bazaar.bazaar.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
private OrderRepository orderRepository;
    //GET
    public List<OrderResponseDTO> getAllOrders() {
        List<OrderResponseDTO> resultorderResponseDTO = new ArrayList<>();
        List<Order> result = orderRepository.findAll();
        if (!result.isEmpty()) {
            for (Order item : result) {
                OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
                orderResponseDTO.setId(item.getId());
                orderResponseDTO.setOrderId(item.getOrderId());
                orderResponseDTO.setOrderDate(item.getOrderDate());
                orderResponseDTO.setCustomerId(item.getCustomerId());
                resultorderResponseDTO.add(orderResponseDTO);
            }
        }
        return resultorderResponseDTO;
    }

    public List<OrderResponseDTO> getOrderById(Integer id) {
        List<OrderResponseDTO> resultOrderResponseDTO = new ArrayList<>();
        List<Order> result = orderRepository.findById(id);
        if (!result.isEmpty()) {
            for (Order item : result) {
                OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
                orderResponseDTO.setId(item.getId());
                orderResponseDTO.setOrderId(item.getOrderId());
                orderResponseDTO.setOrderDate(item.getOrderDate());
                orderResponseDTO.setCustomerId(item.getCustomerId());
                resultOrderResponseDTO.add(orderResponseDTO);
            }
        }
        return resultOrderResponseDTO;
    }
    //POST
    public boolean create(OrderRequestDTO newCustomer) {
        Order order = new Order();
        order.setOrderId(newCustomer.getOrderId());
        order.setOrderDate(newCustomer.getOrderDate());
        order.setCustomerId(newCustomer.getCustomerId());
        orderRepository.save(order);
        return true;
    }
    //PUT
    public boolean update(Integer id, OrderRequestDTO newCustomer) {
        Order order = new Order();
        order.setOrderId(newCustomer.getOrderId());
        order.setOrderDate(newCustomer.getOrderDate());
        order.setCustomerId(newCustomer.getCustomerId());
        order.setId(id);
        orderRepository.save(order);
        return true;
    }
    //DELETE
    public String deleteById(Integer id){
        orderRepository.deleteById(id);
        return "Order deleted.";
    }
}
