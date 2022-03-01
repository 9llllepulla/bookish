package com.gllllepulla.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@Validated
@Component
@ConfigurationProperties(prefix = "bookish.datasource")
public class AppConfigProperties {

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;

    @NotEmpty
    private String database;

    @NotEmpty
    private String serverName;

    @NotEmpty
    private Integer port;

    @NotEmpty
    private String driverClassName;
}
