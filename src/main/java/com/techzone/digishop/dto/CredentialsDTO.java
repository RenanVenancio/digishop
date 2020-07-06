package com.techzone.digishop.dto;

import java.io.Serializable;

public class CredentialsDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String email;
    private String password;


    public CredentialsDTO(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}