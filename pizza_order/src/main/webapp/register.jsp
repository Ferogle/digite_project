<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<jsp:include page="banner.jsp" />

<div class="container">
<h1>Registration Page</h1>
<form class="row g-3 mb-4" action="User" method="post">
<div class="col-md-6">
    <label for="inputEmail4" class="form-label" required>Name</label>
    <input type="text" class="form-control" id="inputEmail4" name="name" required>
  </div>
  <div class="col-md-6">
    <label for="inputEmail4" class="form-label" required>Email</label>
    <input type="email" class="form-control" id="inputEmail4" name="email">
  </div>
  <div class="col-md-6">
    <label for="inputPassword4" class="form-label"   required>Password</label>
    <input type="password" class="form-control" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" id="inputPassword4" name="password">
  </div>
  <div class="col-12">
    <label for="inputAddress" class="form-label" required>Address</label>
    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" name="address">
  </div>
  <div class="col-md-6">
    <label for="inputCity" class="form-label" required>Contact</label>
    <input type="number" class="form-control" id="inputCity" name="contact" pattern="[789][0-9]{9}" title="Must be a 10 digit valid contact number">
  </div>
  <div class="col-12">
    <button type="submit" class="btn btn-primary">Register</button>
  </div>
</form>
<div>
<span>Already Registered?<a href="home.jsp" class="btn btn-outline-primary" style="margin-left:1rem">Login</a></span>
</div>
</div>
</body>
</html>