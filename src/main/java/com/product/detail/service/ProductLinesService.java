package com.product.detail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.detail.entity.Productlines;
import com.product.detail.repository.ProductLinesRepo;

@Service
public class ProductLinesService {
	
	@Autowired
	private ProductLinesRepo productLinesRepo;
	
	public Productlines addProductlines(Productlines productlines) {
		
		return productLinesRepo.save(productlines);

	}

	public void updateProductLines(String product_line, Productlines productlines) {
		
		productLinesRepo.save(productlines);
		
	}

	public void deleteProductLine(String product_line) {	
		productLinesRepo.deleteById(product_line);
	}

	
}
