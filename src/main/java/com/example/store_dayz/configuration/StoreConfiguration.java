package com.example.store_dayz.configuration;


import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan("com.example.store_dayz")
@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
public class StoreConfiguration {

  private final Environment env;

  @Autowired
  public StoreConfiguration(Environment env) {
    this.env = env;
  }

  private Properties hibernateProperties(){
    Properties properties = new Properties();
    properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
    properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
    properties.put("hibernate.default_schema", env.getRequiredProperty("hibernate.default_schema"));
    return properties;
  }

  @Bean
  public DataSource dataSource(){
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getRequiredProperty("hibernate.driver_class"));
    dataSource.setUrl(env.getRequiredProperty("hibernate.connection.url"));
    dataSource.setUsername(env.getRequiredProperty("hibernate.connection.username"));
    dataSource.setPassword(env.getRequiredProperty("hibernate.connection.password"));
    return dataSource;
  }

  @Bean(name="entityManagerFactory")
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan("com.example.store_dayz.entity");
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
  }

  @Bean
  public PlatformTransactionManager hibernateTransactionalManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
  }



}
