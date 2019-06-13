<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<title>Add Song</title>
</head>
	<body>
		<div class="container">
			<div class="nav-bar">
				<a href="http://localhost:8080/dashboard">Dashboard</a>
			</div>
			<div class="details box">
				<form class="form-with-cols" action="" method="POST" autocomplete="off">
					<div class="row">
						<div class="col-25">
							<label for="title">Title</label>
						</div>
						<div class="col-75">
							<input type="text" name="title">
						</div>
					</div>
					<div class="row">
						<div class="col-25">
							<label for="artist">Artist</label>
						</div>
						<div class="col-75">
							<input type="text" name="artist">
						</div>
					</div>
					<div class="row">
						<div class="col-25">
							<label for="rating">Rating (1-10)</label>
						</div>
						<div class="col-75">
							<input type="text" name="rating">
						</div>
					</div>
					<div class="row">
						<input type="submit" value="Add Song">
					</div>
				</form>
			</div>
		</div>
	</body>
</html>