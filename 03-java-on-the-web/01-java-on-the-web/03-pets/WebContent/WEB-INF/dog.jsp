<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="styles.css"/>
	<title>Show Pet page</title>
</head>
	<body>
	<div class="container">
		<p>Your created a <c:out value="${dog.breed}"/>!</p>
		<p><c:out value="${dog.showAffection()}"/></p>
	</div>
	</body>
</html>