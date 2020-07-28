package com.test.alina.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.alina.model.Product;
import com.test.alina.repository.ProductRepository;
import com.test.alina.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product findOne(Long id) {
		return productRepository.findById(id).get();
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public List<Product> findMostExpensives() {
		return productRepository.findMostExpensives();
	}

	public Product save(Product product) {
		if (product.getId() != null) {
			return null;
		}
		return productRepository.save(product);
	}

	public Product update(Product product) {
		findOne(product.getId());
		return productRepository.save(product);
	}
}
