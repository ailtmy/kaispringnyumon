package com.sample.web.service;

import com.sample.web.domain.Product;

public interface ProductDao {

	void addProduct(Product product);
	Product findByProductName(String name);
}
