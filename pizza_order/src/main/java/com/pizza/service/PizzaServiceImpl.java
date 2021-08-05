package com.pizza.service;

import java.sql.SQLException;
import java.util.List;

import com.pizza.bean.CartBean;
import com.pizza.bean.LoginBean;
import com.pizza.bean.PizzaBean;
import com.pizza.bean.RegisterBean;
import com.pizza.dao.PizzaDao;
import com.pizza.dao.PizzaDaoImpl;
import com.pizza.util.PasswordEncoder;

public class PizzaServiceImpl implements PizzaService {
	
	private PizzaDao dao;
	
	public PizzaServiceImpl() {
		dao=new PizzaDaoImpl();
	}

	@Override
	public boolean addUser(RegisterBean user) {
		user.setPassword(PasswordEncoder.encode(user.getPassword()));
		
		try {
			return dao.persist(user);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public RegisterBean authenticate(LoginBean login) {
		login.setPassword(PasswordEncoder.encode(login.getPassword()));
		try {
			return dao.validate(login);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public PizzaBean getPizza(int code) {
		try {
			return dao.fetchPizza(code);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<PizzaBean> getCatalog() {
		try {
			return dao.fetchPizzas();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public boolean addToCart(List<CartBean> cart) {
		try {
			boolean ans=true;
			for(CartBean c:cart) {
				ans&=dao.persistCart(c.getPizza_id(), c.getSize_crust(), c.getUser_id());
			}
			return ans;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean clearCart() {
		try {
			return dao.clearCart();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<CartBean> fetchCart(String email) {
		// TODO Auto-generated method stub
		try {
			return dao.fetchCart(email);
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean removeFromCart(String email) {
		try {
			return dao.deleteFromCart(email);
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

}
