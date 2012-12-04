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
	<%@ page import="model.GeneralAd"%>
	<%@ page import="es.uc3m.ctw.me_gustauto.controller.MySQLConnector"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<hr>
	<p>List of general ads</p>
	<hr>

	<form action="ViewGenAdServlet" method="post">
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

	<c:forEach items="${list}" var="genAd">

		<div
			style="border-style: solid; border-width: 1px; padding: 8px; overflow: hidden;">

			<div>
				<div><jsp:getProperty name="genAd" property="title" />,
					<jsp:getProperty name="genAd" property="descr" />
				</div>

				<div>
					<%
						//Object admin = session.getAttribute(MySQLConnector.IS_ADMIN);
												
							if ( !((GeneralAd)pageContext.getAttribute("genAd")).getValid()	)  {
								out.println("<a href='GenAdAdministrationServlet?command=c&ad_id="
										+ ((GeneralAd) pageContext.getAttribute("genAd"))
												.getAdId()
												+ "&list_type="+request.getParameter("list_type")+"'><img src='res/images/confirm.png' width='13px' height='13px'></a>");
							}
							out.println("<a href='GenAdAdministrationServlet?command=d&ad_id="
									+ ((GeneralAd) pageContext.getAttribute("genAd"))
											.getAdId()+ "&list_type="+request.getParameter("list_type")+"'><img src='res/images/delete.gif' width='13px' height='13px'></a>");
					%>
				</div>
			</div>
		</div>
		<br>
	</c:forEach>
</body>
</html>