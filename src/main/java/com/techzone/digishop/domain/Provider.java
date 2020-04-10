package com.techzone.digishop.domain;

import javax.persistence.Entity;

@Entity
public class Provider extends CompanyAbstract {

	private static final long serialVersionUID = 1L;

	public Provider() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Provider(String name, String cpfCnpj, String adress, String neighborhood, String zipcode, String city,
			String state, String phone, String email) {
		super(name, cpfCnpj, adress, neighborhood, zipcode, city, state, phone, email);
		// TODO Auto-generated constructor stub
	}
	
	

}
