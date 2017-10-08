<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="dev.testlogin.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MainPaige</title>
</head>
<body>
<%
	User user = (User) request.getAttribute("user");
%>
Hello <% out.println(user.getUname()); %> <br>
Your login was successful.

<form action="./SendMailServlet" method="post">
	<input type="submit" value="Send Mail" class="button">
</form>
</body>
</html>