package edu.mum.cs.cs425.bankapp.Service;

import edu.mum.cs.cs425.bankapp.Entities.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    Iterable<Account> getAllAccounts();
    Account saveAccount(Account account);
    Float findSumOfAccounts(int accountTypeId);

}
