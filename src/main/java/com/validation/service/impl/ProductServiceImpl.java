package com.validation.service.impl;

import com.validation.model.Product;
import com.validation.model.ProfileGics;
import com.validation.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public void saveProductsInBatch() {

        List<Product> productList = new ArrayList<>();
        for(int i = 0 ; i<100000; i++){
            Product p = new Product();
             p.setCategory("cat-" + i);
             p.setName("product- "+ i);
             p.setDiscountPercentage(10);
             p.setPriceAfterDiscount( 90);
             p.setPrice(100);
             productList.add(p);
        }

        productRepository.saveAll(productList);

    }

    public List<Product> getProductsByCategory(String category) {
       return productRepository.findByCategory(category);
    }

    //sales team : update the stock of a product in (IS)
     public Product updateStock(int id, int stock){

        Product existingProduct= productRepository.findById(new Long(id))
                .orElseThrow(()-> new RuntimeException("product not found with id "+id));

        existingProduct.setPrice(stock);
        return productRepository.save(existingProduct);
    }
}

