package com.validation.repository;

import com.validation.model.ItemAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemAuditRepository extends JpaRepository<ItemAudit, Long> {
}
