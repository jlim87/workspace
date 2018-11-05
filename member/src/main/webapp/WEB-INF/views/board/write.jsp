<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 작성</title>
<%@ include file="../include/header.jsp" %>
<%@ include file="../include/sessionCheck.jsp" %>
<script>
	$(document).ready(function(){
		$("#btnSave").click(function(){
			// var title = document.form.title.value; ==> name속성으로 처리 할 경우
			var title = $("#title").val();
			var content = $("#content").val();
			if(title == ""){
				alert("제목을 입력하세요.");
				document.form.title.focus();
				return;
			}
			if(content == ""){
				alert("내용을 입력하세요.");
				document.form.content.focus();
				return;
			}
			document.form.submit();
		});
	});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>게시글 작성</h2>
<form name="form" method="post" action="${path}/board/insert.do">
	<table border="1" align="center">
		<tr >
			<td>제목  </td><td><input name="title" id="title" size="30"></td>
		</tr>
		<tr align="center">
			<td>내용  </td><td><textarea name="content" id="content" rows="8" cols="60"></textarea></td>
		</tr>
		<tr>
			<td>이름 </td>
			<td><input name="userId" id="userId" value="${sessionScope.userId }"></td>
		</tr>
		<tr>	
			<td></td>
			<td>
				<button type="button" id="btnSave" >저장</button>
				<button type="reset">취소</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>