package com.techzone.digishop.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.sun.istack.NotNull;

@Entity
public class Employee extends User{

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String address;
	@NotNull
	private String number;
	@NotNull
	private String additional;
	@NotNull
	private String neightbohood;
	@NotNull
	private String zipcode;
	@NotNull
	private String city;
	@NotNull
	private String uf;
	@NotNull
	private Date admissionDate;
	
	private Boolean isActive = true;
	
    @CreatedDate
    private Date creationDate;

    @LastModifiedDate
    private Date modifiedDate;
    
	@ElementCollection
	@CollectionTable(name = "EMPLOYEE_PHONE")
	Set<String> phones = new HashSet<>();
	

	public Employee() {
		super();
	}

	public Employee(Integer id, @NotNull String name,
			@NotNull String cpfCnpj, @NotNull String email,
			@NotNull String password, Date birthDate, Company company,
			String address, String number, String additional, String neightbohood, String zipcode, String city,
			String uf, Date admissionDate, Boolean isActive) {
		super(id, name, cpfCnpj, email, password, birthDate, company);
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

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}
	
	

}
