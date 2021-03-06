package com.techzone.digishop.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techzone.digishop.domain.enums.ClientType;

@Entity
public class Client extends User {

	private static final long serialVersionUID = 1L;

	private Integer clientType;

	@ElementCollection
	@CollectionTable(name = "CLIENT_PHONE")
	Set<String> phones = new HashSet<>();

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	List<ClientAddress> adresses = new ArrayList<>();

	@OneToMany(mappedBy = "client")
	@JsonIgnore
	List<Sale> sales = new ArrayList<>();

	@OneToMany(mappedBy = "client")
	@JsonIgnore
	List<ClientCredit> credits = new ArrayList<>();

	public Double creditLimit;

	public Client() {
		this.creditLimit = 0.00;
	}

	public Client(Integer id, String name, String cpfCnpj, String email, String password, Date birthDate,
			ClientType clientType, Company company) {
		super(id, name, cpfCnpj, email, password, birthDate, company);
		this.clientType = (clientType == null ? null : clientType.getCod());
	}

	public Client(Integer id, String name, String cpfCnpj, String email, String password, Date birthDate,
			ClientType clientType, Company company, String fantasyName) {
		super(id, name, cpfCnpj, email, password, birthDate, company, fantasyName);
		this.clientType = (clientType == null ? null : clientType.getCod());
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public ClientType getClientType() {
		return ClientType.toEnum(this.clientType);
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType.getCod();
	}

	public List<ClientAddress> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<ClientAddress> adresses) {
		this.adresses = adresses;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public Double getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public List<ClientCredit> getCredits() {
		return this.credits;
	}

	public void setCredits(List<ClientCredit> credits) {
		this.credits = credits;
	}

}
