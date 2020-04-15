package com.techzone.digishop.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import com.techzone.digishop.domain.Company;

public class CompanyDTO implements Serializable {

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
	private String slogan;
	
	public CompanyDTO() {
		
	}
	
	
	public CompanyDTO(Company company) {
		this.id = company.getId();
		this.name = company.getName();
		this.cpfCnpj = company.getCpfCnpj();
		this.adress = company.getAdress();
		this.neighborhood = company.getNeighborhood();
		this.zipcode = company.getZipcode();
		this.city = company.getCity();
		this.state = company.getState();
		this.phone = company.getPhone();
		this.email = company.getEmail();
		this.slogan = company.getSlogan();
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


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSlogan() {
		return slogan;
	}


	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
}
