package com.pizza.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pizza.bean.CartBean;
import com.pizza.bean.LoginBean;
import com.pizza.bean.PizzaBean;
import com.pizza.bean.RegisterBean;
import com.pizza.util.JdbcFactory;

public class PizzaDaoImpl implements PizzaDao {

	@Override
	public boolean persist(RegisterBean user) throws SQLException {
		String sql = "insert into users values (?,?,?,?,?)";
		Connection conn = null;
		try {
			conn = JdbcFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getAddress());
			stmt.setString(5, user.getContact());
			stmt.executeUpdate();
			return true;
		} finally {
			conn.close();
		}
	}

	@Override
	public RegisterBean validate(LoginBean login) throws SQLException {
		String sql="select * from users where email=? and password=?";
		Connection conn=null;
		RegisterBean user=null;
		try {
			conn = JdbcFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, login.getEmail());
			stmt.setString(2, login.getPassword());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new RegisterBean();
				user.setEmail(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setName(rs.getString(3));
				user.setAddress(rs.getString(4));
				user.setContact(rs.getString(5));
			}
			return user;
			
		}finally {
			conn.close();
		}
	}

	@Override
	public PizzaBean fetchPizza(int code) throws SQLException {
		
		String sql = "select * from pizza where code="+code;
		Connection conn=null;
		PizzaBean pizza=null;
		try {
			conn=JdbcFactory.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				pizza = new  PizzaBean();
				pizza.setCode(rs.getInt(1));
				pizza.setName(rs.getString(2));
				pizza.setPrice(rs.getDouble(3));
				pizza.setImage(rs.getString(4));
				pizza.setDescription(rs.getString(5));
			}
			return pizza;
		}finally{
			conn.close();
		}
		
	}

	@Override
	public List<PizzaBean> fetchPizzas() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from pizza";
		Connection conn=null;
		List<PizzaBean> catalog = new ArrayList<PizzaBean>();
		try {
			
			conn=JdbcFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				PizzaBean pizza = new PizzaBean();
				pizza.setCode(rs.getInt(1));
				pizza.setName(rs.getString(2));
				pizza.setPrice(rs.getDouble(3));
				pizza.setImage(rs.getString(4));
				pizza.setDescription(rs.getString(5));
				catalog.add(pizza);
			}
			return catalog;
			
		}finally {
			conn.close();
		}
	}
	
	
	public boolean updatePassword(String email,String password) throws SQLException{
		
		String sql="update users set password=? where email=?";
		Connection conn=null;
		
		try {
			conn=JdbcFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,email);
			stmt.setString(2, password);
			stmt.executeUpdate();
			return true;
		}finally {
			conn.close();
		}
		
	}

	@Override
	public boolean persistCart(int pizza_id,String size_crust,String user_id) throws SQLException {
		String sql="insert into cart values(?,?,?)";
		Connection conn = null;
		conn = JdbcFactory.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pizza_id);
			stmt.setString(2, size_crust);
			stmt.setString(3,user_id);
			stmt.executeUpdate();
			return true;
		}finally {
				conn.close();
			}
		}

	@Override
	public boolean clearCart() throws SQLException {
		// TODO Auto-generated method stub
		
		String sql="delete from cart";
		Connection conn=null;
		conn=JdbcFactory.getConnection();
		try {
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.executeUpdate();
		}finally{
			conn.close();
		}
		
		return false;
	}

	@Override
	public List<CartBean> fetchCart(String email) throws SQLException {
		System.out.println(email);
		String sql="select * from cart where email like "+"\'"+email+"\'";
		Connection conn=null;
		List<CartBean> cart = new ArrayList<CartBean>();
		try {
			conn=JdbcFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				CartBean item = new CartBean();
				item.setPizza_id(rs.getInt(1));
				item.setSize_crust(rs.getString(2));
				item.setUser_id(rs.getString(3));
				cart.add(item);
			}
			return cart;
			
		}finally {
			conn.close();
		}
	}

	@Override
	public boolean deleteFromCart(String email) throws SQLException {
		
		String sql="delete from cart where email="+"\'"+email+"\'";
		Connection conn=null;
		try {
			conn=JdbcFactory.getConnection();
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.executeUpdate();
			return true;
		}finally {
			conn.close();
		}
		
	}
	
	


}
