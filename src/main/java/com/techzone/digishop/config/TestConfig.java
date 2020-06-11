package com.techzone.digishop.config;

import com.techzone.digishop.service.DBService;

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
}