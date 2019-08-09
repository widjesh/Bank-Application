package edu.mum.cs.cs425.bankapp.Entities;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
  //  @NotBlank(message = "* Customer Number is required")
    @Column(nullable = false, name = "customerNumber")
    private Long customerNumber;
    @NotBlank(message = "* Firstname is required")
    @Column(nullable = false, name = "firstName")
    private String firstName;
    @Column(name = "middleName")
    private String middleName;
    @NotBlank(message = "* Lastname is required")
    @Column(nullable = false, name = "lastName")
    private String lastName;
    @NotBlank(message = "* Email address is required")
    @Column(nullable = false , name = "emailAddress")
    private String emailAddress;
    @NotBlank(message = "* Phone No. is required")
    @Column(nullable = false, name = "contactPhoneNumber")
    private String contactPhoneNumber;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false, name = "dateOfBirth")
    @Past
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<Account> accounts;

    public Customer(Long customerNumber, String firstName, String middleName,  String lastName, String emailAddress, String contactPhoneNumber, LocalDate dateOfBirth, List<Account> accounts) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.contactPhoneNumber = contactPhoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.accounts = accounts;
    }

    public Customer() {
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}