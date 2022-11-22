package com.example.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class DatabaseConfig {
    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.datasource.url}")
    String url;

    @Bean
    @Primary
    public DataSource dataSource() {
        log.info("Username: {}", username);
        log.info("Password: {}", password);

        return DataSourceBuilder
                .create()
                .url(url)
                .driverClassName("org.postgresql.Driver")
                .username(username)
                .password(password)
                .build();
    }
}
