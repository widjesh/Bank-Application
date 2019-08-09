package edu.mum.cs.cs425.bankapp.Repository;

import edu.mum.cs.cs425.bankapp.Entities.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,Integer> {
}
