<%@ page import="es.uc3m.ctw.me_gustauto.controller.MySQLConnector"%>
<%@ page import="es.uc3m.ctw.me_gustauto.model.AutoAd"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="autoAdListBean"
	class="es.uc3m.ctw.me_gustauto.controller.AutoAdListBean" />
<h2>Current Offers</h2>
<c:choose>
	<c:when test="${SEARCHRESULT}">
		<c:set var="autoAdList" value="${LIST}" />
	</c:when>
	<c:otherwise>
		<c:set var="autoAdList" value="${autoAdListBean.getList()}" />
		<c:set var="SEARCH_QUERY" value="SELECT a FROM AutoAd a"/>
	</c:otherwise>
</c:choose>

<!-- 		sorting:  -->
<%-- 		<c:out value="${SEARCH_QUERY}" /> --%>
sort by: 
<form METHOD="POST" ACTION="SortSearchResults">
	<input type="hidden" name="query" value="${SEARCH_QUERY}"/>
	<select name="field">
		<option value="price">price</option>
		<option value="brand">brand</option>
		<option value="engine">model</option>
		<option value="mileage">mileage</option>
		<option value="title">title</option>
		<option value="engine">engine</option>
		<option value="validTo">valid to</option>
		<option value="addDate">date added</option>
		<option value="registrationNumber">registration number</option>
		<option value="user.username">user</option>
	</select> 
	<select name="order">
		<option value="ASC">ascending</option>
		<option value="DESC">descending</option>
	</select>
	<input type="SUBMIT" value="sort"/>
</form>

<c:forEach items="${autoAdList}" var="autoAd">
	<div
		style="border-style: solid; border-width: 1px; padding: 8px; overflow: hidden;">
		<a href="index.jsp?page=showdetails.jsp&id=${autoAd.adId}"><img
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
							<a href="AutoAdAdministrationServlet?command=c&id=${autoAd.adId}"><img
								src='res/images/confirm.png' width='13px' height='13px'></a>
						</c:if>
						<a href="AutoAdAdministrationServlet?command=d&id=${autoAd.adId}"><img
							src='res/images/delete.gif' width='13px' height='13px'></a>
					</c:if>
					<%
						if (MySQLConnector.favDoesNotExist((String) session
										.getAttribute(MySQLConnector.USERNAME_OF_CLIENT),
										((AutoAd) pageContext.getAttribute("autoAd"))
												.getAdId())) {
									out.println("<a href='AutoAdAdministrationServlet?command=af&id="
											+ ((AutoAd) pageContext.getAttribute("autoAd"))
													.getAdId() + "'>Add to Favourites</a>");
								}
					%>
				</c:if>
			</div>
		</div>
	</div>
	<br>
</c:forEach>
