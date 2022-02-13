package com.gllllepulla;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Map;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "com.gllllepulla.entities")
public class Application {

    public static void main(String[] args) {
        log.info("application started");
        SpringApplication application = new SpringApplication(Application.class);
        application.setDefaultProperties(Map.of("spring.config.name", "app"));
        application.run(args);
    }
}