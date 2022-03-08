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

    /*@Bean
    public DataSource dataSource() {
        log.info("create data source");
        HikariDataSource dataSource = DataSourceBuilder.create(dataSourceProperties.getClass().getClassLoader())
                .driverClassName(dataSourceProperties.getDriverClassName())
                .url(dataSourceProperties.getUrl())
                .username(dataSourceProperties.getUserName())
                .password(dataSourceProperties.getPassword())
                .type(HikariDataSource.class)
                .build();
        dataSource.setMaximumPoolSize(dataSourceProperties.getMaxPoolSize());
        return dataSource;
    }*/
/*
    @Bean
    public PlatformTransactionManager transactionManager() {
        log.info("create transaction manager");
        return new JpaTransactionManager(entityManagerFactory());
    }

    @Bean("entityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        log.info("create entity manager factory");
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("com.gllllepulla.entities");
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public Properties hibernateProperties() {
        log.info("create hibernate properties");
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "hibernate.dialect");
        properties.put("spring.jpa.properties.hibernate.format_sql", true);
        properties.put("hibernate.use_sql_comments", true);
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.max_fetch_depth", 3);
        properties.put("hibernate.jdbc.batch_size", 10);
        properties.put("hibernate.jdbc.fetch_size", 50);
        return properties;
    }*/


}
