package com.techzone.digishop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Column(unique = true)
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

	@JsonIgnore
	@OneToMany(mappedBy = "id.product")
	List<SaleItem> itens = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "id.product")
	List<PurchaseItem> purchaseItens = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private ProductCategory category;

	public Product() {

	}

	public Product(Integer id, String name, String barcode, String reference, String description,
			Double purchasePrice, Double salePrice, String un, Double weight,
			Boolean sell, Double stock, String location, Company company, ProductCategory category) {
		super();
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
		this.stock = stock;
		this.location = location;
		this.company = company;
		this.category = category;
	}

	@JsonIgnore
	public List<Sale> getSales() {
		List<Sale> salesList = new ArrayList<>();
		for (SaleItem x : itens) {
			salesList.add(x.getSale());
		}
		return salesList;
	}
	

	@JsonIgnore
	public List<Purchase> getPurchases() {
		List<Purchase> purchasesList = new ArrayList<>();
		for (PurchaseItem x : purchaseItens) {
			purchasesList.add(x.getPurchase());
		}
		return purchasesList;
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

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Boolean getSell() {
		return sell;
	}

	public void setSell(Boolean sell) {
		this.sell = sell;
	}

	public Double getStock() {
		return stock;
	}

	public void setStock(Double stock) {
		this.stock = stock;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<SaleItem> getItens() {
		return itens;
	}

	public void setItens(List<SaleItem> itens) {
		this.itens = itens;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "{" +
			" id='" + id + "'" +
			", name='" + name + "'" +
			", barcode='" + barcode + "'" +
			", reference='" + reference + "'" +
			", description='" + description + "'" +
			", purchasePrice='" + purchasePrice + "'" +
			", salePrice='" + salePrice + "'" +
			", un='" + un + "'" +
			", weight='" + weight + "'" +
			", sell='" + sell + "'" +
			", stock='" + stock + "'" +
			", location='" + location + "'" +
			", itens='" + itens + "'" +
			", purchaseItens='" + purchaseItens + "'" +
			", company='" + company + "'" +
			", category='" + category + "'" +
			"}";
	}


}
