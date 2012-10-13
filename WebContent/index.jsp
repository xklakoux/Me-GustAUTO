<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>Welcome to Me-GustAUTO</title>
  </head>
  <body>
    <h1>Welcome to Me-GustAUTO</h1>
    <%
    Object client = session.getAttribute("CLIENT_IS_LOGGED_IN");
    if (client != null && (Boolean) client) {
    	out.println("<a href='LoginServlet'>Log out</a><br>");
    } else {
    	out.println("<a href='login.jsp'>Log in</a><br>");
    }
    %>
    <a href="registration_form.jsp">Registration form</a><br>
    <br>
    <a href="content.jsp">SHOW CONTENT!</a>
  </body>
</html>
