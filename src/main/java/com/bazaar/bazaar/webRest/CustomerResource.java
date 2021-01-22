package com.bazaar.bazaar.webRest;

import com.bazaar.bazaar.dtos.CustomerRequestDTO;
import com.bazaar.bazaar.dtos.CustomerResponseDTO;
import com.bazaar.bazaar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get-all-customer")
    private List<CustomerResponseDTO> getAllCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/get-by-customer-id/{id}")
    private CustomerResponseDTO getCustomerById(@PathVariable Integer id) {
        return customerService.getByCustomerID(id);
    }

    @PostMapping("/customer-create")
    private boolean createCustomer(@RequestBody CustomerRequestDTO newCustomer) {
        return customerService.createCustomer(newCustomer);
    }

    @PutMapping("/customer-update/{id}")
    private boolean updateCustomer(@PathVariable Integer id,@RequestBody CustomerRequestDTO newCustomer) {
        return customerService.updateCustomer(id,newCustomer);
    }

    @DeleteMapping("/delete-by-id/{id}")
    private String deleteCustomerById(@PathVariable Integer id) {
        return  customerService.deleteById(id);
    }
}
