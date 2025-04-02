package com.validation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.validation.customvalidation.ValidateUserType;
import com.validation.repository.UserRepository;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@DynamicInsert
@DynamicUpdate
@NamedQuery(name = "User.userDetailByName", query = "select a from User a where a.name = ?1")
//@JsonIgnoreType
@JsonIgnoreProperties(value = "address")
@ToString(exclude = { "address" })
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should not be empty")
    private String name;
    @NotNull(message = "adds should not be empty")
    private String adds;
    @Min(value = 18)
    @Max(value = 60)
    private int age;

    @Email(message = "please add email in correct format")
    private String email;
    @NotBlank(message = "User Type should not blank")
    @ValidateUserType
    private String type;

    @OneToMany( mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true )
    private List<Address> address;




    /*@Transactional
    List<User> userDetailByName(String name){
        return  userRepository.userDetailByName(name);
    }*/
}
