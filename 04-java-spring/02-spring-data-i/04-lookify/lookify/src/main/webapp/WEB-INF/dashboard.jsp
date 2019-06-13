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
				<form action="/search" method="POST" autocomplete="off">
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
				<c:forEach items="${songs}" var="song">
					<tr>
            			<td><a href="http://localhost:8080/songs/${song.id}"><c:out value="${song.title}"/></a></td>
            			<td><c:out value="${song.artist}"/></td>
            			<td><c:out value="${song.rating}"/></td>
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