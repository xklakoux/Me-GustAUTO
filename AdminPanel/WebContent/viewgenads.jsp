<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>Admin view - confirm and delete general ads</title>
</head>
<style>
body {
	text-align: center;
}

p {
	font-weight: bold;
}

table {
	margin-left: auto;
	margin-right: auto;
}
</style>
<body>
	<hr>
	<p>List of general ads</p>
	<hr>
	<form method="POST" name="admin_viewgenads.jsp">
		<table BORDER=1 CELLPADDING=7 CELLSPACING=5 RULES=ROWS>
			<%
				for (int i = 0; i < 6; i++) {
					out.print("<tr>" + "<td><img src=\"genadexample.jpg\"></td>"
							+ "<td> 3 months </td>" + "<td> username: abc </td>"
							+"<td><INPUT TYPE=\"radio\" name=\"" + i
							+ "\" value=\"delete\"> Delete </td>"
							+ "<td><INPUT TYPE=\"radio\" name=\"" + i
							+ "\" value=\"confirmed\"> Confirm </td>"
							+  "</tr>");
				}
			%>


		</table>
		<input type=Submit value="Save">
	</form>
</body>
</html>