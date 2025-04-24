package com.validation.service.impl;

import com.validation.model.ItemAudit;
import com.validation.repository.ItemAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ItemAuditServiceImpl {

    private final ItemAuditRepository itemRepository;

    public ItemAuditServiceImpl(ItemAuditRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Create or Update Item
    @Transactional
    public ItemAudit saveItem(ItemAudit item) {
        return itemRepository.save(item);
    }

    // Get all Items
    public List<ItemAudit> getAllItems() {
        return itemRepository.findAll();
    }

    // Get single Item by ID
    public Optional<ItemAudit> getItemById(long id) {
        return itemRepository.findById(id);
    }

    // Delete Item by ID
    @Transactional
    public void deleteItem(long id) {
        itemRepository.deleteById(id);
    }
}