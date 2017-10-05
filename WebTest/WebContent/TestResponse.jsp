<%@ page import="java.util.*" %>

<html>
<head><title>JSP Tutorial - implicit objects: "request"</title></head>
<body style="font-family: Helvetica, sans-serif;">
<h3>"request"</h3>
<%--
   first iterate over all headers the client provided
--%>
<%
   Enumeration enumeration = request.getHeaderNames();
%>
<p>request headers:
<table border="0" cellspacing="0" 
   cellspacing="1" bgcolor="#000000" style="margin-top:10px; margin-bottom:10px;">
<tr><td>
   <table border="0" bgcolor="#ffffff">
   <%
      while (enumeration.hasMoreElements()) {
         String key = (String)enumeration.nextElement();
   %>
   <tr>
   <td><b><%= key %></b></td><td> </td><td><%= request.getHeader(key) %></td>
   </tr>
   <%
      }
   %>
   </table>
</td></tr>
</table>
</p>
<%--
   then iterate over all submitted parameters, if any
   if none are present, just ignore the following section
--%>
<%
   if (request.getParameterNames().hasMoreElements()) { 
      enumeration = request.getParameterNames();
%>
<p>request parameters:
<table border="0" cellspacing="0" 
   cellspacing="1" bgcolor="#000000" style="margin-top:10px; margin-bottom: 10px;">
<tr><td>
   <table border="0" bgcolor="#ffffff">
   <%
      while (enumeration.hasMoreElements()) {
         String key = (String)enumeration.nextElement();
   %>
   <tr>
   <td><b><%= key %></b></td><td> </td><td><%= request.getParameter(key) %></td>
   </tr>
   <%
      }
   %>
   </table>
</td></tr>
</table>
</p>
<%
   }
%>
<%--
   finally show some other informations the request-object provides
--%>
<p>Some additional information:<br>
<table border="0" cellspacing="0" 
   cellspacing="1" bgcolor="#000000" style="margin-top:10px; margin-bottom: 10px;">
<tr><td>
<table border="0" bgcolor="#ffffff" style="margin:0px;">
<tr>
<td><b>Preferred Locale</b></td><td> </td><td><%= request.getLocale() %></td>
</tr>
<tr>
<td><b>Your host</b></td><td> </td><td><%= request.getRemoteAddr() %></td>
</tr>
<tr>
<td><b>Your query</b></td><td> </td><td><%= request.getQueryString() %></td>
</tr>
</table>
</td></tr>
</table>
</p>
<%--
The following input will appear as "Your result" after submitting
--%>
Your input:<br>
<form action = "/examples/code_implicit_request_object.jsp" method="GET">
<input type="hidden" name="hiddenParm" value="hiddenValue">
<input type="text" name="freistil">
<input type="submit" name="form_submit" value="ok">
</form>
</body>
</html>