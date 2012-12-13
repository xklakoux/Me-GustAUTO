<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h1>Messages</h1>
<c:forEach var="message" items="${messages}">
	<div
		style="border-style: solid; border-width: 1px; padding: 8px; overflow: hidden;">
		<c:out value="${message.content}" />
		<c:out value="${message.user1.username}" />
		<i><fmt:formatDate value="${message.dateAdded}"
				pattern=" d MMM yyyy 'at' hh:mm a " /></i> <br>
	</div>
	
	
	
</c:forEach>
