package com.validation.controller;

import com.validation.model.ItemAudit;
import com.validation.service.impl.ItemAuditServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemAuditController {

    private final ItemAuditServiceImpl itemService;

    public ItemAuditController(ItemAuditServiceImpl itemService) {
        this.itemService = itemService;
    }

    // Create Item
    @PostMapping("/add")
    public ResponseEntity<ItemAudit> createItem(@RequestBody ItemAudit item) {
        return ResponseEntity.ok(itemService.saveItem(item));
    }

    // Get All Items
    @GetMapping
    public ResponseEntity<List<ItemAudit>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    // Get Item by ID
    @GetMapping("/{id}")
    public ResponseEntity<ItemAudit> getItemById(@PathVariable long id) {
        Optional<ItemAudit> item = itemService.getItemById(id);
        return item.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update Item
    @PutMapping("update/{id}")
    public ResponseEntity<ItemAudit> updateItem(@PathVariable long id, @RequestBody ItemAudit item) {
        item.setOrderId(id);
        return ResponseEntity.ok(itemService.saveItem(item));
    }

    // Delete Item
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}