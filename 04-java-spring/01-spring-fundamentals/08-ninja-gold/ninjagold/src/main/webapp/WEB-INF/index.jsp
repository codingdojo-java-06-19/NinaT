<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/styles.css">
	<title>Ninja Gold Game</title>
</head>
	<body>
		<div class="container">
			<h3 class="your-gold">Your Gold: </h3>
			<p class="gold-display"><c:out value="${gold}"/></p>
			<div class="locations">
				<div class="location-card">
					<h3>Farm</h3>
					<p>(earns 10-20 golds)</p>
					<form action="/gold/addGold" method="POST">
						<input type="hidden" name="location" value="farm">
						<input type="submit" value="Find Gold!">
					</form>
				</div>
				<div class="location-card">
					<h3>Cave</h3>
					<p>(earns 5-10 golds)</p>
					<form action="/gold/addGold" method="POST">
						<input type="hidden" name="location" value="cave">
						<input type="submit" value="Find Gold!">
					</form>
				</div>
				<div class="location-card">
					<h3>House</h3>
					<p>(earns 2-5 golds)</p>
					<form action="/gold/addGold" method="POST">
						<input type="hidden" name="location" value="house">
						<input type="submit" value="Find Gold!">
					</form>
				</div>
				<div class="location-card">
					<h3>Casino!</h3>
					<p>(earns/takes 0-50 gold)</p>
					<form action="/gold/addGold" method="POST">
						<input type="hidden" name="location" value="casino">
						<input type="submit" value="Find Gold!">
					</form>
				</div>
			</div>
			<h3>Activities:</h3>
			<textarea class="activities">
				<c:forEach items="${activities}" var="activity">
					<p class="activity"><c:out value="${activity}"/></p>
					</c:forEach>
			</textarea>
		</div>
	</body>
</html>