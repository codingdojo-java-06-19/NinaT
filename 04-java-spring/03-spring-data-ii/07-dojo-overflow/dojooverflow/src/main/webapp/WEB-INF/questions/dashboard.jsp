<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/styles.css">
	<title>Questions Dashboard</title>
</head>
	<body>
		<div class="container">
			<h1>Questions Dashboard</h1>
			<table class="questions-table">
				<tr>
					<th>Question</th>
					<th>Tags</th>
				</tr>
				<tr>
					<td><a href="/">What is the best programming language?</a></td>
					<td>cs, programming</td>
				</tr>
				<tr>
					<td><a href="/">What is the best programming language?</a></td>
					<td>cs, programming</td>
				</tr>
				<tr>
					<td><a href="/">What is the best programming language?</a></td>
					<td>cs, programming</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
			</table>
			<a class="right-link" href="http://localhost:8080/questions/new">New Question</a>
		</div>
	</body>
</html>