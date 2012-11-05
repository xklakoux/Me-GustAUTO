<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="es.uc3m.ctw.me_gustauto.controller.MySQLConnector"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--     <jsp:useBean id="MySQLSession" type="es.uc3m.ctw.me_gustauto.MySQLConnector" scope="session"> --%>
<%-- 			<jsp:getProperty property="MySQLSession" name="IS_ADMIN"/> --%>
<%-- </jsp:useBean> --%>
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

		<c:choose>
			<c:when test="${CLIENT_IS_LOGGED_IN}">
				<div id="header_container">
					<div id="header">
						<div id="login">

							Hello,
							<c:out value="${USERNAME_OF_CLIENT}" />
							<a href="LoginServlet">logout</a>
						</div>
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
			</c:when>
			<c:otherwise>

				<div id="header_container">
					<div id="login">
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

			</c:otherwise>
		</c:choose>

		<div class="container">
			<div id="bar-search">
				<jsp:include page="bar-search.jsp" />
			</div>
			<div id="content">
				<c:choose>
					<c:when test="${param.page==null}">
						<jsp:include page="showautos.jsp" />
					</c:when>
					<c:otherwise>
						<jsp:include page="${param.page}" />
					</c:otherwise>
				</c:choose>
			</div>

			<div id="bar-ads">
						<jsp:include page="/GeneralAdServlet" />
			</div>
		</div>
		<div id="footer_container">
			<div id="footer">Footer Content</div>
		</div>
	</div>

</body>
</html>