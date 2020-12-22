package com.bazaar.bazaar.repository;

import com.bazaar.bazaar.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findById(Integer id);
    void deleteById(Integer id);
}
