<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- pageContexr에 속성 name, age 저장하기 --%>
	<%
		pageContext.setAttribute("name", "이형식");
		pageContext.setAttribute("age", 30);
	%>
	
	<h3>이름 : <%=pageContext.getAttribute("name")%></h3>
	<h3>이름 : ${name}</h3>
	<h3>이름 : ${pageScope.name}</h3>
	
	<h3>나이 : <%=pageContext.getAttribute("age")%></h3>
	<h3>나이 : ${age}</h3>
	<h3>나이 : ${pageScope.age}</h3>
	
	<h3>내년 나이 : <%=(int)pageContext.getAttribute("age") + 1%></h3>
	<h3>내년 나이 : ${age + 1}</h3>
	<h3>내년 나이 : ${pageScope.age + 1}</h3>

</body>
</html>