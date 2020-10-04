package com.techzone.digishop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	// @Column(unique = true)
	private String barcode;
	private String reference;
	private String description;
	private BigDecimal purchasePrice;
	private BigDecimal salePrice;
	private String un = "UN";
	private BigDecimal weight;
	private Boolean sell = true;
	private String location;
	private BigDecimal stockEntries;
	private BigDecimal stockOutputs;

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
		this.stockEntries = new BigDecimal("0.00");
		this.stockOutputs = new BigDecimal("0.00");
		this.purchasePrice = new BigDecimal("0.00");
		this.salePrice = new BigDecimal("0.00");
	}

	public Product(Integer id, String name, String barcode, String reference, String description,
			BigDecimal purchasePrice, BigDecimal salePrice, String un, BigDecimal weight, Boolean sell, String location,
			Company company, ProductCategory category) {
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
		this.location = location;
		this.company = company;
		this.category = category;
		this.stockEntries = new BigDecimal("0.00");
		this.stockOutputs = new BigDecimal("0.00");
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

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public Boolean getSell() {
		return sell;
	}

	public void setSell(Boolean sell) {
		this.sell = sell;
	}

	public BigDecimal getStock() {
		return stockEntries.subtract(stockOutputs);
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

	public BigDecimal getStockEntries() {
		return this.stockEntries;
	}

	public void setStockEntries(BigDecimal stockEntries) {
		this.stockEntries = stockEntries;
	}

	public BigDecimal getStockOutputs() {
		return this.stockOutputs;
	}

	public void setStockOutputs(BigDecimal stockOutputs) {
		this.stockOutputs = stockOutputs;
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
		return "{" + " id='" + id + "'" + ", name='" + name + "'" + ", barcode='" + barcode + "'" + ", reference='"
				+ reference + "'" + ", description='" + description + "'" + ", purchasePrice='" + purchasePrice + "'"
				+ ", salePrice='" + salePrice + "'" + ", un='" + un + "'" + ", weight='" + weight + "'" + ", sell='"
				+ sell + "'" + ", stock='" + getStock() + "'" + ", location='" + location + "'" + ", itens='" + itens
				+ "'" + ", purchaseItens='" + purchaseItens + "'" + ", company='" + company + "'" + ", category='"
				+ category + "'" + "}";
	}

}
