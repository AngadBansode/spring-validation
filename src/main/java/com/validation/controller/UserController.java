package com.validation.controller;

import com.validation.dto.UserDto;
import com.validation.exception.UserNotFoundException;
import com.validation.model.Account;
import com.validation.model.Employee;
import com.validation.model.User;
import com.validation.service.UserService;
import com.validation.service.impl.EmployeeService;
import com.validation.service.impl.UserServiceImpl;
import com.validation.utils.EmployeeType;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    EntityManager entityManager;

    @Autowired(required = false)
    @Qualifier("stgKafkaProperties")
    KafkaProperties properties;

    @PostMapping
    public User saveUser(@Valid @RequestBody User user) {
        log.info("User adding... ", user);
        return userService.save(user);
    }

    /*@PostConstruct
    public void showProp (){
        System.err.println("kafka stg servers : " + properties.getBootstrapServers());
    }
*/
    @GetMapping("{email}")
    public UserDto getUserByEmailID(@PathVariable String email) throws UserNotFoundException {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/map/{flag}/{storeId}")
    public String findLocationByStore(@PathVariable boolean flag, @PathVariable int storeId) {
        return userService.findStoreById(flag, storeId);
    }

    @GetMapping("/update")
    @Transactional
    public Employee updateEmp() {

        Employee employee = entityManager.find(Employee.class, 1);
        employee.setSalary(78945d);
        return entityManager.merge(employee);
    }

    @GetMapping("/delete")
    @Transactional
    public String deleteUserByID() {
        User user = entityManager.find(User.class, 1);
        entityManager.remove(user);
        return "deleted";
    }

    @GetMapping("/save")
    public String saveEntity() {
        Employee employee = Employee.builder()
                .employeeType(EmployeeType.PERMANENT)
                .firmName("Infosys SYSTEMS")
                .salary(1225d)
                .build();
        employee.setAge(25);
        employee.setFirstName("Rajesh-3");
        employee.setLastName("Kale-3");
//        BeanUtils.copyProperties(employee, employee);
        return employeeService.saveEmp(employee);

    }

        @GetMapping("/account")
        @Transactional
        public Account addAccount(){
       /* Account account = Account.builder()
                .accountNumber("SBIN00124563")
                .balance(25474.25)
                .holderName("Suraj Ravi Kale")
                .ifsc("SBIN00012")
                .build();*/
        /*Query query = entityManager.createQuery("select a from Account a");
       List<Account> accountList =     query.getResultList();
            System.out.println(accountList);*/


         Account account =  entityManager.find(Account.class, UUID.fromString("b1b6f47b-2109-40c5-ad03-82e154528fb5"));
            System.out.println(account);
         return account;
    }

    // delete user by id
    @DeleteMapping("/delete/{id}")
    @Transactional
    public String deleteUserById(@PathVariable int id) {

          userService.deleteUserById(id);
        System.out.println("User deleted successfully : " + id);
        return "deleted";
    }


}
