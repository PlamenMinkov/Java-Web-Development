<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<jsp:include page="tags/header.jsp" flush="true"></jsp:include>
	
	<script type="text/javascript">
		document.getElementsByTagName('title')[0].innerHTML = 'Профили';
	</script>
	
	<form:form class="searchForm" method="GET" action="${contextPath}${accountRegister}" modelAttribute="UserSearch">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username"><td>
			</tr>
		</table>
		<input type=submit id="btn1" name="Search" value="Търси"/>
	</form:form>
	<section class="stripe sansSerif">
    <div class="content padding40">
      <h1>Списък на членовете на клуба:</h1>
      <ul class="userList">
        <li class="relative">
       		<span class="cell cellTitle username">Потребителско име:</span>
          	<span class="cell cellTitle name">Име:</span>
          	<span class="cell cellTitle familyName">Фамилия:</span>
          	<span class="cell cellTitle activePeriod">Ативен период:</span>
        </li>
		<c:if test="${not empty customers}">
	        <c:forEach var="custumer" items="${customers}">
		         <li class="relative">
		         	<span class="cell username">
		         		<a href="${contextPath}${accountProfile}?username=${custumer.getUsername()}">
		         			${custumer.getUsername()}
	         			</a>
         			</span>
			        <span class="cell name">${custumer.getFirstName()}</span>
			        <span class="cell familyName">${custumer.getLastName()}</span>
			        <span class="cell activePeriod" id="${custumer.getAccount_id()}_period">${custumer.getActivePeriod()}</span>
			        
			        <sec:authorize access="hasRole('ROLE_ADMIN')">
			        	<span class="cell addPeriod" id="${custumer.getAccount_id()}"><button >Добави активен месец</button></span>
					</sec:authorize>			        
		        </li>
         	</c:forEach>
		</c:if>
      </ul>
    </div>
  </section>
</body>
<script>
		$(".addPeriod").on('click', function() {
			var accountId = $(this).attr("id");
			
			operationsWithDB.addPeriod(accountId);
		});
	</script>
	
<jsp:include page="tags/footer.jsp" flush="true"></jsp:include>