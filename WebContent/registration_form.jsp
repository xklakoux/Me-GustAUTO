<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration form</title>
</head>
<body>
  <form METHOD="POST" ACTION="RegistrationServlet">
    <h1>Client registration</h1>
    <h3>
      Name <input name="name" value=""><br>
      Username <input name="username" value=""><br>
      Address <input name="address" value=""><br>
      Phone <input name="phone" value=""><br>
      Email <input name="email" value=""><br>
      <br>
      Password <input name="password1" value=""><br>
      repeat <input name="password2" value=""><br>
      
      <br>
      <input type=submit value="Send" />
	</h3>
  </form>
</body>
</html>
