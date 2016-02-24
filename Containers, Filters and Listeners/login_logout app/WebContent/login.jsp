<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<c:set var="date" value="<%= new java.util.Date() %>"/>
<%-- <c:set var="name" value="<%= request.getAttribute("insertId") %>"/> --%>

<ct:page title="Containers, Filters and Sessions" version="${version}" project="${project}">
		<jsp:body>
			<form action="login" method="post"> 
				Username: <input type="text" name="user"><br/>
				Password: <input type="password" name="pwd"><br/>
				<input type="submit" value="Login">
			</form>
		</jsp:body>
</ct:page>