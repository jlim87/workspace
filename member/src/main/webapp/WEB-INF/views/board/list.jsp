<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글목록</title>
<%@ include file="../include/header.jsp" %>
<script>
	$(document).ready(function(){
		$("#btnWrite").click(function(){
			// 페이지 주소 변경(이동)
			location.href="${path}/board/write.do";
		});
	});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
	<table class="list" border="1" align="center">
		<colgroup>
			<col width="15%" />
			<col width="30%" />
			<col width="20%" />
			<col width="20%" />
		</colgroup>
		<thead>
			<tr align="center">
				<th>제목</th>
				<th>등록일자</th>
				<th>수정일자</th>
			</tr>
		</thead>
		<c:forEach var="list" items="${list}">
		<tbody>
			<tr align="center">
				<td><a href="${path}/board/view.do?boardId=${list.boardId}">${list.title}</a></td>
				<td><fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><fmt:formatDate value="${list.modDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
		</tbody>
		</c:forEach>
			<tr >
				<td colspan="3" align="right"><a href="${path}/board/write">글쓰기</a></td>
			</tr>
	</table>

</body>
</html>