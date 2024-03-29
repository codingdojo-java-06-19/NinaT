<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/styles.css">
	<title>Details</title>
</head>
	<body>
		<div class="container">
			<div class="nav-bar">
				<a href="http://localhost:8080/dashboard">Dashboard</a>
			</div>
			<div class="details-box">
				<div class="row">
					<div class="col-25">
						<p>Title</p>
					</div>
					<div class="col-75">
						<p>${song.title}</p>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<p>Artist</p>
					</div>
					<div class="col-75">
						<p>${song.artist}</p>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<p>Rating(1-10)</p>
					</div>
					<div class="col-75">
						<p>${song.rating}</p>
					</div>
				</div>
				<div class="row">
					<form action="/songs/${song.id}" method="post">
	    				<input type="hidden" name="_method" value="delete">
	    				<input class="link-style" type="submit" value="Delete">
					</form>
				</div>
			</div>
		</div>
	</body>
</html>