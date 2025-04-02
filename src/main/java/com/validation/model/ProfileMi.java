package com.validation.model;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ues_profile_mi_industry_focus")
@IdClass(ProfileIndustryCompositeID.class)
public class ProfileMi {

//    @Id
   /* @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")*/
    @Column(name = "id")
    private Long id;

    @Id
    private String profile;
    @Id
    @Column(name = "industry_id")

    private Integer industryId;

    @Column(name = "industry_name")
    private String industryName;
}
