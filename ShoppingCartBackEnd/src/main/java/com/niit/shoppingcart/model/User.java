package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class User {
	
	public String id;
	
	public String name;
	
	public String password;
	
	public String mail;
	
	public String contact;
	
	public String role;

}
