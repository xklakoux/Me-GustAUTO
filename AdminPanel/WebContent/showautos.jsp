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

	<jsp:useBean id="autoAdListBean"
		class="es.uc3m.ctw.me_gustauto.controller.AutoAdListBean" />
	<h2>Current Offers</h2>
	<c:forEach items="${autoAdListBean.getList()}" var="autoAd">

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
							out.println("<a href='AutoAdAdministrationServlet?command=c&ad_id="
									+ ((AutoAd) pageContext.getAttribute("autoAd"))
											.getAdId()
									+ "'><img src='res/images/confirm.png' width='13px' height='13px'></a>");
							out.println("<a href='AutoAdAdministrationServlet?command=d&ad_id="
									+ ((AutoAd) pageContext.getAttribute("autoAd"))
											.getAdId()
									+ "'><img src='res/images/delete.gif' width='13px' height='13px'></a>");
											
					%>
				</div>
			</div>
		</div>
		<br>
	</c:forEach>


</body>
</html>