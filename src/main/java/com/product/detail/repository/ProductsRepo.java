package com.product.detail.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.detail.entity.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products, String>,JpaSpecificationExecutor<Products> {


	@Modifying
	@Transactional
	@Query(value = "UPDATE Products u SET u.mSRP=:mSRP,u.product_name=:productName,u.product_scale=:productScale,u.product_vendor=:productVendor,u.product_description=:productDescription,u.quantity_in_stock=:quantityInStock,u.buy_price=:buyPrice WHERE u.product_code = :product_code", nativeQuery = true)
	void saveProductDetail(String product_code, int mSRP, String productName, String productScale, String productVendor,
			String productDescription, int quantityInStock, int buyPrice);

	

	//@Transactional
	@Query(value = "select p from Products p where p.product_code=?1")
	List<Products> getProductsByCodeAndName(String product_code);

	
	
}
