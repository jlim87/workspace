<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VIEW</title>
<%@ include file="../include/header.jsp" %>
<script>
	$(document).ready(function(){
		
		listReply2();
		
		$("#btnReply").click(function(){
			var replyContent = $("#replyContent").val();
			var boardId = "${dto.boardId}";
			var param = "replyContent=" + replyContent + "&boardId=" + boardId;
			$.ajax({
				type:"post",
				url:"${path}/reply/insert.do",
				data:param,
				success:function(){
					alert("댓글이 등록되었습니다.");
					listReply2();
				}
			});
		});
		
		$("#btnList").click(function(){
			location.href="${path}/board/list.do?boardId=${dto.boardId}";
		});
		
		$("#btnDelete").click(function(){
			if(confirm("삭제하시겠습니까?")){
				document.form.action = "${path}/board/delete.do?boardId=${dto.boardId}";
				document.form.submit();
			}
		});
		
		$("#btnUpdate").click(function(){
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
			document.form.action="${path}/board/update.do";
			document.form.submit();
		});
	});
	
	function listReply(){
		$.ajax({
			type:"get",
			url:"${path}/reply/list.do?boardId=${dto.boardId}",
			success:function(result){
				$("#listReply").html(result);
			}
		});
	}
	
	function listReply2(){
		$.ajax({
			type:"get",
			url:"${path}/reply/listJson.do?boardId=${dto.boardId}",
			success:function(result){
				console.log(result);
				var output = "<table border='1' align='center' width='800'>";
				for(var i in result){
					output += "<tr>댓글</tr>";
					output += "<tr>";
					output += "<td>작성자: " + result[i].replyer + "</td>";
					output += "<td>글내용: " + result[i].replyContent + "</td>";
					output += "</tr>";
				}
				output += "</table>";
				$("#listReply").html(output);
			}
		});
	}
	
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>	
<form name="form" method="post">
<div align="center">	
	<table border="1" align="center" width="600px">
			<tr >
				<td>제목 </td><td width="300" height="100">${dto.title}</td>
			</tr>
			<tr >
				<td>이름 </td><td width="300" height="100">${dto.userId}</td>
			</tr>
			<tr>
				<td>내용 </td><td width="300" height="100">${dto.content}</td>
			</tr>
			<tr>
				<td>작성일자 </td><td><fmt:formatDate value="${dto.regDate}" pattern="yyyy-MM-dd a HH:mm:ss"/></td>
			</tr>
			<tr>	
				<td colspan="2" align="right">
					<input type="hidden" name="boardId" value="${dto.boardId}">
					<c:if test="${sessionScope.userId == dto.userId}">
					<button type="button" id="btnUpdate">수정</button>
					<button type="button" id="btnDelete">삭제</button>
					</c:if>
					<button type="button" id="btnList">목록</button>
				</td>
			</tr>
		</table>
</div>
</form>
<div align="center">
<br>
<!-- 로그인 한 회원에게만 댓글 작성폼이 보이게 처리 -->
<c:if test="${sessionScope.userId != null }">
<textarea rows="5" cols="80" id="replyContent" align="center"></textarea>
<br>
<button type="button" id="btnReply">댓글작성</button>
</c:if>
</div>
<div id="listReply"></div>
</body>
</html>