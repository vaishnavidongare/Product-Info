package com.product.detail.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.product.detail.entity.ProductDto;
import com.product.detail.entity.SearchRequest;
import com.product.detail.repository.ProductsRepo;

public class SearchServiceTest1 {
	@Mock
	private RedisTemplate<String, String> redisTemplate;
	
	@Mock
	private ProductsRepo productsRepo;
	
	@Mock
	private RedisConnectionFactory redisConnectionFactory;
	
	private SearchService searchService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		searchService = new SearchService(redisTemplate, productsRepo,redisConnectionFactory);
		}
	
	@Test
	private void test_SearchData_withCache() {
		String cacheKey = "searchRequestKey";
		List<ProductDto> cachedResponse = new ArrayList<>();
		cachedResponse.add(new ProductDto("Product 1",10));
		String cachedJson = "[{\"productName\":\"Product 1\",\"buyPrice\":10}]";
		when(redisTemplate.hasKey(cacheKey)).thenReturn(true);
		when(redisTemplate.opsForValue().get(cacheKey)).thenReturn(cachedJson);
		
		SearchRequest searchRequest = new SearchRequest();
		searchRequest.setFieldIds(new ArrayList<>());
		searchRequest.setQuery(new ArrayList<>());
		List<ProductDto> expectedResponse =cachedResponse;
		List<ProductDto> actualResponse = searchService.searchDataBySpecification(searchRequest);
		assertEquals(expectedResponse, actualResponse);
		verify(redisTemplate,times(1)).hasKey(cacheKey);
		verify(redisTemplate,times(1)).opsForValue().get(cacheKey);
		//verify(productsRepo,never()).findAll(any(),any());
	}
}
