package com.pizza.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.bean.PizzaBean;
import com.pizza.bean.RegisterBean;
import com.pizza.service.PizzaService;
import com.pizza.service.PizzaServiceImpl;

@WebServlet(name = "Checkout", urlPatterns = { "/Checkout" })
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PizzaService service;
	
    public void init() throws ServletException{
    	service = new PizzaServiceImpl();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String referer = request.getHeader("referer");
		if(referer.contains("Cart") || referer.contains("cart")){
			double amount = Double.parseDouble(request.getParameter("amount"));
			request.setAttribute("TOTAL", amount);
			getServletContext().getRequestDispatcher("/payment.jsp").forward(request, response);
		}
		else {
			HttpSession session = request.getSession();
			List<PizzaBean> products = (List<PizzaBean>) session.getAttribute("CART");
			List<String> sizes = (List<String>) session.getAttribute("SIZES");
			RegisterBean user = (RegisterBean)session.getAttribute("USER");
			session.removeAttribute("CART");
			session.removeAttribute("SIZES");
			service.removeFromCart(user.getEmail());
			getServletContext().getRequestDispatcher("/summmary.jsp").forward(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
