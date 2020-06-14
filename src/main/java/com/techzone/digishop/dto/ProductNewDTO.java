package com.techzone.digishop.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.techzone.digishop.domain.Product;

public class ProductNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String barcode;
	private String reference;
	private String description;
	private BigDecimal purchasePrice;
	private BigDecimal salePrice;
	private String un;
	private BigDecimal weight;
	private Boolean sell = true;
	private String location;
	private Integer category;
	private Integer company;


	public ProductNewDTO() {
		this.purchasePrice = new BigDecimal("0.00");
		this.salePrice = new BigDecimal("0.00");
		this.un ="UN";
		this.sell = true;
	}

	public ProductNewDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.barcode = product.getBarcode();
		this.reference = product.getReference();
		this.description = product.getDescription();
		this.purchasePrice = product.getPurchasePrice();
		this.salePrice = product.getSalePrice();
		this.un = product.getUn();
		this.weight = product.getWeight();
		this.sell = product.getSell();
		this.location = product.getLocation();
		this.category = product.getCategory().getId();
		this.company = product.getCompany().getId();

	}

	public ProductNewDTO(Integer id, String name, String barcode, String reference, String description,
			BigDecimal purchasePrice, BigDecimal salePrice, String un, BigDecimal weight, Boolean sell, String location,
			Integer category, Integer company) {
		this.id = id;
		this.name = name;
		this.barcode = barcode;
		this.reference = reference;
		this.description = description;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.un = un;
		this.weight = weight;
		this.sell = sell;
		this.location = location;
		this.category = category;
		this.company = company;

	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public BigDecimal getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getUn() {
		return this.un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
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
