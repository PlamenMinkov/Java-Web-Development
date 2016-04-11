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
		          		<h2>${game.getTitle()}</h2>
		          		<span class="votes">
		          			Vote: <span id="${game.getGameId()}_vote">${game.getVote()}</span>
	          			</span>
			          	<p>
			          		${game.getDescription()}
			          	</p>
			          	<div id="${game.getGameId()}">
							<button class="up">Up</button>
							<button class="down">Down</button>
						</div>
		        	</div>	
		        </c:forEach>
			</c:if>        
	      </div>
	    </div>
  	</section>
	</body>
	<script>
		$(".up").on('click', function() {
			var gameId = $(this).parent().attr("id");
			var value = 1; 
			
			operationsWithDB.addOrUpdateGameVote(gameId, value);
		});
		
		$(".down").on("click", function() {
			var gameId = $(this).parent().attr("id");
			var value = -1;
			
			operationsWithDB.addOrUpdateGameVote(gameId, value);			
		}); 
	</script>
<jsp:include page="../tags/footer.jsp" flush="true"></jsp:include>