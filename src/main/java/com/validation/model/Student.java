package com.validation.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Type;

@Entity
@Data
@JsonDeserialize
@AllArgsConstructor
@Builder
public class Student extends PersonMapper {

    @Column
    private Double mark;

    @Type( value = JsonType.class )
    @Column( columnDefinition = "json" )
    private Long[] mobileNumber;

    @Type( value = JsonType.class )
    @Column( columnDefinition = "json" )
    private String[] adds;

    public Student() {

    }
}
