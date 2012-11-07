<%@ page import="es.uc3m.ctw.me_gustauto.controller.AutoAdBean"%>
<%@ page import="es.uc3m.ctw.me_gustauto.controller.MySQLConnector"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="autoAdListBean"
	class="es.uc3m.ctw.me_gustauto.controller.AutoAdListBean" />
<h2>Current Offers</h2>
<c:forEach items="${autoAdListBean.getList()}" var="autoAdBean">

	<div
		style="border-style: solid; border-width: 1px; padding: 8px; overflow: hidden;">
		<a href="?page=showdetails.jsp&id=${autoAdBean.ad_id}"><img
			src="res/images/car.png" width="50px" height="30px"
			style="float: left; margin-right: 20px;" /></a>
		<div>
			<div><jsp:getProperty name="autoAdBean" property="title" />,
				<jsp:getProperty name="autoAdBean" property="price" />
				&euro;
			</div>

			<div>
				<%
				Object admin = session.getAttribute(MySQLConnector.IS_ADMIN);
				if (admin != null && (Boolean) admin) {
					if (((AutoAdBean) pageContext.getAttribute("autoAdBean")).getValid_to() == null) {
						out.println("<a href='AutoAdAdministrationServlet?command=c&ad_id="
								+ ((AutoAdBean) pageContext.getAttribute("autoAdBean")).getAd_id()
								+ "'><img src='res/images/confirm.png' width='13px' height='13px'></a>");
					}
					out.println("<a href='AutoAdAdministrationServlet?command=d&ad_id="
							+ ((AutoAdBean) pageContext.getAttribute("autoAdBean")).getAd_id()
							+ "'><img src='res/images/delete.gif' width='13px' height='13px'></a>");
				}
				%>
			</div>
		</div>
	</div>
	<br>
</c:forEach>
