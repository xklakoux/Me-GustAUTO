<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="autoAdListBean" class="es.uc3m.ctw.me_gustauto.controller.AutoAdListBean" />
<form METHOD="POST" ACTION="SearchServlet">
	<table>
		<tr>
			<td>Title</td>
			<td></td>
			<td><input name="title" value=""></td>
		</tr>
		<tr>
			<td>Brand</td>
			<td></td>
			<td><select name="brand">
					<option value="-">-</option>
					<c:forEach items="${autoAdListBean.getList('brand')}" var="value">
						<option value="${value}">${value}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Model</td>
			<td></td>
			<td><select name="model">
					<option value="-">-</option>
					<c:forEach items="${autoAdListBean.getList('model')}" var="value">
						<option value="${value}">${value}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Engine</td>
			<td></td>
			<td><select name="engine">
					<option value="-">-</option>
					<c:forEach items="${autoAdListBean.getList('engine')}" var="value">
						<option value="${value}">${value}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><input id="priceFrom" name="priceFrom" value="" size="6" maxlength="6" onblur="validateInput(this.id);">-</td>
			<td><input id="priceTo" name="priceTo" value="" size="6" maxlength="6" onblur="validateInput(this.id);"></td>
		</tr>
		<tr>
			<td>Mileage</td>
			<td><input id="mileageFrom" name="mileageFrom" value="" size="6" maxlength="6" onblur="validateInput(this.id);">-</td>
			<td><input id="mileageTo" name="mileageTo" value="" size="6" maxlength="6" onblur="validateInput(this.id);"></td>
		</tr>
		<tr>
			<td>Year</td>
			<td><input id="yearFrom" name="yearFrom" value="" size="6" maxlength="4" onblur="validateInput(this.id);">-</td>
			<td><input id="yearTo" name="yearTo" value="" size="6" maxlength="4" onblur="validateInput(this.id);"></td>
		</tr>
		<tr>
			<td>Colour</td>
			<td></td>
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
<script type="text/javascript">
	function validateInput(id) {
		var result = parseInt(document.getElementById(id).value);
		if (isNaN(result)) result = '';
		else if (result < 0) result *= -1;
		document.getElementById(id).value = result;
	}
</script>
