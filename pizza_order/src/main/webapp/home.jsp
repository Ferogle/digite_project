<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="media/theme.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<%@ include file="banner.jsp" %>
<div class="container justify-content-center align-items-center">

<% if(request.getParameter("invalid") != null) { %>
	<span id="err">Invalid Email ID/Password</span>
<% } %>

		
<form style="margin:auto;width:40rem;" class="mb-3" method="post" action="User">
	<b style="font-size:2rem;height:2rem" class="mb-3">Hello and Welcome to Pizzeria</b><br>
	  <div class="mb-3 mt-4">
	    <label for="exampleInputEmail1" class="form-label" name="email">Email address</label>
	    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
	    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Password</label>
	    <input type="password" class="form-control" id="exampleInputPassword1" name="password">
	  </div>
	  <button type="submit" class="btn btn-primary mb-4">Submit</button><br>
	  <span style="margin-top:10rem">Not registered yet?<a style="margin-left:1rem;" class="btn btn-outline-primary" href="register.jsp">Register</a></span>
</form>
</div>
</body>
</html>