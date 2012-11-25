<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="autoAdListBean"
	class="es.uc3m.ctw.me_gustauto.controller.AutoAdListBean" />
<form METHOD="POST" ACTION="SearchServlet">
	<table>
		<tr>
			<td>Title</td>
			<td><input name="title" value=""></td>
		</tr>
		<tr>
			<td>Brand</td>
			<td><select name="brand">
					<option value="-">-</option>
					<c:forEach items="${autoAdListBean.getList('brand')}" var="value">
						<option value="${value}">${value}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Model</td>
			<td><select name="model">
					<option value="-">-</option>
					<c:forEach items="${autoAdListBean.getList('model')}" var="value">
						<option value="${value}">${value}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Engine</td>
			<td><select name="engine">
					<option value="-">-</option>
					<c:forEach items="${autoAdListBean.getList('engine')}" var="value">
						<option value="${value}">${value}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Price<input name="priceFrom" value="" size="6" maxlength="6">-</td>
			<td><input name="priceTo" value="" size="6" maxlength="6"></td>
		</tr>
		<tr>
			<td>Mileage<input name="mileageFrom" value="" size="6" maxlength="6">-</td>
			<td><input name="mileageTo" value="" size="6" maxlength="6"></td>
		</tr>
		<tr>
			<td>Year<input name="yearFrom" value="" size="6" maxlength="4">-</td>
			<td><input name="yearTo" value="" size="6" maxlength="4"></td>
		</tr>

		<tr>
			<td>Colour</td>
			<td><select name="colour">
					<option value="-">-</option>
					<c:forEach items="${autoAdListBean.getList('colour')}" var="value">
						<option value="${value}">${value}</option>
					</c:forEach>
			</select></td>
		</tr>
	</table>
	<input type="submit" value="Search">
</form>
