package com.niit.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String homepage()
	{
	System.out.println("Executing the  method of homepage");
	
	
	
	return "Home";
	}
	
	@RequestMapping("/login")
	public ModelAndView showLoginpage()
	{
	ModelAndView mv = new ModelAndView("Home");
	mv.addObject("msg","You Clicked login link");
	mv.addObject("LoadPage", "login");
	return mv;
	}

	
	@RequestMapping("/register")
	public ModelAndView showRegistrationpage()
	{
	
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("msg","You Clicked registration link");
		mv.addObject("LoadPage", "registration");
		return mv;
		}
	
	@RequestMapping("/validate")
	public ModelAndView validate(@RequestParam("id") String id, @RequestParam("password") String pwd, Object isValidCredentials)
	{
		System.out.println("In validate method");
		
		System.out.println("id: " + id);
		System.out.println("pwd: " + pwd);
		System.out.println("Correct credentials");
		
		ModelAndView mv = new ModelAndView("Home");
		
		

		return mv;
	}
}
