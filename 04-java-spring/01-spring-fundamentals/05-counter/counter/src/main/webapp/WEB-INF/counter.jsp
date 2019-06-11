<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Current Visit Count</title>
</head>
	<body>
		<p>You have visited http://localhost:8080/ <c:out value="${count}"/> times.</p>
		<a href="http://localhost:8080/">Test another visit?</a>
	
	</body>
</html>