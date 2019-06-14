<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>New Person</title>
</head>
	<body>
		<div class="container">
			<h1>New Person</h1>
			<form:form action="/persons/new" method="POST" modelAttribute="person" autocomplete="off">
				<div class="row">
					<div class="col-25">
						<label for="firstName">First Name:</label>
					</div>
					<div class="col-75">
						<input type="text" name="firstName"/>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="lastName">Last Name:</label>
					</div>
					<div class="col-75">
						<input type="text" name="lastName"/>
					</div>
				</div>
				<div class="row">
					<input type="submit" value="Create"/>
				</div>
			</form:form>
		</div>
	</body>
</html>