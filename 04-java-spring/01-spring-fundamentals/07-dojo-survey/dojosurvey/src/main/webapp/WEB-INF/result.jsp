<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/styles.css">
	<title>Dojo Survey Index</title>
</head>
	<body>
		<div class="container">
			 <div class="row">
			    <div class="col-25">
			      <label for="name">Name:</label>
			    </div>
			    <div class="col-75">
			      <p><c:out value="${name}"/></p>
			    </div>
			  </div>
			  <div class="row">
			    <div class="col-25">
			      <label for="dojo">Dojo Location:</label>
			    </div>
			    <div class="col-75">
			      <p><c:out value="${dojo}"/></p>
			    </div>
			  </div>
			  <div class="row">
			    <div class="col-25">
			      <label for="favLang">Favorite Language</label>
			    </div>
			    <div class="col-75">
			      <p><c:out value="${favLang}"/></p>
			    </div>
			  </div>
			  <div class="row">
			    <div class="col-25">
			      <label for="comment">Comment:</label>
			    </div>
			    <div class="col-75">
			      <p><c:out value="${comment}"/></p>
			    </div>
			  </div>
			  <a href="http://localhost:8080"><button class="btn">Go Back</button></a>
		</div>
	</body>
</html>