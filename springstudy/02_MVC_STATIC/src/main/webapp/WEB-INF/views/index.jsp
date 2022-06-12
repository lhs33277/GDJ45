<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 
		var="contextPath" 							contextPath 속성(attribute)로 저장.
		value="${pageContext.request.contextPath}"  contextPath 속성에 저장되는 값.
		scope="application"							application에 저장된 속성은 애플리케이션(프로젝트)에서 공유.
													즉, 모든 JSP가 contextPath 속성을 사용할 수 있다.
	-->
	
	
	<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application" />

	<h1>${res}</h1>
	
	<a href="/ex02/imageView">이미지보러가기</a>
	
	<br>
	
	<!-- hosting에 올릴 때 /ex02가 폴더로 인식되는 경우가 있다. -->
	<!-- contextPath를 변수로 처리하면 해결된다. -->
	
	<a href="${contextPath}/imageView">이미지보러가기</a>
	
	<br>
	
	<a href="${contextPath}/imageView2">라이언보기</a>

</body>
</html>