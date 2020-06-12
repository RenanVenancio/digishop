package com.techzone.digishop.dto;

import java.io.Serializable;

import com.techzone.digishop.domain.Provider;

public class ProviderNewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String cpfCnpj;
    private String adress;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private String phone;
    private String email;

    public ProviderNewDTO() {

    }

    public ProviderNewDTO(Integer id, String name, String cpfCnpj, String adress, String neighborhood, String zipcode,
            String city, String state, String phone, String email) {
        this.id = id;
        this.name = name;
        this.cpfCnpj = cpfCnpj;
        this.adress = adress;
        this.neighborhood = neighborhood;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNeighborhood() {
        return this.neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}