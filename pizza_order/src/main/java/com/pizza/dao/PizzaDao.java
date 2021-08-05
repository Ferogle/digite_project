package com.pizza.dao;

import java.sql.SQLException;
import java.util.List;

import com.pizza.bean.CartBean;
import com.pizza.bean.LoginBean;
import com.pizza.bean.PizzaBean;
import com.pizza .bean.RegisterBean;

public interface PizzaDao {
	

		boolean persist(RegisterBean user) throws SQLException;
		
		RegisterBean validate(LoginBean login) throws SQLException;
		
		PizzaBean fetchPizza(int code) throws SQLException;
		
		List<PizzaBean> fetchPizzas() throws SQLException;
		
		boolean persistCart(int pizza_id,String size_crust,String user_id) throws SQLException;
		
		boolean clearCart() throws SQLException;
		
		List<CartBean> fetchCart(String email) throws SQLException;
		
		boolean deleteFromCart(String email) throws SQLException;
				
}
