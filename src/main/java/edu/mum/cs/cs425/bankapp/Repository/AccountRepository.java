package edu.mum.cs.cs425.bankapp.Repository;

import edu.mum.cs.cs425.bankapp.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findAccountsByAccountType_AccountTypeId(int accountTypeId);
}
