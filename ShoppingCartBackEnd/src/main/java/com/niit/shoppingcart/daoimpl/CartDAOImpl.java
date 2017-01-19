package com.niit.shoppingcart.daoimpl;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;

@Repository("CartDAO")
public class CartDAOImpl implements CartDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
    
	@Transactional
	public boolean save(Cart cart) {
		  try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean update(Cart cart) {
		 try {
			if(get(cart.getId())== null){
				 return false;
			 }
			 cart = (Cart)sessionFactory.getCurrentSession().merge(cart);
			 sessionFactory.getCurrentSession().update(cart);
			 return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean delete(int id) {
		
		return false;
	}
	@Transactional
	public Cart get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public Long getTotalAmount(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public List<Cart> getbyUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}


}
