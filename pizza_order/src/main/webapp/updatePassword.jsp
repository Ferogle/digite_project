<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% if(request.getHeader("referer").contains("invalid")) { %>
<span>Passwords should match</span>
<% } %>

<form method="post" action="User?changePassword=true">
<label for="password">Password:</label>
<input type="password" name="password"><br>
<label for="confirm_password">Confirm Password:</label>
<input type="password" name="confirm_password"><br>
<input type="submit" value="submit">;
</form>
</body>
</html>