<%@page import="java.util.Date"%>
<%@page import="es.uc3m.ctw.me_gustauto.controller.MySQLConnector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="autoAdBean" class="es.uc3m.ctw.me_gustauto.controller.AutoAdBean"
	scope="session" />
<jsp:setProperty name="autoAdBean" property="*" />
<form METHOD="POST" ACTION="add_auto_ad_form.jsp">
	<div>
		<h2>Vehicle information</h2>

		Please fill out the data<br>
		<table>
			<tr>
				<td>Type</td>
				<td><INPUT TYPE="radio"
					<%if (autoAdBean.getAuto_moto().equals("auto"))
				out.print("checked");%>
					name="auto_moto" value="auto"> Car <INPUT TYPE="radio"
					<%if (autoAdBean.getAuto_moto().equals("moto"))
				out.print("checked");%>
					name="auto_moto" value="moto"> Motorbike</td>
			</tr>
			<tr>
				<td><br> Title</td>
				<td><INPUT NAME="title"
					VALUE="<jsp:getProperty name="autoAdBean" property="title" />">
			</tr>
			<tr>
				<td>Brand</td>
				<td><SELECT NAME="brand"
					VALUE="<jsp:getProperty name="autoAdBean" property="brand" />"></SELECT>
				</td>
			</tr>
			<tr>
				<td>Model</td>
				<td><SELECT NAME="model"
					VALUE="<jsp:getProperty name="autoAdBean" property="model" />"></SELECT>
				</td>
			</tr>
			<tr>
				<td>Engine</td>
				<td><SELECT NAME="engine"
					VALUE="<jsp:getProperty name="autoAdBean" property="engine" />"></SELECT>
				</td>
			</tr>
			<tr>
				<td>Registration number</td>
				<td><INPUT NAME="registration_number"
					VALUE="<jsp:getProperty name="autoAdBean" property="registration_number" />">
				</td>
			</tr>
			<tr>
				<td>Year</td>
				<td><input name="years"
					value="<jsp:getProperty name="autoAdBean" property="years" />">
				</td>
			</tr>
			<tr>
				<td>Price (in &euro;s)</td>
				<td><INPUT NAME="price"
					VALUE="<jsp:getProperty name="autoAdBean" property="price" />"></td>
			</tr>
			<tr>
				<td>Mileage (in kms)</td>
				<td><INPUT NAME="mileage"
					VALUE="<jsp:getProperty name="autoAdBean" property="mileage" />">
				</td>
			</tr>
			<tr>
				<td>Color</td>
				<td><SELECT NAME="colour"
					VALUE="<jsp:getProperty name="autoAdBean" property="colour" />"></SELECT>
				</td>
			</tr>
			<tr>
				<td>Months</td>
				<td><SELECT NAME="colour"
					VALUE="<jsp:getProperty name="autoAdBean" property="colour" />"></SELECT></td>
		</table>
		Description <br>
		<TEXTAREA NAME="description" COLS=40 ROWS=6><jsp:getProperty
				name="autoAdBean" property="description" /></TEXTAREA>
		<br>
		<br> <INPUT TYPE=Submit Value="Send">
		<%
			if (autoAdBean.storeAutoAd()) {
				out.print("<h1>AD SUCCESFULLY STORED</h1><br>");
				autoAdBean.reset();
			}
		%>
	</div>

	<br>
</form>