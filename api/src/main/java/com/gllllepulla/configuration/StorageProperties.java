package com.gllllepulla.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Setter
@Getter
@Validated
@Component
@ConfigurationProperties(prefix = StorageProperties.PREFIX)
public class StorageProperties {

    static final String PREFIX = "bookish.datasource";

    private StorageType type = StorageType.POSTGRESQL;

    private String schema;

    private String userName;

    private String password;

    private String database;

    private String serverName;

    private Integer port;

    private String driverClassName;

    private String url;

    /**
     * Минимальный размер пула подключений к БД
     */
    private Integer minPoolSize;
    /**
     * Максимальный размер пула подключений к БД
     */
    private Integer maxPoolSize;
    /**
     * Размер пула при старте приложения
     */
    private Integer initPoolSize;

    @NestedConfigurationProperty
    private TaskExecutionProperties reportsPool = new TaskExecutionProperties();

    private enum StorageType {
        POSTGRESQL("org.postgresql.Driver", 5432);

        @Getter
        private final String driverClassName;
        @Getter
        private final int port;

        StorageType(String driverClassName, int port) {
            this.driverClassName = driverClassName;
            this.port = port;
        }
    }

}
