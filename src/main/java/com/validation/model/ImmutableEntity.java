package com.validation.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Immutable
public class ImmutableEntity {

    @Id
//    @Column(name = "event_generated_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    private String name;

    public ImmutableEntity(){

    }

    public ImmutableEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ImmutableEntity( String name) {

        this.name = name;
    }


    // Getters only; no setters to ensure immutability at the Java level
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
