package com.validation.model;

import com.validation.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INVENTORY_ITEMS")
@EqualsAndHashCode(callSuper = true)
public class ItemAudit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    private String name;
    private String category;
    private int qty;
    private String sourceSystem;

}