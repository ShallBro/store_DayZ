package com.example.store_dayz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class StoreDayZApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreDayZApplication.class, args);
	}

}
