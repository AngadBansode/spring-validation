package com.validation;

import com.validation.configuration.UserYmlConfigurationRead;
import com.validation.filter.RateLimitingFilter;
import com.validation.model.ImmutableEntity;
import com.validation.model.Laptop;
import com.validation.model.Person;
import com.validation.model.ProfileGics;
import com.validation.model.ProfileMi;
import com.validation.model.Student;
import com.validation.repository.ImmutableEntityRepository;
import com.validation.repository.LaptopRepository;
import com.validation.repository.PersonRepository;
import com.validation.repository.ProfileGicsRepository;
import com.validation.repository.ProfileMiRepository;
import com.validation.repository.UserRepository;
import com.validation.service.impl.MesseageService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

@EnableAsync
@EnableCaching
@SpringBootApplication
@EnableScheduling
@ConfigurationPropertiesScan("com.validation.configuration")
//@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@RestController
@RequestMapping("/rest")
public class SpringValidationApplication implements CommandLineRunner{


    @Autowired
    com.validation.component.Student student;

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private ProfileMiRepository profileMiRepository;

    @Autowired
    private ProfileGicsRepository profileGicsRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserYmlConfigurationRead userYmlConfigurationRead;
    @Autowired
    private ApplicationContext context;

    @Autowired
    ImmutableEntityRepository immutableEntityRepository;


    @PostConstruct
    public void setSystemProperty(){
        System.out.println("setting enableBean is true....");
        System.setProperty("enableBean","true");
    }
   @Autowired(required = true)
    MesseageService messeageService;
    public static void main(String[] args) {
        SpringApplication.run(SpringValidationApplication.class, args);
    }

//    @Scheduled(fixedRate = 5000)
    // if we pass the argument to print method:
    //Could not create recurring task for @Scheduled method 'print': Only no-arg methods may be annotated with @Scheduled
    public void print(/*String name*/) {
        int cnt = 0;
        System.out.println("count:: " + (++cnt));
//        return "name";
    }

    /*@Bean
    @Order(1)
    @Transactional*/
   /* public CommandLineRunner runTheApplication(UserRepository studentRepository) {

        return runner -> {
//            saveEntity(studentRepository);
          messageServiceBeanTest();
        };
    }*/

    /*@Scheduled(fixedRate = 5000)
    public void messageServiceBeanTest() {
        System.out.println("Bean used: " + messeageService.increaseCount());
    }*/

   /* @Bean
    @Order(2)
    public CommandLineRunner runTheApplication2() {

        return runner -> print();
    }

    @Bean
    @Order(3)
    public CommandLineRunner runTheApplication3() {

        return runner -> System.out.println("command line runner -3");
    }*/

    @Transactional
    private void saveEntity(UserRepository studentRepository) {
        System.out.println("Welcome to command line runner....!!");


/*		 User user  = User.builder()
                 .email("angad@gmail.com")
                 .name("Angad")
                 .adds("fake")
                 .age(25)
                 .type("Admin")
                 .build();

        user.setAddress(Arrays.asList(new Address().builder()
                .country("India")
                .homeName("Suman Niwas")
                .streetName("karegaon road")
                .pinCode(431501)
                .user(user)
                .build(),new Address().builder()
				.country("India")
				.homeName("Angad House")
				.streetName("Zero road")
				.pinCode(1401511)
				.user(user)
				.build()));
//        studentRepository.save(user);*/

		//2. employee save

		/*Employee employee = new Employee().builder()
				.employeeType(EmployeeType.PERMANENT)
				.firmName("EPAM SYSTEMS")
				.salary(25441d)
               .build();
        employee.setAge(25);
        employee.setFirstName("Pavan");
        employee.setLastName("Kale");*/

        //Delete the Address


//        userRepository.deleteById(5);


      // Delete UserByID -- 1

//      userRepository.deleteById(1);

   // student details

        Student student = new Student().builder()
                .mark(75.5)
                .mobileNumber(new Long[]{9545909071l,9545909072l})
                .adds(new String[]{"pbn","pune","pau"})
                .build();
        student.setAge(45);
        student.setFirstName("Savi");
        student.setLastName("patil");

//        studentRepository.save(student);

    /* Student student1 =   studentRepository.findById(3).orElseGet(Student::new);
     String [] adds = student1.getAdds();
     Long [] nos = student1.getMobileNumber();
        System.out.println("adds : " + Arrays.toString(adds));
        System.out.println("numbers : " + Arrays.toString(nos));*/


    }

    @Override
    public void run(String... args) {
        Laptop laptop = new Laptop();
        laptop.setConfiguration("macbook m2 with 16 Gb ram and 256 SSD");
        laptop.setModel("Macbook M2");
        laptop.setPrice(13200d);
        laptop.setName("Apple Macbook M2");
//        laptopRepository.save(laptop);

        System.out.println("user details from Yaml file: " + userYmlConfigurationRead.getLaptop() +": email: "+ userYmlConfigurationRead.getEmail());
    // to see the dispatcher-servlet is called or not
        String[] beans = context.getBeanNamesForType(DispatcherServlet.class);
        for (String bean : beans) {
            System.out.println("DispatcherServlet bean: " + bean);
        }

        // add ImmutableEntity
       /* ImmutableEntity immutableEntity = new ImmutableEntity("Laptop");
        ImmutableEntity immutableEntity1 = new ImmutableEntity("Mobile");
      List<ImmutableEntity> immutableEntityList = new ArrayList<>();
       immutableEntityList.add(immutableEntity);
        immutableEntityList.add(immutableEntity1);*/
//        immutableEntityRepository.saveAll(immutableEntityList);
       // update ImmutableEntity
        //ImmutableEntity immutable = immutableEntityRepository.findById(2l).get();
        ImmutableEntity immutableEntityUpdate = new ImmutableEntity(2L,"Laptop-Updated");
        immutableEntityRepository.save(immutableEntityUpdate);

    }

    @PostMapping("/mi")
    public ProfileMi save(@RequestBody ProfileMi profileMi){

        return profileMiRepository.save(profileMi);
    }

    @PostMapping("/gics")
    public ProfileGics saveGics(@RequestBody ProfileGics profileGics){
        return profileGicsRepository.save(profileGics);
    }

    @PostMapping("/person")
    public Person savePerson(@RequestBody Person person){
        return personRepository.save(person);
    }



}
