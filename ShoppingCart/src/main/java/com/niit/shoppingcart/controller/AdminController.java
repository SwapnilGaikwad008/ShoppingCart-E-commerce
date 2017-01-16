package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class AdminController {
	private static Logger log = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private Product product;

	@Autowired
	private Supplier supplier;

	@Autowired
	private Category category;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@Autowired
	private ProductDAO productDAO;

	 @RequestMapping("/addcategory")
	 public String Addcategory(Model model, HttpSession session, @ModelAttribute("id") String id, @ModelAttribute("name") String name, @ModelAttribute("description") String description)
	 {
		 category.setId(id);
		 category.setName(name);
		 category.setDescription(description);
 if(categoryDAO.save(category))
	 
 {
	 model.addAttribute("message","Category added");
	 
	 session.setAttribute("category", category);
	   List<Category> categoryList = categoryDAO.list();
	   session.setAttribute("CategoryList", categoryList);
 }
 else
	 model.addAttribute("message","Error occured");
  model.addAttribute("UserClickedCATEGORY", "true");
  
  return "admin";
		} 
	 
	 
/*	 @RequestMapping("/addsupplier")
	 public String AddSupplier(Model model,HttpSession session, @RequestParam("Id") String id,@RequestParam("name") String name, @RequestParam("address") String address )
	 {
		 supplier.setId(id);
		 supplier.setName(name);
		 supplier.setAddress(address);
      if(supplierDAO.save(supplier))
      {
    	  model.addAttribute("message", "supplier added");
    	  List<Supplier> supplierList = supplierDAO.list();
    	  session.setAttribute("supplierList", supplierList);
      }else
    	  model.addAttribute("message", "Error Occured");
          model.addAttribute("UserClickedSUPPLIER", "true");
          
          return "admin";
	 }
	  
	/*@RequestMapping("Category")
	public ModelAndView categories() {
		log.debug("Starting of the method categories");
		ModelAndView mv = new ModelAndView("Category");
		mv.addObject("category", category);
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("categoryList", categoryDAO.list());
		log.debug("Ending of the method categories");
		return mv;
	}
*/
  /*	 @RequestMapping("manageProducts")
	public ModelAndView products() {
		log.debug("Starting of the method products");
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("isAdminClickedProducts", "true");
		mv.addObject("product", product);
		mv.addObject("productList", productDAO.list());
		mv.addObject("category", category);
		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("supplier", supplier);
		mv.addObject("supplierList", supplierDAO.list());
		log.debug("Ending of the method products");
		return mv;
	}*/

/*	@RequestMapping("manageSuppliers")
	public ModelAndView suppliers() {
		log.debug("Starting of the method suppliers");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("supplier", supplier);
		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("supplierList", supplierDAO.list());
		log.debug("Ending of the method suppliers");
		return mv;
	}   */
	
	 
	 @RequestMapping(value = {"/categorytable"})
		public String categorytable(Model model, HttpSession session)
		
		{
		 model.addAttribute("UserClickedViewCategoryTable", "true");
		   List<Category> categoryList = categoryDAO.list();
		   session.setAttribute("CategoryList", categoryList);
		 
		 			return "admin";
		}
	 
	 @RequestMapping("/category")
		public String Category(Model model)

		{
			model.addAttribute("UserClickedCATEGORY", "true");
			return "admin";
		}
	 
       
	 @RequestMapping(value = { "/suppliertable"})
	 public String suppliertable(Model model)
	 {
		 model.addAttribute("UserClickedViewSupplierTable", "true");
		 return "admin";
	 }
	 
	 @RequestMapping("/supplier")
	 public String Supplier(Model model)
	 {
		 model.addAttribute("UserClickedSUPPLIER", "true");
		 return "admin";
	 }
	 
	 
}