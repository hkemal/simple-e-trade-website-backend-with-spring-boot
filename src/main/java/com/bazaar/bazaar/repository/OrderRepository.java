package com.bazaar.bazaar.repository;

import com.bazaar.bazaar.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findById(Integer id);
    void deleteById(Integer id);
}
