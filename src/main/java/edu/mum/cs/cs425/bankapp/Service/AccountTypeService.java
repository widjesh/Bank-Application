package edu.mum.cs.cs425.bankapp.Service;

import edu.mum.cs.cs425.bankapp.Entities.AccountType;
import org.springframework.stereotype.Service;

@Service
public interface AccountTypeService {
    Iterable<AccountType> findAll();
}