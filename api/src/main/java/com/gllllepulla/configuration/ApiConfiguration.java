package com.gllllepulla.configuration;

import lombok.extern.slf4j.Slf4j;
import org.postgresql.Driver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@Slf4j
@ComponentScan(basePackages = {"com.gllllepulla.controller"})
@Configuration
@ConditionalOnClass(Driver.class)
@ConditionalOnProperty (prefix = StorageProperties.PREFIX, name = "type", havingValue = "postgresql")
public class ApiConfiguration {

    private final StorageProperties dataSourceProperties;

    public ApiConfiguration(@Qualifier ("dataSource") DataSource dataSource, StorageProperties properties) {
        this.dataSourceProperties = properties;
        try {
            checkDataSource(dataSource);
        } catch (SQLException e) {
            log.error("Not connected to data source with properties {}", properties, e);
        }
    }

    @Bean
    JdbcTemplate jdbcTemplate(@Qualifier ("dataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Qualifier("reportsTaskExecutor")
    public TaskExecutor reportsTaskExecutor() {
        log.info("create task executor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        final TaskExecutionProperties reportsPool = dataSourceProperties.getReportsPool();
        executor.setCorePoolSize(reportsPool.getPool().getCoreSize());
        executor.setMaxPoolSize(reportsPool.getPool().getMaxSize());
        executor.setQueueCapacity(reportsPool.getPool().getQueueCapacity());
        executor.setThreadNamePrefix(reportsPool.getThreadNamePrefix());
        executor.initialize();
        return executor;
    }

    private void checkDataSource(DataSource dataSource) throws SQLException {
        log.info("check data source");
        Connection connection = dataSource.getConnection();
        DatabaseMetaData metaData = connection.getMetaData();
        String databaseProductName = metaData.getDatabaseProductName();
        String databaseProductVersion = metaData.getDatabaseProductVersion();
        String driverName = metaData.getDriverName();
        String driverVersion = metaData.getDriverVersion();
        log.info("""

                    Connected to
                    \tDB name\t\t\t: {}
                    \tDB version\t\t: {}
                    \tJDBC driver\t\t: {}, {}""", databaseProductName, databaseProductVersion, driverName, driverVersion);
    }

}
