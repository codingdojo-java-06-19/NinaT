<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="styles.css"/>
	<title>Create a Pet!</title>
</head>
<body>
	<div class="container">
		<h1>Create a Dog</h1>
		<form action="/Pets/Dogs">
			<h3>Name:<input type="text" name="name"></h3>
			<h3>Breed:<input type="text" name="breed"></h3>
			<h3>Weight:<input type="text" name="weight"></h3>
			<input type="submit" value="Create Dog">
		</form>	
		<h1>Create a Cat</h1>	
		<form action="/Pets/Cats">
			<h3>Name:<input type="text" name="name"></h3>
			<h3>Breed:<input type="text" name="breed"></h3>
			<h3>Weight:<input type="text" name="weight"></h3>
			<input type="submit" value="Create Cat">
		</form>
	</div>
</body>
</html>