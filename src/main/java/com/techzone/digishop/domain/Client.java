package com.techzone.digishop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	String cpfCnpj;
	String email;
	Integer clientType;

	@ElementCollection
	@CollectionTable(name = "CLIENT_PHONE")
	Set<String> phones = new HashSet<>();
	
	@OneToMany(mappedBy = "client")
	List<ClientAddress> adresses = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "company_id")
	Company company;

	public Client(Object object, String string, String string2, String string3, String string4, ClientType pessoaFisica, Company c) {

	}

	public Client(Integer id, String name, String cpfCnpj, String email, ClientType clientType,
			Company company) {
		super();
		this.id = id;
		this.name = name;
		this.cpfCnpj = cpfCnpj;
		this.email = email;
		this.clientType = clientType.getCod();
		this.company = company;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", cpfCnpj=" + cpfCnpj + ", email=" + email
				+ ", phones=" + phones + ", company=" + company + "]";
	}

}
