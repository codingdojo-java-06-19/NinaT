<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<title>Search Lookify</title>
</head>
	<body>
		<div class="container">
			<div class="nav-bar">
				<p>Songs by artist: <c:out value="${search}"/></p>
				<form action="" method="POST">
					<input type="search" name="searchQuery"/>
					<input type="submit" value="New Search"/>
				</form>
				<a href="http://localhost:8080/dashboard">Dashboard</a>
			</div>
			<table class="search-table">
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
				<c:forEach items="${songsFromArtist}" var="song">
				<tr>
					<td><a href="http://localhost:8080/songs/${song.id}">${song.title}</a></td>
					<td>${song.rating}</td>
					<td>
						<form action="/songs/${song.id}" method="post">
	    					<input type="hidden" name="_method" value="delete">
	    					<input class="link-style" type="submit" value="Delete">
						</form>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>