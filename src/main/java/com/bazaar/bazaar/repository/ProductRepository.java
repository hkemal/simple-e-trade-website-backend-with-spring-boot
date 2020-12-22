package com.bazaar.bazaar.repository;

import com.bazaar.bazaar.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findById(Integer id);
    void deleteById(Integer id);
}
