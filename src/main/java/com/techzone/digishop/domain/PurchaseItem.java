package com.techzone.digishop.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PurchaseItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private PurchaseItemPK id = new PurchaseItemPK();

	private BigDecimal discount;

	private BigDecimal quantity;

	private String name;

	private String barcode;

	private String reference;

	private String description;

	private BigDecimal purchasePrice;

	private BigDecimal salePrice;

	private String un = "UN";

	public PurchaseItem() {
	}

	public PurchaseItem(Product p){
		this.setProduct(p);
		this.discount = new BigDecimal("0.00");
		this.quantity = new BigDecimal("1.00");
		this.name = p.getName();
		this.barcode = p.getBarcode();
		this.reference = p.getReference();
		this.description = p.getDescription();
		this.purchasePrice = p.getPurchasePrice();
		this.salePrice = p.getSalePrice();
		this.un = p.getUn();
	}

	public PurchaseItem(Purchase purchase, Product product, BigDecimal discount, BigDecimal quantity, String name,
			String barcode, String reference, String description, BigDecimal purchasePrice,
		 BigDecimal salePrice, String un) {
		super();
		this.id.setPurchase(purchase);
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
	}

	public void addQuantity(BigDecimal value){
		this.quantity = this.quantity.add(value);
	}

	public BigDecimal getSubtotal() {
		return (purchasePrice.subtract(discount)).multiply(quantity);
	}

	@JsonIgnore
	public Purchase getPurchase() {
		return id.getPurchase(); 
	}

	public void setPurchase(Purchase purchase){
		this.id.setPurchase(purchase);
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product){
		this.id.setProduct(product);
	}

	public PurchaseItemPK getId() {
		return id;
	}

	public void setId(PurchaseItemPK id) {
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
		PurchaseItem other = (PurchaseItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
