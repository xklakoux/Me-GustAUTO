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
	<div style="text-align:center;">
		<h2>Our prices:</h2>
		<hr>
		<h3>Auto ads prices:</h3>
		<c:forEach items="${prices}" var="value">
		<c:out value="${value.name}" />
		</c:forEach>
		1 day (less than 3 months) - 0.20€<br>
		1 day (more than 3 months) - 0.15€<br>
		Yearly BestSeller Premium Special Extended Promotional Bonus Extra VIP offer - 60€<br>
		<hr>
		<h3>General ads prices:</h3>
		1 day (less than 3 months) - 55.00€<br>
		1 day (more than 3 months) - 44.25€<br>
		<hr>
	</div>
</body>
</html>