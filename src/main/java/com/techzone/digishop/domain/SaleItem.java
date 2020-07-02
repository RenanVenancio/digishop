package com.techzone.digishop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SaleItem implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@EmbeddedId
	private SaleItemPK id = new SaleItemPK();
	private BigDecimal discount;
	private BigDecimal quantity;
	private String name;
	private String barcode;
	private String reference;
	private String description;
	private BigDecimal purchasePrice;
	private BigDecimal salePrice;
	private String un = "UN";
	private BigDecimal weight;
	private String location;

	public SaleItem() {
	}

	public SaleItem(Sale sale, Product product, BigDecimal discount, BigDecimal quantity, String name, String barcode,
			String reference, String description, BigDecimal purchasePrice, BigDecimal salePrice, String un, BigDecimal weight,
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

	public void addQuantity(BigDecimal value){
		this.quantity = this.quantity.add(value);
	}

	public BigDecimal getSubtotal() {
		return (salePrice.subtract(discount)).multiply(quantity);
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

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
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
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		StringBuilder builder = new StringBuilder();
		builder.append(getDescription());
		builder.append(", Qtde: ");
		builder.append(getQuantity());
		builder.append(", Valor Unitário: ");
		builder.append(nf.format(getSalePrice()));
		builder.append(", Subtotal: ");
		builder.append(nf.format(getSubtotal()));
		builder.append("\n");
		return builder.toString();
	}



}
