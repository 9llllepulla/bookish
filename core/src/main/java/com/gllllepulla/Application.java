package com.gllllepulla;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Map;

@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        log.info("application started");
        SpringApplication application = new SpringApplication(Application.class);
        application.setDefaultProperties(Map.of("spring.config.name", "server"));
        application.run(args);
    }
}
