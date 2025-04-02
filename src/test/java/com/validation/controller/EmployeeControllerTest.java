
package com.validation.controller;

import com.validation.dto.EmployeeDto;
import com.validation.mapper.EmployeeMapper;
import com.validation.model.Employee;
import com.validation.model.User;
import com.validation.service.impl.EmployeeService;
import com.validation.utils.NotificationUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("Employee-Controller Test")
@Order(2)
public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @Captor
    private ArgumentCaptor<Employee> employeeCaptor;

    @InjectMocks
    private EmployeeController employeeController;

    // write the Junits for saveEmployee method
    // beforeall, afterall, beforeeach, aftereach
    // write the Junits beforeall
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All Emp controller Test");
    }


    @Test
    public void testSaveEmployee() {

        Employee employee = new Employee();
        employee.setFirstName("Raj");
        employee.setLastName("Kumar");
        employee.setAge(25);
        employee.setSalary(25000d);
        doNothing().when(employeeService).saveEmployee(employee);
        employeeController.saveEmployee(employee);
        verify(employeeService, times(1)).saveEmployee(employee);

    }

    //Junits for saveEmployee method with ArgumentCaptor
    @Test
    public void testSaveEmployeeWithArgumentCaptor() {
        Employee employee = new Employee();
        employee.setFirstName("Raj");
        employee.setLastName("Kumar");
        employee.setAge(25);
        employee.setSalary(25000d);

        doNothing().when(employeeService).saveEmployee(employee);

        employeeController.saveEmployee(employee);

        verify(employeeService, times(1)).saveEmployee(employeeCaptor.capture());

        assertEquals(employeeCaptor.getValue().getFirstName(), "Raj");
        assertEquals(employeeCaptor.getValue().getLastName(), "Kumar");
        assertEquals(employeeCaptor.getValue().getAge(), 25);
        assertEquals(employeeCaptor.getValue().getSalary(), 25000d);
    }

    // Mock EmployeeService and test the addEmployee method
    @Test
    public void testAddEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Raj");
        employee.setLastName("Kumar");
        employee.setAge(25);
        employee.setSalary(25000d);
        when(employeeService.addEmployee(employee)).thenReturn(employee);
        Employee actual = employeeController.addEmployee(employee);
        verify(employeeService, times(1)).addEmployee(any(Employee.class));
        assertEquals(employee, actual);
    }

    // write Junits with doAnswer for deleteEmployee method
    @DisplayName("Test deleteEmployee")
    @Test
    public void testDeleteEmployee() {
//        doNothing().when(employeeService).deleteEmployee(1);
        employeeController.deleteEmployee(1);
        verify(employeeService, Mockito.atLeastOnce()).deleteEmployee(1);
    }

    // write the Junits for getEmployeeById method using thenAnswer
    @Test
    public void testGetEmployeeById() {
        Employee employee = new Employee();
        employee.setFirstName("Raj");
        employee.setLastName("Kumar");
        employee.setAge(25);
        employee.setSalary(25000d);
        when(employeeService.getEmployeeById(1)).then(invocation -> {
            Object obj = invocation.getArgument(0);
            //     obj.
            return employee;
        });
        EmployeeDto actual = employeeController.getEmployeeById(1);
        verify(employeeService, times(1)).getEmployeeById(1);
        // check firstname using assertequals
        assertEquals("Raj", actual.getFirstName());
    }

    // addEmployee method with thenAnswer
    @Test
    public void testAddEmployeeWithThenAnswer() {

        Employee employee = new Employee();
        employee.setFirstName("Raj");
        employee.setLastName("Kumar");
        employee.setAge(25);
        employee.setSalary(25000d);
        when(employeeService.addEmployee(any(Employee.class))).thenAnswer(invocation -> {
            Employee emp = invocation.getArgument(0);
            emp.setFirstName("Rajesh");
            return emp;
        });
        Employee actual = employeeController.addEmployee(employee);
        verify(employeeService, times(1)).addEmployee(any(Employee.class));
        assertEquals(employee, actual);
        // check firstname using assertequals
        assertEquals("Rajesh", actual.getFirstName());
    }

    // write the Junits using doAnswer for saveEmployee method
    @Test
    public void testSaveEmployeeWithDoAnswer() {
        Employee employee = new Employee();
        employee.setFirstName("Raj");
        employee.setLastName("Kumar");
        employee.setAge(25);
        employee.setSalary(25000d);
        doAnswer(invocation -> {
            Employee emp = invocation.getArgument(0);
            emp.setFirstName("Pavan");
            return null;
        }).when(employeeService).saveEmployee(any(Employee.class));

        employeeController.saveEmployee(employee);

        verify(employeeService, times(1)).saveEmployee(employee);

        // check firstname using assertequals
        assertEquals("Pavan", employee.getFirstName());
        // check lastname using assertequals
        assertEquals("Kumar", employee.getLastName());
    }

    // doReturn Junits for getEmployeeById method
    @Test
    public void testGetEmployeeByIdWithDoReturn() {
        Employee employee = new Employee();
        employee.setFirstName("Raj");
        employee.setLastName("Kumar");
        employee.setAge(25);
        employee.setSalary(25000d);

        var employeeDto = EmployeeMapper.INSTANCE.employeeToEmployeeDto(employee);

        doReturn(employeeDto).when(employeeService).getEmployeeById(1);

        EmployeeDto actual = employeeController.getEmployeeById(1);

        // verify the getEmployeeById method is called once
        verify(employeeService, times(1)).getEmployeeById(1);
        // check firstname using assertequals
        assertEquals("Raj", actual.getFirstName());

    }



    //write the parameterized test cases for add method
    @ParameterizedTest
    @CsvSource({"10,20,30", "20,30,50", "30,40,70"})
    public void testAddCSV(int num1, int num2, int expected) {
        int actual = employeeController.add(num1, num2);
        assertEquals(expected, actual);
    }

    //write the parameterized test cases for add method
    @ParameterizedTest
    @MethodSource("addMethodData")
    public void testAdd(int num1, int num2, int expected) {
        int actual = employeeController.add(num1, num2);
        assertEquals(expected, actual);
    }
    //create a static method addMethodData
    public static Stream<Arguments> addMethodData() {
        return Stream.of(
                Arguments.of(10, 20, 30),
                Arguments.of(20, 30, 50),
                Arguments.of(30, 40, 70)
        );
    }

    // write the parameterized test cases for add method using CSV   source
    @ParameterizedTest
    @CsvSource(value = {"10,20,30", "20,30,50", "30,40,70"}, delimiter = ',')
    public void testAddCSVFile(int num1, int num2, int expected) {
        int actual = employeeController.add(num1, num2);
        assertEquals(expected, actual);
    }
    // write the parameterized test cases for add method using CSV file  source
    @ParameterizedTest
    @CsvFileSource(resources = "/add.csv", numLinesToSkip = 1)
    public void testAddCSVFileSource(int num1, int num2, int expected) {
        int actual = employeeController.add(num1, num2);
        assertEquals(expected, actual, "Expected and actual are same");
    }

    // write the parameterized test cases for add method using @ValueSource annotation
    @ParameterizedTest
    @ValueSource(ints = {10, 20, 30})
    public void testAddValueSource(int num1) {
        int actual = employeeController.add(num1, 20);
        assertEquals(num1 + 20, actual);
    }

    // write the @repeatabletest for add method
    @RepeatedTest(3)
    @DisplayName("Repeatable Test")
    public void testAddRepeatable() {
        int actual = employeeController.add(10, 20);
        assertEquals(30, actual);
    }

    // write the Junits for sendMail method
    @Test
    public void testSendMail() throws Exception {
        String email = "a@gmail.com";
        String actual = employeeController.sendMail(email);
    assertEquals("Mail sent successfully", actual);
    }
    // private method for validateEmail
    @Test
    public void testValidateEmail() {
        String email = "anbansode24@gmail.com";
        EmployeeController spy = PowerMockito.spy(employeeController);
//        doReturn(true).when(spy).validateEmail(email);
//        assertEquals(true, actual);

//        Boolean actual = employeeController.validateEmail(email);
//        assertEquals(false, actual);
    }

}

