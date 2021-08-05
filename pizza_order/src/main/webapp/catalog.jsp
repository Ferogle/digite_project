<%@page import="com.pizza.bean.PizzaBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalog</title>
</head>
<body>
	<jsp:include page="banner.jsp" />
	<% List<PizzaBean> catalog = (List<PizzaBean>) request.getAttribute("CATALOG"); %>
	<div class="container background">
		<h1>Welcome to Pizza Catalogue</h1><hr>
		<div class="row">
			<% for(PizzaBean p : catalog) { %>
					<div class="card" style="width: 18rem;margin:1rem;padding:0rem">
					<form method="get" action='Cart'>
				 		<img src="<%=p.getImage() %>" class="card-img-top" alt="...">
				 		<div class="card-body d-flex flex-column">
				   			<h5 class="card-title"><%=p.getName() %></h5>
				   			<p class="card-text" style="height:3rem"><%=p.getDescription() %></p>
				   			<select name="sizeCrust" id="sizecrust">
		  						<option value="Personal">Personal Pan</option>
		  						<option value="Medium">Medium Pan</option>
		  						<option value="PersonalCheese">Personal Cheese Stuffed Crust</option>		
		  						<option value="MediumCheese">Medium Cheese Stuffed Crust</option>
							</select>
				 		</div>
				 		<input type="hidden" name="pcode" value="<%=p.getCode() %>" >
				 		<button type="submit" value="submit" class="btn btn-primary" style="width:100%;font-weight:600;">
				 			<span style="width:75%">Add</span>
				 			<span class="w-auto ml-3">Rs.<%=p.getPrice()%></span>
				 		</button>
				 	</form>
					</div>
			<% } %>
		</div>
	</div>
</body>
</html>