<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<%@ include file="include/menu.jsp" %>
	<c:if test="${msg == 'success' }">
		<h2>${sessionScope.userId } 환영합니다!</h2>
	</c:if>
</body>
</html>
