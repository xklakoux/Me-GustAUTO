<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Favourites</h2>
<c:forEach items="${FavList}" var="fav">
	<c:set var="autoAd" value="${fav.autoAd}"/>
	<div
		style="border-style: solid; border-width: 1px; padding: 8px; overflow: hidden;">
		<a href="ShowDetailsServlet?id=${fav.autoAd.adId}"><img
			src="res/images/car.png" width="50px" height="30px"
			style="float: left; margin-right: 20px;" /></a>
		<div>
			<div><jsp:getProperty name="autoAd" property="title" />,
				<jsp:getProperty name="autoAd" property="price" />
				&euro;
			</div>

			<div>
				<a href="AutoAdAdministrationServlet?command=df&id=${fav.favId}"><img src='res/images/delete.gif' width='13px' height='13px'></a>
			</div>
		</div>
	</div>
	<br>
</c:forEach>
