<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="gen-ad">
	<c:forEach var="i" items="${list}">
		<table>
			<thead>
				<tr>
					<td><a href="link"> ${i.title} </a></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${i.descr}</td>
				</tr>

			</tbody>
		</table>
	</c:forEach>
</div>