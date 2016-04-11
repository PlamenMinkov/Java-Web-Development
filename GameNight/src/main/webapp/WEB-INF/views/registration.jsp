<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<jsp:include page="tags/header.jsp" flush="true"></jsp:include>
	
	<script type="text/javascript">
		document.getElementsByTagName('title')[0].innerHTML = 'Регистрация';
	</script>
  <section class="stripe sansSerif">
    <div class="content padding80">
		<form:form method="POST" class="panel" action='${contextPath}${saveRegistration}'
			modelAttribute="student">
			<input type="text" placeholder="Потребителско име" name="username"><br />
			<input type="text" placeholder="Име" name="firstName"><br />
			<input type="text" placeholder="Фамилия" name="lastName"><br />
			<!-- <span>Профилна снимка: </span>
				<input type="file" name="fileSrc"  > <br/> -->
			<input type="text" placeholder="Парола" name="password"><br />
			<input type="submit" value="Регистрация">
		</form:form>
	</div>
  </section>
	</body>
<jsp:include page="tags/footer.jsp" flush="true"></jsp:include>