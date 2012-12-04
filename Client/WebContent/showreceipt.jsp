<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>Receipt for ${auto.brand} ${auto.model}</title>
</head>
<body>
<div>
	<h3>Your advertisement details:</h3>
	You want to order an advertisement of ${auto.brand} ${auto.model} <br>
	For ${param.months} month(s). <br>
	The price is ${price} € <br>
</div>
<div>
	<input type="button" value="Proceed to payment">
	<input type="button" value="Cancel">
</div>
</body>
</html>