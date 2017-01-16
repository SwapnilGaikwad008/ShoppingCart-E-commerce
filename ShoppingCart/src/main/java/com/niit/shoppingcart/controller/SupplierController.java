package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class SupplierController {
	
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("manage_supplier_remove")
	public String deleteSupplier(@RequestParam("id") String id, Model model, HttpSession session)
	{ 
		supplier = supplierDAO.get(id);
		System.out.println(supplier);
		boolean flag = supplierDAO.delete(supplier);
		
		List<Supplier> supplierList = supplierDAO.list();
		session.setAttribute("SupplierList", supplierList);
		
		String msg = "successfully";
		if(!flag == true)
			msg = "Not Successful";
		model.addAttribute("msg", msg);
		return "forward:/suppliertable";
	}
	
	@RequestMapping("manage_supplier_edit")
	public String editSupplier(@RequestParam("id") String id, Model model, HttpSession session)
	{
		supplier = supplierDAO.get(id);
		model.addAttribute("supplier", supplier);
		model.addAttribute("UserclickedEDIT", "true");
		return "admin";
	}
	
	@RequestMapping("/editsupplier")
	public String Editsupplier(Model model,HttpSession session, @RequestParam("ID") String id, @RequestParam("name") String name,@RequestParam("address") String address)
	{
		supplier.setId(id);
		supplier.setName(name);
		supplier.setAddress(address);
		
		if(supplierDAO.update(supplier))
			model.addAttribute("message","Supplier updated");
		session.setAttribute("supplier", supplier);
		List<Supplier> supplierList = supplierDAO.list();
		session.setAttribute("SupplierList", supplierList);
		model.addAttribute("EditSupplier", "true");
		return "admin";
		
	}
	
	

}
