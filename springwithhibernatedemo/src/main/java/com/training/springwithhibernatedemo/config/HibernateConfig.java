package com.training.springwithhibernatedemo.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {

	@Bean
	SessionFactory initSf() {
		 StandardServiceRegistry sr = new StandardServiceRegistryBuilder()
				 .configure("hibernate.cfg.xml").build();
		 Metadata meta = new MetadataSources(sr).getMetadataBuilder().build();
		 SessionFactory sf = meta.getSessionFactoryBuilder().build();
		return sf;
	}
	
}
