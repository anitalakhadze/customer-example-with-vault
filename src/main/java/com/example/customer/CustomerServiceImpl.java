package com.example.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Long create(Customer customer) {
        return customerRepository
                .save(customer)
                .getId();
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found by id: " + id));
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository
                .findAll();
    }
}
