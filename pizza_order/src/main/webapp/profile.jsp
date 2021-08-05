<%@page import="com.pizza.bean.RegisterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<jsp:include page="banner.jsp" />
<% RegisterBean user = (RegisterBean) session.getAttribute("USER");%>

<div class="card text-center" style="width:30%;margin:auto;">
  <div class="card-header" style="height:18rem;width:100%;">
    <img src="media/profile.png" style="height:100%;width:100%;">
  </div>
  <div class="card-body">
    <h3 class="card-title"><%=user.getName()%></h5>
    <p class="card-text"><%=user.getEmail() %></p>
    <p class="card-text"><%=user.getAddress() %></p>
    <button class="btn btn-primary text-bold">Contact:<%=user.getContact()%></button>
  </div>
</div>
</body>
</html>