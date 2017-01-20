package com.niit.shoppingcart.controller;

import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Product;


@Controller
public class CartController {
	
	Logger log = LoggerFactory.getLogger(CartController.class);
	

	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value= "/cart", method = RequestMethod.GET)
	public String cart(Model model, HttpSession session)
	{
		log.debug("Starting of the method cart");
		model.addAttribute("cart", new Cart());
		
		String loggedInUserid = (String)session.getAttribute("loggedInUserID");
		
		int cartSize = cartDAO.getbyUser(loggedInUserid).size();
		
		if(cartSize==0){
			model.addAttribute("errorMessagecart","Empty cart");
		}
		else{
			model.addAttribute("cartList",cartDAO.getbyUser(loggedInUserid));
			model.addAttribute("totalAmount",cartDAO.getTotalAmount(loggedInUserid));
			model.addAttribute("displayCart",true);

		}
		
	return "index";	
	}
	@RequestMapping(value="/cart_add",method = RequestMethod.GET)
	public ModelAndView addToCart(@RequestParam("productName") String productName , HttpSession session)
	{
		
		//get the product based on product name
		Product product =productDAO.get(productName);

		
		cart.setProductName(product.getName());
		cart.setStock(1);
		
		
		String loggedInUserMailID = (String)session.getAttribute("loggedInUserid");
		
		
		
	
		
	    cart.setId(ThreadLocalRandom.current().nextInt(100, 1000000 + 1));
	
	
	cartDAO.save(cart);
	
	ModelAndView mv = new ModelAndView("/index");
	mv.addObject("successMessage"," Successfully add the product to Cart");

    return mv;
	}
	
	@RequestMapping("/cart_delete")
	public String removeCart(@RequestParam("id") int id, Model model) throws Exception
	{
		
		try{
			
			cartDAO.delete(id);
			model.addAttribute("successMessage" , "Successfully Removed from your cart");
			}
		catch(Exception e)
		{
			model.addAttribute("message" , e.getMessage());
			e.printStackTrace();
		}
		
		return "redirect:/index";
	}

 

}
		
	
	


