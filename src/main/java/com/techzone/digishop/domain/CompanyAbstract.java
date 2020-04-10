package com.techzone.digishop.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class CompanyAbstract implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	private String name;
	@Column(unique = true)
	private String cpfCnpj;
	@NotNull
	private String adress;
	@NotNull
	private String neighborhood;
	@NotNull
	private String zipcode;
	@NotNull
	private String city;
	@NotNull
	private String state;
	@NotNull
	private String phone;
	private String email;
	
    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;


	public CompanyAbstract() {

	}

	public CompanyAbstract(String name, String cpfCnpj, String adress, String neighborhood, String zipcode, String city,
			String state, String phone, String email) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyAbstract other = (CompanyAbstract) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", cpfCnpj=" + cpfCnpj + ", adress=" + adress
				+ ", neighborhood=" + neighborhood + ", zipcode=" + zipcode + ", city=" + city + ", state=" + state
				+ ", phone=" + phone + ", email=" + email + "]";
	}

}
