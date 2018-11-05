<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<title>로그인</title>
<%@ include file="../include/header.jsp" %>
<script>
	$(document).ready(function(){
		$("#btnLogin").click(function(){
			var userId = $("#userId").val();
			var password = $("#password").val();
			if(userId == ""){
				alert("아이디를 입력하세요.");  
				$("#userId").focus();
				return;
			}
			if(password == ""){
				alert("비밀번호를 입력하세요.");
				$("#password").focus();
				return;
			}
			document.form1.action="${path}/member/loginCheck.do"
			document.form1.submit();
		});
	});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2 align="center">로그인</h2>
<form name="form1" method="post">
	<table border="1" width="400px" align="center">
		<tr>
			<td>아이디</td>
			<td><input name="userId" id="userId"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" id="password"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" id="btnLogin">로그인</button>
			<c:if test="${msg == 'failure' }">
				<div style="color:red">
					아이디 또는 비밀번호가 일치하지 않습니다.
				</div>
			</c:if>
			<c:if test="${msg == 'logout' }">
				<div style="color:red">
					로그아웃되었습니다.
				</div>			
			</c:if>
		</tr>
	</table>
</form>
</body>
</html>
