package com.techzone.digishop.dto;

import java.io.Serializable;

import com.techzone.digishop.domain.Provider;

public class ProviderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String cpfCnpj;
    private String adress;
    private String neighborhood;
    private String zipcode;
    private String city;

    public ProviderDTO(){

    }

    public ProviderDTO(Provider provider){
        this.id = provider.getId();
        this.name = provider.getName();
        this.cpfCnpj = provider.getCpfCnpj();
        this.adress = provider.getAdress();
        this.neighborhood = provider.getNeighborhood();
        this.zipcode = provider.getZipcode();
        this.city = provider.getCity();
    }

    public ProviderDTO(Integer id, String name, String cpfCnpj, String adress, String neighborhood, String zipcode,
            String city) {
        this.id = id;
        this.name = name;
        this.cpfCnpj = cpfCnpj;
        this.adress = adress;
        this.neighborhood = neighborhood;
        this.zipcode = zipcode;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}