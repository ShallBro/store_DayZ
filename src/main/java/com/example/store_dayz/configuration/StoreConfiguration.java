package com.example.store_dayz.configuration;


import jakarta.persistence.EntityManagerFactory;
import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan("com.example.store_dayz")
@EnableTransactionManagement
public class StoreConfiguration {

  private final Environment env;
  @Autowired
  public StoreConfiguration(Environment env) {
    this.env = env;
  }

  private Properties hibernateProperties(){
    Properties properties = new Properties();
    properties.put("hibernate.show_sql", env.getRequiredProperty("spring.jpa.show-sql"));
    properties.put("hibernate.dialect", env.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
    return properties;
  }
  @Bean
  public DataSource dataSource(){
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
    dataSource.setUrl(env.getRequiredProperty("spring.datasource.url"));
    dataSource.setUsername(env.getRequiredProperty("spring.datasource.username"));
    dataSource.setPassword(env.getRequiredProperty("spring.datasource.password"));
    dataSource.setSchema(env.getRequiredProperty("spring.jpa.properties.hibernate.default_schema"));
    dataSource.setConnectionProperties(hibernateProperties());
    return dataSource;
  }
  @Bean(name = "entityManagerFactory")
  public LocalContainerEntityManagerFactoryBean sessionFactory() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource());
    em.setPackagesToScan("com.example.store_dayz");
    em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    return em;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);
    return transactionManager;
  }



}
