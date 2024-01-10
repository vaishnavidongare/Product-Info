package com.product.detail.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.product.detail.entity.ProductDto;
import com.product.detail.entity.SearchRequest;
import com.product.detail.service.SearchService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
public class SearchControllerTest {
	private SearchController searchController;
	
	@Mock
	private SearchService searchService;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		//MockitoAnnotations.initMocks(this);//.openMocks(this);
		MockitoAnnotations.initMocks(this);
		searchController = new SearchController(searchService);
	}
	
	@Test
	public void testSearchDataBySpecification() {
		SearchRequest searchRequest = new SearchRequest();
		List<ProductDto> expectedResult =new ArrayList<>();
		when(searchService.searchDataBySpecification(searchRequest)).thenReturn(expectedResult);
		Object request = expectedResult;
		List<ProductDto> response = searchController.searchDataBySpecification((SearchRequest) request);
		//mockMvc.perform(MockMvcRequestBuilders.post("/api/serachusingspecification").contentType(MediaType.APPLICATION_JSON).content(searchRequest.toString())).andExpect(MockMvcResultMatchers.status().isOk());
	    //assertEquals(HttpStatus.OK, ((ResponseEntity<List<ProductDto>>) response).getStatusCode());
		assertEquals(expectedResult,response);
	}
	
	@Test
	public void testSearchDataByStream() throws Exception{
		SearchRequest searchRequest = new SearchRequest();
		when(searchService.searchDataByStreamApi(searchRequest)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
		mockMvc.perform(MockMvcRequestBuilders.post("/api/serachusingstreamapi").contentType(MediaType.APPLICATION_JSON).content(searchRequest.toString())).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
}
