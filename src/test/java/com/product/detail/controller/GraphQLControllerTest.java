package com.product.detail.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.product.detail.service.GraphQLService;

public class GraphQLControllerTest {
	@InjectMocks
	private  GraphQLController controller;
	@Mock
	private GraphQLService service;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void executeQueryTest() {
		//creating mock request
		Map<String, Object> request = new HashMap<>();
		//mock Query
		String query = "query{"
				+ "products("
				+ "filter:{"
				+ "filter:{"
				+ "attribute:\"productVendor\","
				+ "equals:\"Classic Metal Creations\""
				+ "} },"
				+ "order:{"
				+ "fieldId:\"buyPrice\","
				+ "sort:\"asc\""
				+ "}"
				+ "){"
				+ "productName"
				+ " quantityInStock"
				+ "}"
				+ "}";
//		System.out.println(query);
		request.put("query", query);
		Map<String, Object> variable = new HashMap<>();
		request.put("variables",variable);
		Object mockResponse = new Object();
		when(service.executeQuery(query, variable)).thenReturn(ResponseEntity.ok(mockResponse));
		ResponseEntity<Object> responseEntity = controller.executeQuery(request);
		assertEquals(mockResponse, responseEntity.getBody());
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		System.out.println(responseEntity.getBody());
		
	}
}
