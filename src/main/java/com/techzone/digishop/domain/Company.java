package com.techzone.digishop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Company extends CompanyAbstract {

	private static final long serialVersionUID = 1L;
	private String slogan;

	@OneToMany(mappedBy = "company")
	private List<Client> clients = new ArrayList<>();

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Company() {
		super();
	}

	public Company(String name, String cpfCnpj, String adress, String neighborhood, String zipcode, String city,
			String state, String phone, String email, String slogan) {
		super(name, cpfCnpj, adress, neighborhood, zipcode, city, state, phone, email);
		this.slogan = slogan;
	}

}
