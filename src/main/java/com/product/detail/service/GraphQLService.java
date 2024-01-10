package com.product.detail.service;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.io.Resources;
import com.product.detail.controller.GraphQLController;
import com.product.detail.entity.Products;
import com.product.detail.repository.ProductsRepo;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {
	Logger logger = LoggerFactory.getLogger(GraphQLController.class);
	@Autowired
	private GraphQL graphQL;

	@Autowired
	private ProductsRepo productsRepo;
	public List<Products> productFetcher(DataFetchingEnvironment environment) {
		Map<String, Object> filter = environment.getArgument("filter");
		Map<String, Object> order = environment.getArgument("order");
	    logger.info(filter.toString());
	    logger.info(order.toString());
		if (filter == null || order == null) {
			throw new RuntimeException("Either filter or order cannot be null");
		}
		logger.info("filter"+filter);
		logger.info("order"+order);
		List<Products> products = productsRepo.findAll();
		logger.info(products.toString());
		// filtering the data based on filterInput
		if (filter != null && filter.containsKey("filter")) {
			logger.info("Inside the filtercheck");
			Map<String, Object> filterInput = (Map<String, Object>) filter.get("filter");
			Class<? extends Object> atr=filterInput.get("attribute").getClass();
			System.out.println(atr);
			String attribute = (String) filterInput.get("attribute");
			String valueTomatch = (String) filterInput.get("equals");

           logger.info("attribute"+attribute);
			if ("productName".equals(attribute)) {
				products = products.stream().filter(product -> valueTomatch.equals(product.getProductName()))
						.collect(Collectors.toList());
				logger.info("FilterResult");
			}
			if ("product_code".equals(attribute)) {
				products = products.stream().filter(product -> valueTomatch.equals(product.getProduct_code()))
						.collect(Collectors.toList());
				logger.info("FilterResult");
			}
			if ("productScale".equals(attribute)) {
				products = products.stream().filter(product -> valueTomatch.equals(product.getProductScale()))
						.collect(Collectors.toList());
				logger.info("FilterResult");
			}
			if ("productVendor".equals(attribute)) {
				products = products.stream().filter(product -> valueTomatch.equals(product.getProductVendor()))
						.collect(Collectors.toList());
				logger.info("FilterResult");
			}
			if ("quantityInStock".equals(attribute)) {
				products = products.stream().filter(product -> valueTomatch.equals(product.getQuantityInStock()))
						.collect(Collectors.toList());
				logger.info("FilterResult");
			}
			if ("msrp".equals(attribute)) {
				products = products.stream().filter(product -> valueTomatch.equals(product.getMsrp()))
						.collect(Collectors.toList());
				logger.info("FilterResult");
			}
			if ("buyPrice".equals(attribute)) {
				products = products.stream().filter(product -> valueTomatch.equals(product.getBuyPrice()))
						.collect(Collectors.toList());
				logger.info("FilterResult");
			}
		}
		// filtering data based on order either asc or desc
		if (order != null) {
			String fieldId = (String) order.get("fieldId");
			String sort = (String) order.get("sort");
			if ("productName".equals(fieldId)) {
				if ("asc".equalsIgnoreCase(sort)) {
					products.sort(Comparator.comparing(Products::getProductName));
				} else if ("desc".equalsIgnoreCase(sort)) {
					products.sort(Comparator.comparing(Products::getProductName).reversed());
				}
			}
			if("quantityInStock".equals(fieldId)) {
				if("asc".equalsIgnoreCase(sort)) {
					products.sort(Comparator.comparing(Products::getProductName));
				}
				else if("desc".equalsIgnoreCase(sort)) {
					products.sort(Comparator.comparing(Products::getProductName).reversed());
				}
			}
			if("msrp".equals(fieldId)) {
				if("asc".equalsIgnoreCase(sort)) {
					products.sort(Comparator.comparing(Products::getProductName));
				}
				else if("desc".equalsIgnoreCase(sort)) {
					products.sort(Comparator.comparing(Products::getProductName).reversed());
				}
			}
			if("buyPrice".equals(fieldId)) {
				if("asc".equalsIgnoreCase(sort)) {
					products.sort(Comparator.comparing(Products::getProductName));
				}
				else if("desc".equalsIgnoreCase(sort)) {
					products.sort(Comparator.comparing(Products::getProductName).reversed());
				}
			}
		}
		logger.info(products.toString());
		return products;

		
	}
	public ResponseEntity<Object> executeQuery(String query, Map<String, Object> variables) {
		
		if (variables == null) {
			variables = new HashMap<>();
		}
		logger.info("before execution");
		ExecutionInput executionInput = ExecutionInput.newExecutionInput().query(query).variables(variables).build();
		ExecutionResult result = graphQL.execute(executionInput);
		logger.info("After execution");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	@Bean
	public GraphQL graphQL() throws IOException {
		URL url = Resources.getResource("productInfo.graphqls");
		String file = Resources.toString(url, StandardCharsets.UTF_8);
		TypeDefinitionRegistry registry = new SchemaParser().parse(file);
		RuntimeWiring wiring = buildWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
		return graphQL;

	}

	// calling data fetcher
	private RuntimeWiring buildWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring -> typeWiring.dataFetcher("products", this::productsFetcher)).build();

	}

	// Product Fetcher
	public List<Products> productsFetcher(DataFetchingEnvironment environment) {
		List<Products> productsList = productFetcher(environment);
		return productsList;

	}

}
