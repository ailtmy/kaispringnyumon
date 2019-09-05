package com.sample.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.web.domain.Product;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public void addProduct(Product product) {

		productDao.addProduct(product);
	}

	@Override
	public Product findByProductName(String name) {

		return productDao.findByProductName(name);
	}


}
