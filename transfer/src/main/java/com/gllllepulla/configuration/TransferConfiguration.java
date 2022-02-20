package com.gllllepulla.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.gllllepulla.transfer", "com.gllllepulla.mapper"})
@Configuration
public class TransferConfiguration {
}
