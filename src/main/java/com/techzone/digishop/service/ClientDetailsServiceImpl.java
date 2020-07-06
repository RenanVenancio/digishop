package com.techzone.digishop.service;

import com.techzone.digishop.domain.Client;
import com.techzone.digishop.domain.User;
import com.techzone.digishop.repository.ClientRepository;
import com.techzone.digishop.repository.EmployeeRepository;
import com.techzone.digishop.security.UserSS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client cli = repository.findByEmail(email);
        if(cli == null) {
            throw new UsernameNotFoundException(email);
        }

        return new UserSS(cli.getId(), cli.getEmail(), cli.getPassword());
    }
    
}