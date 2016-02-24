<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Customers Register ${name}</title>
</head>
<body>
	<button type="button" onclick="location = '${contextPath}${bankOperationUrl}'">Add Student</button>
	<table border="1">
		<thead>
			<tr>
				<th>Customer Name</th>
				<th>Account Amount</th>
				<th>Currency</th>
			</tr>
		</thead>
		<c:if test="${not empty customers}">
	    	<tbody>
		        <c:forEach var="custumer" items="${customers}">
		            <tr>
		                <td>${custumer.value.getName()}</td>
		                <td>${custumer.value.getAccountAmount()}</td>
		                <td>${custumer.value.getCurrency()}</td>
		            </tr>
		        </c:forEach>
	        </tbody>
		</c:if>
	</table>
</body>
</html>