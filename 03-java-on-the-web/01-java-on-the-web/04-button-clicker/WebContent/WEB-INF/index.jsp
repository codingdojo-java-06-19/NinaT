<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="styles.css"/>
	<title>Click</title>
</head>
	<body>
		<div class="container">
		<form action="Counter" method="POST">
			<input type="submit" value="Click Me!"/>
		</form>
		<h1>You have clicked this button <c:out value="${count}"/> times.</h1>
		</div>
	</body>
</html>