package edu.mum.cs.cs425.bankapp.Service.Implementation;

import edu.mum.cs.cs425.bankapp.Entities.AccountType;
import edu.mum.cs.cs425.bankapp.Repository.AccountTypeRepository;
import edu.mum.cs.cs425.bankapp.Service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeImplementation implements AccountTypeService {
    @Autowired
    AccountTypeRepository accountTypeRepository;

    @Override
    public Iterable<AccountType> findAll() {
        return accountTypeRepository.findAll();
    }
}
