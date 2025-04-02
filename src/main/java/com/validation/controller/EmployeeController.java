package com.validation.controller;

import com.validation.dto.EmployeeDto;
import com.validation.model.Employee;
import com.validation.service.impl.EmployeeService;
import com.validation.utils.NotificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

//mapping -- GetMapping -- localhost:9191/employee/byID/13
//  PostMapping -- localhost:9191/employee/add/13

// //  DeleteMapping -- localhost:9191/employee/delete/14

@RequestMapping("/employee")
@RestController
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    // GET
    @GetMapping(value = "/byID/{empId}")
    public EmployeeDto getEmployeeById(@PathVariable int empId) {

        return employeeService.getEmployeeById(empId);
    }

    // get all emp
    @GetMapping(value = "/all")
    public Iterable<Employee> getAllEmployee() {

        return employeeService.getAllEmployee();
    }

    // ADD
    @PostMapping(value = "/add")
    public Employee addEmployee(@RequestBody Employee employee) {

        return employeeService.addEmployee(employee);
    }

    // Delete
    @DeleteMapping(value = "/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {

        return employeeService.deleteEmployee(id);
    }

    // save Emp and dont return anything
    @PostMapping(value = "/save")   // localhost:9191/employee/save
    public void saveEmployee(@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);
    }

    // take two numbers and return sum
    @GetMapping(value = "/add/{num1}/{num2}")
    public int add(@PathVariable int num1, @PathVariable int num2) {

        return num1 + num2;
    }

    // patch method for partial update employee
    @PatchMapping(value = "/update/{id}")   // localhost:9191/employee/update/1
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Map<Object, Object> fields) {

//   return ResponseEntity.ok(employeeService.partialUpdateEmployee(id, fields)).status(HttpStatus.OK).build();
        Employee result = employeeService.partialUpdateEmployee(id, fields);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public String sendMail(String email) {
        if (email == null || email.isEmpty()) {
            return "Email is empty";
        }
        Boolean isValid = validateEmail(email);
        if (!isValid) {
            return "Email is not valid";
        }
        return NotificationUtil.sendNotification(email);

    }

    private Boolean validateEmail(String email) {
        // check mail format should be gmail and at least 10 characters
        return email.contains("@gmail.com") && email.length() > 10;
    }

    @GetMapping(path = {"/edit/{name}"})
    public String getEmpName(@PathVariable(required = false) Optional<String> name) {
        if (name.isEmpty())
            return "Name: Angad-PathVariable";
        else return "Name: " + name;
    }

    @GetMapping("/empByName")
    public String getEmpNameRequestParam(@RequestParam(required = false) String name) {
        if (Objects.isNull(name))
            return "Name: Angad-RequestParam";
        else return "Name: " + name;
    }

}
