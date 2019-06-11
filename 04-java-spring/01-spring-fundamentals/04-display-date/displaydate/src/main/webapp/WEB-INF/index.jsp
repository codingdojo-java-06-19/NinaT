<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<title>Time Dashboard</title>
</head>
	<body>
		<div class="container">
			<a class="left-link" href="<c:out value="${path}"/>date">Date Template</a>
			<a class="right-link" href="<c:out value="${path}"/>time">Time Template</a>
		</div>
	</body>
</html>