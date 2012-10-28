<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when
		test="${param.page==null || (param.page!=null && param.page!='search.jsp')}">

		<form METHOD="POST" ACTION="">

			<table>
				<tr>
					<td>Brand</td>
					<td><select name="username" value=""></td>
				</tr>
				<tr>
					<td>Model</td>
					<td><select name="name" value=""></td>
				</tr>
				<tr>
					<td>Engine</td>
					<td><select name="email" value=""></td>
				</tr>
				<tr>
					<td>Price:<input name="phone" value="" size="6" maxlength="6">-
					</td>
					<td><input name="address" value="" size="6" maxlength="6"></td>
				</tr>
				<!-- 		<tr> -->
				<!-- 			<td>from:</td><td><input name="address" value=""></td> -->
				<!-- 			<td>to:</td><td><input name="address" value=""></td> -->
				<!-- 		</tr> -->
				<tr>
					<td>Year:<input name="phone" value="" size="6" maxlength="4">-
					</td>
					<td><input name="address" value="" size="6" maxlength="4"></td>
				</tr>

				<tr>
					<td>Color</td>
					<td><select name="email" value=""></td>
				</tr>
			</table>
			<input type="submit" action="" value="Search">
		</form>
	</c:when>
	<c:otherwise>
		<h2>Use this form -&gt;</h2>
	</c:otherwise>
</c:choose>
