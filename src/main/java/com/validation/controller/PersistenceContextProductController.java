package com.validation.controller;

import com.validation.model.Product;
import com.validation.service.impl.ProductPersistenceContextServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/context")
public class PersistenceContextProductController {

    @Autowired
    private ProductPersistenceContextServiceImpl productService;

    @PostMapping
    public String saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return "Product saved successfully!";
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public String updateProductPrice(@PathVariable Long id, @RequestParam double price) {
        productService.updateProductPrice(id, price);
        return "Product price updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted successfully!";
    }

}
