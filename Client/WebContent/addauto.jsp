<%@page import="java.util.Date"%>
<%@page import="es.uc3m.ctw.me_gustauto.controller.MySQLConnector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<form METHOD="POST" ACTION="AddAutoAd">
	<div>
		<h2>Vehicle information</h2>

		Please fill out the data<br>
		<table>
			<tr>
				<td>Type</td>
				<td><INPUT TYPE="radio" name="auto_moto" value="auto">
					Car <INPUT TYPE="radio" name="auto_moto" value="moto">
					Motorbike</td>
			</tr>
			<tr>
				<td><br>Title</td>
				<td><INPUT NAME="title" VALUE="">
			</tr>
			<tr>
				<td>Brand</td>
				<td><INPUT NAME="brand" VALUE="" /></td>
			</tr>
			<tr>
				<td>Model</td>
				<td><INPUT NAME="model" VALUE="" /></td>
			</tr>
			<tr>
				<td>Engine</td>
				<td><INPUT NAME="engine" VALUE=""></td>
			</tr>
			<tr>
				<td>Registration number</td>
				<td><INPUT NAME="registration_number" VALUE=""></td>
			</tr>
			<tr>
				<td>Year</td>
				<td><input name="years" value="" /></td>
			</tr>
			<tr>
				<td>Price (in &euro;s)</td>
				<td><INPUT NAME="price" VALUE="" /></td>
			</tr>
			<tr>
				<td>Mileage (in kms)</td>
				<td><INPUT NAME="mileage" VALUE="" /></td>
			</tr>
			<tr>
				<td>Color</td>
				<td><INPUT NAME="colour" VALUE="" /></td>
			</tr>
			<tr>
				<td>Number of months that the ad will be available</td>
				<td><select name="months">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				</select>
				</td></td>
			</tr>
		</table>
		Description <br>
		<TEXTAREA NAME="description" COLS=40 ROWS=6></TEXTAREA>
		<br> <br> <INPUT TYPE=Submit Value="Send">
	</div>

	<br>
</form>