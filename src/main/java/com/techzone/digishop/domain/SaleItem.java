package com.techzone.digishop.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SaleItem implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@EmbeddedId
	private SaleItemPK id = new SaleItemPK();
	private Double discount = 0.00;
	private Double quantity;
	private String name;
	private String barcode;
	private String reference;
	private String description;
	private Double purchasePrice;
	private Double salePrice;
	private String un = "UN";
	private Double weight = 0.00;
	private String location;

	public SaleItem() {
	}

	public SaleItem(Sale sale, Product product, Double discount, Double quantity, String name, String barcode,
			String reference, String description, Double purchasePrice, Double salePrice, String un, Double weight,
			String location) {
		super();
		this.id.setSale(sale);
		this.id.setProduct(product);
		this.discount = discount;
		this.quantity = quantity;
		this.name = name;
		this.barcode = barcode;
		this.reference = reference;
		this.description = description;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.un = un;
		this.weight = weight;
		this.location = location;
	}

	public Double getSubtotal() {
		return (salePrice - discount) * quantity;
	}

	@JsonIgnore
	public Sale getSale() {
		return id.getSale();
	}

	public void setSale(Sale sale){
		this.id.setSale(sale);
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		this.id.setProduct(product);
	}

	public SaleItemPK getId() {
		return id;
	}

	public void setId(SaleItemPK id) {
		this.id = id;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
		SaleItem other = (SaleItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{" + " id='" + id + "'" + ", discount='" + discount + "'" + ", quantity='" + quantity + "'" + ", name='"
				+ name + "'" + ", barcode='" + barcode + "'" + ", reference='" + reference + "'" + ", description='"
				+ description + "'" + ", purchasePrice='" + purchasePrice + "'" + ", salePrice='" + salePrice + "'"
				+ ", un='" + un + "'" + ", weight='" + weight + "'" + ", location='" + location + "'" + "}";
	}

}
