<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<title>New Product</title>
</head>
	<body>
	<div class="container">
			<h1>New Product</h1>
			<form:form action="/products/new" method="POST" modelAttribute="product" autocomplete="off">
				<div class="row">
					<div class="col-25">
						<label for="name">Name</label>
					</div>
					<div class="col-75">
						<input type="text" name="name"/>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="description">Description</label>
					</div>
					<div class="col-75">
						<textarea name="description"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="price">Price</label>
					</div>
					<div class="col-75">
						<input type="number" min="1" step="any" name="price"/>
					</div>
				</div>
				<div class="row">
					<input type="submit" value="Create"/>
				</div>
			</form:form>
		</div>
	</body>
</html>