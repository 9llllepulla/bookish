package com.gllllepulla.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.gllllepulla.entities"})
@EnableJpaRepositories(basePackages = {"com.gllllepulla.repository"})
@Configuration
public class StorageConfiguration {
}
