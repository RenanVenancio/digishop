package com.techzone.digishop.dto;

import java.io.Serializable;
import java.util.Date;

import com.techzone.digishop.domain.ClientType;

public class ClientNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String cpfCnpj;
	private String email;
	private String password;
	private Date birthDate;
	private Integer company;
	private String phone;
	private String description;
	private String address;
	private String number;
	private String additional;
	private String neightbohood;
	private String zipcode;
	private String city;
	private String uf;
	private Integer type;

	public ClientNewDTO() {

	}

	public ClientNewDTO(String name, String cpfCnpj, String email, String password, Date birthDate, Integer company,
			String phone, String description, String address, String number, String additional, String neightbohood,
			String zipcode, String city, String uf, ClientType type) {
		super();
		this.name = name;
		this.cpfCnpj = cpfCnpj;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.company = company;
		this.phone = phone;
		this.description = description;
		this.address = address;
		this.number = number;
		this.additional = additional;
		this.neightbohood = neightbohood;
		this.zipcode = zipcode;
		this.city = city;
		this.uf = uf;
		this.type = type.getCod();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getCompany() {
		return company;
	}

	public void setCompany(Integer company) {
		this.company = company;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public String getNeightbohood() {
		return neightbohood;
	}

	public void setNeightbohood(String neightbohood) {
		this.neightbohood = neightbohood;
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public ClientType getType() {
		return ClientType.toEnum(type);
	}

	public void setType(ClientType type) {
		this.type = type.getCod();
	}
	
	

}
