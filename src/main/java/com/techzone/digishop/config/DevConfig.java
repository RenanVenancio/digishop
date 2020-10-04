package com.techzone.digishop.config;


import com.techzone.digishop.service.DBService;
import com.techzone.digishop.service.EmailService;
import com.techzone.digishop.service.SmtpEmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    
	@Autowired
	DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
    @Bean
    public boolean initDatabase(){
    	if(!"create".equals(strategy)) {
            System.out.println("Não criar o banco novamente");
            return false;
        }
        System.out.println("Criando novo banco");
    	dbService.instantiateDatabase();
        return true;
    }

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }
}