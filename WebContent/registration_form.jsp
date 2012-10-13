<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration form</title>
</head>
<body>
  <%
  String username = request.getParameter("username");
  String name = request.getParameter("name");
  String email = request.getParameter("email");
  String password1 = request.getParameter("password1");
  String password2 = request.getParameter("password2");
  boolean alright = true;
  %>
  <jsp:useBean id="clientBean" class="es.uc3m.ctw.me_gustauto.ClientBean" />
  <jsp:setProperty name="clientBean" property="*" />
  <form METHOD="POST" ACTION="registration_form.jsp">
    <h1>Client registration</h1>
    <h4>
      <% if (username != null && username.length() == 0) {out.print("<div style='color:red;'>Username cannot be empty</div>"); alright = false;}%>
      Username* <input name="username" value="<jsp:getProperty name="clientBean" property="username" />"><br>
      <% if (name != null && name.length() == 0) {out.print("<div style='color:red;'>Name cannot be empty</div>"); alright = false;}%>
      Name* <input name="name" value="<jsp:getProperty name="clientBean" property="name" />"><br>
      <% if (email != null && email.length() == 0) {out.print("<div style='color:red;'>Email cannot be empty</div>"); alright = false;}%>
      Email* <input name="email" value="<jsp:getProperty name="clientBean" property="email" />"><br>
      Address <input name="address" value="<jsp:getProperty name="clientBean" property="address" />"><br>
      Phone <input name="phone" value="<jsp:getProperty name="clientBean" property="phone" />"><br>
      <br>
      <%
      if (password1 != null && password2 != null) {
    	  if (!password1.equals(password2)) {
    		  out.print("<div style='color:red;'>Passwords must be equals</div>");
    		  alright = false;
    	  } else if (password1.length() < 6) {
    		  out.print("<div style='color:red;'>Password must contain of at least 6 characters</div>");
    		  alright = false;
    	  }
      } else {
    	  alright = false;
      }
      %>
      Password <input name="password1" value="<jsp:getProperty name="clientBean" property="password1" />"><br>
      repeat <input name="password2" value=""><br>
      <br>
      <input type=submit value="Send" />
	</h4>
  </form>
  <a href="index.jsp">Back to index</a>
  <%
  if (alright) {
	  clientBean.storeClient();
	  config.getServletContext().getRequestDispatcher("/thanks.jsp").forward(request, response);  
  }
  %>
</body>
</html>
