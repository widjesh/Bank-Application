package edu.mum.cs.cs425.bankapp.Service.Implementation;

import edu.mum.cs.cs425.bankapp.Entities.Account;
import edu.mum.cs.cs425.bankapp.Repository.AccountRepository;
import edu.mum.cs.cs425.bankapp.Repository.CustomerRepository;
import edu.mum.cs.cs425.bankapp.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImplementation implements AccountService {

    @Autowired
    AccountRepository accountRepository;


    @Override
    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll(Sort.by("accountNumber"));
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Float findSumOfAccounts(int accountTypeId) {
        Float sumOfChecking = 0F;
        List<Account> accountsFind = accountRepository.findAccountsByAccountType_AccountTypeId(accountTypeId);
        for(Account acc : accountsFind){
            sumOfChecking += acc.getBalance();
        }
        return sumOfChecking;
    }


}
