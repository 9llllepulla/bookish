package com.gllllepulla.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.gllllepulla.configuration", "com.gllllepulla.service", "com.gllllepulla.service.impl"})
@Configuration
public class CoreConfiguration {

}
