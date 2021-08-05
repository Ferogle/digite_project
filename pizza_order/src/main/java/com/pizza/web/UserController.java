package com.pizza.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.bean.CartBean;
import com.pizza.bean.LoginBean;
import com.pizza.bean.PizzaBean;
import com.pizza.bean.RegisterBean;
import com.pizza.service.PizzaService;
import com.pizza.service.PizzaServiceImpl;

@WebServlet(name = "User", urlPatterns = { "/User" })
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private PizzaService service;
	
	@Override
	public void init(){
		service = new PizzaServiceImpl();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		RegisterBean user = (RegisterBean)session.getAttribute("USER");
		if(request.getParameter("logout")!=null) {
			service.removeFromCart(user.getEmail());
			List<PizzaBean> pizza_cart=(List<PizzaBean>)session.getAttribute("CART");
			List<String> sizes = (List<String>)session.getAttribute("SIZES");
			
			if(pizza_cart!=null) {
				List<CartBean> cart = new ArrayList<CartBean>();
				for(int i=0;i<pizza_cart.size();i++) {
					CartBean item=new CartBean();
					PizzaBean p = pizza_cart.get(i);
					String s = sizes.get(i);
					item.setPizza_id(p.getCode());
					item.setSize_crust(s);
					item.setUser_id(user.getEmail());
					cart.add(item);
				}
				service.addToCart(cart);
			}
			
			session.invalidate();
			response.sendRedirect("home.jsp");
		}
		else {
			String referer = request.getHeader("referer");
			if(referer.equals("http://localhost:8980/") || referer.contains("home")) {
				LoginBean login = new LoginBean();
				login.setEmail(request.getParameter("email"));
				login.setPassword(request.getParameter("password"));
				user = service.authenticate(login);
				if(user!=null) {
					List<CartBean> pizza_cart=service.fetchCart(user.getEmail());
					List<PizzaBean> cart = new ArrayList<PizzaBean>();
					List<String> sizes = new ArrayList<String>();
					if(pizza_cart!=null) {
						for(CartBean cb:pizza_cart) {
							PizzaBean piz = service.getPizza(cb.getPizza_id());
							String size_crust=cb.getSize_crust();
							cart.add(piz);
							sizes.add(size_crust);
						}
						session.setAttribute("CART", cart);
						session.setAttribute("SIZES", sizes);
					}
				
					session.setAttribute("USER", user);
					response.sendRedirect("Cart");
				}
				else {
					response.sendRedirect("home.jsp?invalid=yes");
				}
			}
			else {
				
				user = new RegisterBean();
				user.setEmail(request.getParameter("email"));
				user.setPassword(request.getParameter("password"));
				user.setName(request.getParameter("name"));
				user.setAddress(request.getParameter("address"));
				user.setContact(request.getParameter("contact"));

				if (service.addUser(user)) {
					// Registration successful
					response.sendRedirect("home.jsp");
					
				} else {
					// Registration failed
					response.sendRedirect("register.jsp");
				}
				
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
