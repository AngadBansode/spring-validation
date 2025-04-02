package com.validation.model;

import com.validation.repository.AccountRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.NaturalId;
import org.hibernate.type.SqlTypes;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
//@ToString(exclude = { "accountRepository" })
@NamedQuery(name = "Account.accountDetailByHolderName", query = "select a from Account a where a.holderName = ?1")
public class Account implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
//    @JdbcTypeCode(SqlTypes.JSON)
    private UUID id;
    @NaturalId
    private String holderName;

    private double balance;

    private String accountNumber;

    private String ifsc;

   /* @Autowired
    AccountRepository accountRepository;*/

   /* @Transactional
    List<Account> accountDetailByHolderName(String name){
    return  accountRepository.accountDetailByHolderName(name);
    }*/

}
