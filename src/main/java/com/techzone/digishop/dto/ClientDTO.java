package com.techzone.digishop.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.techzone.digishop.domain.Client;
import com.techzone.digishop.service.validation.ClientUpdate;

@ClientUpdate
public class ClientDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Campo obrigatório")
	@Length(min = 5, max = 80, message = "Deve conter entre 5 e 80 caracteres")
	private String name;
	private String fantasyName;
	@NotEmpty(message = "Campo obrigatório")
	@Email(message = "O email informado não é válido")
	private String email;

	public ClientDTO() {

	}

	public ClientDTO(Client client) {
		this.id = client.getId();
		this.name = client.getName();
		this.fantasyName = client.getFantasyName();
		this.email = client.getEmail();
	}

	public ClientDTO(Integer id, String name, String fantasyName, String email) {
		this.id = id;
		this.name = name;
		this.fantasyName = fantasyName;
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

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
