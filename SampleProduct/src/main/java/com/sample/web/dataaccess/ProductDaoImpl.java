package com.sample.web.dataaccess;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sample.web.domain.Product;
import com.sample.web.service.ProductDao;

@Component
public class ProductDaoImpl implements ProductDao {
	//MapはRDBの代わり
	private Map<String, Product> storage = new HashMap<String, Product>();

	@Override
	public void addProduct(Product product) {
		storage.put(product.getName(), product);
	}

	@Override
	public Product findByProductName(String name) {
		return storage.get(name);
	}

}
