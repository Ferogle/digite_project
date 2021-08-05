package com.pizza.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pizza.bean.RegisterBean;
import com.pizza.service.PizzaService;
import com.pizza.service.PizzaServiceImpl;

public class TestRegister {
	
	private RegisterBean user;
	private PizzaService service;
	
	@BeforeEach
	public void init() {
		service=new PizzaServiceImpl();
		
	}
	
	@Test
	public void testRegistration() {
		assertEquals(false,service.addUser(user),"User already exists");
		user=new RegisterBean();
		user.setAddress("Bangalore");
		user.setContact("9123456789");
		user.setName("Ram");
		user.setEmail("ram@sr.com");
		user.setPassword("1234");
	}
	
	@Test
	public void testRegistrationFail() {
		user.setContact("1111111111111");
		user=new RegisterBean();
		user.setAddress("Bangalore");
		user.setName("Ram");
		user.setEmail("ram@sr.com");
		user.setPassword("1234");
		assertEquals(false,service.addUser(user),"Invalid Details");
	}

}
