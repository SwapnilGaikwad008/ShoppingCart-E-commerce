package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;

public interface ProductDAO {

	public List<Product> list();
	
	public List<Product> listByCategory(String categoryId);

	public Product get(String id);

	public boolean save(Product product);

	public boolean update(Product product);
	
	public boolean delete(Product product);

}
