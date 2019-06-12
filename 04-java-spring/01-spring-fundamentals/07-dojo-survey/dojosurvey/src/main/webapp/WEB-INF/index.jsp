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
			<form action="/submit" method="POST" autocomplete="off">
			  <div class="row">
			    <div class="col-25">
			      <label for="name">Your Name:</label>
			    </div>
			    <div class="col-75">
			      <input type="text" id="name" name="name" >
			    </div>
			  </div>
			  <div class="row">
			    <div class="col-25">
			      <label for="dojo">Dojo Location</label>
			    </div>
			    <div class="col-75">
			      <select id="dojo" name="dojo">
			        <option value="San Jose">San Jose</option>
			        <option value="Seattle">Seattle</option>
			        <option value="Burbank">Burbank</option>
			        <option value="Online">Online</option>
			        <option value="TC">TC</option>
			        <option value="Chicago">Chicago</option>
			        <option value="Tulsa">Tulsa</option>
			        <option value="Berkeley">Berkeley</option>
			        <option value="Boise">Boise</option>
			        <option value="OC">OC</option>
			      </select>
			    </div>
			  </div>
			    <div class="row">
			    <div class="col-25">
			      <label for="favLang">Favorite Language:</label>
			    </div>
			    <div class="col-75">
			      <select id="favLang" name="favLang">
			        <option value="Python">Python</option>
			        <option value="Javascript">Javascript</option>
			        <option value="Java">Java</option>
			        <option value="CSS">CSS</option>
			        <option value="Ruby">Ruby</option>
			        <option value="Swift">Swift</option>
			        <option value="C++">C++</option>
			        <option value="C#">C#</option>
			      </select>
			    </div>
			  </div>
			  <div class="row">
			    <div class="col-25">
			      <label for="comment">Comment(optional)</label>
			    </div>
			    <div class="col-75">
			      <textarea id="comment" name="comment" style="height:200px"></textarea>
			    </div>
			  </div>
			  <div class="row">
			    <input type="submit" value="Submit">
			  </div>
			  </form>
		</div>
	</body>
</html>