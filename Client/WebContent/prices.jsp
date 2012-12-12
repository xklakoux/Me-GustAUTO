<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Price list</title>
</head>
<body>
	<div>
		<h2>Our prices:</h2><br>
		<table style="margin:0 auto;">
			<c:forEach var="price" items="${prices}">
				<tr>
					<td>${price.typ} advertisment for ${price.months} months</td>
					<td>${price.price}&euro;</td>
				</tr>
			</c:forEach>
		</table>

		<hr>
	</div>
</body>
</html>