<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/styles.css">
	<title>New Question</title>
</head>
	<body>
		<div class="container">
			<div class="new">
			<h1>What is your question?</h1>
			<form action="/questions/new" method="POST" modelAttribute="question" autocomplete="off">
				<div class="row">
					<div class="col-25">
						<label for="question">Question:</label>
					</div>
					<div class="col-75">
						<textarea name="content"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="tags">Tags:</label>
					</div>
					<div class="col-75">
						<input type="text" name="tagStrings"/>
					</div>
				</div>
				<div class="row">
					<input type="submit" value="Submit"/>
				</div>
			</form>
			</div>
		</div>
	</body>
</html>