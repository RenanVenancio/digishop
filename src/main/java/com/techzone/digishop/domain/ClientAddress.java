package com.techzone.digishop.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ClientAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private String address;
	private String number;
	private String additional;
	private String neightbohood;
	private String zipcode;
	private String city;
	private String uf;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public ClientAddress(Integer id, String description, String address, String number, String additional,
			String neightbohood, String zipcode, String city, String uf, Client client) {
		super();
		this.id = id;
		this.description = description;
		this.address = address;
		this.number = number;
		this.additional = additional;
		this.neightbohood = neightbohood;
		this.zipcode = zipcode;
		this.city = city;
		this.uf = uf;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
		ClientAddress other = (ClientAddress) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClientAddress [id=" + id + ", description=" + description + ", address=" + address + ", number="
				+ number + ", additional=" + additional + ", neightbohood=" + neightbohood + ", zipcode=" + zipcode
				+ ", uf=" + uf + ", client=" + client + "]";
	}

}
