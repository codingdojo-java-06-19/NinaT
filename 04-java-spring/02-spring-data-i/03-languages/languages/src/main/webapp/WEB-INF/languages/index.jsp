<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Languages</title>
	</head>
	<body>
	<h1>All Languages</h1>
		<table>
		    <thead>
		        <tr>
		            <th>Name</th>
		            <th>Creator</th>
		            <th>Version</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${languages}" var="language">
		        <tr>
		            <td><c:out value="${language.name}"/></td>
		            <td><c:out value="${language.creator}"/></td>
		            <td><c:out value="${language.version}"/></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
	<a href="/languages/new">New Language</a>
	</body>
</html>