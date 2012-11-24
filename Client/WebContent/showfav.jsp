<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="favListBean" class="es.uc3m.ctw.me_gustauto.controller.FavListBean" />
<h2>Favourites</h2>
<c:forEach items="${favListBean.getList(USERNAME_OF_CLIENT)}" var="fav">
	<c:set var="autoAd" value="${fav.autoAd}"/>
	<div
		style="border-style: solid; border-width: 1px; padding: 8px; overflow: hidden;">
		<a href="?page=showdetails.jsp&id=${fav.autoAd.adId}"><img
			src="res/images/car.png" width="50px" height="30px"
			style="float: left; margin-right: 20px;" /></a>
		<div>
			<div><jsp:getProperty name="autoAd" property="title" />,
				<jsp:getProperty name="autoAd" property="price" />
				&euro;
			</div>

			<div>
				<a href="AutoAdAdministrationServlet?command=df&id=${fav.id}"><img src='res/images/delete.gif' width='13px' height='13px'></a>
			</div>
		</div>
	</div>
	<br>
</c:forEach>

