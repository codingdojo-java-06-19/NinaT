<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<script type="text/javascript" src="js/date.js"></script>
	<title>Date</title>
</head>
	<body>
		<div class="container">
			<h1 class="date-color"><c:out value="${date}"/></h1>
		</div>
	</body>
</html>