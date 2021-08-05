<%@page import="com.pizza.service.PizzaServiceImpl"%>
<%@page import="com.pizza.service.PizzaService"%>
<%@page import="com.pizza.bean.PizzaBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>
<jsp:include page="banner.jsp" />

<% 	
	List<PizzaBean> cart = (List<PizzaBean>) session.getAttribute("CART"); 
	List<String> sizes = (List<String>) session.getAttribute("SIZES");
	int idx=0;
	double total=0;				  
%>
<% if(request.getParameter("index")!=null){
	 	int index=Integer.parseInt(request.getParameter("index"));
		cart.remove(index);sizes.remove(index);
		session.setAttribute("CART",cart);
		session.setAttribute("SIZES",sizes);
	}%>
	<table class="table table-striped" border="2">
<tr><th>Code</th><th>Name</th><th>Price</th><th>Description</th><th>Image</th><th>Size and Crust</th><th>Action</th></tr>
<% if(cart == null || cart.size()==0) { %>
	<tr><th colspan="6">Your cart is empty! Add products to your cart.</th></tr>
<% } else { 
		for(int i=0;i<cart.size();i++) { %>
				<% PizzaBean p = cart.get(i); String size = sizes.get(i); %>
		<tr>
			<td><%=i+1 %></td>
			<td><%=p.getName() %></td>
			<td><%=p.getPrice() %></td>
			<td><%=p.getDescription() %></td>
			<td><img src=<%=p.getImage() %> height="50" width="50"></td>
			<td><%=size %></td>
			<td><a href="cart.jsp?index=<%=idx%>">Remove from Cart</a></td>
		</tr>
	<% idx ++; total += p.getPrice(); } %>
	<tr><th colspan="8">Cart Total : <%= total %></th></tr>
<% } %>
</table>
<div style="text-align:center;">
<a class="btn btn-primary" href="Cart">Add Pizza</a> |
<% if(cart!=null){ %> 
<a class="btn btn-outline-primary" href="Checkout?amount=<%= total %>">Checkout</a>
<% } %>
</div>
</body>
</html>

</body>
</html>