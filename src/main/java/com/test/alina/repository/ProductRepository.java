package com.test.alina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.alina.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	//there can be more products with the same highest price
	@Query("SELECT p from Product p where p.price = (Select MAX(p.price) from Product p)")
	List<Product> findMostExpensives();

}
