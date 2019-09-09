package sample.di.dataaccess;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import sample.di.business.domain.Product;
import sample.di.business.service.ProductDao;

@Repository
public class ProductDaoImpl implements ProductDao {

	//RDBの代わり
	private Map<String, Product> storage = new HashMap<String, Product>();

	//Daoだけど簡単にするためにRDBにはアクセスしていません。
	@Override
	@Cacheable(value = "area")
	public Product findProduct(String name) {
		slowly();
		return storage.get(name);
	}

	@Override
	@CacheEvict(value = "area", key = "#product.name")
	public void addProduct(Product product) {
		storage.put(product.getName(), product);
	}

	private void slowly() {
		try {
			Thread.sleep(3000L);;
		} catch(InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

}
