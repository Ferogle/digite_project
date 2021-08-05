package com.pizza.service;

import java.util.List;

import com.pizza.bean.CartBean;
import com.pizza.bean.LoginBean;
import com.pizza.bean.PizzaBean;
import com.pizza.bean.RegisterBean;

public interface PizzaService {
	
	boolean addUser(RegisterBean user);
	RegisterBean authenticate(LoginBean login);
	PizzaBean getPizza(int code);
	List<PizzaBean> getCatalog();
	boolean addToCart(List<CartBean> cart);
	boolean clearCart();
	List<CartBean> fetchCart(String email);
	boolean removeFromCart(String email);
	

}
