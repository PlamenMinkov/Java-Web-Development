<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<jsp:include page="tags/header.jsp" flush="true"></jsp:include>
<%-- <p>${user.getUsername()}</p> --%>
<section class="stripe sansSerif">
    <div class="content padding80">
      <form name="login" action="/gamenight/login" method="POST">
			<label>Username</label>
			<input id="username" name="username" type="text"/>
			<label>Password</label>
			<input id="password" name="password" type="password" />
			<input name="submit" type="submit" value="Login" />
 			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
		</form>
      
      <div class="registerInfo">
      </div>
    </div>
  </section>
		<%-- <form name="login" action="/gamenight/login" method="POST">
			<label>Username</label>
			<input id="username" name="username" type="text"/>
			<label>Password</label>
			<input id="password" name="password" type="password" />
			<input name="submit" type="submit" value="Login" />
 			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
		</form> --%>
	</body>
</html>