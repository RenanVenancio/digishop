package com.techzone.digishop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Company extends CompanyAbstract {

	private static final long serialVersionUID = 1L;
	private String slogan;

	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Client> clients = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Sale> sales = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Product> products = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Employee> employees = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Purchase> purchases = new ArrayList<>();

	public Company() {
		super();
	}

	public Company(String name, String cpfCnpj, String adress, String neighborhood, String zipcode, String city,
			String state, String phone, String email, String slogan) {
		super(name, cpfCnpj, adress, neighborhood, zipcode, city, state, phone, email);
		this.slogan = slogan;
	}

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

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
	
	

}
