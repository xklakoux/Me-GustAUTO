<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="es.uc3m.ctw.me_gustauto.controller.MySQLConnector"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Me gustAUTO</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<div class="wrapper">
			    <h1>Hello Admin!</h1>

		
				<div id="menu">
					<ul>
						<li><a href="index.jsp">Home</a></li>
						<li><a href="?page=editprices.jsp">Edit Pricing</a></li>
						<li><a href="?page=showautos.jsp">View ads</a></li>
						<li><a href="?page=viewgenads.jsp">View general ads</a></li>
					</ul>
				</div>

			<div id="content">
				<c:choose>
					<c:when test="${param.page==null}">
						<jsp:include page="home.jsp" />
					</c:when>
					<c:otherwise>
						<jsp:include page="${param.page}" />
					</c:otherwise>
				</c:choose>
				
 

</body>
</html>
