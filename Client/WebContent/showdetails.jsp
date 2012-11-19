<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="es.uc3m.ctw.me_gustauto.controller.MySQLConnector"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js" type="text/javascript"></script>
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
	<jsp:useBean id="autoAdBean"
		class="es.uc3m.ctw.me_gustauto.controller.AutoAdBean" />
	<jsp:setProperty name="autoAdBean" property="*" />
	<%
		//LATER: get from db by adid
		//NOW: create a fictional record
		autoAdBean.fillWithData();
	%>
	<br>

	<div style="font-weight: bold; font-size: 16px">
		<jsp:getProperty name="autoAdBean" property="title" />
	</div>

	<div
		style="border-style: solid; border-width: 1px; padding: 8px; overflow: hidden;">
		<img src="res/images/car.png" width="120px" height="72px"
			style="float: left; margin-right: 20px;" /> <b> <jsp:getProperty
				name="autoAdBean" property="brand" /> <jsp:getProperty
				name="autoAdBean" property="model" /><br>
		</b> engine: <b><jsp:getProperty name="autoAdBean" property="engine" /><br></b>
		year of manufacture: <b><jsp:getProperty name="autoAdBean"
				property="years" /><br></b> mileage: <b><jsp:getProperty
				name="autoAdBean" property="mileage" /><br></b> color: <b><jsp:getProperty
				name="autoAdBean" property="colour" /><br></b> registration
		number: <b><jsp:getProperty name="autoAdBean"
				property="registration_number" /><br></b>
	</div>

	<div
		style="border-style: solid; border-width: 1px; padding: 8px; overflow: hidden;">

		owner's username: <b><jsp:getProperty name="autoAdBean"
				property="username" /><br></b> offer valid until: <b><jsp:getProperty
				name="autoAdBean" property="valid_to" /></b> <br> Description:<br>
		<br>
		<jsp:getProperty name="autoAdBean" property="description" /><br>
		<br>
	</div>

	<div class="contact_seller" >
	<form  method="POST" action="SendEmailServlet">
	<input type="hidden" value="${param.id}" name="id">
	<textarea cols="30" rows="5" name="message" onfocus="">
	Hi there,
	I'm interested in this advertisment...
	</textarea>
	<br />
	<input type="submit" value="Send to the owner">
	</form>
	</div>
	
	
	<jsp:useBean id="commentsListBean"
		class="es.uc3m.ctw.me_gustauto.controller.CommentsListBean" />
	<%
		commentsListBean.setAd_id(autoAdBean.getAd_id());
	%>
	<c:if test="${CLIENT_IS_LOGGED_IN}">
		<div>
			<h4>Add your comment:</h4>
			<div style="border-style: solid; border-width: 1px; padding: 8px;">
				<!-- 			send ad_id parameter  -->

				<form METHOD="POST" ACTION="AddComment">
					<input type="hidden" name="ad_id"
						value="<%=autoAdBean.getAd_id()%>">
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
			
			<jsp:getProperty name="comment" property="content" />
			<br>
			<!-- 			TODO : username instead of userid -->
			from user:
			<jsp:getProperty name="comment" property="userId" />
			<%-- 		TODO:	<jsp:getProperty name="comment" property="date"> --%>
			<br>
		</div>
	</c:forEach>


</body>
</html>
