<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<<<<<<< HEAD

=======
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<<<<<<< HEAD
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="../resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript">

=======

<script src="../resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
</script>
</head>
<body>

	<h3>게시판</h3>
<<<<<<< HEAD

	<c:if test="${user != null}">
		<a href="${contextPath}/board/savePage">새글작성</a>
	</c:if>

	<hr>
	
	<table>
=======
	
	<c:if test="${user != null}">
		<a href="${contextPath}/board/savePage">새글작성</a>
	</c:if>
	
	<hr>
	
	<table border="1">
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
		<thead>
			<tr>
				<td>순번</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
				<td>작성일자</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boards}" var="board">
				<tr>
					<td>${totalRecord + 1 - board.rn}</td>
					<td><a href="${contextPath}/board/detail?boardNo=${board.boardNo}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.hit}</td>
					<td>${board.created}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
<<<<<<< HEAD
			<tr>
				<td colspan="5">
					${paging}
				</td>
			</tr>
		</tfoot>
	</table>

=======
		<tr>
			<td colspan="5">
				${paging}
			</td>
		</tr>
		</tfoot>
	</table>
	
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
</body>
</html>