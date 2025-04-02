package com.validation.repository;

import com.validation.model.ProfileIndustryCompositeID;
import com.validation.model.ProfileMi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileMiRepository extends JpaRepository<ProfileMi, ProfileIndustryCompositeID> {
}
