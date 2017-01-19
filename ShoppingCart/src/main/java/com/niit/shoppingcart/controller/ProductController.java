package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class ProductController {
	
	@Autowired
	 Product product;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Category category;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("manage_product_remove")
	public String DeleteProduct(@ModelAttribute("id") String id, Model model, HttpSession session )
	{
		product = productDAO.get(id);
		System.out.println(product);
		boolean flag = productDAO.delete(product);
		List<Product> productList = productDAO.list();
		session.setAttribute("ProductList", productList);
		String msg = "successfully done";
		if(!flag==true)
			msg = "Not successful";
		return "/forward:/producttable";
		
	}
	
	@RequestMapping("manage_product_edit")
	public String editproduct(@ModelAttribute("id") String id, Model model, HttpSession session)
	{
		product = productDAO.get(id);
		model.addAttribute("product", product);
		
		model.addAttribute("UserClickedPRODUCTEDIT", "true");
		return "admin";
	}
	
	@RequestMapping("/editproduct")
	public String Editproduct(Model model,HttpSession session, @ModelAttribute("id") String id, @ModelAttribute("name") String name, @ModelAttribute("price") String price, @ModelAttribute("stock") String stock, @ModelAttribute("category_id") String category_id, @ModelAttribute("supplier_id") String supplier_id)
	{
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		product.setStock(stock);
		product.setCategory_id(category_id);
		product.setSupplier_id(supplier_id);
	if(productDAO.update(product))
	{
	   model.addAttribute("message", "Product Added");
	session.setAttribute("product", product);
	List<Product> productList = productDAO.list();
	session.setAttribute("ProductList", productList);
	}
	else{
		model.addAttribute("message", "Error Occurred");
		model.addAttribute("EditProduct", "true");
		
	}
	 return "admin";
	}
	
	
}
