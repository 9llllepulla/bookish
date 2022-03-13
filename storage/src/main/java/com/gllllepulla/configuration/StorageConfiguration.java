package com.gllllepulla.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@EntityScan(basePackages = "com.gllllepulla")
@ComponentScan(basePackages = "com.gllllepulla.repository")
public class StorageConfiguration {

}
