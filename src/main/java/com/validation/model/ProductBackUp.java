package com.validation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductBackUp {
    @Id
    @GeneratedValue(generator = "abc")
    @GenericGenerator(name = "abc", strategy = "increment")
    private Long id;
    private String name;
    private String category;
    private double price;
    private int discountPercentage;
    @Formula("price - (price * discountPercentage/100)")
    private double priceAfterDiscount;

}
