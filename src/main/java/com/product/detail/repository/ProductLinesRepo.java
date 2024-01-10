package com.product.detail.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.detail.entity.Productlines;

@Repository
public interface ProductLinesRepo extends JpaRepository<Productlines, String>{
   Optional<Productlines> findById(String product_line);

	

}
