package com.korostenskyi.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.korostenskyi.app.data.repository")
@EnableJpaRepositories("com.korostenskyi.app.data.repository")
public class DataConfig {

    private DriverManagerDataSource driverManagerDataSource;
    private LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;
    private JpaTransactionManager jpaTransactionManager;
    private JpaVendorAdapter vendorAdapter;
    private Properties properties;

    private Properties additionalProperties() {

        properties = new Properties();

        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");

        return properties;
    }

    @Bean
    public DataSource dataSource() {

        driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName("org.h2.Driver");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("korostenskyi");
        driverManagerDataSource.setUrl("jdbc:h2:database/springDataTest");
        return driverManagerDataSource;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        vendorAdapter = new HibernateJpaVendorAdapter();

        localContainerEntityManagerFactoryBean.setDataSource(dataSource());

        localContainerEntityManagerFactoryBean.setPackagesToScan("com.korostenskyi.app");
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        localContainerEntityManagerFactoryBean.setJpaProperties(additionalProperties());

        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory managerFactory) {

        jpaTransactionManager = new JpaTransactionManager();

        jpaTransactionManager.setEntityManagerFactory(managerFactory);

        return jpaTransactionManager;
    }
}
