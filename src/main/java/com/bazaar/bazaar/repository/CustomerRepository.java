package com.bazaar.bazaar.repository;

import com.bazaar.bazaar.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findById(Integer id);

    Optional<Customer> findByEmailAndPassword(String email,String password);

    void deleteById(Integer id);
}
