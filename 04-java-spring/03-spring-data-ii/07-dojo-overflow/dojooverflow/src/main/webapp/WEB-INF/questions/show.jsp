<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/styles.css">
	<title>Question profile</title>
</head>
	<body>
		<div class="container">
			<h1>${question.content}</h1>
			<div class="nav-bar">
				<h3>Tags:</h3>
				<c:forEach items="${tags}" var="tag">
					<div class="btn">${tag.content}</div>
				</c:forEach>
			</div>
			<div class="row">
				<div class="col">
					<table class="questions-table answers">
						<tr>
							<th>Answers</th>
						</tr>
						<c:forEach items="${answers}" var="answer">
						<tr>
							<td>${answer.content}</td>
						</tr>
						</c:forEach>
					</table>
				</div>
				<div class="col">
					<h2>Add your answer:</h2>
					<form action="/question/answer" method="POST" autocomplete="off">
						<div class="row">
							<div class="col-25">
								<label for="answer">Answer:</label>
							</div>
							<div class="col-75">
								<textarea name="content"></textarea>
							</div>
						</div>
						<div class="row">
							<input type="hidden" name="question_id" value="<c:out value="${question.id}"/>"/>
							<input type="submit" value="Answer it!"/>
						</div>
					</form>
				</div>
			</div>

			
		
		</div>
	</body>
</html>