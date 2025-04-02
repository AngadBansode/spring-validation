package com.validation.service.impl;

import com.validation.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProductPersistenceContextServiceImpl {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void saveProduct(Product product) {
        entityManager.flush();
        entityManager.persist(product); // Save the product to the database
        entityManager.flush();
    }

    @Transactional
    public Product getProductById(Long id) {
        return entityManager.find(Product.class, id); // Retrieve the product by ID
    }

    @Transactional
    public void updateProductPrice(Long id, double newPrice) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            product.setPrice(newPrice); // Update the product price
            entityManager.merge(product); // Update the product in the database
        }
    }

    @Transactional
    public void deleteProduct(Long id) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityManager.remove(product); // Delete the product
        }
    }

}
