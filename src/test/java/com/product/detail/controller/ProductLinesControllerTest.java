package com.product.detail.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.product.detail.entity.Productlines;
import com.product.detail.service.ProductLinesService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductLinesControllerTest {
		@Autowired
		private ProductLinesController productLinesController;
		
		@Mock
		private RequestAttributes requestAttributes;
		
		@Mock
		private ProductLinesService productLinesService;
		
		private MockMvc mockMvc;
		

		@Before
		public void setup() {
			RequestContextHolder.setRequestAttributes(requestAttributes);
			this.mockMvc = MockMvcBuilders.standaloneSetup(productLinesController).build();
		}
		
		@Test
		public void updateProductLines() {
			String pline="Shift";
			Productlines productlines= new Productlines();
			productlines.setProduct_line(pline);;
			productlines.setHtmlDescription("bhbfhvbjfbv");
			productlines.setImage(null);
			productlines.setTextDescription("bvfvhf");
			productLinesService.updateProductLines(pline, productlines);
			Mockito.doNothing().when(productLinesService).updateProductLines(anyString(),any());//updateDepartment(anyString(),any());
			
			
		}
}
