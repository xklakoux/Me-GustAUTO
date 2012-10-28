<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thanks for your registration</title>
</head>
<body>
  <jsp:useBean id="clientBean" class="es.uc3m.ctw.me_gustauto.controller.ClientBean" />
  <jsp:setProperty name="clientBean" property="*" />
  <h1>Thanks for your registration</h1>
  <h4>
    Name: <jsp:getProperty name="clientBean" property="name" /><br>
    Username: <jsp:getProperty name="clientBean" property="username" /><br>
    Email: <jsp:getProperty name="clientBean" property="email" /><br>
    Address: <jsp:getProperty name="clientBean" property="address" /><br>
    Phone: <jsp:getProperty name="clientBean" property="phone" /><br>
  </h4>
  <a href="index.jsp">Back to index</a>
</body>
</html>