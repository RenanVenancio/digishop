package com.techzone.digishop.config;

import java.util.Arrays;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private Environment env;

    @Autowired
    private UserDetailsService userDetailsService;

    private static final String[] PUBLIC_MATCHES = {
        "/h2-console/**",
    };

    private static final String[] PUBLIC_MATCHES_GET = {
        "/products/**",
        "/categories/**",
    };
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println(env);
        if(Arrays.asList(env.getActiveProfiles()).contains("test")){
            System.out.println("CONTEM TESTE");
            http.headers().frameOptions().disable();
        }

        http.authorizeRequests()
        .antMatchers(HttpMethod.GET, PUBLIC_MATCHES_GET).permitAll()
        .antMatchers(PUBLIC_MATCHES).permitAll()
        .anyRequest().authenticated();

        http.csrf().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }  

}