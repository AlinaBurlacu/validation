package com.test.alina.service;

import java.util.List;

import com.test.alina.model.Product;

public interface ProductService {

	Product findOne(Long id);

	List<Product> findAll();

	List<Product> findMostExpensives();

	Product save(Product product);

	Product update(Product product);

}
