<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Category Page</title>
</head>
	<body>
		<div class="container">
			<h1><c:out value="${category.name}"/></h1>
			<div class="row">
				<div class="col">
					<h3>Products:</h3>
					<ul>
						<c:forEach items="${productsAdded}" var="product">
							<li><c:out value="${product.name}"/></li>
						</c:forEach>
					</ul>
				</div>
				<div class="col">
					<form:form action='/categories/addProduct/${category.id}' method="POST" modelAttribute="product" autocomplete="off">
						<div class="row">
							<div class="col-25">
								<label for="product">Add Product:</label>
							</div>
							<div class="col-75">
								<select name="product">
									<c:forEach items="${productsNotYetAdded}" var="product">
										<option value='<c:out value="${product.id}"/>'><c:out value="${product.name}"/></option>
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