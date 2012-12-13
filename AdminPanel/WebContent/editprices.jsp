<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin view - edit prices</title>
</head>
<style type="text/css">
p {
	font-size: 14;
	font-weight: bold;
}

body {
	text-align: center;
}

table {
	margin-left: auto;
	margin-right: auto;
}
</style>
<body>
	<hr>
	<p>Edit prices</p>
	<hr>
	<form method="POST" action="SavePricesServlet">
		<table>
			<c:forEach var="price" items="${prices}">
				<tr>
					<td>${price.typ} advertisment for ${price.months} months</td>
					<td><input type="text" name="${price.priceId}"
						value="${price.price}">&euro;</td>
					</td>
				</tr>
			</c:forEach>
		</table>

	<hr>
	<p>Promotions</p>
	<hr>
	<table>
		<tr>
			<td>${promo.name}</td>
			<td><input type="text" name="perc" value="${promo.perc}" maxlength="2" size="2" > %</td>
			<c:choose>
			<c:when test="${promo.valid}">
			<td>Valid <input type="checkbox" name="valid"
				value="true" checked>
			</c:when>
			<c:otherwise>
			<td>Valid <input type="checkbox" name="valid"
				value="true">
			</c:otherwise>
		</c:choose>
		</tr>
	</table>
	<INPUT TYPE=Submit Value="Save">
	</form>
	<hr>
</body>
</html>