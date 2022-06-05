<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		fnList();
		fnAdd();
		fnDetail();
	})
	
	function fnList(){
		$.ajax({
			url: '/StaffProject/list.json',
			type: 'get',
			dataType: 'json',
			success: function(responseText){
				$('#staffs').empty();
				$.each(responseText.staffs, function(i, staff){
					var tr= '<tr>';
					tr += '<td>' + staff.SNo + '</td>';
					tr += '<td>' + staff.name + '</td>';
					tr += '<td>' + staff.dept + '</td>';
					tr += '<td>' + staff.salary + '</td>';
					$('#staffs').append(tr);
				})
			}
		})
	}
	
	function fnAdd(){
		$('#btnAdd').on('click', function(){
			$.ajax({
				url: '/StaffProject/add.json',
				type: 'POST',
				data: $('#formStaff').serialize(),
				dataType: 'json',
				success: function(responseText){
					if(responseText.res ==1){
						alert('사원 등록이 성공했습니다.');
						fnList();
					}
				}
			})
		})
	}
	
	function fnDetail(){
		$('btnDetail').on('click', function(){
			var sNo = $(this).data('SNo');
			$.ajax({
				url: '/StaffProject/detail.json',
				data: 'SNo=' + sNo,
				type: 'get',
				dataType: 'json',
				success: function(responseText){
					if(responseText.result == true){
						$('#SNo').val(responseText.staff.SNo);
						$('#name').val(responseText.staff.name);
						$('#dept').val(responseText.staff.dept);
					} 
				}
			})
		})
	}
	
</script>
</head>
<body>
	
	<form id="formStaff">
		<h3>사원등록</h3>
		<input type="text" name="sNo" id="sNo" placeholder="사원번호">
		<input type="text" name="name" id="name" placeholder="사원명">
		<input type="text" name="dept" id="dept" placeholder="부서명">
		<input type="button" value="등록" id="btnAdd">
	</form>
	
	<hr>
	
	<form>
		<h3>사원조회</h3>
		<input type="text" name="sNo"  placeholder="사원번호입력">
		<input type="button" value="조회" id="btnDetail">
		<input type="button" value="전체">
	</form>
	
	<hr>
	
	<h3>사원목록</h3>
	<table border="1">
		<thead>
			<tr>
				<td>사원번호</td>
				<td>사원명</td>
				<td>부서명</td>
				<td>연봉</td>
			</tr>
		</thead>
		<tbody id="staffs">
		</tbody>
	</table>
</body>
</html>