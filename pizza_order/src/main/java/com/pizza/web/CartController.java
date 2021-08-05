package com.pizza.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.bean.CartBean;
import com.pizza.bean.PizzaBean;
import com.pizza.bean.RegisterBean;
import com.pizza.service.PizzaService;
import com.pizza.service.PizzaServiceImpl;

@WebServlet(name = "Cart", urlPatterns = { "/Cart" })
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PizzaService service;
	
	@Override
	public void init() throws ServletException {
		service = new PizzaServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("pcode");
		System.out.println(code);
		System.out.println("code here");
		String size=request.getParameter("sizeCrust");
		if(code!=null) {
			HttpSession session = request.getSession();
			PizzaBean pizza = service.getPizza(Integer.parseInt(code));
			List<PizzaBean> cart = (List<PizzaBean>) session.getAttribute("CART");
			List<String> sizes = (List<String>) session.getAttribute("SIZES");
			if(cart==null) {
				cart = new ArrayList<PizzaBean>();
				sizes = new ArrayList<String>(); 
			}
			cart.add(pizza);
			sizes.add(size);
			session.setAttribute("CART", cart);
			session.setAttribute("SIZES", sizes);
			getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
		}else {
			List<PizzaBean> catalog = service.getCatalog();
			System.out.println("Pizza fetched: " + catalog.size());
			
			request.setAttribute("CATALOG", catalog);
			getServletContext().getRequestDispatcher("/catalog.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
