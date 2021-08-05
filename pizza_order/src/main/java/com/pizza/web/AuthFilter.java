package com.pizza.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(
		urlPatterns = { 
				"/summary", 
				"/payment", 
				"/cart", 
				"/catalog",
				"/profile.jsp"
		}, 
		servletNames = { 
				"Cart", 
				"Checkout"
		})
public class AuthFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		if(session.getAttribute("USER")==null)
			((HttpServletResponse) response).sendRedirect("home.jsp");

		// pass the request along the filter chain
		else {
			
			chain.doFilter(request, response);
		}
	}


}
