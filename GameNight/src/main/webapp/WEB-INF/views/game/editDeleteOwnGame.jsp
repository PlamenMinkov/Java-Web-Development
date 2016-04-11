<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<jsp:include page="../tags/header.jsp" flush="true"></jsp:include>
	
	<script type="text/javascript">
		document.getElementsByTagName('title')[0].innerHTML = 'Редактор';
	</script>
	<section class="stripe sansSerif">
	    <div class="content padding80">
	      <h1 class="title align_center">Игрите на GAME NIGHT</h1>
	      
	      <div class="justifyBetween">
	      	<c:if test="${not empty games}">
				<c:forEach var="game" items="${games}">
		        	<div class="oneThird gameTile gameForm">
		          		<h2><input type="text" id="${game.getGameId()}_title" value="${game.getTitle()}" name="title"></h2>
			          	<p>
			            	<textarea id="${game.getGameId()}_description" name="description">
			            		${game.getDescription()}
			            	</textarea> 
			          	</p>
			          	<div id="${game.getGameId()}">
							<button class="edit">Edit</button>
							<button class="delete">Delete</button>
						</div>
		        	</div>	
		        </c:forEach>
			</c:if>        
	      </div>
	    </div>
  	</section>
	</body>
	<script>
		$(".delete").on('click', function() {
			var gameId = $(this).parent().attr("id");
			
			operationsWithDB.deleteGame(gameId);
		});
		
		$(".edit").on("click", function() {
			var gameId = $(this).parent().attr("id");			
			var title = $("#" + gameId + "_title").val();
			var description = $("#" + gameId + "_description").val();
			
			operationsWithDB.editGame(gameId, title, description);
		}); 
	</script>
	
<jsp:include page="../tags/footer.jsp" flush="true"></jsp:include>