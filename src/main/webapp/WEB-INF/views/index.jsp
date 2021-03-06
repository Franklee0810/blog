<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 헤더 -->
<%@ include file="layout/header.jsp" %>
<!-- 헤더 -->


<!-- 메인 -->
<div class="container">

<c:forEach var="board" items="${boards.content}">
	<div class="card m-2">
	  <div class="card-body">
	    <h4 class="card-title">${board.title}</h4>
	    <a href="/board/${board.id}" class="btn btn-dark">detail</a>
	    <span>${board.user.username}</span>
	  </div>
	</div>
</c:forEach>	 
 
<ul class="pagination justify-content-center">

	<c:choose>
		<c:when test="${boards.first}">
			  <li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">이전</a></li> 
		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link" href="?page=${boards.number-1}">이전</a></li>
		</c:otherwise>	
	</c:choose>
	
	<c:choose>
		<c:when test="${boards.last}">
			<li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">다음</a></li>
 		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link" href="?page=${boards.number+1}">다음</a></li>
		</c:otherwise>	
	</c:choose>
	 
</ul> 

</div>
<!-- 메인 -->



<!-- 푸터 -->
<%@ include file="layout/footer.jsp" %>
<!-- 푸터 -->
