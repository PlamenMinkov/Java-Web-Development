<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<jsp:include page="../tags/header.jsp" flush="true"></jsp:include>
	
	<script type="text/javascript">
		document.getElementsByTagName('title')[0].innerHTML = 'Създаване на игра';
	</script>
	<section class="stripe sansSerif">
	    <div class="content padding80">
	      <h1 class="title align_center">Игрите на GAME NIGHT</h1>
	      
	      <div class="justifyBetween">
		        	<div class="oneThird gameTile gameForm">
		        		<form:form method="POST" action='${contextPath}${saveGame}'
							modelAttribute="game">
			          		<h2><input type="text" placeholder="Enter title!" name="title"></h2>
				          	<p>
				            	<textarea placeholder="Enter description!" name="description">
				            	</textarea> 
				          	</p>
				          	<input type="submit" value="Създай">
			          	</form:form>
		        	</div>    
	      </div>
	    </div>
  	</section>
	</body>
<jsp:include page="../tags/footer.jsp" flush="true"></jsp:include>