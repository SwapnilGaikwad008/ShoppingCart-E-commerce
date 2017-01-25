package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Controller
public class UserController {

	public static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDAO UserDAO;

	@Autowired
	User User;

	//@Autowired
	//private CartDAO cartDAO;

	//@Autowired
	//private MyCart myCart;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	
	@Autowired
	private HttpSession session;

	/**
	 * if invalid credentials -> Home page , login , error message if valid
	 * credentials && he is admin -> AdminHome page ,logout link if valid
	 * credentials && he is end User -> Home page, myCart, logout link
	 * 
	 * @param UserID
	 * @param password
	 * @return it will return data and page name where to return
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public ModelAndView validate(@RequestParam(value = "emailId") String emailId,
			@RequestParam(value = "password") String password) {
		log.debug("Starting of the method validate");

		// ModelAndView mv = new ModelAndView("/index");
		ModelAndView mv = new ModelAndView("/index");
		ModelAndView mu = new ModelAndView("/adminHome");
		
		User = UserDAO.isValidUser(emailId, password);
		// if the record exist with this UserID and password it will return User
		// details else will return null

		if (User != null) {
			log.debug("Valid Credentials");
			
			session.setAttribute("loggedInUser", User.getName());
			session.setAttribute("loggedInUserID", User.getId());

			session.setAttribute("User", User); //
			session.setAttribute("supplier", supplier);
			session.setAttribute("supplierList", supplierDAO.list());

			session.setAttribute("category", category);
			session.setAttribute("categoryList", categoryDAO.list());
			
			mv.addObject("loggedOut", "false");

			if (User.getRole().equals("ROLE_ADMIN")) {
				log.debug("Logged in as Admin");
				mv.addObject("isAdmin", "true");
				
				return mu; 

			} else {
				log.debug("Logged in as User");
				mv.addObject("isAdmin", "false");
				//myCart = cartDAO.list(UserID);
				//mv.addObject("myCart", myCart);
				// Fetch the myCart list based on User ID
				//List<MyCart> cartList = cartDAO.list(UserID);
				//mv.addObject("cartList", cartList);
				//mv.addObject("cartSize", cartList.size());
			}
			
			mv.addObject("successMsg", "Welcome " + User.getName() + "!!!");

		} else {
			log.debug("Invalid Credentials");

			mv.addObject("invalidCredentials", "true");
			mv.addObject("errorMsg", "Invalid Credentials");

		}
		log.debug("Ending of the method validate");
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		log.debug("Starting of the method logout");
		ModelAndView mv = new ModelAndView("/index");
		session.invalidate(); // will remove the attributes which are added
								// session
		session = request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());

		mv.addObject("successMsg", "You successfully logged out");
		mv.addObject("loggedOut", "true");
		
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
		  //  return "redirect:/login?logout";
		    
		    
		log.debug("Ending of the method logout");
		return mv;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUser(@ModelAttribute User User) {
		log.debug("Starting of the method registerUser");
		ModelAndView mv = new ModelAndView("index");
		if (UserDAO.get(User.getId()) == null) {
			User.setRole("ROLE_USER"); // all the Users are end Users by default
			UserDAO. save(User);
			log.debug("You are successfully register");
			mv.addObject("successMsg", "You are successfully registered " + User.getName() + " try logging in now !!!");
		} else {
			log.debug("User exist with this id");
			mv.addObject("errorMessage", "User exist with this id");
		}
		log.debug("Ending of the method registerUser");
		return mv;
	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(Model model) {
		log.debug("Starting of the method loginError");
		model.addAttribute("errorMessage", "Login Error");
		log.debug("Ending of the method loginError");
		return "index";

	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		log.debug("Starting of the method accessDenied");
		model.addAttribute("errorMessage", "You are not authorized to access this page");
		log.debug("Ending of the method accessDenied");
		return "index";

	}

}
