package com.learn2code.mycar.search.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.learn2code.mycar.search.app")
//@PropertySource("classpath:application.properties")
public class MyCarAppConfig {
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driverClass}")
    private String driverClass;

    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource(dbUrl,username,password);
        ds.setDriverClassName(driverClass);
        return ds;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate dbTemplate = new JdbcTemplate();
        dbTemplate.setDataSource(dataSource());
        return dbTemplate;
    }

    @Bean
    public RestTemplate template(){
        return new RestTemplate();
    }
}
