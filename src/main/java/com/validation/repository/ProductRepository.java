package com.validation.repository;

import com.validation.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

//    List<Product> getProductsByCategory(String category);

    List<Product> findByCategory(String category);
}