<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<%
	// will get those prices from db
	double aal3 = 0.2;
	double aam3 = 0.15;
	double allInc = 60;
	double gal3 = 55;
	double gam3 = 44.25;
%>
<body>
	<hr>
	<p>Edit prices</p>
	<hr>
	<form method="POST" name="admin_editprices.jsp">
		<table>
			<tr>
				<td>Auto ad less than 3 months</td>
				<td><input type="text" name="aal3" value="<%=aal3%>">&euro;</td>
			</tr>
			<tr>
				<td>Auto ad more than 3 months</td>
				<td><input type="text" name="aam3" value="<%=aam3%>">&euro;</td>
			</tr>
			<tr>
				<td>All inclusive 1 year</td>
				<td><input type="text" name="allInc" value="<%=allInc%>">&euro;</td>
			</tr>
			<tr>
				<td>General ad less than 3 months</td>
				<td><input type="text" name="gal3" value="<%=gal3%>">&euro;</td>
			</tr>
			<tr>
				<td>General ad more than 3 months</td>
				<td><input type="text" name="gam3" value="<%=gam3%>">&euro;</td>
			</tr>
		</table>
		<hr>
		<p>Promotions</p>
		<hr>
		Admin will be able to set promotions here.
		<hr>
		<INPUT TYPE=Submit Value="Save">
	</form>

</body>
</html>