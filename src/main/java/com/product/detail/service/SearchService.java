package com.product.detail.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.detail.entity.ProductDto;
import com.product.detail.entity.Products;
import com.product.detail.entity.SearchOrder;
import com.product.detail.entity.SearchQuery;
import com.product.detail.entity.SearchRequest;
import com.product.detail.repository.ProductsRepo;

@Service
public class SearchService {
	@Autowired
	private ProductsRepo productsRepo;

	public ResponseEntity<Object> searchDataBySpecification(SearchRequest searchRequest) {
		List<String> fieldIds = searchRequest.getFieldIds();
		List<SearchQuery> query = searchRequest.getQuery();
		List<SearchOrder> order = searchRequest.getOrder();

		List<Sort.Order> sortFields = new ArrayList<>();
		for (SearchOrder o : order) {
			String fieldId = o.getFieldId();
			String sortDirection = o.getSort();
			Sort.Order sort = new Sort.Order(Sort.Direction.fromString(sortDirection), fieldId);
			sortFields.add(sort);
		}

		Specification<Products> specification = Specification.where(null);
		for (SearchQuery s : query) {
			String fieldId = s.getFieldId();
			List<String> values = s.getValues();

			specification = specification.and((root, criteriaQuery, criteriaBuilder) -> {
				if (values.size() == 1) {
					return criteriaBuilder.equal(root.get(fieldId), values.get(0)); // returns the specification
				} else {
					return root.get(fieldId).in(values);
				}
			});

		}

		Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(sortFields));
		Page<Products> searchResults = productsRepo.findAll(specification, pageable);
		List<Products> content = searchResults.getContent();
		// List<ProductDto> response = content.stream().map(products ->new
		// ProductDto(products,fieldIds)).collect(Collectors.toList());
		List<ProductDto> response = content.stream().map(products -> mapToDTO(products, fieldIds))
				.collect(Collectors.toList());
		return ResponseEntity.ok(response);
	}

	private ProductDto mapToDTO(Products products, List<String> fieldIds) {
		ProductDto productDto = new ProductDto();
		if ((fieldIds.contains("buyPrice")) && (products.getBuyPrice() != 0)) {
			productDto.setBuyPrice(products.getBuyPrice());
		}
		if (fieldIds.contains("msrp") && (products.getMsrp() != 0)) {
			productDto.setMsrp(products.getMsrp());
		}
		if (fieldIds.contains("product_code") && (products.getProduct_code()) != null) {
			productDto.setProduct_code(products.getProduct_code());
		}
		if (fieldIds.contains("productName") && (products.getProductName()) != null) {
			productDto.setProductName(products.getProductName());
		}
		if (fieldIds.contains("productScale") && (products.getProductScale()) != null) {
			productDto.setProductScale(products.getProductScale());
		}
		if (fieldIds.contains("productVendor") && (products.getProductVendor()) != null) {
			productDto.setProductVendor(products.getProductVendor());
		}
		if (fieldIds.contains("productDescription") && (products.getProductDescrption()) != null) {
			productDto.setProductDescrption(products.getProductDescrption());
		}
		if (fieldIds.contains("quantityInStock") && (products.getQuantityInStock()) != 0) {
			productDto.setQuantityInStock(products.getQuantityInStock());
		}
		if (fieldIds.contains("p") && (products.getProductl1()) != null) {
			productDto.setP(products.getProductl1());
		}
		return productDto;
	}
	
	
	
	//Search data by stream api

	public ResponseEntity<Object> searchDataByStreamApi(SearchRequest searchRequest) {
		List<String> fieldIds = searchRequest.getFieldIds();
		List<SearchQuery> query = searchRequest.getQuery();
		List<SearchOrder> order = searchRequest.getOrder();
		
		List<Products> products = productsRepo.findAll();
		//To apply filter based on search query
		for(SearchQuery q:query) {
			String fieldId = q.getFieldId();
			List<String> values = q.getValues();
			products = products.stream().filter(product->values.contains(getFieldValue(product,fieldId))).collect(Collectors.toList());
		}
		//to sort the result based on the search order
		for(SearchOrder o:order) {
			String fieldId = o.getFieldId();
			String sortDirection = o.getSort();
			
			Comparator<Products> comparator = Comparator.comparing(product1->(Comparable)getFieldValue(product1,fieldId));
			
			if(sortDirection.equalsIgnoreCase("asc")) {
				products = products.stream().sorted(comparator).collect(Collectors.toList());
			} else if(sortDirection.equalsIgnoreCase("desc")) {
				products = products.stream().sorted(comparator.reversed()).collect(Collectors.toList());
			}
		}
		
		//Convert search result to dto
		List<ProductDto> response = products.stream().map(products1 -> mapToDTO(products1, fieldIds))
				.collect(Collectors.toList());
		return ResponseEntity.ok(response);
	}
    private Object getFieldValue(Products products,String fieldId) {
    	switch (fieldId) {
		case "product_code":
			return products.getProduct_code();
			
		case "buyPrice":
			return products.getBuyPrice();
			
		case "msrp":
			return products.getMsrp();
			
		case "productName":
			return products.getProductName();
			
		case "productScale":
			return products.getProductScale();
			
		case "productVendor":
			return products.getProductVendor();
			
		case "productDescription":
			return products.getProductDescrption();
			
		case "quantityInStock":
			return products.getQuantityInStock();
    }
    	return null;
}
    

}