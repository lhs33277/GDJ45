<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD

=======
    
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${user == null}">
		<form action="${contextPath}/user/login" method="post">
			<input type="text" name="id" placeholder="ID"><br>
			<input type="password" name="pw" placeholder="Password"><br>
			<button>로그인</button>
		</form>
	</c:if>
	
	<c:if test="${user != null}">
		${user.name} 님 반갑습니다
	</c:if>
<<<<<<< HEAD

	<hr>

	<a href="${contextPath}/board/list">게시판</a>
=======
	
	<hr>
	
	<a href="${contextPath}/board/list">게시판</a>
	
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675

</body>
</html>