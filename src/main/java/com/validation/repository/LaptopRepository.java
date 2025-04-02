package com.validation.repository;

import com.validation.model.Address;
import com.validation.model.Laptop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends CrudRepository<Laptop, Integer> {
}
