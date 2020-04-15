package com.techzone.digishop.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.techzone.digishop.domain.ProductCategory;

public class ProductCategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "O nome não pode ser vazio")
	@Length(min = 2, max = 80, message = "O tamanho deve conter entre 2 e 80 caracteres")
	private String name;

	public ProductCategoryDTO() {

	}

	public ProductCategoryDTO(ProductCategory category) {
		this.id = category.getId();
		this.name = category.getName();
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

}
