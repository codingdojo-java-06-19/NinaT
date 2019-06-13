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
				<p>Songs by artist: Sheeran</p>
				<form action="" method="POST">
					<input type="search" name="searchQuery"/>
					<input type="submit" value="New Search"/>
				</form>
				<a href="http://localhost:8080/dashboard">Dashboard</a>
			</div>
			<table>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
				<tr>
					<a href="http://localhost:8080/songs/2"><td>Shape of You</td></a>
					<td>8</td>
					<a href=""><td>Delete</td></a>
				</tr>
			</table>
		</div>
	</body>
</html>