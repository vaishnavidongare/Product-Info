package com.product.detail.controller;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.detail.service.GraphQLService;

@RestController
@RequestMapping("/api/search/data/bygraphQl")
public class GraphQLController {
	Logger logger = LoggerFactory.getLogger(GraphQLController.class);
//	@Autowired
//	private GraphQL graphQL;

	@Autowired
	private GraphQLService service;
	@PostMapping
	public ResponseEntity<Object> executeQuery(@RequestBody Map<String, Object> request) {
		String query = (String) request.get("query");
		logger.info(query);
		Map<String, Object> variables = (Map<String, Object>) request.get("variables");
		return service.executeQuery(query,variables);

	}

	// Sending request to execute query
//	@PostMapping
//	public ResponseEntity<Object> executeQuery(@RequestBody Map<String, Object> request) {
//		String query = (String) request.get("query");
//		logger.info(query);
//		Map<String, Object> variables = (Map<String, Object>) request.get("variables");
//		if (variables == null) {
//			variables = new HashMap<>();
//		}
//		logger.info("before execution");
//		ExecutionInput executionInput = ExecutionInput.newExecutionInput().query(query).variables(variables).build();
//		ExecutionResult result = graphQL.execute(executionInput);
//		logger.info("After execution");
//		return new ResponseEntity<>(result, HttpStatus.OK);
//
//	}
//
//	// Resource loading
//	@Bean
//	public GraphQL graphQL() throws IOException {
//		URL url = Resources.getResource("productInfo.graphqls");
//		String file = Resources.toString(url, StandardCharsets.UTF_8);
//		TypeDefinitionRegistry registry = new SchemaParser().parse(file);
//		RuntimeWiring wiring = buildWiring();
//		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry, wiring);
//		graphQL = GraphQL.newGraphQL(schema).build();
//		return graphQL;
//
//	}
//
//	// calling data fetcher
//	private RuntimeWiring buildWiring() {
//		return RuntimeWiring.newRuntimeWiring()
//				.type("Query", typeWiring -> typeWiring.dataFetcher("products", this::productsFetcher)).build();
//
//	}
//
//	// Product Fetcher
//	public List<Products> productsFetcher(DataFetchingEnvironment environment) {
//		List<Products> productsList = service.productFetcher(environment);
//		return productsList;
//
//	}
}
