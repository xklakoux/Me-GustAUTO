<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin view - confirm and delete ads</title>
</head>
<body>
	<%@ page import="model.AutoAd"%>
	<%@ page import="es.uc3m.ctw.me_gustauto.controller.MySQLConnector"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h2>Current Offers</h2>

	<form action="ShowAutosServlet" method="post">
		<select name="list_type">
			<option value="0">Only unconfirmed ads</option>
			<option value="1" 			
			<c:if test="${param.list_type == '1' }">
				selected="selected"
			</c:if>
			 >All ads</option>
		</select> 
		<input type="submit" value="OK">
	</form>

	<c:forEach items="${list}" var="autoAd">
		<div
			style="border-style: solid; border-width: 1px; padding: 8px; overflow: hidden;">
			<a href="?page=showdetails.jsp&id=123"><img
				src="res/images/car.png" width="50px" height="30px"
				style="float: left; margin-right: 20px;" /></a>
			<div>
				<div><jsp:getProperty name="autoAd" property="brand" />
					<jsp:getProperty name="autoAd" property="model" />,
					<jsp:getProperty name="autoAd" property="description" />,
					<jsp:getProperty name="autoAd" property="price" />
					&euro;
				</div>

				<div>
					<%
						if (!((AutoAd) pageContext.getAttribute("autoAd")).getValid()) {
								out.println("<a href='AutoAdAdministrationServlet?command=c&ad_id="
										+ ((AutoAd) pageContext.getAttribute("autoAd"))
										.getAdId()
										+ "&list_type="+request.getParameter("list_type")+"'><img src='res/images/confirm.png' width='13px' height='13px'></a>");
							}
							out.println("<a href='AutoAdAdministrationServlet?command=d&ad_id="
									+ ((AutoAd) pageContext.getAttribute("autoAd"))
									.getAdId()
									+ "&list_type="+request.getParameter("list_type")+"'><img src='res/images/delete.gif' width='13px' height='13px'></a>");
					%>
				</div>
			</div>
		</div>
		<br>
	</c:forEach>


</body>
</html>