package com.bazaar.bazaar.service;

import com.bazaar.bazaar.domain.Product;
import com.bazaar.bazaar.dtos.ProductRequestDTO;
import com.bazaar.bazaar.dtos.ProductResponseDTO;
import com.bazaar.bazaar.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponseDTO> getAllProducts() {
        List<ProductResponseDTO> resultProductResponseDTO = new ArrayList<>();
        List<Product> result = productRepository.findAll();
        if (!result.isEmpty()) {
            for (Product item : result) {
                ProductResponseDTO productResponseDTO = new ProductResponseDTO();
                productResponseDTO.setId(item.getId());
                productResponseDTO.setPictureUrl(item.getPictureUrl());
                productResponseDTO.setProductName(item.getProductName());
                productResponseDTO.setCategory(item.getCategory());
                productResponseDTO.setPrice(item.getPrice());
                resultProductResponseDTO.add(productResponseDTO);
            }
        }
        return resultProductResponseDTO;
    }

    public List<ProductResponseDTO> getProductById(Integer id) {
        List<ProductResponseDTO> resultProductResponseDTO = new ArrayList<>();
        List<Product> result = productRepository.findById(id);
        if (!result.isEmpty()) {
            for (Product item : result) {
                ProductResponseDTO productResponseDTO = new ProductResponseDTO();
                productResponseDTO.setId(item.getId());
                productResponseDTO.setPictureUrl(item.getPictureUrl());
                productResponseDTO.setProductName(item.getProductName());
                productResponseDTO.setCategory(item.getCategory());
                productResponseDTO.setPrice(item.getPrice());
                resultProductResponseDTO.add(productResponseDTO);
            }
        }
        return resultProductResponseDTO;
    }
    //POST
    public boolean create(ProductRequestDTO newCustomer) {
        Product product = new Product();
        product.setPictureUrl(newCustomer.getPictureUrl());
        product.setProductName(newCustomer.getProductName());
        product.setCategory(newCustomer.getCategory());
        product.setPrice(newCustomer.getPrice());
        productRepository.save(product);
        return true;
    }
    //PUT
    public boolean update(Integer id, ProductRequestDTO newCustomer) {
        Product product = new Product();
        product.setPictureUrl(newCustomer.getPictureUrl());
        product.setProductName(newCustomer.getProductName());
        product.setCategory(newCustomer.getCategory());
        product.setPrice(newCustomer.getPrice());
        product.setId(id);
        productRepository.save(product);
        return true;
    }

//DELETE
    public String deleteById(Integer id) {
        productRepository.deleteById(id);
        return "Product deleted.";
    }
}
