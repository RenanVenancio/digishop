package com.techzone.digishop.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String barcode;
	private String reference;
	private String description;
	private Double purchasePrice;
	private Double salePrice;
	private String un = "UN";
	private Double weight = 0.00;
	private Boolean sell = true;
	private Double stock;
	private String location;
	private Integer category;
	private Integer company;

	public ProductDTO(String name, String barcode, String reference, String description, Double purchasePrice,
			Double salePrice, String un, Double weight, Boolean sell, Double stock, String location,
			Integer category, Integer company) {
		this.name = name;
		this.barcode = barcode;
		this.reference = reference;
		this.description = description;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.un = un;
		this.weight = weight;
		this.sell = sell;
		this.stock = stock;
		this.location = location;
		this.category = category;
		this.company = company;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public String getUn() {
		return this.un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Boolean isSell() {
		return this.sell;
	}

	public Boolean getSell() {
		return this.sell;
	}

	public void setSell(Boolean sell) {
		this.sell = sell;
	}

	public Double getStock() {
		return this.stock;
	}

	public void setStock(Double stock) {
		this.stock = stock;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getCategory() {
		return this.category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getCompany() {
		return this.company;
	}

	public void setCompany(Integer company) {
		this.company = company;
	}

}
