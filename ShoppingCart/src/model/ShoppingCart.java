package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SHOPPING_CART database table.
 * 
 */
@Entity
@Table(name="SHOPPING_CART", schema="TESTDB")
@NamedQuery(name="ShoppingCart.findAll", query="SELECT s FROM ShoppingCart s")
public class ShoppingCart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRODUCT_CODE")
	private long productCode;

	@Column(name="PRODUCT_DESCRIPTION")
	private String productDescription;

	@Column(name="PRODUCT_NAME")
	private String productName;

	@Column(name="PRODUCT_PRICE")
	private double productPrice;

	public ShoppingCart() {
	}

	public long getProductCode() {
		return this.productCode;
	}

	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

}