package com.example.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RequiredArgsConstructor
@EnableScheduling
@SpringBootApplication
public class CustomerApplication {
    private final CustomerRepository customerRepository;

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Scheduled(fixedDelay = 30000)
    public void checkVaultCredentials() {
        String username = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Tbilisi"));
        System.out.println(now + " ---> username: " + username + ", password: " + password);

        List<Customer> all = customerRepository.findAll();
        all.forEach(System.out::println);

        System.out.println("\n");
    }
}
