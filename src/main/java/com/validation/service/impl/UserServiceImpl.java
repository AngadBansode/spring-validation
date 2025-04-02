package com.validation.service.impl;

import com.validation.annonation.LogPayloads;
import com.validation.annonation.TrackExecutionTime;
import com.validation.dto.UserDto;
import com.validation.exception.StoreNotFoundException;
import com.validation.exception.UserNotFoundException;
import com.validation.model.Address;
import com.validation.model.User;
import com.validation.repository.UserRepository;
import com.validation.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;


    @SneakyThrows
    @LogPayloads
    @TrackExecutionTime
    public User save(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if (userOptional.isPresent())
            throw new Exception("User ID already present");
        return userRepository.save(user);
    }

    public UserDto getUserByEmail(String email) throws UserNotFoundException {

        User user = userRepository.getUserByEmail(email);
        // join
        entityManager.detach(user);// session closed
        System.err.println("User Name: " + user.getEmail());
        var address = user.getAddress(); // join fetch
        System.err.println("User Name: " + user.getEmail());
        System.err.println("Country: " + address.get(0).getCountry());
//        System.err.println("User Name: " + user.getEmail());
        if (user == null)
            throw new UserNotFoundException("User not found for Email: " + email);
        return UserDto.builder()
                .adds(user.getAdds())
                .age(user.getAge())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    //    @SneakyThrows
    public String findStoreById(boolean flag, int storeId) {

        try {
            if (flag) // from DB else REST call
                throw new DataRetrievalFailureException("store not found with ID: " + storeId);
            else
                throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "Rest client error occurred while getting store details:" + storeId);
        } catch (Exception exception) {
            throw new StoreNotFoundException(exception.getLocalizedMessage());
        }
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}