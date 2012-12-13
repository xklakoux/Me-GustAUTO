<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<hr>
		<p>Statistics</p>
	<hr>
	<table>
		<tr>
			<td>Number of vehicles introduced:</td>
			<td><b>${AutoAdsCount}</b></td>
		</tr>
		<tr>
			<td>Number of adverts introduced:</td>
			<td><b>${GeneralAdsCount}</b></td>
		</tr>
		<tr>
			<td>Totoal income:</td>
			<td><b>${TotalIncome}</b></td>
		</tr>
	</table>
</body>
</html>