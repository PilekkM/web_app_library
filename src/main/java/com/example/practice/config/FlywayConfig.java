package com.example.practice.config;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;

@Configuration
@ComponentScan({"com.example.practice.config"})
@PropertySource(value="classpath:application.properties")
public class FlywayConfig {

    @Autowired
    Environment env;

    @Autowired
    DataSourceManager dataSourceManager;

    @Bean(initMethod = "migrate")
    public Flyway flyway(){
        ClassicConfiguration config = new ClassicConfiguration();
        config.setBaselineOnMigrate(true);
        config.setDataSource(dataSourceManager.getDataSource());
        config.setLocationsAsStrings(env.getRequiredProperty("spring.flyway.locations"));
        Flyway flyway = new Flyway(config);
        return flyway;
    }

    @Bean
    @DependsOn("flyway")
    EntityManagerFactory entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSourceManager.getDataSource());
        return bean.getObject();
    }
}
