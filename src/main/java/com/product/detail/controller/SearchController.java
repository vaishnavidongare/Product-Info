package com.product.detail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.detail.entity.SearchRequest;
import com.product.detail.service.SearchService;

@RestController
@RequestMapping(value = "/api")
public class SearchController {
	
	@Autowired
	private SearchService searchService;

	@PostMapping("/serachusingspecification")
	public ResponseEntity<Object> searchDataBySpecification(@RequestBody SearchRequest searchRequest) {

		return searchService.searchDataBySpecification(searchRequest);
	}
	
	@PostMapping("/serachusingstreamapi")
	public ResponseEntity<Object> searchDataByStreamApi(@RequestBody SearchRequest searchRequest) {

		return searchService.searchDataByStreamApi(searchRequest);
	}

}
