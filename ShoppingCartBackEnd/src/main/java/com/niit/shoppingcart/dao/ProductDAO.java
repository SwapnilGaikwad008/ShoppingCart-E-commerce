package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;

public interface ProductDAO {

	public List<Product> list();

	public Product get(String id);

	public Product validate(String id, String password);

	public boolean save(Product product);

	public boolean update(Product product);

}
