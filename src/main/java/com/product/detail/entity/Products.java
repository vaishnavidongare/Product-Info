package com.product.detail.entity;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	@Id
	@Column(name = "product_code")
	private String product_code;
	@Column(name = "productName")
	private String productName;
	@Column(name = "productScale")
	private String productScale;
	@Column(name = "productVendor")
	private String productVendor;
	@Column(name = "productDescription")
	private String productDescrption;
	@Column(name = "quantityInStock")
	private int quantityInStock;
	@Column(name = "buyPrice")
	private int buyPrice;
	@Column(name = "msrp")
	private int msrp;
	@ManyToOne()
	@JoinColumn(name = "p_line", referencedColumnName = "product_line")
	Productlines productl1;
	public Products() {
		// TODO Auto-generated constructor stub
	}
	public Products(String product_code, int msrp, Productlines productlines) {
		super();
		this.product_code = product_code;
		this.msrp = msrp;
		this.productl1 = productlines;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public int getMsrp() {
		return msrp;
	}
	public void setMsrp(int msrp) {
		this.msrp = msrp;
	}
//	public Productlines getProductlines() {
//		return productl1;
//	}
	public void setProductlines(Productlines productlines) {
		this.productl1 = productlines;
	}
	public Products(String product_code, String productName, String productScale, String productVendor,
			String productDescrption, int quantityInStock, int buyPrice, int msrp, Productlines productl1) {
		super();
		this.product_code = product_code;
		this.productName = productName;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescrption = productDescrption;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.msrp = msrp;
		this.productl1 = productl1;
	}
	
	public Products(String product_code, String productName, String productScale, String productVendor,
			String productDescrption, int quantityInStock, int buyPrice, int msrp) {
		super();
		this.product_code = product_code;
		this.productName = productName;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescrption = productDescrption;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.msrp = msrp;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductScale() {
		return productScale;
	}
	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}
	public String getProductVendor() {
		return productVendor;
	}
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}
	public String getProductDescrption() {
		return productDescrption;
	}
	public void setProductDescrption(String productDescrption) {
		this.productDescrption = productDescrption;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public int getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Productlines getProductl1() {
		return productl1;
	}
	public void setProductl1(Productlines productl1) {
		this.productl1 = productl1;
	}
	

}
