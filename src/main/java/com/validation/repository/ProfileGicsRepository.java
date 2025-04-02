package com.validation.repository;

import com.validation.model.ProfileGics;
import com.validation.model.ProfileIndustryCompositeID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileGicsRepository extends JpaRepository<ProfileGics, ProfileIndustryCompositeID> {
}
