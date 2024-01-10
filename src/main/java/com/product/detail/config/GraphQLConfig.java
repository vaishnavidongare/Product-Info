//package com.product.detail.config;
//
//import java.io.IOException;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.google.common.io.Resources;
//import com.product.detail.controller.GraphQLController;
//
//import graphql.schema.GraphQLSchema;
//import graphql.schema.idl.RuntimeWiring;
//import graphql.schema.idl.SchemaGenerator;
//import graphql.schema.idl.SchemaParser;
//import graphql.schema.idl.TypeDefinitionRegistry;
//import graphql.schema.idl.TypeRuntimeWiring;
//
//@Configuration
//public class GraphQLConfig {
//	@Autowired
//	private GraphQLController graphQLController;
//	
//	@Bean
//	public GraphQLSchema schema() throws IOException {
//		URL url= Resources.getResource("productsearch.graphqls");
//		String file = Resources.toString(url, StandardCharsets.UTF_8);
//		TypeDefinitionRegistry registry = new SchemaParser().parse(file);
//		RuntimeWiring runtimeWiring = buildWiring();
//		return new SchemaGenerator().makeExecutableSchema(registry, runtimeWiring);
//	}
//
//	private RuntimeWiring buildWiring() {
//		return RuntimeWiring.newRuntimeWiring().type("Query",typewiring->
//		typewiring.dataFetcher("products", graphQLController::productsFetcher)).build();
//				
//	}
//	
//}
