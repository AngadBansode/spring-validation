package com.validation.repository;

import com.validation.model.Account;
import com.validation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByEmail(String email);

    List<User> userDetailByName(String name);

}
