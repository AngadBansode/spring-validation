package com.validation.repository;

import com.validation.model.ImmutableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImmutableEntityRepository extends JpaRepository<ImmutableEntity,Long> {
}
