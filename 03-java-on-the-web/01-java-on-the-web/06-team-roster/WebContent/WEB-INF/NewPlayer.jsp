<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	    <link rel="stylesheet" href="styles.css">
	<meta charset="UTF-8">
	<title><c:out value="${team.getName()}"/>: New Player</title>
</head>
	<body>
	<div class="container">
			<h1 class="header">Add a player to team <c:out value="${team.getName()}"/></h1>
			<div class="form-group">
				<form action="Home" method="POST" autocomplete="off">
					<label for="teamName">Team Name:</label>
					<input type="text" name="teamName"/>
					<input type="submit" value="Create">
			</form>
			</div>
		</div>
	</body>
</html>