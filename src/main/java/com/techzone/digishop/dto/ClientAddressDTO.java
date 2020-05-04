package com.techzone.digishop.dto;

import java.io.Serializable;

import com.techzone.digishop.domain.ClientAddress;

public class ClientAddressDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;
	private String description;
	private String address;
	private String number;
	private String additional;
	private String neightbohood;
	private String zipcode;
	private String city;
	private String uf;
    private Integer client;

    public ClientAddressDTO(){
        
    }
    
    public ClientAddressDTO(ClientAddress address){
        this.id = address.getId();
        this.description = address.getDescription();
        this.address = address.getAddress();
        this.number = address.getNumber();
        this.additional = address.getAdditional();
        this.neightbohood = address.getNeightbohood();
        this.zipcode = address.getZipcode();
        this.city = address.getCity();
        this.uf = address.getUf();
        this.client = address.getClient().getId();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAdditional() {
        return this.additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public String getNeightbohood() {
        return this.neightbohood;
    }

    public void setNeightbohood(String neightbohood) {
        this.neightbohood = neightbohood;
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

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getClient() {
        return this.client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

}