<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<title>Secret Code</title>
</head>
	<body>
		<div class="container">
			<p class="error"><c:out value="${error}"/></p>
			<p>What is the code?</p>
			<form action="/guess" method="POST" autocomplete=off>
				<input type="text" name="codeInput"/>
				<input type="submit" value="Try Code"/>
			</form>
		</div>
	</body>
</html>