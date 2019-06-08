<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="styles.css"/>
	<title>Great Number Game</title>
</head>
	<body>
		<div class="container">
		<% if (session.getAttribute("attempts") == null || (Integer)session.getAttribute("attempts")!= 5) { %>
			<h1>Welcome to the Great Number Game!</h1>
				<% if (session.getAttribute("randNum") == null){%>
				<p>You only have 10 guesses. Good luck!</p>
				<form action="Home" method="POST" autocomplete="off">
					<label>First, generate a (secret!) random  number between </label>
					<input class="entry" type="text" name="lowNum">
					<label> and </label>
					<input class="entry" type="text" name="highNum">
					<label>.</label>
					<input type="submit" value="Start game!"/>
				</form>
				<% } else { %>
					<p>Awesome! You generated a random number between <span><c:out value="${lowNum}"/></span> and <span><c:out value="${highNum}"/></span>. </p>
					<p>Now, guess what it is below!</p>
				<form action="Home" method="POST" autocomplete="off">
					<input class="guess" type="text" name="guess">
					<input type="submit" value="Submit"/>
				</form>
				<% } %>
				<% if (session.getAttribute("guess") != null) { %>
					<% String result = (String)session.getAttribute("result"); %>
					<% if (result == "toohigh"){ %>
						<div class="alert red">
							<p>Too high!</p>
						</div>
					<% } else if (result == "toolow") { %>
						<div class="alert red">
							<p>Too low!</p>
						</div>
					<% } else { %>
						<div class="alert green">
							<p><span><c:out value="${guess}"/></span> was the number!</p>
							<form action="Reset" method="get">
								<input type="submit" value="Play again!"/>
							</form>
						</div>
					<% } %>
					<p>Guess count: <span><c:out value="${attempts}"/></span>
					<form action="Reset" method="get">
						<input type="submit" value="Reset Game"/>
					</form>
					
				<% } %>
				 
			<% } else {%>
				<p>You lost. </p>
				<form action="Reset" method="get">
					<input type="submit" value="Play again!"/>
				</form>
			<% } %>
			
		</div>
	</body>
</html>