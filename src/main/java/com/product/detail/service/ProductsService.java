package com.product.detail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.product.detail.dto.ProductsRequest;
import com.product.detail.entity.Productlines;
import com.product.detail.entity.Products;
import com.product.detail.repository.ProductLinesRepo;
import com.product.detail.repository.ProductsRepo;

@Service
public class ProductsService {
	
	@Autowired
	private ProductLinesRepo productLinesRepo;

	@Autowired
	private ProductsRepo productsRepo;

	public Products addProducts(ProductsRequest pr) {
		
		Productlines p = new Productlines();
		Optional<Productlines> productlines = productLinesRepo.findById(pr.p_line);
		//Productlines productlines = null;
		if (productlines.isPresent()) {
			p = productlines.get();
		}
		Products products = new Products();
		products.setProduct_code(pr.product_code);
		products.setMsrp(pr.MSRP);
		products.setProductlines(p);
		products.setBuyPrice(pr.buyPrice);
		products.setProductDescrption(pr.productDescrption);
		products.setProductName(pr.productName);
		products.setProductScale(pr.productScale);
		products.setProductVendor(pr.productVendor);
		products.setQuantityInStock(pr.quantityInStock);
		
		return productsRepo.save(products);
	}

	public void updateproduct(String product_code, Products products) {
		
		int MSRP = products.getMsrp();
		String productName = products.getProductName();
		String productScale = products.getProductScale();
		String productVendor = products.getProductVendor();
		String productDescrption = products.getProductDescrption();
		int quantityInStock = products.getQuantityInStock();
		int buyPrice = products.getBuyPrice();
		productsRepo.saveProductDetail(product_code, MSRP, productName, productScale, productVendor, productDescrption,
				quantityInStock, buyPrice);
	}

	@Cacheable(value = "searchDataCache", key = "#product_code")
	public List<Products> getProductsByCodeAndName(String product_code) {
		// TODO Auto-generated method stub
		 return   productsRepo.getProductsByCodeAndName(product_code);
	
	}

}
