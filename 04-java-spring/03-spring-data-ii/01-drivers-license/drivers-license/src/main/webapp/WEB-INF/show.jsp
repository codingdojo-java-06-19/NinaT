<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Profile Page</title>
</head>
	<body>
		<div class="container">
			<h1>${person.firstName} ${person.lastName}</h1>
			<p>License Number: ${person.license.number}</p>
			<p>State: ${person.license.state}</p>
			<p>Expiration Date: ${person.license.expirationDate}</p>
		</div>
	</body>
</html>