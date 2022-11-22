package com.example.customer;

import java.util.List;

public interface CustomerService {

    Long create(Customer customer);

    Customer getById(Long id);

    List<Customer> getAll();

}
