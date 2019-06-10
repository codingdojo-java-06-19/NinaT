<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="styles.css">
	  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<!-- Because our roster contains a list of our teams, we'll call upon the forEach method to loop through the array of teams. -->
			<c:forEach items="${roster.getTeams()}" var="team">
			<tr>
				<td>${team.getName()}</td>
				<td>${team.getPlayers().size()}</td>
				<td><a href="Teams?id=<c:out value="${team.getId()}"/>">Details</a>  |
					<form class="short-form" action="DeleteTeam?teamid=${team.getId()}" method="POST">
						<input class="normal-link" type="submit" value="Delete">
					</form>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	</body>
</html>