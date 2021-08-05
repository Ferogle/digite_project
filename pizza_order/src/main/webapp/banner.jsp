<%@page import="com.pizza.bean.RegisterBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pizzeria</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="media/theme.css">
</head>
<body class="background-color:white">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<%	RegisterBean user = (RegisterBean) session.getAttribute("USER");
	if(user != null) { %>
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="Cart" style="font-size:38pt">Pizzeria</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
		      <ul class="navbar-nav nav-pills mb-2 mb-lg-0">
		        <li class="nav-item">
		        	<span class="nav-link" style="font-size	:22pt;margin-right:1rem">Hello, <%=user.getName() %> </span>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" aria-current="page" href="Cart">Pizzas</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="cart.jsp">My Cart</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="profile.jsp">Profile</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="User?logout=yes">Logout</a>
		        </li>        
		      </ul>
		    </div>
		  </div>
		</nav>
<%	} else { %>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="User" style="font-size:38pt">Pizzeria</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
		      <ul class="navbar-nav nav-pills mb-2 mb-lg-0">
		        <li class="nav-item">
		        	<span class="nav-link" style="font-size	:22pt;margin-right:1rem">Hello, Guest</span>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
<%	} %>
<hr size=4 color="gold">
</body>
</html>