package edu.mum.cs.cs425.bankapp.Entities;

import javax.persistence.*;

@Entity
@Table(name = "account_types")
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountTypeId;
    @Column(name="account_type_name", nullable = false)
    private String accountTypeName;

    public AccountType() {
    }

    public AccountType(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public int getAccountTypeId() {
        return accountTypeId;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }
}
