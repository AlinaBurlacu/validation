package com.test.alina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.alina.model.Product;
import com.test.alina.service.ProductService;

@Controller
@RequestMapping(value = "/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAll() {
		List<Product> allProducts = productService.findAll();
		return new ResponseEntity<List<Product>>(allProducts, HttpStatus.OK);
	}

	@RequestMapping(value = "/mostExpensive", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getMostExpensive() {
		List<Product> products = productService.findMostExpensives();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Product> save(@RequestBody Product product) {
		Product savedProduct = productService.save(product);
		if (savedProduct == null) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Product> update(@RequestBody Product product) {
		Product updated = productService.update(product);
		return new ResponseEntity<Product>(updated, HttpStatus.OK);
	}
}
