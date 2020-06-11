package com.techzone.digishop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.techzone.digishop.service.DBService;

@Configuration
@Profile("test")
public class TestConfig {
    
	@Autowired
	DBService dbService;
	
    @Bean
    public boolean initDatabase(){
    	dbService.instantiateDatabase();
        return true;
    }

}