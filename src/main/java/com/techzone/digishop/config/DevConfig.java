package com.techzone.digishop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.techzone.digishop.service.DBService;

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
    		return false;
    	}
    	dbService.instantiateDatabase();
        return true;
    }

}