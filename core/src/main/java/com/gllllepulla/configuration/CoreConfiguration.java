package com.gllllepulla.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@ComponentScan(basePackages = "com.gllllepulla.service.impl")
@Configuration
public class CoreConfiguration {

}
