package com.validation.service;

import com.validation.dto.UserDto;
import com.validation.exception.UserNotFoundException;
import com.validation.model.User;

public interface UserService {
       User save(User user);

       UserDto getUserByEmail(String email) throws UserNotFoundException;

       String findStoreById(boolean flag, int storeId);

    void deleteUserById(int id);
}
