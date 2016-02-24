<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<c:set var="date" value="<%= new java.util.Date() %>"/>
<%-- <c:set var="name" value="<%= request.getAttribute("insertId") %>"/> --%>

<ct:page title="Containers, Filters and Sessions" version="${version}" project="${project}">
		<jsp:body>
			<c:choose>
		        <c:when test="${username == null}">
		             <a href="login">Login</a>
		        </c:when>
		        <c:otherwise>
		        	<p style="display: inline-block;">Hello ${username}</p>
		        	<a href="logout">Logout</a>
		        </c:otherwise>
    		</c:choose>
		</jsp:body>
</ct:page>