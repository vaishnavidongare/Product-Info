package com.product.detail.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.detail.dto.ProductsRequest;
import com.product.detail.entity.Products;
import com.product.detail.service.ProductsService;

@RestController
@RequestMapping(value = "/api/products")
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@PostMapping
	public Products addProducts(@RequestBody ProductsRequest pr) {
		
		Products employee = productsService.addProducts(pr);
		String product_code = employee.getProduct_code();
		
        pr.product_code=product_code;
        return employee;
	}
	
	@PutMapping("/{product_code}")
	public void updateProduct(@PathVariable String product_code, @RequestBody Products products) {
		
		updateProduct(product_code, products);
	}
	
	@GetMapping("/productbycodeandname/{product_code}")
	public ResponseEntity<List<Products>> getProductsByCodeAndName(@PathVariable("product_code") String product_code){
	 List<Products> p= productsService.getProductsByCodeAndName(product_code);
	 return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	
	
}