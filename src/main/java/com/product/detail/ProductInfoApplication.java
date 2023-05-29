package com.product.detail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@SpringBootApplication
public class ProductInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductInfoApplication.class, args);
		
	}

}
