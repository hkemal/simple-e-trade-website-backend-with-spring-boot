package com.bazaar.bazaar.service;

import com.bazaar.bazaar.domain.Customer;
import com.bazaar.bazaar.domain.Order;
import com.bazaar.bazaar.domain.OrderItem;
import com.bazaar.bazaar.domain.Product;
import com.bazaar.bazaar.dtos.OrderRequestDTO;
import com.bazaar.bazaar.dtos.OrderResponseDTO;
import com.bazaar.bazaar.repository.OrderItemRepository;
import com.bazaar.bazaar.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    //GET
    public List<OrderResponseDTO> getAllOrders() {
        List<OrderResponseDTO> resultOrderResponseDTO = new ArrayList<>();
        List<Order> result = orderRepository.findAll();
        if (!result.isEmpty()) {
            for (Order item : result) {
                OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
                orderResponseDTO.setId(item.getId());
                orderResponseDTO.setOrderDate(item.getOrderDate());
                orderResponseDTO.setCustomerId(item.getCustomer().getId());
                resultOrderResponseDTO.add(orderResponseDTO);
            }
        }
        return resultOrderResponseDTO;
    }

    public OrderResponseDTO getOrderById(Integer id) {
        Optional<Order> result = orderRepository.findById(id);
        if (result.isPresent()) {
            Order item = result.get();
            OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
            orderResponseDTO.setId(item.getId());
            orderResponseDTO.setOrderDate(item.getOrderDate());
            orderResponseDTO.setCustomerId(item.getCustomer().getId());
            return orderResponseDTO;
        }
        return null;
    }

    public List<OrderResponseDTO> getOrderByCustomerId(Integer customerId) {
        List<OrderResponseDTO> resultOrderResponseDTOByCustomerId = new ArrayList<>();
        List<Order> result = orderRepository.findByCustomer_Id(customerId);
        if (!result.isEmpty()) {
            for (Order item : result) {
                OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
                orderResponseDTO.setId(item.getId());
                orderResponseDTO.setOrderDate(item.getOrderDate());
                orderResponseDTO.setCustomerId(item.getCustomer().getId());
                resultOrderResponseDTOByCustomerId.add(orderResponseDTO);
            }
            return resultOrderResponseDTOByCustomerId;
        } else {
            return null;
        }
    }

    //POST
    public boolean createOrder(OrderRequestDTO newOrder) {
        Order order = new Order();
        order.setOrderDate();
        Customer customer = new Customer();
        customer.setId(newOrder.getCustomerId());
        order.setCustomer(customer);
        orderRepository.save(order);

        newOrder.getItems().forEach(orderItemRequestDTO -> {
            OrderItem item = new OrderItem();
            Product product = new Product();
            product.setId(orderItemRequestDTO.getProductId());
            item.setOrder(order);
            item.setProduct(product);
            item.setAmount(orderItemRequestDTO.getAmount());
            orderItemRepository.save(item);
        });
        return true;
    }

    //PUT
    public boolean updateOrder(Integer id, OrderRequestDTO newOrder) {
        Order order = new Order();
        order.setOrderDate();
        Customer customer = new Customer();
        customer.setId(newOrder.getCustomerId());
        order.setCustomer(customer);
        order.setId(id);
        orderRepository.save(order);
        return true;
    }

    //DELETE
    public String deleteById(Integer id) {
        orderRepository.deleteById(id);
        return "Order deleted.";
    }
}
