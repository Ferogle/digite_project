<%@page import="com.pizza.bean.PizzaBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Order</title>
</head>
<body>
<%  session.removeAttribute("CART");
	session.removeAttribute("SIZES");	
%>
<jsp:include page="banner.jsp" />
<div class="container">
	<h1>Order placed successfully.</h1>
	<a href="Cart" class="btn btn-outline-primary">Continue Ordering</a>
</div>
</body>
</html>