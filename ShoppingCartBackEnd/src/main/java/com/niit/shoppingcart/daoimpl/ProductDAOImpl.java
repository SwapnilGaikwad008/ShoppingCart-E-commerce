package com.niit.shoppingcart.daoimpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;
@Repository("productDAO")
@EnableTransactionManagement
public class ProductDAOImpl implements ProductDAO {


	@Autowired
	SessionFactory sessionFactory;


	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Product> list() {

		String hql = "from Product";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();

	}
	
	@Transactional
	public Product get(String id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);

	}

	@Transactional
	public Product validate(String id, String password) {
		String hql = "from Product where id ='" + id + "'  and password='" + password + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return (Product) query.uniqueResult();
	}

	@Transactional
	public boolean save(Product product) {

		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

}

