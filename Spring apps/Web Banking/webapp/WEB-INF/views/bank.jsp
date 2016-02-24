<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Customers Register</title>
</head>
	<body>
		<form:form method="POST" action='${contextPath}${saveOperation}'
			modelAttribute="student">
			<span>Name: </span>
				<input type="text" 
					<c:if test='${customerName != null}'>
						value="${customerName}"
					</c:if> name="name"><br />
					
			<span>Account amount: </span>
				<input type="text" value="${accountAmount}" name="amount"><br />
			<span>Operation: </span>
				<select name=operation>
					<option value="deposit">Deposit</option>
					<option value="withdraw">Withdraw</option>
				</select><br />
			<span>Amount to change: </span>
				<input type="text" value="0" name="sum"><br />
	
			<input type="submit" value="Submit">
		</form:form>
		<p>${message}</p>
	</body>
</html>