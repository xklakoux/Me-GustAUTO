<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Current Offers</h2>
<c:forEach var="i" begin="0" end="20">

	<div
		style="border-style: solid; border-width: 1px; padding: 8px; overflow: hidden;">

		<a
			href="?page=showdetails.jsp&id=123"><img src="res/images/car.png" width="50px" height="30px"
			style="float: left; margin-right: 20px;" /></a>
		<div style="">
			<table>
				<tr>
					<td>Title
					<td>
					<td>29000 &euro;</td>
				</tr>
			</table>
		</div>
	</div>
</c:forEach>

