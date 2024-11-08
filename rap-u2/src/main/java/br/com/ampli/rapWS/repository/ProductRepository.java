package br.com.ampli.rapWS.repository;

import jakarta.annotation.PostConstruct;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import br.com.ampli.rapWS.entity.Product;

@Component
public class ProductRepository {
	private static final Map<Integer, Product> products = new HashMap<>();

	@PostConstruct
	public void initData() {
		Product tenisNike = new Product();
		tenisNike.setName("Tênis Nike");
		tenisNike.setPrice(200.0);
		

		products.put(1, tenisNike);
	}

	public Product find(Integer id) {
		Assert.notNull(id, "The product's ID cannot be null");
		return products.get(id);
	}

	public Collection<Product> findAll() {
		return products.values();
	}

	public void create(String name, Double price) throws Exception {
		Assert.notNull(name, "The product's name cannot be null");
		Assert.notNull(price, "The product's price cannot be null");
		if (price <= 0) {
			throw new Exception("O preço precisa ser maior que zero!");
		}
		
		Product createdProduct = new Product();
		createdProduct.setName(name);
		createdProduct.setPrice(price);
		products.put(products.size() + 1, createdProduct);
	}

	public void remove(Integer id) {
		Assert.notNull(id, "The product's ID cannot be null");
		products.remove(id);
	}
}