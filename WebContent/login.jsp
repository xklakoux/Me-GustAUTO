<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
  <form METHOD="POST" ACTION="LoginServlet">
    <h1>Login</h1>
    <h4>
      Username <input name="username" value=""><br>
      Password <input name="password" value=""><br>
      <br>
      <input type=submit value="Log in" />
	</h4>
  </form>
  <a href="index.jsp">Back to index</a>
</body>
</html>