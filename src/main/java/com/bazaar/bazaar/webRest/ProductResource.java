package com.bazaar.bazaar.webRest;

import com.bazaar.bazaar.domain.Product;
import com.bazaar.bazaar.dtos.ProductRequestDTO;
import com.bazaar.bazaar.dtos.ProductResponseDTO;
import com.bazaar.bazaar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping("/get-all-product")
    private List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/get-by-product-id/{id}")
    private ProductResponseDTO getProductByName(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @GetMapping("/get-by-product-category/{category}")
    private List<ProductResponseDTO> getProductByName(@PathVariable String category) {
        return productService.getProductByCategory(category);
    }

    @GetMapping("/get-by-product-all-category")
    private List<String> getAllCategoryName() {
        return productService.getAllCategoryName();
    }

    @PostMapping("/product-create")
    private boolean createCustomer(@RequestBody ProductRequestDTO newProduct) {
        return productService.create(newProduct);
    }

    @PutMapping("/product-update/{id}")
    private boolean updateProduct(@PathVariable Integer id,@RequestBody ProductRequestDTO updatingCustomer) {
        return productService.update(id,updatingCustomer);
    }

    @DeleteMapping("/delete-product-by-id/{id}")
    private String deleteProductById(@PathVariable Integer id) {
        return productService.deleteById(id);
    }
}
