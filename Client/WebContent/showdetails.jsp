<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="es.uc3m.ctw.me_gustauto.controller.MySQLConnector"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"
	type="text/javascript"></script>
<script>
$(function() {
    $("textarea").focus(function(event) {
    
          // Erase text from inside textarea
        $(this).text("");
    
          // Disable text erase
        $(this).unbind(event);
    });
});​
</script>
<title>Detailed ad</title>
<style type="text/css" media="screen">
body {
	font: 12px arial, helvetica, sans-serif;
}
</style>
</head>
<body>
	<c:if test="${param.sent}">
		<div class="confirm">Message successfully sent!</div>
	</c:if>

	<jsp:useBean id="autoAdBean"
		class="es.uc3m.ctw.me_gustauto.controller.AutoAdBean" />
	<jsp:setProperty name="autoAdBean" property="*" />
	<br>

	<div style="font-weight: bold; font-size: 16px">
		${auto.title}
		<jsp:getProperty name="autoAdBean" property="title" />
	</div>

	<div
		style="border-style: solid; border-width: 1px; padding: 8px; overflow: hidden;">
		<img src="res/images/car.png" width="120px" height="72px"
			style="float: left; margin-right: 20px;" /> ${auto.brand}
		${auto.model} <br><b> engine: </b>${auto.engine}<br> <b>year of
		manufacture:</b> ${auto.years}<br> <b>mileage: </b>${auto.mileage} <br>
		<b>color:</b>${auto.colour}<br> <b>registration number:</b>
		${auto.registrationNumber}
	</div>

	<div
		style="border-style: solid; border-width: 1px; padding: 8px; overflow: hidden;">
		Description:<br> <br>
		${auto.description}
		<br>
		<br>
	</div>
	
		<jsp:useBean id="commentsListBean"
			class="es.uc3m.ctw.me_gustauto.controller.CommentsListBean" />
		<%
			commentsListBean.setAd_id(Integer.valueOf(request.getParameter("id")));
		%>
	
	<c:if test="${CLIENT_IS_LOGGED_IN}">

		<div class="contact_seller">
			<form method="POST" action="SendEmailServlet">
				<input type="hidden" value="${param.id}" name="id">
				<textarea cols="30" rows="5" name="message" onfocus="">
Hi there,
I'm interested in this advertisment...
	</textarea>
				<br /> <input type="submit" value="Send to the owner">
			</form>
		</div>


		<div>
			<h4>Add your comment: </h4>
			<div style="border-style: solid; border-width: 1px; padding: 8px;">
				<form METHOD="POST" ACTION="AddComment">
					<input type="hidden" name="ad_id"
						value="<%=request.getParameter("id")%>">
					<textarea rows="5" cols="50" name="content"></textarea>
					<br> <br> <input type=submit value="Add" />
				</form>
			</div>
		</div>
	</c:if>
	<h4>Comments:</h4>

	<c:forEach items="${commentsListBean.getList()}" var="comment">
		<div
			style="border-style: solid; border-width: 1px; padding: 8px; overflow: hidden;">
			<c:out value="${comment.getContent() }" />
			-
			<c:out value="${comment.getUser().getUsername()}" />
			,<i><fmt:formatDate value="${comment.getDateAdded()}"
					pattern=" d MMM yyyy 'at' hh:mm a " /></i> <br>
		</div>
	</c:forEach>


</body>
</html>
