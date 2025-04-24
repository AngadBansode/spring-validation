package com.validation.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "url_mapping")
public class UrlMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String longUrl;

    @Column(nullable = false, unique = true)
    private String shortUrl;

    // Getters and Setters
}
