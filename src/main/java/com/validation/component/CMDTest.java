package com.validation.component;

import com.validation.repository.AccountRepository;
import com.validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CMDTest implements CommandLineRunner {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserRepository userRepository;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Acc by NamedQuery : " + accountRepository.accountDetailByHolderName("Suraj Ravi Kale"));
        System.out.println("User by NamedQuery : " + userRepository.userDetailByName("Angad"));

    }
}
