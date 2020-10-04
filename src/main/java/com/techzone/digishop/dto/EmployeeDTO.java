package com.techzone.digishop.dto;

import java.io.Serializable;
import java.util.Date;

public class EmployeeDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String fantasyName;
    private String cpfCnpj;
    private String email;
    private String password;
    private String birthDate;
    private Integer company;
    private String address;
    private String number;
    private String additional;
    private String neightbohood;
    private String zipcode;
    private String city;
    private String uf;
    private Date admissionDate;
    private Boolean isActive;

    public EmployeeDTO(){
        
    }

    public EmployeeDTO(Integer id, String name, String fantasyName, String cpfCnpj, String email, String password, String birthDate, Integer company, String address, String number, String additional, String neightbohood, String zipcode, String city, String uf, Date admissionDate, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.fantasyName = fantasyName;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.company = company;
        this.address = address;
        this.number = number;
        this.additional = additional;
        this.neightbohood = neightbohood;
        this.zipcode = zipcode;
        this.city = city;
        this.uf = uf;
        this.admissionDate = admissionDate;
        this.isActive = isActive;
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

    public String getFantasyName() {
        return this.fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
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

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getCompany() {
        return this.company;
    }

    public void setCompany(Integer company) {
        this.company = company;
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

    public Date getAdmissionDate() {
        return this.admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Boolean isIsActive() {
        return this.isActive;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }


}