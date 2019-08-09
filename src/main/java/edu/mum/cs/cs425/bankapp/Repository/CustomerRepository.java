package edu.mum.cs.cs425.bankapp.Repository;

import edu.mum.cs.cs425.bankapp.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
