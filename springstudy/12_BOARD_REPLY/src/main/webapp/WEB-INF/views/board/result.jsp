<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<<<<<<< HEAD
<script>

	if('${type}' == 'insert') {
		if('${insRes}' > '0') {
=======
<script src="../resources/js/jquery-3.6.0.js"></script>
<script>
	if('${type}' == 'insert'){
		if('${insRes}' > '0') {	// 이렇게 안묶으면 .. 실패시 >표시나옴
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
			alert('등록 성공');
			location.href='${contextPath}/board/list';
		} else {
			alert('등록 실패');
			history.back();
<<<<<<< HEAD
		}	
	} else if('${type}' == 'update') {
		if('${updRes}' > '0') {
=======
		}
	} else if ('${type}' == 'update') {
		if('${updRes}' > '0') {	// 이렇게 안묶으면 .. 실패시 >표시나옴
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
			alert('수정 성공');
			location.href='${contextPath}/board/list';
		} else {
			alert('수정 실패');
			history.back();
<<<<<<< HEAD
		}	
	} else if('${type}' == 'delete') {
		if('${delRes}' > '0') {
=======
		}
	} else if ('${type}' == 'delete') {
		if('${delRes}' > '0') {	// 이렇게 안묶으면 .. 실패시 >표시나옴
>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
			alert('삭제 성공');
			location.href='${contextPath}/board/list';
		} else {
			alert('삭제 실패');
			history.back();
<<<<<<< HEAD
		}	
	}

=======
		}
	}


>>>>>>> a253384adb4cb43f711c76c7b574dc52fe345675
</script>