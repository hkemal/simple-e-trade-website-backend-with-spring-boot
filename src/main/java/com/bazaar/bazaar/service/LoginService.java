package com.bazaar.bazaar.service;

import com.bazaar.bazaar.domain.Customer;
import com.bazaar.bazaar.dtos.CustomerResponseDTO;
import com.bazaar.bazaar.dtos.LoginDTO;
import com.bazaar.bazaar.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LoginService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerResponseDTO login(LoginDTO loginDTO) {
        CustomerResponseDTO customerDTO = new CustomerResponseDTO();
        Optional<Customer> customers = customerRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        List<Customer> result = customerRepository.findAll();
        if (customers.isPresent()) {
            customerDTO.setId(customers.get().getId());
            customerDTO.setName(customers.get().getName());
            customerDTO.setSurname(customers.get().getSurname());
            customerDTO.setEmail(customers.get().getEmail());
            customerDTO.setAddress(customers.get().getAddress());
            customerDTO.setPhoneNumber(customers.get().getPhoneNumber());
            return customerDTO;
        } else {
            return null;
        }
    }
}
