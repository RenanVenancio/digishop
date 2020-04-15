package com.techzone.digishop.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.techzone.digishop.domain.Company;

public class CompanyDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Campo não pode ser vazio")
	@Length(min = 2, max = 80, message = "O tamanho deve conter entre 2 e 80 caracteres")
	private String name;
	@NotEmpty(message = "Campo não pode ser vazio")
	@Length(min = 11, max = 14, message = "O tamanho deve conter entre 11 e 14 caracteres")
	private String cpfCnpj;
	@NotEmpty(message = "Campo não pode ser vazio")
	private String adress;
	@NotEmpty(message = "Campo não pode ser vazio")
	private String neighborhood;
	@NotEmpty(message = "Campo não pode ser vazio")
	private String zipcode;
	@NotEmpty(message = "Campo não pode ser vazio")
	private String city;
	@NotEmpty(message = "Campo não pode ser vazio")
	@Length(min = 2, max = 2, message = "O tamanho deve conter 2 caracteres")
	private String state;
	@NotEmpty(message = "Campo não pode ser vazio")
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
