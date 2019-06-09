<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="styles.css">
	<title>New Team</title>
</head>
	<body>
		<div class="container">
			<h1 class="header">Create a new Team</h1>
			<div class="form-group">
				<form action="Home" method="POST" autocomplete="off">
					<label for="teamName">Team Name:</label>
					<input type="text" name="teamName"/>
					<input type="submit" value="Create">
			</form>
			</div>
		</div>
	</body>
</html>