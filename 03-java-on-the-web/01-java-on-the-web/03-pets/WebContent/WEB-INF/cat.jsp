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
	<p>You created a <c:out value="${cat.breed}"/>!</p>
	<p><c:out value="${cat.showAffection()}"/></p>
	</body>
</html>