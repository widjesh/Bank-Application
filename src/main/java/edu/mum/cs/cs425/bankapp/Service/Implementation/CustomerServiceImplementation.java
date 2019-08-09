package edu.mum.cs.cs425.bankapp.Service.Implementation;

import edu.mum.cs.cs425.bankapp.Entities.Customer;
import edu.mum.cs.cs425.bankapp.Repository.CustomerRepository;
import edu.mum.cs.cs425.bankapp.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll(Sort.by("firstName").descending());
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
         customerRepository.deleteById(customerId);
    }
}
