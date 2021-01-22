package com.bazaar.bazaar.service;

import com.bazaar.bazaar.domain.Customer;
import com.bazaar.bazaar.dtos.CustomerRequestDTO;
import com.bazaar.bazaar.dtos.CustomerResponseDTO;
import com.bazaar.bazaar.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

//GET
    public List<CustomerResponseDTO> getAll() {
        List<CustomerResponseDTO> resultCustomerResponseDTO = new ArrayList<>();
        List<Customer> result = customerRepository.findAll();
        if (!result.isEmpty()) {
            for (Customer item : result) {
                CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
                customerResponseDTO.setName(item.getName());
                customerResponseDTO.setSurname(item.getSurname());
                customerResponseDTO.setId(item.getId());
                customerResponseDTO.setPhoneNumber(item.getPhoneNumber());
                customerResponseDTO.setAddress(item.getAddress());
                customerResponseDTO.setEmail(item.getEmail());
                resultCustomerResponseDTO.add(customerResponseDTO);
            }
        }
        return resultCustomerResponseDTO;
    }

    public CustomerResponseDTO getByCustomerID(Integer id) {
        List<Customer> result = customerRepository.findById(id);
        if (!result.isEmpty()) {
            Customer item = result.get(0);
            CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
            customerResponseDTO.setName(item.getName());
            customerResponseDTO.setSurname(item.getSurname());
            customerResponseDTO.setId(item.getId());
            customerResponseDTO.setPhoneNumber(item.getPhoneNumber());
            customerResponseDTO.setAddress(item.getAddress());
            customerResponseDTO.setEmail(item.getEmail());
            return customerResponseDTO;
        }
        return null;
    }
    //POST
    public boolean createCustomer(CustomerRequestDTO newCustomer) {
        Customer customer = new Customer();
        customer.setName(newCustomer.getName());
        customer.setSurname(newCustomer.getSurname());
        customer.setPhoneNumber(newCustomer.getPhoneNumber());
        customer.setAddress(newCustomer.getAddress());
        customer.setEmail(newCustomer.getEmail());
        customer.setPassword(newCustomer.getPassword());
        customerRepository.save(customer);
        return true;
    }

    //PUT
    public boolean updateCustomer(Integer id ,CustomerRequestDTO newCustomer) {
        Customer customer = new Customer();
        customer.setName(newCustomer.getName());
        customer.setSurname(newCustomer.getSurname());
        customer.setPhoneNumber(newCustomer.getPhoneNumber());
        customer.setAddress(newCustomer.getAddress());
        customer.setEmail(newCustomer.getEmail());
        customer.setPassword(newCustomer.getPassword());
        customer.setId(id);
        customerRepository.save(customer);
        return true;
    }
    //DELETE
    public String deleteById(Integer id) {
        customerRepository.deleteById(id);
        return "Customer deleted.";
    }
}
