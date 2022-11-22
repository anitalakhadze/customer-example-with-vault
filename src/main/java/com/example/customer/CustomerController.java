package com.example.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping()
    public Long create(@RequestBody Customer customer) {
        log.info("Received request for creating a customer: {}", customer);
        return customerService.create(customer);
    }

    @GetMapping("/{id}")
    public Customer getOne(@PathVariable Long id) {
        log.info("Received request for getting a customer by id: {}", id);
        return customerService.getById(id);
    }

    @GetMapping()
    public List<Customer> getAll() {
        log.info("Received request for getting all customers");
        return customerService.getAll();
    }
}
