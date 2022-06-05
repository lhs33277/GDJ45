<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		fnSearchAll();
		fnSearch();
	})
	
	
	// 전체
	function fnSearchAll(){
		$.ajax({
			url: '${contextPath}/movie/searchAllMovies',
			type: 'get',
			dataType: 'json',
			success: function(map){
				alert(map.msg);
				$('#movieBody').empty();
				if(map.status == 1){
					$.each(map.movies, function(i, movie){
						$('<tr>')
						.append($('<td>').text(movie.title))
						.append($('<td>').text(movie.genre))
						.append($('<td>').text(movie.description))
						.append($('<td>').text(movie.star))
						.appendTo('#movieBody');
					})
				} else if(map.status == 0){
					$('<tr>')
					.append($('<td colspan="4">').text('목록 없음.'))
					.appendTo('#movieBody');
				}
			}
		})
	}
	
	// 검색된거
	function fnSearch() {
		
		$('#btnSearch').on('click', function(){
			$.ajax({
				url: '${contextPath}/movie/searchMovie',
				type: 'post',
				data: JSON.stringify({
					'column': $('#column').val(),
					'searchText': $('#searchText').val()
				}),
				contentType: 'application/json',
				dataType: 'json',
				success: function(result){
					alert(result.msg);
					$('#movieBody').empty();
					if(result.status == 1){
						$.each(result.movies, function(i, movie){
							$('<tr>')
							.append($('<td>').text(movie.title))
							.append($('<td>').text(movie.genre))
							.append($('<td>').text(movie.description))
							.append($('<td>').text(movie.star))
							.appendTo('#movieBody');
						})
					} else if(map.status == 0){
						$('<tr>')
						.append($('<td colspan="4">').text('목록 없음.'))
						.appendTo('#movieBody');
					}
				}
			})
		})
	}


</script>
</head>
<body>
	
	<form>
		<select id="column">
			<option value="">선택</option>
			<option value="title">제목</option>
			<option value="genre">장르</option>
			<option value="description">내용</option>
		</select>
		<input type="text" id="searchText">
		<input type="button" value="검색" id="btnSearch"> 
		<input type="reset" value="초기화">
	</form>
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<td>제목</td>
				<td>장르</td>
				<td>내용</td>
				<td>평점</td>
			</tr>
		</thead>
		<tbody id="movieBody">
		
		</tbody>
	
	</table>
	
</body>
</html>