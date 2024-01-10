package com.product.detail.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.product.detail.entity.ProductDto;
import com.product.detail.entity.Productlines;
import com.product.detail.entity.Products;
import com.product.detail.entity.SearchRequest;
import com.product.detail.repository.ProductsRepo;

//@ExtendWith(MockitoExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SearchServiceTest {

	@Mock
	private ProductsRepo productsRepo;

	@InjectMocks
	private SearchService searchService;

	public SearchServiceTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void searchDataBySpecification() {
		System.out.println("Entering in to code...");
		// Mock search request
		SearchRequest searchRequest = new SearchRequest();

		// Set the search request properties
		List<Products> productsList = new ArrayList<>();
		Productlines pline1 = new Productlines("uij", "uji", "desd", null);
		Productlines pline2 = new Productlines("nmb", "yui", "xsxw", null);
		productsList.add(new Products("HYU", "Car", "1:5", "hbgh", "juhyt", 8, 89090, 78, pline1));
		productsList.add(new Products("WEQ", "Bike", "1:10", "IKO", "hyt", 9, 89090, 8, pline2));
		Page<Products> searchResultPage = new PageImpl<>(productsList);
		when(productsRepo.findAll(any(Specification.class), any(Pageable.class))).thenReturn(searchResultPage);

		Arrays.asList("product_code", "productName", "productScale", "productVendor",
				"productDescription", "quantityInStock", "buyPrice", "msrp", "p");

		Arrays.asList(
				new ProductDto("HYU", "Car", "1:5", "hbgh", "juhyt", 8, 89090, 78, pline1),
				new ProductDto("WEQ", "Bike", "1:10", "IKO", "hyt", 9, 89090, 8, pline2));
		searchService.searchDataBySpecification(searchRequest);

		//Throwable exception = assertThrows(Exception.class,() -> searchService.searchDataBySpecification(searchRequest));
		// verify mock intereaction
		verify(productsRepo, times(1)).findAll(any(Specification.class), any(Pageable.class));

		// verify the response
//		assertEquals(HttpStatus.OK, ((Object) response).getStatusCode());
//		assertEquals(expectedResult, response.getBody());
		
//		assertNotNull(exception);
//		assertEquals("Expected exception message", exception.getMessage());
	}
}