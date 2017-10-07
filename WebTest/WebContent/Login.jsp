<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<form action="./LoginServlet" method="post">
	User <input name="usr" type="text" value=""><br>
	Password <input name="pwd" type="password" value=""><br>
	<input type="submit" value="Login" class="button">	
</form>
</body>
</html>