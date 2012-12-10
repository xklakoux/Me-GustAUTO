<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>Payment</title>
</head>
<body>
	<div>
		<c:if test="${bad_data}">
			<div style='color: red;'>
				Wrong data input<br>
			</div>
		</c:if>
		
		<form action="PaymentVerificationServlet">
		Credit card number:<input type="text" name="number1" maxlength="4" size="4">
		<input type="text" name="number2" maxlength="4" size="4">
		<input type="text" name="number3" maxlength="4" size="4">
		<input type="text" name="number4" maxlength="4" size="4"><br>
		Expiry date:<br>   
		Month/Year:<input type="text" name="month" maxlength="2" size="2">/
		<input type="text" name="year" maxlength="2" size="2"><br>
		
		<input type="hidden" name="ad_type" value="${param.ad_type}">
		<input type="hidden" name="id" value="${param.id}">
		<input type="hidden" name="price" value="${param.price}">
		
		<input type="submit" value="I want to pay ${param.price} €.">
		</form>	
	</div>
</body>
</html>