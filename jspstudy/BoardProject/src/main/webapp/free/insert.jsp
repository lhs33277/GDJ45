<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><h1><strong>자유게시판 게시글 작성화면</strong></h1></div>

	<form action="/BoardProject/insert.do" method="post">
		<input type="text" name="name" placeholder="작성자"><br>
		<input type="text" name="title" placeholder="제목"><br>
		<textarea name="content" rows="5" cols="10" placeholder="내용"></textarea><br>

	</form>
	
</body>
</html>