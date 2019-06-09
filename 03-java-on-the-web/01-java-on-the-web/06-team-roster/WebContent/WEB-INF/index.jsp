<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="styles.css">
	<title>Roster</title>
</head>
	<body>
	<div class="container">
		<h1 class="header">Prototype Roster</h1>
		<a class="right-link" href="Teams">New Team</a>
		<table class="roster">
			<tr>
				<th>Team</th>
				<th>Players</th>
				<th>Action</th>
			</tr>
			<tr>
				<td>Ninjas</td>
				<td>2</td>
				<td><a href="Teams?id<c:out value="${team.id}"/>">Details</a>  | <a href="DeleteTeam?id<c:out value="${team.id}"/>">Delete</a></td>
			</tr>
			<tr>
				<td>Samurai</td>
				<td>5</td>
				<td><a href="Teams?id=0">Details</a>  | <a href="DeleteTeam?id=0">Delete</a></td>
			</tr>
			<tr>
				<td>Knights</td>
				<td>4</td>
				<td><a href="Teams">Details</a>  | <a href="DeleteTeam">Delete</a></td>
			</tr>
		</table>
	</div>
	</body>
</html>