package com.gllllepulla.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@EntityScan(basePackages = "com.gllllepulla")
public class StorageConfiguration {

}
