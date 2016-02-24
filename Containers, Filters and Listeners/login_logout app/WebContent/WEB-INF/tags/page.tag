<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ attribute name="title" %>
<%@ attribute name="version" %>
<%@ attribute name="project" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<ct:Header title="${title}" />
	<jsp:doBody/>
	<ct:Footer version="${version}" project="${project}"/>
</body>
</html>