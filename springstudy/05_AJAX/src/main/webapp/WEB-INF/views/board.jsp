<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.js"></script>
<script>
	
	// 페이지로드
	$(document).ready(function(){
		$('#btn1').on('click', function(){ fnAjax1(); })
		$('#btn2').on('click', function(){ fnAjax2(); })
		$('#btn3').on('click', function(){ fnAjax3(); })
		$('#btn4').on('click', function(){ fnAjax4(); })
	})
	
	// 함수
	function fnAjax1(){
		$('result').empty();
		
		$.ajax({
			url: '${contextPath}/board/detail1',
			type: 'get',
			data: $('#f').serialize(),
			
			dataType: 'json',
			success: function(obj){
				$('<ul>')					
				.append($('<li>').text(obj.title))	
				.append($('<li>').text(obj.hit))	
				.appendTo($('#result'));		
			},
			error: function(jqXHR){
				$('#result').text(jqXHR.status + ' : ' + jqXHR.responseText); // 404 : status / not found : responseText
			}
		})
	}
</script>
</head>
<body>

	<form id="f">
		<input type="text" name="title" id="title" placeholder="제목"><br>
		<input type="text" name="hit" id="hit" placeholder="조회수"><br>
		<input type="button" value="전송1" id="btn1">
		<input type="button" value="전송2" id="btn2">
		<input type="button" value="전송3" id="btn3">
		<input type="button" value="전송4" id="btn4">
	</form>
	
	<hr>
	
	<div id="result"></div>

</body>
</html>