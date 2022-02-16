package com.gllllepulla;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        log.info("application started");
        SpringApplication application = new SpringApplication(Application.class);
        application.setDefaultProperties(Map.of("spring.config.name", "app"));
        application.run(args);
    }
}
