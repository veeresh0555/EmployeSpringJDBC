package com.example.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
/* @ComponentScans() */
public class Appconfig {
	@Autowired
	Environment env;
	
	@Bean
	public LocalSessionFactoryBean getsessionfactory() {
		LocalSessionFactoryBean sessionfactory=new LocalSessionFactoryBean();
		Properties prop=new Properties();
		prop.put("Driver", env.getProperty("mysql.driver"));
		prop.put("Url", env.getProperty("mysql.url"));//mysql.url
		prop.put("user", env.getProperty("mysql.user"));
		prop.put("password", env.getProperty("mysql.password"));
		return sessionfactory;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		
		HibernateTransactionManager transactionmanager=new HibernateTransactionManager();
		transactionmanager.setSessionFactory(getsessionfactory().getObject());
		
		return transactionmanager;
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
}
