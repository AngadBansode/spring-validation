package com.validation.controller;

import com.validation.model.Product;
import com.validation.service.impl.DataTransferService;
import com.validation.service.impl.ProductServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/batch")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private DataTransferService dataTransferService;

    @PostMapping
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    @GetMapping
//    @QueryMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // add 1 lakh product using hibernate batch size - 1000
    // 100 batches  - 1000 * 100 = 1 lakh

    @PostMapping("/products")
    public ResponseEntity<String> saveProducts() {
        productService.saveProductsInBatch();
        return new ResponseEntity("Saved", HttpStatus.OK);
    }

    @PostMapping("/process")
    public ResponseEntity<String> saveToProductBackup() {
        dataTransferService.transferData();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}