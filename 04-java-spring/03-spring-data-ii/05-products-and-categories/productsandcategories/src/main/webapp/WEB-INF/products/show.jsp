<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Product Page</title>
</head>
	<body>
	<div class="container">
		<h1><c:out value="${product.name}"/></h1>
			<div class="row">
				<div class="col">
					<h3>Categories:</h3>
					<ul>
						<c:forEach items="${categoriesAdded}" var="category">
							<li><c:out value="${category.name}"/></li>
						</c:forEach>
					</ul>
				</div>
				<div class="col">
					<form:form action="/products/addCategory/${product.id}" method="POST" modelAttribute="category" autocomplete="off">
						<div class="row">
							<div class="col-25">
								<label for="category">Add Category:</label>
							</div>
							<div class="col-75">
								<select name="category">
									<c:forEach items="${categoriesNotYetAdded}" var="category">
										<option value="<c:out value="${category.id}"/>"><c:out value="${category.name}"/></option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="row">
							<input type="submit" value="Add"/>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	
	</body>
</html>