package com.example.config;



import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScans(value = {@ComponentScan("com.example.model"),@ComponentScan("com.example.dao"),@ComponentScan("com.example.controller"),@ComponentScan("com.example.service")})
public class Appconfig {
	@Autowired
	Environment env;
	
	@Bean
	public LocalSessionFactoryBean getsessionfactory() {
		LocalSessionFactoryBean sessionfactory=new LocalSessionFactoryBean();
		 Properties props = new Properties();
	      // Setting JDBC properties
	      props.put(DRIVER, env.getProperty("mysql.driver"));
	      props.put(URL, env.getProperty("mysql.url"));
	      props.put(USER, env.getProperty("mysql.user"));
	      props.put(PASS, env.getProperty("mysql.password"));

	      // Setting Hibernate properties
	      props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
	      props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));

	      // Setting C3P0 properties
	      props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
	      props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
	      props.put(C3P0_ACQUIRE_INCREMENT,env.getProperty("hibernate.c3p0.acquire_increment"));
	      props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
	      props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
		sessionfactory.setHibernateProperties(props);
		sessionfactory.setPackagesToScan("com.example.model");
		return sessionfactory;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionmanager=new HibernateTransactionManager();
		transactionmanager.setSessionFactory(getsessionfactory().getObject());
		return transactionmanager;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
}
