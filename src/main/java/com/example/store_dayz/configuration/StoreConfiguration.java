package com.example.store_dayz.configuration;

import com.example.store_dayz.entity.ItemsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.example.store_dayz")
public class StoreConfiguration {

  @Bean
  public Session session(){
    org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().addAnnotatedClass(ItemsEntity.class);
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    return sessionFactory.getCurrentSession();
  }

}
