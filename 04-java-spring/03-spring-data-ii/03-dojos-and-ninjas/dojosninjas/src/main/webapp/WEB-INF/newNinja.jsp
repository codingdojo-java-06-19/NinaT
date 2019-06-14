<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/styles.css">
	<title>New Ninja</title>
</head>
	<body>
		<div class="container">
			<h1>New Ninja</h1>
			<form:form action="/ninjas/new" method="POST" modelAttribute="ninja" autocomplete="off">
				<div class="row">
					<div class="col-25">
						<label for="dojo">Dojo:</label>
					</div>
					<div class="col-75">
						<select name="dojo" path="dojo">
							<c:forEach items="${dojos}" var="dojo">
								<option value="<c:out value="${dojo.id}"/>"><c:out value="${dojo.name}"/></option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="firstName">First Name:</label>
					</div>
					<div class="col-75">
						<input type="text" name="firstName" path="firstName"/>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="lastName">Last Name:</label>
					</div>
					<div class="col-75">
						<input type="text" name="lastName" path="lastName"/>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="age">Age:</label>
					</div>
					<div class="col-75">
						<input type="number" name="age" min="18" max="80" path="age"/>
					</div>
				</div>
				<div class="row">
					<input type="submit" value="Create"/>
				</div>
			</form:form>
		</div>
	</body>
</html>