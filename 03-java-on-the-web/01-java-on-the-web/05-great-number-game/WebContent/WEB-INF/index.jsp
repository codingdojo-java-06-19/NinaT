<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="styles.css"/>
	<title>Great Number Game</title>
</head>
	<body>
		<div class="container">
			<h1>Welcome to the Great Number Game!</h1>
			<form action="Home" method="POST" autocomplete="off">
				<label>First, generate a (secret!) random  number between </label>
				<input class="entry" type="text" name="lowNum">
				<label> and </label>
				<input class="entry" type="text" name="highNum">
				<label>.</label>
			</form>
			<p>Then, guess what it is below!</p>
			<form action="Home" method="POST" autocomplete="off">
				<input class="guess" type="text" name="guess">
				<input type="submit" value="Submit"/>
			</form>
			<form action="Reset" method="get">
				<input type="submit" value="Reset Game"/>
			</form>
		</div>
	</body>
</html>