package com.gllllepulla.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan(basePackages = {"com.gllllepulla.entities"})
@EnableJpaRepositories(basePackages = {"com.gllllepulla.repository"})
@EnableTransactionManagement
public class StorageConfiguration {
}
