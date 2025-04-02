package com.validation.service.impl;

import com.validation.dto.EmployeeDto;
import com.validation.mapper.EmployeeMapper;
import com.validation.model.Employee;
import com.validation.model.Student;
import com.validation.repository.EmployeeRepository;
import com.validation.utils.NotificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

//@Service
//@Repository -- database
//@RestController -- controller
@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    StudentServiceImpl studentService;

    EmployeeMapper employeeMapper;

    public  String sendMail(String email) {

        // check email is not empty or null
        if (email != null && !email.isEmpty()) {
            System.out.println("Mail sent to : " + email);
            return NotificationUtil.sendNotification(email);
        } else {
            System.out.println("Email is empty or null");
        }
        return "Email is empty or null";
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public String saveEmp(Employee employee) {
        Student student = Student.builder()
                .mark(75.5)
                .mobileNumber(new Long[]{9071l, 548412l})
                .adds(new String[]{"bast", "chennai", "pau"})
                .build();
        student.setAge(23);
        student.setFirstName("Ramesh-3");
        student.setLastName("Dev-3");

        employeeRepository.save(employee);

        try {
            studentService.saveStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Employee saved...!!!");
        return "employee saved...!!!";
    }

    public EmployeeDto getEmployeeById(int empId) {
        Employee emp = employeeRepository.findById(empId).orElse(Employee.builder().build());
        return employeeMapper.INSTANCE.employeeToEmployeeDto(emp);

    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public String deleteEmployee(int id) {

        employeeRepository.deleteById(id);
        return "deleted....!!!";
    }

    public Iterable<Employee> getAllEmployee() {
        // use completable future to call repository and convert name in upper case  and return
        Executor executor = Executors.newCachedThreadPool();
        CompletableFuture<List<Employee>> completableFuture = CompletableFuture.supplyAsync(() -> employeeRepository.findAll(), executor);
        try {
            System.out.println("Name Completable : " + Thread.currentThread().getName());
            completableFuture.thenApplyAsync(employees -> {
                // convert name in upper case
                System.out.println("Upper case : " + Thread.currentThread().getName());
                return employees.parallelStream().map(emp -> emp.getFirstName().toUpperCase()).toList();
            }).thenApplyAsync(ageFilteredList -> {
                System.out.println("Name length : " + Thread.currentThread().getName());
                return ageFilteredList.parallelStream().filter(empAge -> empAge.length() > 5).toList();
            }).thenAcceptAsync(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // return empty list of employee
        return new ArrayList<>();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee partialUpdateEmployee(int id, Map<Object, Object> fields) {

        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            // use Reflection here to identify Employee class fields and update the fields
            fields.forEach((k, v) -> {
                Field field = ReflectionUtils.findRequiredField(Employee.class, k.toString());
                field.setAccessible(true);
                ReflectionUtils.setField(field, employee.get(), v);
            });
            return employeeRepository.save(employee.get());
        }
        return null;
    }
}
