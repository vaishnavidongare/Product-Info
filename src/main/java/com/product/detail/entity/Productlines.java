package com.product.detail.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "productlines")
public class Productlines implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "product_line")
	private String product_line;
	@Column(name = "textDescription")
	private String textDescription;
	@Column(name = "htmlDescription")
	private String htmlDescription;
	
	@Column(name = "image")
	private String image;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productl1")
	private List<Products> products = new ArrayList<>();
	
	public Productlines() {
		// TODO Auto-generated constructor stub
	}
	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	public Productlines(String product_line, String textDescription, String htmlDescription, String image,
			List<Products> products) {
		super();
		this.product_line = product_line;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
		this.products = products;
	}

	public Productlines(String product_line, String textDescription, String htmlDescription, String image) {
		super();
		this.product_line = product_line;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
	}
	public Productlines(String product_line, String image, List<Products> products) {
		super();
		this.product_line = product_line;
		this.image = image;
		this.products = products;
	}

	public String getProduct_line() {
		return product_line;
	}

	public void setProduct_line(String product_line) {
		this.product_line = product_line;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}
	

}
