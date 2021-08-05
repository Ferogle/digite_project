package com.pizza.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pizza.bean.LoginBean;
import com.pizza.bean.RegisterBean;
import com.pizza.service.PizzaService;
import com.pizza.service.PizzaServiceImpl;


public class TestLogin {
	
	private PizzaService service;
	private LoginBean user;
	
	@BeforeEach
	public void init() {
		service = new PizzaServiceImpl();
		user = new LoginBean();
		
	}
	
	@Test
	public void testLogin() {
		user.setEmail("sm@sr.com");
		user.setPassword("123123");
		assertNotNull(service.authenticate(user));
	}
	
	@Test
	public void testLoginFail() {
		user.setEmail("sm@sr.com");
		user.setPassword("111111");
		assertNull(service.authenticate(user));
	}
	
	
}
