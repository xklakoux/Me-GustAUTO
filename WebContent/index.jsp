<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="es.uc3m.ctw.me_gustauto.MySQLConnector"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page errorPage="error.jsp" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Me gustAUTO</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<div class="wrapper">
		<div id="header_container">
			<div id="header"></div>
			<div id="login">
				<%
					if (session.getAttribute(MySQLConnector.USERNAME_OF_CLIENT) == null) {
				%>

				<jsp:include page="login.jsp" />
			</div>

		</div>

		<div id="menu">
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="?page=prices.jsp">Pricing</a></li>
				<li><a href="?page=search.jsp">Search</a></li>
				<li><a href="?page=contact.jsp">Contact</a></li>
				<li><a href="?page=registration_form.jsp">Register</a></li>


			</ul>

		</div>

		<%
			} else {
		%>
		Hello, <%=session.getAttribute(MySQLConnector.IS_ADMIN) %>
		<%=session
						.getAttribute(MySQLConnector.USERNAME_OF_CLIENT)%>
		<a href="LoginServlet">logout</a>

	</div>

	</div>
	<div id="menu">
		<ul>

			<li><a href="index.jsp">Home</a></li>
			<li><a href="?page=addauto.jsp">Add Auto Ad</a></li>
			<li><a href="?page=addgenad.jsp">Add General Ad</a></li>
			<li><a href="?page=prices.jsp">Pricing</a></li>
			<li><a href="?page=search.jsp">Search</a></li>
			<li><a href="?page=contact.jsp">Contact</a></li>

		</ul>

	</div>

	<%
		}
	%>
	<div class="container">
		<div id="bar-search">
			<jsp:include page="bar-search.jsp" />
		</div>
		<div id="content">

			<%
				if (request.getParameter("page") == null) {
			%>
			<jsp:include page="showautos.jsp" />
			<%
				} else {
			%>
			<jsp:include page="<%=request.getParameter("page")%>" />
			<%
				}
			%>
		</div>

		<div id="bar-ads">
			<jsp:include page="bar-ads.jsp" />
		</div>
	</div>
	<div id="footer_container">
		<div id="footer">Footer Content</div>
	</div>
	</div>
</body>
</html>