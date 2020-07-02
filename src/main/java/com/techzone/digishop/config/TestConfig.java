package com.techzone.digishop.config;

import com.techzone.digishop.service.DBService;
import com.techzone.digishop.service.EmailService;
import com.techzone.digishop.service.MockEmailService;
import com.techzone.digishop.service.SmtpEmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    
	@Autowired
	private DBService dbService;
	
    @Bean
    public boolean initDatabase(){
        System.out.println("Perfil de desenvolvimento ativado");
    	dbService.instantiateDatabase();
        return true;
    }

    // @Bean
    // public EmailService emailService(){
    //     return new MockEmailService();
    // }

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }
}