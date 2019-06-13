<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<title>Lookify Dashboard</title>
</head>
	<body>
		<div class="container">
			<div class="nav-bar">
				<a href="http://localhost:8080/songs/new">Add New</a>
				<a href="http://localhost:8080/search/topTen">Top Songs</a>
				<form action="/search/artist" method="POST" autocomplete="off">
					<input type="search" name="searchQuery">
					<input type="submit" value="Search Artists">
				</form>
			</div>
			<table class="songs">
				<tr>
					<th>Name</th>
					<th>Artist</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
				<tr>
					<a href="#"><td>Shape of You</td></a>
					<td>Ed Sheeran</td>
					<td>Rating</td>
					<a href="#"><td>Delete</td></a>
				</tr>
				<c:forEach items="${songs}" var="song">
					<tr>
            			<a href="#"><td><c:out value="${song.title}"/></td></a>
            			<td><c:out value="${song.artist}"/></td>
            			<td><c:out value="${song.rating}"/></td>
            			<a href="#"><td>Delete</td></a>
        			</tr>
        		</c:forEach>
			</table>
		</div>
	</body>
</html>