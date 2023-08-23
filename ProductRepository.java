package org.jsp.merchantproduct.repository;

import org.jsp.merchantproduct.dto.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("select p from Product p where p.merchant.id=?1")
   List<Product> findProductByUserId(int user_id);
	@Query("select p from Product p where p.brand=?1")
	Product findProductByBrand(String brand);
	
	@Query("select p from Product p where p.category=?1")
	Product findProductByCategory(String category);
}

