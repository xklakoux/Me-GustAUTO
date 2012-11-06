<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>Admin view - confirm and delete general ads</title>
</head>
<style>
body {
	text-align: center;
}

p {
	font-weight: bold;
}

table {
	margin-left: auto;
	margin-right: auto;
}
</style>

<body>
	<jsp:useBean id="generalAdListBean"
		class="es.uc3m.ctw.me_gustauto.controller.GenAdListBean" />
	<%@ page import="model.GeneralAd"%>
	<%@ page import="es.uc3m.ctw.me_gustauto.controller.MySQLConnector"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<hr>
	<p>List of general ads</p>
	<hr>
	<c:forEach items="${generalAdListBean.getList()}" var="genAd">

		<div
			style="border-style: solid; border-width: 1px; padding: 8px; overflow: hidden;">

			<div>
				<div><jsp:getProperty name="genAd" property="title" />,
					<jsp:getProperty name="genAd" property="descr" />					
				</div>

				<div>
					<%
						//Object admin = session.getAttribute(MySQLConnector.IS_ADMIN);
							

							out.println("<a href='AutoAdAdministrationServlet?command=c&ad_id="
									+ ((GeneralAd) pageContext.getAttribute("genAd"))
											.getAdId()
									+ "'><img src='res/images/confirm.png' width='13px' height='13px'></a>");
							out.println("<a href='AutoAdAdministrationServlet?command=d&ad_id="
									+ ((GeneralAd) pageContext.getAttribute("genAd"))
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