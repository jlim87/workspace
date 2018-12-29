<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
	<table align="center">
		<c:forEach var="row" items="${list}">
			<tr>
				<td>
				${row.userId}
				<br>
				${row.replyContent}
				<br>
				<fmt:formatDate value="${row.regDate}" pattern="yyyy-MM-dd a HH:mm:ss"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>