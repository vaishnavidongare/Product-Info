package com.product.detail.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.detail.entity.Productlines;
import com.product.detail.service.ProductLinesService;

@RestController
@RequestMapping(value = "/api/productline")
public class ProductLinesController {
	
	
	@Autowired
	private ProductLinesService productLinesService;
	
	@PostMapping
	public Productlines addProductlines(@RequestBody Productlines productlines) {
		
		 Productlines productlines1 = productLinesService.addProductlines(productlines);
			//pbs.publishDepartment(dep);
			return productlines1;
	}
	
	@PutMapping("/{product_line}")
	public void updateProductLines(@PathVariable String product_line, @RequestBody Productlines productlines) {
		productLinesService.updateProductLines(product_line, productlines);
	}
	
	@DeleteMapping("/{product_line}")
	public void deleteProductLine(@PathVariable("product_line") String product_line) {
		productLinesService.deleteProductLine(product_line);
	}
	
	
}
