package com.product.detail.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String product_code;
	private String productName;
	private String productScale;
	private String productVendor;
	private String productDescription;
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	private int quantityInStock;
	private int buyPrice;
	private int msrp;
	private Productlines p;
	
	public Productlines getP() {
		return p;
	}
	public void setP(Productlines p) {
		this.p = p;
	}
	
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
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
	public int getMsrp() {
		return msrp;
	}
	public void setMsrp(int msrp) {
		this.msrp = msrp;
	}
	public ProductDto(String product_code, String productName, String productScale, String productVendor,
			String productDescription, int quantityInStock, int buyPrice, int msrp, Productlines p) {
		super();
		this.product_code = product_code;
		this.productName = productName;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.msrp = msrp;
		this.p = p;
	}
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}
	public ProductDto(String productName, int buyPrice) {
		// TODO Auto-generated constructor stub
		this.productName=productName;
		this.buyPrice=buyPrice;
	}
	
}

