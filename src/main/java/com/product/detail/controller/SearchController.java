package com.product.detail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.detail.entity.ProductDto;
import com.product.detail.entity.SearchRequest;
import com.product.detail.service.SearchService;

@RestController
@RequestMapping(value = "/api")
public class SearchController {
	
	@Autowired
	private SearchService searchService;

	public SearchController() {
		// TODO Auto-generated constructor stub
	}
	public SearchController(SearchService searchService2) {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/serachusingspecification")
	public @ResponseBody List<ProductDto> searchDataBySpecification(@RequestBody SearchRequest searchRequest) {

		return searchService.searchDataBySpecification(searchRequest);
	}
	
	@PostMapping("/serachusingstreamapi")
	public ResponseEntity<List<ProductDto>> searchDataByStreamApi(@RequestBody SearchRequest searchRequest) {

		return searchService.searchDataByStreamApi(searchRequest);
	}
}
