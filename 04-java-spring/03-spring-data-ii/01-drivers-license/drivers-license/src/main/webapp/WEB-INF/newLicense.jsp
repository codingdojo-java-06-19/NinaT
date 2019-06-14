<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>New License</title>
</head>
	<body>
	<div class="container">
			<h1>New License</h1>
			<form:form action="/licenses/new" method="POST" modelAttribute="license" autocomplete="off">
				<form:hidden path="number"></form:hidden>
				<div class="row">
					<div class="col-25">
						<label for="person">Person:</label>
					</div>
					<div class="col-75">
						<select name="person">
							<c:forEach items="${persons}" var="person">
								<option value="<c:out value="${person.id}"/>"><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></option>
						  	</c:forEach>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="state">State:</label>
					</div>
					<div class="col-75">
						<input type="text" name="state"/>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="expDate">Expiration Date:</label>
					</div>
					<div class="col-75">
						<input type="date" name="expirationDate"/>
					</div>
				</div>
				<div class="row">
					<input type="hidden" value="number"/>
					<input type="submit" value="Create"/>
				</div>
			</form:form>
		</div>
	</body>
</html>