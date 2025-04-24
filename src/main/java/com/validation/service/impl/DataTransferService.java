package com.validation.service.impl;

import com.validation.model.ProductBackUp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Service
public class DataTransferService {

    @Autowired
    private JdbcTemplate mysqlTemplate;

    @Autowired
    private JdbcTemplate postgresTemplate;

//    @PersistenceContext
//    private EntityManager entityManager;

    private final ExecutorService executor = Executors.newFixedThreadPool(10);

   /* old logic
   public void transferData() {
        int batchSize = 1000;
        int offset = 0;

        while (true) {
            List<ProductBackUp> records = fetchBatchFromMySQL(batchSize, offset);
            if (records.isEmpty()) {
                break; // No more records to process
            }

            CompletableFuture.runAsync(() -> processBatch(records), executor);

            offset += batchSize;
            log.info("batch-size  offset: " + offset);
        }

        executor.shutdown();
    }*/

    // new optimized logic from chatgpt
    public void transferData() {
        int batchSize = 1000;
        int offset = 0;

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        while (true) {
            List<ProductBackUp> records = fetchBatchFromMySQL(batchSize, offset);
            if (records.isEmpty()) {
                break; // No more records to process
            }

            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                processBatch(records);
                log.info("Processing batch on thread: " + Thread.currentThread().getName());
            }, executor);

            futures.add(future);
            offset += batchSize;
        }

        // Wait for all tasks to complete...main thread also wait
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        executor.shutdown();
    }

    private List<ProductBackUp> fetchBatchFromMySQL(int batchSize, int offset) {
        String query = "SELECT * FROM Product LIMIT ? OFFSET ?";
        return mysqlTemplate.query(query, new Object[]{batchSize, offset}, (rs, rowNum) -> {
            ProductBackUp entity = new ProductBackUp();
            entity.setId(rs.getLong("id"));
            entity.setName(rs.getString("name"));
            entity.setPrice(rs.getDouble("price"));
            entity.setCategory(rs.getString("category"));
            entity.setDiscountPercentage(rs.getInt("discountPercentage"));

            return entity;
        });
    }

    private void processBatch(List<ProductBackUp> records) {
        records.forEach(record -> {
            try {
                log.info("Thread Name: " + Thread.currentThread().getName());
                // Insert into mySQL
                String insertQuery = "INSERT INTO ProductBackUp (id, name, category, price, discountPercentage)\n" +
                        "VALUES (?, ?, ?, ?, ?)\n" +
                        "ON DUPLICATE KEY UPDATE id = id";
                int updated = postgresTemplate.update(insertQuery, record.getId(), record.getName(), record.getCategory(), record.getPrice(), record.getDiscountPercentage());

                // Handle duplicates
                if (updated == 0) {
//                    String duplicateQuery = "INSERT INTO duplicates_table (id, name, value) VALUES (?, ?, ?)";
//                    postgresTemplate.update(duplicateQuery, record.getId(), record.getName(), record.getValue());
                    System.out.println("Duplicate records...");
                }
            } catch (Exception ex) {
                ex.printStackTrace(); // Log errors
            }
        });
    }
}
