package edu.mum.cs.cs425.bankapp.Service;

import edu.mum.cs.cs425.bankapp.Entities.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Iterable<Customer> getAllCustomers();
    Customer saveCustomer(Customer customer);
    Customer getCustomerById(Long customerId);
    void deleteCustomerById(Long customerId);
}
