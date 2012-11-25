<%@ page import="es.uc3m.ctw.me_gustauto.controller.MySQLConnector"%>
<%@ page import="es.uc3m.ctw.me_gustauto.model.AutoAd"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="autoAdListBean" class="es.uc3m.ctw.me_gustauto.controller.AutoAdListBean" />
<h2>Current Offers</h2>
<c:choose>
	<c:when test="${SEARCHRESULT}">
		<c:set var="autoAdList" value="${LIST}"/>
	</c:when>
	<c:otherwise>
		<c:set var="autoAdList" value="${autoAdListBean.getList()}"/>
	</c:otherwise>
</c:choose>
<c:forEach items="${autoAdList}" var="autoAd">

	<div
		style="border-style: solid; border-width: 1px; padding: 8px; overflow: hidden;">
		<a href="?page=showdetails.jsp&id=${autoAd.adId}"><img
			src="res/images/car.png" width="50px" height="30px"
			style="float: left; margin-right: 20px;" /></a>
		<div>
			<div><jsp:getProperty name="autoAd" property="title" />,
				<jsp:getProperty name="autoAd" property="price" />
				&euro;
			</div>

			<div>
				<c:if test="${CLIENT_IS_LOGGED_IN}">
					<c:if test="${IS_ADMIN}">
					<c:if test="${autoAd.getValidTo() == null}">
						<a href="AutoAdAdministrationServlet?command=c&id=${autoAd.adId}"><img src='res/images/confirm.png' width='13px' height='13px'></a>
					</c:if>
					<a href="AutoAdAdministrationServlet?command=d&id=${autoAd.adId}"><img src='res/images/delete.gif' width='13px' height='13px'></a>
					</c:if>
					<%
					if (MySQLConnector.favDoesNotExist((String) session.getAttribute(MySQLConnector.USERNAME_OF_CLIENT), ((AutoAd) pageContext.getAttribute("autoAd")).getAdId())) {
						out.println("<a href='AutoAdAdministrationServlet?command=af&id="
								+ ((AutoAd) pageContext.getAttribute("autoAd")).getAdId()
								+ "'>Add to Favourites</a>");
					}
					%>
				</c:if>
			</div>
		</div>
	</div>
	<br>
</c:forEach>
